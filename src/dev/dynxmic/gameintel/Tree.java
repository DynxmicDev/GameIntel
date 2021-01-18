package dev.dynxmic.gameintel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tree<P extends Position, M extends Move> {

    private final List<Layer<P, M>> layers;
    private final P position;
    private final Player turn;

    public Tree(P position, Player turn, int depth) {
        this.layers = new ArrayList<>();
        this.position = position;
        this.turn = turn;

        List<Node<P, M>> layer = createFirst();
        for (int i = 0; i < depth; i++) {
            layer = createLayer(i, new ArrayList<>(layer));
        }
    }

    public M calculateMove() {
        if (layers.get(0).getNodes().isEmpty()) return null;

        List<Node<P, M>> viable = new ArrayList<>(Collections.singletonList(layers.get(0).getNodes().get(0)));
        for (Node<P, M> node : layers.get(0).getNodes()) {
            if (node.getDeepValue().getDeepValue() > viable.get(0).getDeepValue().getDeepValue()) {
                viable = new ArrayList<>(Collections.singletonList(node));
            } else if (node.getDeepValue() == viable.get(0).getDeepValue() && !viable.contains(node)) {
                viable.add(node);
            }
        }

        Random random = new Random();
        return viable.get(random.nextInt(viable.size())).getMove();
    }

    private List<Node<P, M>> createFirst() {
        return Collections.singletonList(new Node<>(position, null, 0));
    }

    private List<Node<P, M>> createLayer(int layer, List<Node<P, M>> nodes) {
        Layer<P, M> newLayer = new Layer<>();

        if (layer % 2 == 0) {
            for (Node<P, M> node : nodes) {
                if (node.getPosition().getValue() == 1 || node.getPosition().getValue() == -1) {
                    continue;
                }
                for (Move move : node.getPosition().getMoves(turn)) {
                    Node<P, M> newNode = new Node<>((P) move.getNewPosition(node.getPosition()), (M) move, layer + 1);
                    node.addChild(newNode);
                    newLayer.addNode(newNode);
                }
            }
        } else {
            for (Node<P, M> node : nodes) {
                if (node.getPosition().getValue() == 1 || node.getPosition().getValue() == -1) {
                    continue;
                }
                for (Move move : node.getPosition().getMoves(getOpposite(turn))) {
                    Node<P, M> newNode = new Node<>((P) move.getNewPosition(node.getPosition()), (M) move, layer + 1);
                    node.addChild(newNode);
                    newLayer.addNode(newNode);
                }

            }
        }

        layers.add(newLayer);
        return newLayer.getNodes();
    }

    private Player getOpposite(Player player) {
        if (player == Player.COMPUTER) return Player.OPPONENT;
        return Player.COMPUTER;
    }

}
