package dev.dynxmic.tictactoe;

import dev.dynxmic.gameintel.Move;
import dev.dynxmic.gameintel.Player;
import dev.dynxmic.gameintel.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GamePosition implements Position {

    private final Map<Integer, Player> squares;

    public GamePosition(Map<Integer, Player> squares) {
        this.squares = squares;
    }
    
    public Map<Integer, Player> getSquares() {
        return squares;
    }

    public List<Move> getMoves(Player type) {
        List<Move> moves = new ArrayList<>();
        for (int square : squares.keySet()) {
            if (squares.get(square) == null) moves.add(new GameMove(square, type));
        }

        return moves;
    }

    public int getValue(Player type) {
        if (type == Player.COMPUTER) {
            if (squares.get(0) == Player.OPPONENT && squares.get(1) == Player.OPPONENT && squares.get(2) == Player.OPPONENT) return -1;
            if (squares.get(3) == Player.OPPONENT && squares.get(4) == Player.OPPONENT && squares.get(5) == Player.OPPONENT) return -1;
            if (squares.get(6) == Player.OPPONENT && squares.get(7) == Player.OPPONENT && squares.get(8) == Player.OPPONENT) return -1;
            if (squares.get(0) == Player.OPPONENT && squares.get(3) == Player.OPPONENT && squares.get(6) == Player.OPPONENT) return -1;
            if (squares.get(1) == Player.OPPONENT && squares.get(4) == Player.OPPONENT && squares.get(7) == Player.OPPONENT) return -1;
            if (squares.get(2) == Player.OPPONENT && squares.get(5) == Player.OPPONENT && squares.get(8) == Player.OPPONENT) return -1;
            if (squares.get(0) == Player.OPPONENT && squares.get(4) == Player.OPPONENT && squares.get(8) == Player.OPPONENT) return -1;
            if (squares.get(2) == Player.OPPONENT && squares.get(4) == Player.OPPONENT && squares.get(6) == Player.OPPONENT) return -1;

            if (squares.get(0) == Player.COMPUTER && squares.get(1) == Player.COMPUTER && squares.get(2) == Player.COMPUTER) return 1;
            if (squares.get(3) == Player.COMPUTER && squares.get(4) == Player.COMPUTER && squares.get(5) == Player.COMPUTER) return 1;
            if (squares.get(6) == Player.COMPUTER && squares.get(7) == Player.COMPUTER && squares.get(8) == Player.COMPUTER) return 1;
            if (squares.get(0) == Player.COMPUTER && squares.get(3) == Player.COMPUTER && squares.get(6) == Player.COMPUTER) return 1;
            if (squares.get(1) == Player.COMPUTER && squares.get(4) == Player.COMPUTER && squares.get(7) == Player.COMPUTER) return 1;
            if (squares.get(2) == Player.COMPUTER && squares.get(5) == Player.COMPUTER && squares.get(8) == Player.COMPUTER) return 1;
            if (squares.get(0) == Player.COMPUTER && squares.get(4) == Player.COMPUTER && squares.get(8) == Player.COMPUTER) return 1;
            if (squares.get(2) == Player.COMPUTER && squares.get(4) == Player.COMPUTER && squares.get(6) == Player.COMPUTER) return 1;
        } else {
            if (squares.get(0) == Player.COMPUTER && squares.get(1) == Player.COMPUTER && squares.get(2) == Player.COMPUTER) return -1;
            if (squares.get(3) == Player.COMPUTER && squares.get(4) == Player.COMPUTER && squares.get(5) == Player.COMPUTER) return -1;
            if (squares.get(6) == Player.COMPUTER && squares.get(7) == Player.COMPUTER && squares.get(8) == Player.COMPUTER) return -1;
            if (squares.get(0) == Player.COMPUTER && squares.get(3) == Player.COMPUTER && squares.get(6) == Player.COMPUTER) return -1;
            if (squares.get(1) == Player.COMPUTER && squares.get(4) == Player.COMPUTER && squares.get(7) == Player.COMPUTER) return -1;
            if (squares.get(2) == Player.COMPUTER && squares.get(5) == Player.COMPUTER && squares.get(8) == Player.COMPUTER) return -1;
            if (squares.get(0) == Player.COMPUTER && squares.get(4) == Player.COMPUTER && squares.get(8) == Player.COMPUTER) return -1;
            if (squares.get(2) == Player.COMPUTER && squares.get(4) == Player.COMPUTER && squares.get(6) == Player.COMPUTER) return -1;

            if (squares.get(0) == Player.OPPONENT && squares.get(1) == Player.OPPONENT && squares.get(2) == Player.OPPONENT) return 1;
            if (squares.get(3) == Player.OPPONENT && squares.get(4) == Player.OPPONENT && squares.get(5) == Player.OPPONENT) return 1;
            if (squares.get(6) == Player.OPPONENT && squares.get(7) == Player.OPPONENT && squares.get(8) == Player.OPPONENT) return 1;
            if (squares.get(0) == Player.OPPONENT && squares.get(3) == Player.OPPONENT && squares.get(6) == Player.OPPONENT) return 1;
            if (squares.get(1) == Player.OPPONENT && squares.get(4) == Player.OPPONENT && squares.get(7) == Player.OPPONENT) return 1;
            if (squares.get(2) == Player.OPPONENT && squares.get(5) == Player.OPPONENT && squares.get(8) == Player.OPPONENT) return 1;
            if (squares.get(0) == Player.OPPONENT && squares.get(4) == Player.OPPONENT && squares.get(8) == Player.OPPONENT) return 1;
            if (squares.get(2) == Player.OPPONENT && squares.get(4) == Player.OPPONENT && squares.get(6) == Player.OPPONENT) return 1;
        }

        return 0;
    }
    
}
