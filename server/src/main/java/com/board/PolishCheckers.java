import com.board.CheckersBoardBuilder;
import com.board.GameType;
import com.board.Pawn;

public class PolishCheckers implements GameType {

    int size;

    public PolishCheckers() {
        this.size = 10;
    }

    @Override
    public int getSize() {
        return size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see GameType#moveOneField(int, int)
     */
    @Override
    public int[] moveOneFieldRight(int height, int width, Pawn[][] board) {
        try {
            if (board[height][width].getPlayer() == 1) {
                return new int[] { height++, width++ };
            } else
                return new int[] { height--, width++ };
        } catch (Exception e) {
            return new int[] { -1 };
        }
    }

    @Override
    public int[] moveOneFieldLeft(int height, int width, Pawn[][] board) {
        try {
            if (board[height][width].getPlayer() == 1) {
                return new int[] { height++, width-- };
            } else
                return new int[] { height--, width-- };
        } catch (Exception e) {
            return new int[] { -1 };
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see GameType#jumpOverRight(int, int, Pawn[][])
     */
    @Override
    public int[] jumpOverRight(int height, int width, Pawn[][] board) {
        try {
            if (board[height][width].getPlayer() == 1) {
                return new int[] { height + 2, width + 2 };
            } else
                return new int[] { height - 2, width + 2 };
        } catch (Exception e) {
            return new int[] { -1 };
        }
    }

    @Override
    public int[] jumpOverLeft(int height, int width, Pawn[][] board) {
        try {
            if (board[height][width].getPlayer() == 1) {
                return new int[] { height + 2, width - 2 };
            } else
                return new int[] { height - 2, width - 2 };
        } catch (Exception e) {
            return new int[] { -1 };
        }
    }

    @Override
    public int[] moveKing(int height, int width) {
        return null;
    }

    @Override
    public Pawn[][] setPlayers(Pawn [][]board) {
        for (int height = 0; height < 3; height++) {
            for (int width = 0; width < width; width+2) {
                Pawn pawn = new Pawn(1)
                board[width][height] = pawn;
            }
        
        return board;
    }
    
}

    @Override
    public Pawn[][] setVaildmoves(int height, int width, Pawn[][] board) {
        Pawn[][] LogicBoard = new CheckersBoardBuilder().setType(this).buildEmpty();
        int [] nextmove;
        LogicBoard = new CheckersBoardBuilder().setType(this).buildEmpty();
        if (ju)
        if (board[height][width].getPlayer() == 1){
            nextmove = jumpOverLeft(height, width, board);
            if(nextmove[0] != -1){
                if(board[nextmove[0]][nextmove[1]].getPlayer() == 0 && board[height++][width--].getPlayer() != board[height][width].getPlayer()){
                    LogicBoard[nextmove[0]][nextmove[1]].setPlayer(1);
                }
            }
            nextmove = jumpOverRight(height, width, board);
            if(nextmove[0] != -1){
                if(board[nextmove[0]][nextmove[1]].getPlayer() == 0 && board[height++][width++].getPlayer() != board[height][width].getPlayer()){
                    LogicBoard[nextmove[0]][nextmove[1]].setPlayer(1);
                }
            }

        }
        return null;
    }
