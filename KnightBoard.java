public class KnightBoard {
  private int[][] board;

  public KnightBoard(int startingRows,int startingCols) {
    board = new int[startingRows][startingCols];
  }

  public String toString() {
    String s = "";
    for (int i=0;i<board.length;i++) {
      for (int j=0;j<board[i].length;j++) {
        if (board[i][j]==0) s+=" _";
        else s+= " "+board[i][j];
      }
      s+="\n";
    }
    return s;
  }

  public boolean solve(int startingRow, int startingCol) {
    clearLevels(0);
    return solveH(startingRow,startingCol,1);
  }
  private boolean solveH(int row ,int col, int level)  {
    board[row][col]=level;
    if (level==board.length*board[0].length) return true;
    int[] moves = {2,1,2,-1,-2,1,-2,-1,1,2,1,-2,-1,2,-1,-2};
    for (int k=0;k<moves.length;k+=2) {
      //System.out.println(Text.go(1,1));
      //System.out.println(this);Text.wait(1); //adjust this delay
      if (row+moves[k]>=0 && row+moves[k]<board.length
      && col+moves[k+1]>=0 && col+moves[k+1]<board[0].length
      && board[row+moves[k]][col+moves[k+1]]==0) {
        if (solveH(row+moves[k],col+moves[k+1],level+1)) {
          return true;
        }
        board[row+moves[k]][col+moves[k+1]]=0;
      }
    }
    return false;
  }

  public int countSolutions(int startingRow, int startingCol) {
    return 0;
  }

  private void clearLevels(int level) {
    for (int i=0;i<board.length;i++) {
      for (int j=0;j<board[i].length;j++) {
        if (board[i][j]>level) board[i][j]=0;
      }
    }
  }

  public static void main(String[] args) {
    KnightBoard board = new KnightBoard(5,5);
    //System.out.println(board);
    System.out.println(board.solve(0,0));
    System.out.println(board);
  }
}
