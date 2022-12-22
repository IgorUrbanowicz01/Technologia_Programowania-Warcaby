package com.client.controllers;

/**
 * Class responsible for controlling the layout of the login screen and the
 * functionality.
 */
public class LoginIntoLauncherController {
    
    @FXML
    private Button LoginButton, RegisteryButton;
    @FXML
    private TextField LoginField, PasswordField;
    @FXML
    private URL location;
    @FXML
    private Pane ErrorPane;

    private static Stage stage;
    private static Parent root;

    /**
     * Method for initialize controller and send it to server
     * 
     * @param url            users url
     * @param resourceBundle users resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Method which is responsible for loading the login screen or register screen
     * 
     * @param event what event
     * @throws Exception
     */
    @FXML
    private void LoginLauncherControllerButtons(ActionEvent event) throws Exception {

    }

    /**
     * Method which is responsible for close error notification after click X on
     * error pane.
     * Also invokes animation
     * 
     * @param e keyEvent
     */
    @FXML
    private void errorButton(ActionEvent e) {
 
    }

    /**
     * Method which invokes error pane, and animation
     */
    public void ErrorNotification() {

    }

    /**
     * Method responsible for loade the dasboard view scene
     * 
     */
    public void LoadDashboardScene() {
        
    }

    /**
     * Method responsible for loading the register view scene
     * 
     * @throws IOException throws if an error occurs
     */
    private void LoadRegisteryScene() throws IOException {
);
    }

}
