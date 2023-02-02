package com.client.controllers;

import java.net.MalformedURLException;
import java.util.LinkedList;

import com.client.ClientCore;
import com.client.game.CheckersBoard;
import com.client.game.CheckersBoardAdapter;
import com.client.game.CheckersBoardBuilder;

import com.client.game.MouseMoveHandler;
import com.client.helpers.Routes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class responsible for controlling the layout of the game and the
 * functionality.
 */
public class GameViewController {

    @FXML
    public StackPane gameBoard;
    @FXML
    public Button skipRound;
    @FXML
    Text Player1;
    Text Player2;
    @FXML
    public Rectangle Color1;
    public Rectangle Color2;

    LinkedList<String> playersNicknames;
    int playerCount;
    int playerNumber;
    static Group group = new Group();
    public int[] playerNumbers;

    private MouseMoveHandler mmh;

    /**
     * This method initialize Game View.
     * Also send to server instane of this controller.
     * 
     */
    @FXML
    public void initialize() {
        ClientCore.getInstance().setGameController(this);

    }

    /**
     * @param playerCount  number of players
     * @param playerNumber number of client number
     */
    public void startGameView(int playerCount, int playerNumber) {
        this.playerCount = playerCount;
        this.playerNumber = playerNumber;
        gameBoard.getChildren().add(gameBoardLoader());
        gameBoard.setAlignment(Pos.CENTER);
        mmh.setPlayerNumber(playerNumber);
        setUsers();

    }

    /**
     * Method which send to server information about that player skip round
     */
    @FXML
    public void skipRound() {
        try {
            ClientCore.getInstance().skipRound();
        } catch (Exception ignored) {
        }
    }

    /**
     * Method which send to server information about that player exit game.
     * And show dasboard of lobbys
     */
    @FXML
    public void exitGame() {
        try {
            ClientCore.getInstance().exitLobby();
            ClientCore.getInstance().exitLobby();
            Stage stage = (Stage) skipRound.getScene().getWindow();
            Parent root = FXMLLoader.load(Routes.viewsRoute("DashboardView.fxml"));
            Scene scene = new Scene(root, 1200, 800);
            scene.getStylesheets().add(Routes.styleRoute("app.css"));
            stage.setScene(scene);
            stage.show();
        } catch (Exception ignored) {
        }
    }

    /**
     * Method which initialize game board in view
     * 
     * @return Group - game board
     */
    public Group gameBoardLoader() {
        try {
            CheckersBoard board = new CheckersBoardBuilder().setSize(5).setNumberOfPlayers(playerCount).build();
            CheckersBoardAdapter boardAdapter = new CheckersBoardAdapter(board);
            mmh = boardAdapter.getMouseMoveHandler();

            com.client.game.Field[][] fields = boardAdapter.getFields();

            for (com.client.game.Field[] a : fields) {
                for (com.client.game.Field c : a) {
                    if (c != null) {
                        group.getChildren().add(c);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return group;
    }

    /**
     * @return MouseMoveHandler - the MouseMoveHandler
     */
    public MouseMoveHandler getMouseMoveHandler() {
        return mmh;
    }

    private void setUsers() {
        
    }
}