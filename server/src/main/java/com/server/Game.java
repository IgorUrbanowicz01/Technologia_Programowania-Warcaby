package com.server;

import com.board.CheckersBoard;
import com.board.GameType;
import com.board.CheckersBoardBuilder;
import com.messages.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * class that handles one game
 */
public class Game {
    GameType gameType;
    Lobby lobby;
    int readyPlayers;
    CheckersBoard board;
    int[] playerNumbers;
    int currentPlayer;
    boolean won[];

    /**
     * creates the game
     * 
     * @param lobby games lobby
     * @param type  games type
     * @throws Exception throws if size or number of players if wrongly set
     */
    public Game(Lobby lobby, GameType gameType) throws Exception {
        this.lobby = lobby;
        this.gameType = gameType;
        ArrayList<String> logins = new ArrayList<>();
        lobby.getPlayers().forEach((e) -> logins.add(e.userData.getLogin()));
        history.setLogins(logins);
        readyPlayers = 0;
        won = new boolean[2];
        Arrays.fill(won, false);
        board = new CheckersBoardBuilder().setType(gameType).build();
        playerNumbers = new int[] { 1, 2 };
        currentPlayer = new Random().nextInt(2);
        /**
         * for (int i = 0; i < 2; i++) {
         * gameBeginningMessage gbm = new gameBeginningMessage();
         * gbm.setMessageType("gameBeginning");
         * gbm.setPlayerCount(playerCount);
         * gbm.setPlayerNumber(playerNumbers[i]);
         * lobby.getPlayers().get(i).out.writeObject(gbm);
         * }
         */
    }

    /**
     * informs current player that its his move
     */
    public void turn() {
        joinLobbyMessage jlm = new joinLobbyMessage();
        jlm.setMessageType("turn");
        jlm.setHostName(lobby.getPlayers().get(currentPlayer).userData.getLogin());
        lobby.deliverMessages(jlm);
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
        try {
            board.move(pawnX, pawnY, moveX, moveY);
            deliverMove(pawnX, pawnY, moveX, moveY);
            boolean[] end = board.checkIfGameEnded(); // sprawdzałem działa
            boolean gameEnd = true;
            for (int i = 0; i < 2; i++) {
                won[i] = end[playerNumbers[i] - 1];
                if (!won[i])
                    gameEnd = false;
            }
            if (gameEnd) {
                endGame();
                return;
            }
            turn();
        } catch (Exception e) {
            MessageHolder mh = new MessageHolder();
            mh.setMessageType("invalid move");
            messageCurrentPlayer(mh);
        }

    }

    /**
     * ends game
     */
    public void endGame() {
        ServerCore.getInstance().saveGame(history);
        lobby.sendLobbyInfo();
    }

    /**
     * sends a message to current player
     * 
     * @param message message to send
     */
    public void messageCurrentPlayer(MessageHolder message) {
        try {
            lobby.getPlayers().get(currentPlayer).out.writeObject(message);
            ServerCore.getInstance().getController().appendOutput(message.getMessageType());
        } catch (IOException ex) {
            endGame();
        }
    }

    /**
     * informs all players about the move
     * 
     * @param pawnX pawns x
     * @param pawnY pawns y
     * @param moveX moves x
     * @param moveY moves y
     */
    public void deliverMove(int pawnX, int pawnY, int moveX, int moveY) {
        MoveMessage mm = new MoveMessage();
        mm.setMessageType("move");
        mm.setAll(pawnX, pawnY, moveX, moveY);
        lobby.deliverMessages(mm);
    }
}
