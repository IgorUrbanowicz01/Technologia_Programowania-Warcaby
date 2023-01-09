package com.board;

import javax.print.attribute.Size2DSyntax;

/**
 * checkers board builder
 */
public class CheckersBoardBuilder {
    int size;
    int numberOfPlayers;
    GameType gameType;

    /**
     * sets the number of players
     * 
     * @param numberOfPlayers number of players
     * @return this builder
     */
    public void setType(GameType gameType) {
        this.gameType = gameType;
    }

    /**
     * builds the board
     * 
     * @return built board
     * @throws Exception throws if size or number of players if wrongly10 set
     */
    public CheckersBoard build() throws Exception {
        size = gameType.getSize();
        if (size < 1 || numberOfPlayers < 0 || numberOfPlayers == 1 || numberOfPlayers > 2)
            throw new Exception("wrong build parameters");
        CheckersBoard checkersBoard = new CheckersBoard();
        Pawn[][] board = new Pawn[size][size];
        // czyszczenie tabeli (wszystkie pola na 0)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Pawn(0);
            }
        }
        board = gameType.setPlayers(board);
        checkersBoard.setBoard(board, gameType);
        return checkersBoard;
    }

    public Pawn[][] buildEmpty(int sizeOf) {
        Pawn[][] board = new Pawn[sizeOf][sizeOf];
        for (int i = 0; i < sizeOf; i++) {
            for (int j = 0; j < sizeOf; j++) {
                board[i][j] = new Pawn(0);
            }
        }
        return board;
    }
}