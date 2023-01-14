package com.client.game;

/**
 * checkers board builder
 */
public class CheckersBoardBuilder {
    int size;
    int numberOfPlayers;
    int height;
    int width;

    /**
     * sets the board size
     * 
     * @param size size
     * @return this builder
     */
    public CheckersBoardBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    /**
     * builds the board
     * 
     * @return built board
     * @throws Exception throws if size or number of players if wrongly set
     */
    public CheckersBoard build() throws Exception {
        CheckersBoard checkersBoard = new CheckersBoard();
        height = size + 3 * (size - 1); // dla size = 5 wynosi 17
        width = 2 * (size + 2 * (size - 1)) - 1; // dla size = 5 wynosi 25
        int[][] board = new int[height][width];
        // czyszczenie tabeli (wszystkie pola na -1)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = -1;
            }
        }
        // tworzenie planszy (zaznaczanie kształtu na 0)
        setLegal(board);
        checkersBoard.setBoard(board, size);
        return checkersBoard;
    }

    /**
     * @param board
     */
    private void setLegal(int[][] board) {
        int goodPoint = width / 2;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                board[i - 1][goodPoint + 2 * j] = 0;
                board[height - i][goodPoint + 2 * j] = 0;
            }
            goodPoint = goodPoint - 1;
        }
        goodPoint = 0;
        for (int i = size; i < 2 * size; i++) {
            for (int j = 0; j < width - 2 * (i - size); j += 2) {
                board[i - 1][goodPoint + j] = 0;
                board[height - i][goodPoint + j] = 0;
            }
            goodPoint = goodPoint + 1;
        }
    }
}