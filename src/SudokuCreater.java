import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SudokuCreater extends Controller {
    private String[][] puzzle = new String[9][9];
    Map<Boolean, String[][]> map = new HashMap<>();


    public void fillTableWithZero(String[][] puzzle) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = "0";
            }
        }

    }

    public void fillKeys(ArrayList<String> hints) {
        hints.add("B");
        hints.add("I");
        hints.add("M");
        hints.add("C");
        hints.add("N");
        hints.add("G");
        hints.add("2");
        hints.add("1");
        hints.add("3");
    }

    public Map<Boolean, String[][]> isSolvable(String[][] puzzle) {

        String[][] temp = new String[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(puzzle[i], 0, temp[i], 0, 9);
        }
        SudokuSolver solver = new SudokuSolver(temp);
        if (solver.solveSudoku())
            map.put(true, temp);
        return map;

    }

    public String[][] generate() {
        fillTableWithZero(puzzle);

        ArrayList<String> hints = new ArrayList<>();
        fillKeys(hints);

        int numberOfHints = 0;


        do {

            int randomColumn = (int) (Math.random() * 9);
            int randomRow = (int) (Math.random() * 9);

            Collections.shuffle(hints);

            if ((puzzle[randomRow][randomColumn]).equals("0") && isAllowed(puzzle, randomRow, randomColumn, hints.get(1))) {

                puzzle[randomRow][randomColumn] = hints.get(1);
                numberOfHints++;

            }
            if (numberOfHints == 23 && (isSolvable(puzzle).isEmpty())) {
                numberOfHints = 0;
                fillTableWithZero(puzzle);


            }

        } while (numberOfHints != 23);


        return puzzle;
    }

    public void print(String[][] puzzle) {


        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("----------------------------------\n");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + puzzle[i][j] + " ");

            }

            System.out.println();
        }
    }
}



