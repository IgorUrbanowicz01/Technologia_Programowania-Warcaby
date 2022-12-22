package com.client.controllers;

/**
 * Class responsible for controlling the layout of the lobby and the
 * functionality.
 */
public class LobbyController {
    
    @FXML
    public Text NickName, HostName, Player1Nick, Player2Nick;
    @FXML
    public TextField gameName;

    private static Stage stage;
    private static Parent root;
     /**
     * This method initialize LobbyController by settings nickName and avatar.
     * Also send to server instane of this controller.
     * 
     */
    @FXML
    public void initialize() {
 
    }

    /**
     * Method for change game name.
     * Valible only for host
     */
    @FXML
    public void saveEdit() {

    }

    /**
     * Method for go Out from lobby
     * 
     * @throws IOException
     */
    @FXML
    private void goOut() throws IOException {

    }

    /**
     * Method for invokes game.
     * Valible only for host
     * 
     * @throws IOException
     */
    @FXML
    public void startGame() throws IOException {

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

    }

    /**
     * Method which is chaking that you are host
     * 
     * @param playerName checking name
     * @return Boolean true - host, false - normal user
     */
    private Boolean isHost(String playerName) {

    }

    // Set avatars and nicknames
    private void setUsers() {
        // Set Nicks
    }

    /**
     * Method which load game view
     * 
     * @param playerCount  number of players in lobby
     * @param playerNumber client number
     * @throws Exception
     */
    public void loadGameScene(int playerCount, int playerNumber) throws Exception {
        
    }

    /**
     * Method which set user nickName
     * 
     * @param nickName users nickName
     */
    private void displayNickName(String nickName) {

    }

    /**
     * Method which set user avatar
     * 
     * @param avatarNumber
     */
    public void displayAvatar(Integer avatarNumber) {

    }
}
