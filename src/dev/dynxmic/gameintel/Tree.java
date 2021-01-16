package dev.dynxmic.gameintel;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private final Player type;
    private final List<Layer> layers;

    public Tree(Position position, Player type, int depth) {
        this.layers = new ArrayList<>();
        this.type = type;

        Layer layer = createFirst(position);
        for (int i = 0; i < depth; i++) {
            layer = createNext(layer);
        }
    }

    public Move calculateMove() {
        Node optimal = layers.get(1).getNodes().get(0);
        for (Node node : layers.get(1).getNodes()) {
            if (node.getValue(type) > optimal.getValue(type)) optimal = node;
        }

        return optimal.getMove();
    }

    private Layer createFirst(Position position) {
        Layer layer = new Layer();
        layers.add(layer);
        layer.addNode(new Node(position, new Move() {

            @Override
            public Position getNewPosition(Position position) {
                return position;
            }

            @Override
            public Player getType() {
                return Player.COMPUTER;
            }

        }, layers.indexOf(layer)));

        return layer;
    }

    private Layer createNext(Layer layer) {
        Layer newLayer = new Layer();
        layers.add(newLayer);

        if (layers.indexOf(layer) % 2 == 0) {
            for (Node node : layer.getNodes()) {
                if (node.getPosition().getValue(type) == 1 || node.getPosition().getValue(type) == -1) continue;
                for (Move move : node.getPosition().getMoves(type)) {
                    Node newNode = new Node(move.getNewPosition(node.getPosition()), move, layers.indexOf(newLayer));
                    node.addChild(newNode);
                    newLayer.addNode(newNode);
                }
            }
        } else {
            for (Node node : layer.getNodes()) {
                if (node.getPosition().getValue(type) == 1 || node.getPosition().getValue(type) == -1) continue;
                if (type == Player.COMPUTER) {
                    for (Move move : node.getPosition().getMoves(Player.OPPONENT)) {
                        Node newNode = new Node(move.getNewPosition(node.getPosition()), move, layers.indexOf(newLayer));
                        node.addChild(newNode);
                        newLayer.addNode(newNode);
                    }
                } else {
                    for (Move move : node.getPosition().getMoves(Player.COMPUTER)) {
                        Node newNode = new Node(move.getNewPosition(node.getPosition()), move, layers.indexOf(newLayer));
                        node.addChild(newNode);
                        newLayer.addNode(newNode);
                    }
                }

            }
        }

        return newLayer;
    }

}
