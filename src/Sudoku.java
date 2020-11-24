
public interface Sudoku {
    static void main(String[] args) {
        if(args.length==1){
            if(args[0].equals("c") || args[0].equals("C")){
                Creator.generate();
            }
            else if(args[0].equals("s") || args[0].equals("S")) {
                Solver solver = new Solver(Creator.generate());
                solver.solveSudoku();
                solver.displaySudoku();
            }
        }
    }
}
