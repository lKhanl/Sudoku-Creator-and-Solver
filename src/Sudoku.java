import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] puzzle;
        while (true) {
            System.out.print("What do you want to do? ( C or S or Stop ): ");
            System.out.println();
            String option = input.next();
            switch ((option.toLowerCase())) {
                case "s" -> System.out.println("First you should create a puzzle.");
                case "c" -> {
                    SudokuCreater creator = new SudokuCreater();
                    puzzle = creator.generate();
                    creator.print(puzzle);
                    System.out.println();
                    System.out.print("Press S to solve the given puzzle or press stop: ");
                    System.out.println();
                    String nextOption = input.next();
                    if ((nextOption.toLowerCase().equals("s"))) {
                        SudokuSolver solver = new SudokuSolver(creator.map.get(true));
                        solver.displaySudoku();
                    } else if ((nextOption.toLowerCase().equals("stop"))) {
                        System.out.println("Program was stopped...");
                    }
                }
                case "stop" -> {
                    System.out.println("Program was stopped...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid input. Please enter C or S : ");
            }
        }
    }
}