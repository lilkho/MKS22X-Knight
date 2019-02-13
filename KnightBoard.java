public class KnightBoard {
  private int[][] board;

  public KnightBoard(int startingRows,int startingCols) {
    board = new int[startingRows][startingCols];
  }

  public String toString() {
    String s = "";
    for (int i=0;i<board.length;i++) {
      for (int j=0;j<board.length;j++) {
        if (board[i][j]==0) s+=" _";
        else s+= " "+board[i][j];
      }
    }
  }

  public boolean solve(int startingRow, int startingCol) {
    return solveH(0,0,1);
  }
  private boolean solveH(int row ,int col, int level)  {
    if (level==row*col) return true;
    for
  }

  public int countSolutions(int startingRow, int startingCol) {
    return 0;
  }

}
