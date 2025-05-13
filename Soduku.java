public class Soduku{
    private static final int Size = 9;
    public static boolean isSafe(int soduku[][], int row, int col, int digit){
            // column
            for(int i=0;i<Size;i++){
                if(soduku[i][col] == digit){
                    return false;
                }
            }

            // Row
            for(int j=0;j<Size;j++){
                if(soduku[row][j] == digit){
                    return false;
                }
            }

            // Grid
            int sr = (row/3) * 3;
            int sc = (col/3) * 3;
            // 3*3 Grid
            for(int i=sr;i<sr+3;i++){
                for(int j=sc;j<sc+3;j++){
                    if(soduku[i][j] == digit){
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean solve(int[][] board) {
        for (int row = 0; row < Size; row++) {
            for (int col = 0; col < Size; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= Size; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = 0; // backtrack
                        }
                    }
                    return false; // trigger backtracking
                }
            }
        }
        return true; // solved
    }
    public static void printBoard(int[][] board) {
        for (int i = 0; i < Size; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-----------");
            }
            for (int j = 0; j < Size; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
         int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solve(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}