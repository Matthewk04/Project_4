package main;

import game.Game;
import maze.*;
import player.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Create the game with a valid grid size (e.g., 3–7)
        Game game = new Game(5);
        Grid grid = game.getGrid();

        // Place the player at a known starting cell — bottom-right
        int size = grid.getRows().size();
        Row startRow = grid.getRows().get(size - 1);
        Cell startCell = startRow.getCells().get(size - 1);
        Player player = new Player(startRow, startCell);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to 'Tears, Despair & Debugging'!");
        System.out.println("Controls: W = Up, A = Left, S = Down, D = Right, Q = Quit");

        while (running) {
            // Show current location
            int rowIndex = grid.getRows().indexOf(player.getCurrentRow());
            int colIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
            System.out.println("\nYou are at row " + rowIndex + ", column " + colIndex);
            System.out.print("Move: ");
            String input = scanner.nextLine().toUpperCase();

            Movement move = switch (input) {
                case "W" -> Movement.UP;
                case "A" -> Movement.LEFT;
                case "S" -> Movement.DOWN;
                case "D" -> Movement.RIGHT;
                case "Q" -> {
                    running = false;
                    System.out.println("Quitting game.");
                    yield null;
                }
                default -> {
                    System.out.println("Invalid input.");
                    yield null;
                }
            };

            if (move != null) {
                boolean moved = game.play(move, player);
                if (!moved) {
                    System.out.println("Movement blocked by a WALL.");
                }
            }

            // Check win condition
            if (hasPlayerReachedExit(player)) {
                System.out.println("\nYou've reached the EXIT! You win!");
                break;
            }
        }

        scanner.close();
    }

    private static boolean hasPlayerReachedExit(Player player) {
        Cell cell = player.getCurrentCell();
        return cell.getLeft() == CellComponents.EXIT ||
               cell.getRight() == CellComponents.EXIT ||
               cell.getUp() == CellComponents.EXIT ||
               cell.getDown() == CellComponents.EXIT;
    }
}
