package com.client.controllers;

/**
 * Class responsible for controlling the layout of the game and the
 * functionality.
 */
public class GameViewController {

    @FXML
    public StackPane gameBoard;
    @FXML
    Text Player1, Player2;
    @FXML
    public Rectangle Color1, Color2;

    LinkedList<String> playersNicknames;
    int playerCount;
    int playerNumber;
    static Group group = new Group();
    public int[] playerNumbers;

    private MouseMoveHandler mouseMovehHandler;
    /**
     * This method initialize Game View.
     * Also send to server instane of this controller.
     * 
     */
    @FXML
    public void initialize() {

    }

    /**
     * @param playerCount  number of players
     * @param playerNumber number of client number
     */
    public void startGameView(int playerCount, int playerNumber) {

    }

    /**
     * Method which send to server information about that player skip round
     */
    @FXML
    public void skipRound() {

    }

    /**
     * Method which send to server information about that player exit game.
     * And show dasboard of lobbys
     */
    @FXML
    public void ExitGame() {

    }

    /**
     * Method which initialize game board in view
     * 
     * @return Group - game board
     */
    public Group gameBoardLoader() {

        return group;
    }

    /**
     * @return MouseMoveHandler - the MouseMoveHandler
     */
    public MouseMoveHandler getMouseMoveHandler() {
        return mouseMoveHandler;
    }

    private void setUsers() {

    }

    private Paint setColor(int playerNumber) {

        return COLOR;
    }

}
