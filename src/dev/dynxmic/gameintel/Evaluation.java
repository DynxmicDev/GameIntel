package dev.dynxmic.gameintel;

public class Evaluation {

    private final int deepValue;
    private final int deepLayer;

    public Evaluation(int deepValue, int deepLayer) {
        this.deepValue = deepValue;
        this.deepLayer = deepLayer;
    }

    public int getDeepValue() {
        return deepValue;
    }

    public int getDeepLayer() {
        return deepLayer;
    }

}
