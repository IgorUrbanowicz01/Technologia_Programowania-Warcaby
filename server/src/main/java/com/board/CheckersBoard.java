package com.board;

import java.util.List;

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
        Pawn[][] LogicBoard = gameType.setVaildmovesP(pawnY, pawnX, board);
        List<Integer> kils = LogicBoard[moveY][moveX].getKills();
        if (LogicBoard[moveY][moveX].getPlayer() != 0) {
            board[moveY][moveX].setPlayer(board[pawnY][pawnX].getPlayer());
            board[pawnY][pawnX].setPlayer(0);
            for (int i = 0; i < LogicBoard[moveY][moveX].getKillsSize(); i += 2) {
                board[kils.get(i)][kils.get(i + 1)].setPlayer(0);
            }

        } else {
            throw new Exception("invalid move");
        }
    }

    /**
     * checks if a pawn can become a king
     * 
     * @param pawnX pawn's X coordinate (this is for choosing triangle to check)
     * @param pawnY pawn's Y coordinate (this is for choosing triangle to check)
     * @return true if is in target false otherwise
     */
    public void isInTarget(int height, int width) {
        if (board[height][width].getPlayer() == 1) {
            if (height == gameType.getSize()) {
                board[height][width].setKing();
            }
        } else {
            if (height == 0) {
                board[height][width].setKing();
            }
        }
    }

    /**
     * chcecks if game ended
     * 
     * @return array of who won
     */

    public boolean[] checkIfGameEnded() {
        boolean checksP2 = true;
        boolean checksP1 = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getPlayer() == 1)
                    checksP2 = false;
                if (board[i][j].getPlayer() == 2)
                    checksP1 = false;
            }
        }
        return new boolean[] { checksP1, checksP2 };
    }

}