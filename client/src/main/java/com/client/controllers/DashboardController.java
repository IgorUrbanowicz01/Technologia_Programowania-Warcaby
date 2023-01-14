package com.client.controllers;

import java.io.IOException;
import java.util.LinkedList;
<<<<<<< Updated upstream
import com.client.ClientCore;
=======

import com.client.ClientCore;
import com.client.helpers.Routes;

import com.messages.DummyLobby;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
>>>>>>> Stashed changes

/**
 * Class responsible for controlling the layout of the dasboard and the
 * functionality.
 */
public class DashboardController {
<<<<<<< Updated upstream

    @FXML
    public Text NickName;
    @FXML
    Button createGameButton, logoutButton;
=======
    @FXML
    public Text NickName;
    public Text paginationPosition;
    @FXML
    Button createGameButton;
    Button logoutButtin;
    Button paginationButtonNext;
    Button paginationButtonPrev;
    Button gameHistory;
>>>>>>> Stashed changes
    @FXML
    VBox GamesCardsPane;
    @FXML
    Button refreshButton;
<<<<<<< Updated upstream
    // Dummy list
    public LinkedList<dummyLobbyClass> lobbyLinkedList = new LinkedList<>();
=======
    @FXML
    ImageView refreshIcon;
    // Dummy list
    public LinkedList<DummyLobby> lobbyLinkedList = new LinkedList<>();

    // Varible for help which card games we schuld load
    private Integer paginationIndex = 0;
>>>>>>> Stashed changes

    /**
     * This method initialize DashboardController by settings nickName and avatar.
     * Also send to server instane of this controller.
     * 
     * @throws IOException if send looby list request fails
     */
    @FXML
    public void initialize() throws IOException {
<<<<<<< Updated upstream
=======
        displayNickName(ClientCore.getInstance().getLogin());
        ClientCore.getInstance().setDashboardController(this);
        try {
            ClientCore.getInstance().sendLobbyListRequest();
            lobbyList();
        } catch (Exception ignored) {
        }
>>>>>>> Stashed changes

    }

    /**
     * Method which invokes method which is responsible for loading the lobby;
     */
    @FXML
    public void createLooby() {
<<<<<<< Updated upstream

=======
        try {
            ClientCore.getInstance().createLobby();
            loadLobby();
        } catch (Exception e) {
            e.printStackTrace();
        }
>>>>>>> Stashed changes
    }

    /**
     * Method which send request to server for get lobbyList again
     */
    @FXML
    public void refreshAction() {
<<<<<<< Updated upstream

=======
        try {
            ClientCore.getInstance().sendLobbyListRequest();
            lobbyList();
        } catch (Exception ignored) {
        }
>>>>>>> Stashed changes
    }

    /**
     * Method which logout you form your dasboard (account). And show login launcher
     * 
     * @throws IOException if can't find loginIntoLauncher.fxml
     */
    @FXML
    public void logout() throws IOException {
<<<<<<< Updated upstream

=======
        Stage stage;
        Parent root;

        stage = (Stage) logoutButtin.getScene().getWindow();
        root = FXMLLoader.load(Routes.viewsRoute("loginIntoLauncher.fxml"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(Routes.styleRoute("app.css"));

        stage.setScene(scene);
        stage.show();
>>>>>>> Stashed changes
    }

    @FXML
    public void gameHistoryAction() throws IOException {
<<<<<<< Updated upstream

=======
        Stage stage;
        Parent root;

        stage = (Stage) logoutButtin.getScene().getWindow();
        root = FXMLLoader.load(Routes.viewsRoute("GamesHistory.fxml"));
        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(Routes.styleRoute("app.css"));

        stage.setScene(scene);
        stage.show();
>>>>>>> Stashed changes
    }

    /**
     * Method which load next five loobies
     * 
     * @throws IOException
     */
    @FXML
    public void loadNext() throws IOException {
<<<<<<< Updated upstream
=======
        GamesCardsPane.getChildren().clear();
        paginationIndex++;
        lobbyList();
>>>>>>> Stashed changes

    }

    /**
     * Method which load previoues five loobies
     * 
     * @throws IOException
     */
    @FXML
    public void loadPrev() throws IOException {
<<<<<<< Updated upstream

=======
        GamesCardsPane.getChildren().clear();
        paginationIndex--;
        lobbyList();
>>>>>>> Stashed changes
    }

    /**
     * Method which load all loobies and init dasboard gamesCardsPanes
     * And sett pagination options
     */
    public void lobbyList() {
<<<<<<< Updated upstream
        
=======
        // Send link list off lobbys init dasboard
        initDashboardGames();
        // Control when pagination button schuld be active
        if (lobbyLinkedList.size() < 5) {
            paginationButtonNext.setDisable(true);
            paginationButtonPrev.setDisable(true);
        } else if (paginationIndex == ((int) Math.ceil(lobbyLinkedList.size() / 5))) {
            paginationButtonNext.setDisable(true);
            paginationButtonPrev.setDisable(false);
        } else if (paginationIndex == 0) {
            paginationButtonPrev.setDisable(true);
            paginationButtonNext.setDisable(false);
        } else {
            paginationButtonNext.setDisable(false);
            paginationButtonPrev.setDisable(false);
        }
>>>>>>> Stashed changes
    }

    /**
     * Method which load game list from linkList and create them
     */
    public void initDashboardGames() {
<<<<<<< Updated upstream

=======
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                GamesCardsPane.getChildren().clear();
                for (int i = 0; i < 5; i++) {
                    if (i + (paginationIndex * 5) < lobbyLinkedList.size()) {
                        GamesCardsPane.getChildren().add(i,
                                gameCardCreator(lobbyLinkedList.get(i + (paginationIndex * 5)).getName(),
                                        lobbyLinkedList.get(i + (paginationIndex * 5)).getPlayersInLobby(),
                                        lobbyLinkedList.get(i + (paginationIndex * 5)).hostName()));
                    }
                }
            }
        });
>>>>>>> Stashed changes
    }

    /**
     * Method for creating a new game card and adding it to the list of cards
     * 
     * @param newList new created list
     */
