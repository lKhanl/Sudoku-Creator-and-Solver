import java.util.ArrayList;

public class SudokuSolver extends Controller {
    private String[][] puzzle;
    SudokuCreater creator = new SudokuCreater();

    public SudokuSolver(String[][] puzzle) {
        this.puzzle = puzzle;
    }

    public boolean solveSudoku() {
        ArrayList<String> hints = new ArrayList<>();
        creator.fillKeys(hints);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (puzzle[row][col].equals("0")) {


                    for (int index = 0; index < 9; index++) {
                        if (isAllowed(puzzle,row,col,hints.get(index))){
                            puzzle[row][col] = hints.get(index);
                            if (solveSudoku()) {
                                return true;
                            } else {
                                puzzle[row][col] = "0";
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
        creator.print(puzzle);
    }

}