package dev.dynxmic.tictactoe;

import dev.dynxmic.gameintel.Move;
import dev.dynxmic.gameintel.Player;
import dev.dynxmic.gameintel.Tree;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Player> squares = new HashMap<>();
        squares.put(0, Player.COMPUTER);
        squares.put(1, null);
        squares.put(2, null);
        squares.put(3, null);
        squares.put(4, Player.COMPUTER);
        squares.put(5, null);
        squares.put(6, null);
        squares.put(7, null);
        squares.put(8, Player.OPPONENT);

        Tree<GamePosition, Move> tree = new Tree<>(new GamePosition(squares), Player.COMPUTER, 9);

        GameMove move = (GameMove) tree.calculateMove();
        if (move == null) return;

        squares.put(move.getSquare(), move.getType());
        System.out.println(getPrint(squares.get(0)) + " " + getPrint(squares.get(1)) + " " + getPrint(squares.get(2)));
        System.out.println(getPrint(squares.get(3)) + " " + getPrint(squares.get(4)) + " " + getPrint(squares.get(5)));
        System.out.println(getPrint(squares.get(6)) + " " + getPrint(squares.get(7)) + " " + getPrint(squares.get(8)));
        System.out.println("");
    }

    private static String getPrint(Player type) {
        if (type == null) return "_";
        if (type.equals(Player.COMPUTER)) return "X";
        else return "O";
    }

}
