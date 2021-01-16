package dev.dynxmic.gameintel;

import java.util.List;

public interface Position {

    List<Move> getMoves(Player type);

    int getValue(Player type);

}
