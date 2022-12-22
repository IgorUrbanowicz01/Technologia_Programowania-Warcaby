package com.client.controllers;

/**
 * Class responsible for controlling the layout of the login screen and the
 * functionality.
 */
public class StartViewController {
    @FXML
    public Button connectServerButton, errorButton;
    @FXML
    public TextField IP, PORT;

    @FXML
    private Pane ErrorPane;

    /**
     * Method for initialize controller and send it to server
     * 
     * @param url            users url
     * @param resourceBundle users resourceBundle
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

    /**
     * Method for initialize try to connect to server
     * 
     * @param event users event
     */
    @FXML
    private void StartViewControllerButtons(ActionEvent event) {

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorButton(ActionEvent e) {

    }

    /**
     * Method to show the error pane when any error occurs
     */
    public void showError() {
    }

    /**
     * Method which load the Login and Registery view
     * 
     * @throws IOException throws if an error occurs
     */
    public void LoadNewScene() throws IOException {

    }

    /**
     * Getter for the IP
     * 
     * @return String IP which put users
     */
    public String getIP() {
        return this.IP.getText();
    }

}
