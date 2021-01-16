package dev.dynxmic.gameintel;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final Position position;
    private final Move move;
    private final List<Node> children;
    private final int layer;

    public Node(Position position, Move move, int layer) {
        this.position = position;
        this.move = move;
        this.layer = layer;
        this.children = new ArrayList<>();
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public int getValue(Player type) {
        if (children.isEmpty()) return position.getValue(type);

        Node optimalMove = children.get(0);
        for (Node child : children) {
            if (layer % 2 == 0 && child.getValue(type) > optimalMove.getValue(type)) {
                optimalMove = child;
            } else if (layer % 2 == 1 && child.getValue(type) < optimalMove.getValue(type)) {
                optimalMove = child;
            }
        }

        return optimalMove.getValue(type);
    }

    public Move getMove() {
        return move;
    }

    public Position getPosition() {
        return position;
    }

}
