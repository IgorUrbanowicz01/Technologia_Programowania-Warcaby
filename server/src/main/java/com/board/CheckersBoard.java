package com.board;

import com.board.Pawn;

/**
 * checkers board
 */
public class CheckersBoard {
    private Pawn[][] board;
    int size;
    GameType gameType;

    /**
     * sets board
     * 
     * @param board board to set
     * @param size  size of the board
     */
    public void setBoard(Pawn[][] board, GameType gameType) {
        this.board = board;
        this.size = gameType.getSize();
    }

    /**
     * returns board
     * 
     * @return board
     */
    public Pawn[][] getBoard() {
        return board;
    }

    // /**
    // * prints the board on standard output
    // */
    // public void printInTerminal(){
    // for(int[] a :board){
    // for(int b :a){
    // if(b<0) {
    // System.out.print(" ");
    // }else{
    // System.out.print("[" + b + "]");
    // }
    // }
    // System.out.println();
    // }
    // }

    /**
     * returns a board where 0 is a non-valid move and 1 is a valid one
     * 
     * @param height Y coordinate of the point to validate
     * @param width  X coordinate of the point to validate
     * @return board with valid points
     */
    public CheckersBoard setValidMoves(int height, int width) {
        boolean isInTarget = isInTarget(width, height, width, height);
        CheckersBoard LogicBoard;
        try {
            LogicBoard = new CheckersBoardBuilder().setType(gameType).buildEmpty();
            if (board[height][width].getPlayer() == 0)
                return LogicBoard;
            try {
                int[] pointaftermove = gameType.moveOneField(height, width);
                if (board[pointaftermove[0]][pointaftermove[1]].getPlayer() == 0) {
                    LogicBoard.board[pointaftermove[0]][pointaftermove[1]] = 1;
                } else if (board[pointaftermove[0]][pointaftermove[1]].getPlayer() != board[height][width]
                        .getPlayer()) {
                    int[] pointafterjump = moveOneField(pointaftermove[0], pointaftermove[1]);
                    // jump validation
                    if (board[pointafterjump[0]][pointafterjump[1]] == 0) {
                        if (isInTarget) {
                            if (isInTarget(width, height, pointafterjump[1], pointafterjump[0])) {
                                LogicBoard.board[pointafterjump[0]][pointafterjump[1]] = 1;
                            } else {
                                continue;
                            }
                        } else {
                            LogicBoard.board[pointafterjump[0]][pointafterjump[1]] = 1;
                        }
                        validateAfterJump(LogicBoard, pointafterjump[0], pointafterjump[1], height, width, width,
                                height);
                    }
                }
            } catch (Exception ignored) {
            }
            return LogicBoard;
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     * return coordinates after move
     * 
     * @param height    current hight
     * @param width     current width
     * @param direction 0 - right, 1 - left
     * @return coordinates after move
     * @throws Exception throws if point is outside of the board
     */
    public int[] moveOneField(int height, int width, int direction) throws Exception {
        switch (direction) {
            case 0 -> {
                width++;
                height++;
            }
            case 1 -> {
                width--;
                height++;
            }
        }
        if (width < 0 || width == board[0].length || height < 0 || height == board.length)
            throw new Exception("point is outside of the board");
        return new int[] { height, width };
    }

    private void validateAfterJump(CheckersBoard logic, int heightAfterJump, int widthAfterJump,
            int heightBeforeJump, int widthBeforeJump, int pawnX, int pawnY) {
        boolean isInTarget = isInTarget(pawnX, pawnY, widthAfterJump, heightAfterJump);
        for (int i = 0; i < 6; i++) {
            try {
                int[] pointaftermove = moveOneField(heightAfterJump, widthAfterJump, i);
                if (board[pointaftermove[0]][pointaftermove[1]] > 0) {
                    int[] pointafterjump = moveOneField(pointaftermove[0], pointaftermove[1], i);
                    if (pointafterjump[0] == heightBeforeJump && pointafterjump[1] == widthBeforeJump)
                        continue;
                    if (board[pointafterjump[0]][pointafterjump[1]] == 0) {
                        if (logic.board[pointafterjump[0]][pointafterjump[1]] == 1)
                            continue;
                        if (isInTarget) {
                            if (isInTarget(pawnX, pawnY, pointafterjump[1], pointafterjump[0])) {
                                logic.board[pointafterjump[0]][pointafterjump[1]] = 1;
                            } else {
                                continue;
                            }
                        } else {
                            logic.board[pointafterjump[0]][pointafterjump[1]] = 1;
                        }
                        validateAfterJump(logic, pointafterjump[0], pointafterjump[1], heightAfterJump, widthAfterJump,
                                pawnX, pawnY);
                    }
                }
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * moves a pawn on the board
     * 
     * @param pawnX pawn's X coordinate
     * @param pawnY pawn's Y coordinate
     * @param moveX move's X coordinate
     * @param moveY move's Y coordinate
     * @throws Exception throws if move isn't valid
     */
    public void move(int pawnX, int pawnY, int moveX, int moveY) throws Exception {
        CheckersBoard Logic = setValidMoves(pawnY, pawnX);
        if (Logic.getBoard()[moveY][moveX] == 1) {
            board[moveY][moveX] = board[pawnY][pawnX];
            board[pawnY][pawnX] = 0;
        } else {
            throw new Exception("invalid move");
        }
    }

    /**
     * checks if a move is in target triangle
     * 
     * @param pawnX pawn's X coordinate (this is for choosing triangle to check)
     * @param pawnY pawn's Y coordinate (this is for choosing triangle to check)
     * @param moveX move's X coordinate (this is for choosing a field to check)
     * @param moveY move's Y coordinate (this is for choosing a field to check)
     * @return true if is in target false otherwise
     */
    public boolean isInTarget(int pawnX, int pawnY, int moveX, int moveY) {
        // Może damy tutaj tworzenie dam ?
    }

    /**
     * chcecks if game ended
     * 
     * @return array of who won
     */

    public boolean[] checkIfGameEnded() {
        // To Do
    }
}
