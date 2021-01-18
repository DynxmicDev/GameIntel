package dev.dynxmic.tictactoe;

import dev.dynxmic.gameintel.Move;
import dev.dynxmic.gameintel.Player;
import dev.dynxmic.gameintel.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Player> squares = new HashMap<>();

        squares.put(0, null);
        squares.put(1, null);
        squares.put(2, null);
        squares.put(3, null);
        squares.put(4, null);
        squares.put(5, null);
        squares.put(6, null);
        squares.put(7, null);
        squares.put(8, null);

        System.out.println(getPrint(squares.get(0)) + " " + getPrint(squares.get(1)) + " " + getPrint(squares.get(2)));
        System.out.println(getPrint(squares.get(3)) + " " + getPrint(squares.get(4)) + " " + getPrint(squares.get(5)));
        System.out.println(getPrint(squares.get(6)) + " " + getPrint(squares.get(7)) + " " + getPrint(squares.get(8)));
        System.out.println("");

        while (true) {
            System.out.print("Enter Move X: ");
            int xInput = scanner.nextInt();

            System.out.print("Enter Move Y: ");
            int yInput = scanner.nextInt();

            if (xInput == 1) {
                if (yInput == 1) {
                    squares.put(0, Player.OPPONENT);
                } else if (yInput == 2) {
                    squares.put(1, Player.OPPONENT);
                } else if (yInput == 3) {
                    squares.put(2, Player.OPPONENT);
                }
            } else if (xInput == 2) {
                if (yInput == 1) {
                    squares.put(3, Player.OPPONENT);
                } else if (yInput == 2) {
                    squares.put(4, Player.OPPONENT);
                } else if (yInput == 3) {
                    squares.put(5, Player.OPPONENT);
                }
            } else if (xInput == 3) {
                if (yInput == 1) {
                    squares.put(6, Player.OPPONENT);
                } else if (yInput == 2) {
                    squares.put(7, Player.OPPONENT);
                } else if (yInput == 3) {
                    squares.put(8, Player.OPPONENT);
                }
            }

            if (new GamePosition(squares).getValue() != 0) {
                System.out.println("You Win!");
                return;
            }

            System.out.println("");
            Tree<GamePosition, Move> tree = new Tree<>(new GamePosition(squares), Player.COMPUTER, 9);

            GameMove move = (GameMove) tree.calculateMove();
            if (move == null) {
                System.out.println("");
                System.out.println("Draw!");
                return;
            }

            squares.put(move.getSquare(), move.getType());
            if (new GamePosition(squares).getValue() != 0) {
                System.out.println("You Lose!");
                return;
            }

            System.out.println(getPrint(squares.get(0)) + " " + getPrint(squares.get(1)) + " " + getPrint(squares.get(2)));
            System.out.println(getPrint(squares.get(3)) + " " + getPrint(squares.get(4)) + " " + getPrint(squares.get(5)));
            System.out.println(getPrint(squares.get(6)) + " " + getPrint(squares.get(7)) + " " + getPrint(squares.get(8)));
            System.out.println("");
        }

    }

    private static String getPrint(Player type) {
        if (type == null) return "_";
        if (type.equals(Player.COMPUTER)) return "X";
        else return "O";
    }

}
