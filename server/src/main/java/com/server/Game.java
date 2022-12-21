package com.server;

/**
 * class that handles one game
 */
public class Game {
    Lobby lobby;
    int playerCount, readyPlayers;
    int[] playerNumbers;
    int currentPlayer;
    boolean won;

    /**
     * creates the game
     * 
     * @param lobby       games lobby
     * @param playerCount number of players
     * @throws Exception throws if size or number of players if wrongly set
     */
    public Game(Lobby lobby, int playerCount) throws Exception {
        // To Do (!!!!)
    }

    /**
     * informs current player that its his move
     */
    public void turn() {
        // To Do
    }

    /**
     * performs move on board
     * 
     * @param pawnX pawns x
     * @param pawnY pawns y
     * @param moveX moves x
     * @param moveY moves y
     */
    public void move(int pawnX, int pawnY, int moveX, int moveY) {
        // To do
    }

    /**
     * ends game
     */
    public void endGame() {
        // To Do
    }
}
