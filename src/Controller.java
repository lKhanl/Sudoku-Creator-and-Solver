abstract class Controller {


    public boolean columnControl(String[][] table, int collum, String hint) {
        int count = 0;
        while (count != 9) {
            if (table[count++][collum].equals(hint))
                return false;
        }
        return true;

    }

    public boolean rowControl(String[][] table, int row, String hint) {
        int count = 0;
        while (count != 9) {
            if (table[row][count++].equals(hint))
                return false;
        }
        return true;
    }

    public boolean boxControl(String[][] puzzle, int row, int column, String hint) {
        int r = row - row % 3;
        int c = column - column % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (puzzle[i][j].equals(hint)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAllowed(String[][] puzzle, int row, int column, String hint) {
        return (boxControl(puzzle, row, column, hint) && rowControl(puzzle, row, hint) && columnControl(puzzle, column, hint));
    }

}
