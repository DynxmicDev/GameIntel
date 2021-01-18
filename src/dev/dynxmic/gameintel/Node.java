package dev.dynxmic.gameintel;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Node<P extends Position, M extends Move> {

    private final P position;
    private final M move;
    private final List<Node<P, M>> children;
    private final int layer;

    public Node(P position, M move, int layer) {
        this.position = position;
        this.move = move;
        this.layer = layer;
        this.children = new ArrayList<>();
    }

    public void addChild(Node<P, M> node) {
        children.add(node);
    }

    public DeepValue getDeepValue() {
        if (children.isEmpty()) {
            return new DeepValue(position.getValue(), layer);
        }

        int value = children.get(0).getDeepValue().getDeepValue();
        int layer = children.get(0).getDeepValue().getDeepLayer();

        for (Node<P, M> child : children) {
            int childValue = child.getDeepValue().getDeepValue();
            int childLayer = child.getDeepValue().getDeepLayer();

            if (layer % 2 == 0) {
                if (childValue >= value && childLayer > layer) {
                    value = childValue;
                    layer = childLayer;
                }
            } else {
                if (childValue <= value && childLayer < layer) {
                    value = childValue;
                    layer = childLayer;
                }
            }
        }

        return new DeepValue(value, layer);
    }

    public M getMove() {
        return move;
    }

    public P getPosition() {
        return position;
    }

}
