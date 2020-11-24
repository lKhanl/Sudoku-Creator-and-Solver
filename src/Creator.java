
import java.util.ArrayList;
import java.util.Collections;

public class Creator {

    public static String[][] fillTable() {
        String[][] temp = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                temp[i][j] = "0";
            }
        }
        return temp;
    }

    public static boolean columnControl(String[][] table, int collum, String hint) {

        int count = 0;

        while (count != 9) {
            if (table[count++][collum].equals(hint))
                return false;
        }

        return true;

    }
    public static boolean rowControl(String[][] table, int row, String hint) {
        int count = 0;

        while (count != 9) {
            if (table[row][count++].equals(hint))
                return false;
        }
        return true;
    }
    public static boolean boxControl(String[][] table, int row, int column, String hint) {


        if (row < 3  && column < 3) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i][j].equals(hint))
                        return false;
                }
            }
        }

        else if (3 <= column && column < 6 && row < 3 ) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i][j + 3].equals(hint))
                        return false;
                }
            }
        }

        else if (6 <= column && column < 9 && row < 3) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i][j + 6].equals(hint))
                        return false;
                }
            }
        }

        else if (3 <= row && row < 6 && column < 3) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i + 3][j].equals(hint))
                        return false;
                }
            }
        }

        else if (3 <= row && row < 6 && 6 > column) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i + 3][j + 3].equals(hint))
                        return false;
                }
            }
        }

        else if (3 <= row && row < 6 && 9 > column) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i + 3][j + 6].equals(hint))
                        return false;
                }
            }
        }

        else if (6 <= row && row < 9 && column < 3 ) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i + 6][j].equals(hint))
                        return false;
                }
            }
        }

        else if (6 <= row && row < 9 && 6 > column) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i + 6][j + 3].equals(hint))
                        return false;
                }
            }
        }

        else if (6 <= row && row < 9 && 9 > column){
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (table[i + 6][j + 6].equals(hint))
                        return false;
                }
            }
        }

        else {
            return true;
        }


        return true;
    }

    public static String[][] generate() {
        String[][] table = fillTable();
        ArrayList<String> ar = new ArrayList<>();

        Fill(ar);


        int counter = 0;

        do {

            int randomColumn = (int) (Math.random() * 9);
            int randomRow = (int) (Math.random() * 9);

            Collections.shuffle(ar);

            if (table[randomRow][randomColumn].equals("0") && columnControl(table, randomColumn, ar.get(1))
                    && rowControl(table, randomRow, ar.get(1)) && boxControl(table, randomRow, randomColumn, ar.get(1))) {

                table[randomRow][randomColumn] = ar.get(1);
                counter++;

            }

        } while (counter != 18);


        Solver.print(table);
        System.out.println("\n\n__________________________________________\n\n");

        return table;
    }

    public static void Fill(ArrayList<String> ar) {
        ar.add("B");
        ar.add("I");
        ar.add("M");
        ar.add("C");
        ar.add("N");
        ar.add("G");
        ar.add("2");
        ar.add("1");
        ar.add("3");
    }

}
