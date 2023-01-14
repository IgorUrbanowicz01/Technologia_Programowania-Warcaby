package com.client.controllers;

import java.io.IOException;
import java.util.Objects;

import com.client.ClientCore;
import com.client.helpers.Routes;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Class responsible for controlling the layout of the lobby and the
 * functionality.
 */
public class LobbyController {
    @FXML
    public Text NickName, HostName, Player1Nick, Player2Nick;
    @FXML
    public TextField gameName;
    @FXML
    Button saveEditButton, goOut, startGame;

    private Boolean saveMode = false;
    private static Stage stage;
    private static Parent root;

    /**
     * This method initialize LobbyController by settings nickName and avatar.
     * Also send to server instane of this controller.
     * 
     */
    @FXML
    public void initialize() {
        ClientCore.getInstance().setLobbyController(this);
        displayNickName(ClientCore.getInstance().getLogin());
        gameName.setPromptText(ClientCore.getInstance().getLobbyInfo().getGameName());
        gameName.setDisable(true);
        checkPrivilages();
    }

    /**
     * Method for change game name.
     * Valible only for host
     */
    @FXML
    public void saveEdit() {
        saveMode = !saveMode;
        if (isHost(ClientCore.getInstance().getLogin())) {
            if (saveMode) {
                // After edit
                saveEditButton.setText("Save");
                gameName.setDisable(false);
                gameName.requestFocus();
            } else if (isHost(ClientCore.getInstance().getLogin())) {
                // After Save
                saveEditButton.setText("Edit");
                gameName.setDisable(true);
                ClientCore.getInstance().changeLobbyName(gameName.getText());
            }
        }
    }

    /**
     * Method for go Out from lobby
     * 
     * @throws IOException
     */
    @FXML
    private void goOut() throws IOException {
        ClientCore.getInstance().exitLobby();
        stage = (Stage) goOut.getScene().getWindow();
        root = FXMLLoader.load(Routes.viewsRoute("DashboardView.fxml"));
        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(Routes.styleRoute("app.css"));
        stage.setScene(scene);
        stage.show();
        ClientCore.getInstance().setLobbyController(this);
        gameName.setText("Game Name");
    }

    /**
     * Method for invokes game.
     * Valible only for host
     * 
     * @throws IOException
     */
    @FXML
    public void startGame() throws IOException {
        ClientCore.getInstance().startGame();

    }

    /**
     * Method which refresh lobby and set users again and thiers privilages
     */
    public void refreshLobbyData() {
        setUsers();
        checkPrivilages();
    }

    /**
     * Method which set users thier privilages
     */
    private void checkPrivilages() {
        if (isHost(ClientCore.getInstance().getLogin())
                && ClientCore.getInstance().getLobbyInfo().getPlayernames().size() > 1
                && ClientCore.getInstance().getLobbyInfo().getPlayernames().size() != 5) {
            saveEditButton.setDisable(false);
            startGame.setDisable(false);
        } else if (isHost(ClientCore.getInstance().getLogin())
                && (ClientCore.getInstance().getLobbyInfo().getPlayernames().size() == 1
                        || ClientCore.getInstance().getLobbyInfo().getPlayernames().size() == 5)) {
            saveEditButton.setDisable(false);
            startGame.setDisable(true);
        } else {
            saveEditButton.setDisable(true);
            startGame.setDisable(true);
            gameName.setDisable(true);
        }
    }

    /**
     * Method which is chaking that you are host
     * 
     * @param playerName checking name
     * @return Boolean true - host, false - normal user
     */
    private Boolean isHost(String playerName) {
        return Objects.equals(playerName, ClientCore.getInstance().getLobbyInfo().getPlayernames().get(0));
    }

    // Set avatars and nicknames
    private void setUsers() {
        // Set Nicks
        if (ClientCore.getInstance().getLobbyInfo().getPlayernames().size() >= 1) {
            HostName.setText(ClientCore.getInstance().getLobbyInfo().getPlayernames().get(0).toString());
        }

        if (ClientCore.getInstance().getLobbyInfo().getPlayernames().size() >= 2) {
            Player1Nick.setText(ClientCore.getInstance().getLobbyInfo().getPlayernames().get(1).toString());
        }

        if (ClientCore.getInstance().getLobbyInfo().getPlayernames().size() >= 3) {
            Player2Nick.setText(ClientCore.getInstance().getLobbyInfo().getPlayernames().get(2).toString());
        }
    }

    /**
     * Method which load game view
     * 
     * @param playerCount  number of players in lobby
     * @param playerNumber client number
     * @throws Exception
     */
    public void loadGameScene(int playerCount, int playerNumber) throws Exception {
        final int count = playerCount;
        final int number = playerNumber;
        Platform.runLater(() -> {
            try {
                stage = (Stage) startGame.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(Routes.viewsRoute("GameView.fxml"));
                root = loader.load();
                Scene scene = new Scene(root, 1200, 800);
                scene.getStylesheets().add(Routes.styleRoute("app.css"));
                stage.setScene(scene);
                stage.show();
                ClientCore.getInstance().getGameController().startGameView(count, number);
                ClientCore.getInstance().ready();
            } catch (Exception ignored) {
            }
        });
    }

    /**
     * Method which set user nickName
     * 
     * @param nickName users nickName
     */
    private void displayNickName(String nickName) {
        NickName.setTextAlignment(TextAlignment.CENTER);
        NickName.setText(nickName);
    }

}
