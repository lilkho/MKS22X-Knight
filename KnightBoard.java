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
      s+="\n";
    }
    return s;
  }

  public boolean solve(int startingRow, int startingCol) {
    return solveH(startingRow,startingCol,1);
  }
  private boolean solveH(int row ,int col, int level)  {
    if (board[row][col]==0) {
      board[row][col]=level;
    }
    if (level==row*col) return true;
    for (int i=0;i<board.length;i++) {
      for (int j=0;j<board[i].length;j++) {
        System.out.println(Text.go(1,1));
        System.out.println(this);Text.wait(200); //adjust this delay
        if (row+2>0 && col+1>0) {
          if (solveH(row+2,col+1,level+1)) return true;
          clearLevels(level);
        }
        if (row+2>0 && col-1>0) {
          if (solveH(row+2,col-1,level+1)) return true;
          clearLevels(level);
        }
        if (row-2>0 && col+1>0) {
          if (solveH(row-2,col+1,level+1)) return true;
          clearLevels(level);
        }
        if (row-2>0 && col-1>0) {
          if (solveH(row-2,col-1,level+1)) return true;
          clearLevels(level);
        }
        if (row+1>0 && col+2>0) {
          if (solveH(row+1,col+1,level+1)) return true;
          clearLevels(level);
        }
        if (row+1>0 && col-2>0) {
          if (solveH(row+1,col-1,level+1)) return true;
          clearLevels(level);
        }
        if (row-1>0 && col+2>0) {
          if (solveH(row-1,col+1,level+1)) return true;
          clearLevels(level);
        }
        if (row-1>0 && col-2>0) {
          if (solveH(row-1,col-1,level+1)) return true;
          clearLevels(level);
        }
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
    KnightBoard board = new KnightBoard(7,7);
    System.out.println(board);
    board.solve(0,0);
    System.out.println(board);
  }
}
