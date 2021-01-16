package dev.dynxmic.gameintel;

public interface Move {

    Position getNewPosition(Position oldPosition);

    Player getType();

}
