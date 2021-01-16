package dev.dynxmic.gameintel;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private final List<Node> nodes;

    public Layer() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

}
