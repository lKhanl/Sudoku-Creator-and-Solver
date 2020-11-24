
import java.util.ArrayList;

public class Solver {
    private String[][] sudoku;

    public Solver() {
        sudoku = new String[9][9];
    }
    public Solver(String[][] sudoku) {
        this.sudoku = sudoku;
    }

    public ArrayList<String> fill() {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("B");
        ar.add("I");
        ar.add("M");
        ar.add("C");
        ar.add("N");
        ar.add("G");
        ar.add("2");
        ar.add("1");
        ar.add("3");
        return ar;
    }


    private boolean containsInRow(int row, String number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i].equals(number)) {
                return true;
            }
        }
        return false;
    }
    private boolean containsInCol(int col, String number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col].equals(number)) {
                return true;
            }
        }
        return false;
    }
    private boolean containsInBox(int row, int col, String number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (sudoku[i][j].equals(number)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isAllowed(int row, int col, String number) {
        return !(containsInRow(row, number) || containsInCol(col, number) || containsInBox(row, col, number));
    }

    public boolean solveSudoku() {
        ArrayList<String> ar = fill();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudoku[row][col].equals("0")) {


                    for (int number = 0; number < 9; number++) {
                        if (isAllowed(row, col, ar.get(number))) {
                            sudoku[row][col] = ar.get(number);
                            if (solveSudoku()) {
                                return true;
                            } else {
                                sudoku[row][col] = "0";
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void displaySudoku() {
        print(sudoku);

    }
    static void print(String[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------------------------------\n");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + sudoku[i][j] + " ");

            }

            System.out.println();
        }
    }


}