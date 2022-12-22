package com.client.controllers;

import java.io.IOException;
import java.util.LinkedList;
import com.client.ClientCore;

/**
 * Class responsible for controlling the layout of the dasboard and the
 * functionality.
 */
public class DashboardController {

    @FXML
    public Text NickName;
    @FXML
    Button createGameButton, logoutButton;
    @FXML
    VBox GamesCardsPane;
    @FXML
    Button refreshButton;
    // Dummy list
    public LinkedList<dummyLobbyClass> lobbyLinkedList = new LinkedList<>();

    /**
     * This method initialize DashboardController by settings nickName and avatar.
     * Also send to server instane of this controller.
     * 
     * @throws IOException if send looby list request fails
     */
    @FXML
    public void initialize() throws IOException {

    }

    /**
     * Method which invokes method which is responsible for loading the lobby;
     */
    @FXML
    public void createLooby() {

    }

    /**
     * Method which send request to server for get lobbyList again
     */
    @FXML
    public void refreshAction() {

    }

    /**
     * Method which logout you form your dasboard (account). And show login launcher
     * 
     * @throws IOException if can't find loginIntoLauncher.fxml
     */
    @FXML
    public void logout() throws IOException {

    }

    @FXML
    public void gameHistoryAction() throws IOException {

    }

    /**
     * Method which load next five loobies
     * 
     * @throws IOException
     */
    @FXML
    public void loadNext() throws IOException {

    }

    /**
     * Method which load previoues five loobies
     * 
     * @throws IOException
     */
    @FXML
    public void loadPrev() throws IOException {

    }

    /**
     * Method which load all loobies and init dasboard gamesCardsPanes
     * And sett pagination options
     */
    public void lobbyList() {
        
    }

    /**
     * Method which load game list from linkList and create them
     */
    public void initDashboardGames() {

    }

    /**
     * Method for creating a new game card and adding it to the list of cards
     * 
     * @param newList new created list
     */
    public void changeLobbyList(final LinkedList<dummyLobbyClass> newList) {

    }

    /**
     * Method which set players login in dasboard
     * 
     * @param nickName users nickName
     */
    public void displayNickName(String nickName) {

    }

    /**
     * Method which load user avatar and set him on dasboard
     * 
     * @param avatarNumber users avatar
     */
    public void displayAvatar(Integer avatarNumber) {

    }

    /**
     * Method which create a new game card and set it on dasboard lobbies list
     * 
     * @param gameName       the name of game which is visible on game card
     * @param playersInLobby information about players in the lobby
     * @param hostName       show who is hosting the game
     * @return gameCardHBox  new game cards list
     */
    // Create new card gamer
    public Pane gameCardCreator(String gameName, Integer playersInLobby, String hostName) {

    }

    /**
     * Method which load new lobby scene and send information about it to the server
     */
    public void loadLobby() {

    }
}