<<<<<<< Updated upstream
    public void changeLobbyList(final LinkedList<dummyLobbyClass> newList) {

=======
    public void changeLobbyList(final LinkedList<DummyLobby> newList) {
        lobbyLinkedList.clear();
        lobbyLinkedList.addAll(newList);
>>>>>>> Stashed changes
    }

    /**
     * Method which set players login in dasboard
     * 
     * @param nickName users nickName
     */
    public void displayNickName(String nickName) {
<<<<<<< Updated upstream

    }

    /**
     * Method which load user avatar and set him on dasboard
     * 
     * @param avatarNumber users avatar
     */
    public void displayAvatar(Integer avatarNumber) {

=======
        NickName.setTextAlignment(TextAlignment.CENTER);
        NickName.setText(nickName);
>>>>>>> Stashed changes
    }

    /**
     * Method which create a new game card and set it on dasboard lobbies list
     * 
     * @param gameName       the name of game which is visible on game card
     * @param playersInLobby information about players in the lobby
     * @param hostName       show who is hosting the game
<<<<<<< Updated upstream
     * @return gameCardHBox  new game cards list
=======
     * @return gameCardHBox new game cards list
>>>>>>> Stashed changes
     */
    // Create new card gamer
    public Pane gameCardCreator(String gameName, Integer playersInLobby, String hostName) {

<<<<<<< Updated upstream
=======
        HBox gameCardHBox = new HBox();
        gameCardHBox.setId("gameCardHBox");

        Button playButton = new Button();
        playButton.setId(hostName);
        playButton.setGraphic(new ImageView(new Image(Routes.imageRoute("Play.png"))));
        playButton.setOnAction(event -> {
            try {
                ClientCore.getInstance().joinLobby(((Node) event.getSource()).getId());
            } catch (Exception ignored) {
            }
        });

        if (playersInLobby == 6) {
            playButton.setDisable(true);
        }

        gameCardHBox.getChildren().addAll(new Text(gameName), new Text(playersInLobby + "/2"), new Text(hostName),
                playButton);

        gameCardHBox.setSpacing(40.0);
        gameCardHBox.setAlignment(Pos.CENTER);

        return gameCardHBox;
>>>>>>> Stashed changes
    }

    /**
     * Method which load new lobby scene and send information about it to the server
     */
    public void loadLobby() {
<<<<<<< Updated upstream

    }
=======
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Parent root = null;
                try {
                    root = FXMLLoader.load(Routes.viewsRoute("Lobby.fxml"));
                    Scene scene = new Scene(root, 1200, 800);
                    scene.getStylesheets().add(Routes.styleRoute("app.css"));
                    ClientCore.getInstance().programStage.setScene(scene);
                    ClientCore.getInstance().programStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ClientCore.getInstance().getLobbyController().refreshLobbyData();
            }
        });

    }

>>>>>>> Stashed changes
}

