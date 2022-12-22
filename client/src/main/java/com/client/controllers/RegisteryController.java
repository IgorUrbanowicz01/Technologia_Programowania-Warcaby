package com.client.controllers;

/**
* Class responsible for controlling the layout of the login screen and the
* functionality.
*/
public class RegisteryController {
    @FXML
    private Button buttonnBack, buttonCreateAccount;
    @FXML
    private TextField newLogin, newPassword, checkNewPassword;
    @FXML
    Pane errorRegisteryNewAccount, errorPanePassword, accountCreatedSuccesfully, errorPanePasswordValidation,
            avatarError, errorSomethinkWrong, errorrThisLoginIsToShort;
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

    private boolean allCorect = false;

    /**
     * Method which controlling registration of new users.
     * Checking if user is already registered
     * Checking if possword is enough length and checkNewPassword
     * Checking if user login length is enough
     * Checking if user choose any avatar
     * TimeUnit is needed to wait for server respond
     * 
     * @param e users actionEvent
     * @throws Exception
     * @throws StringSameValidation
     * @throws NumberFormatException
     */
    @FXML
    private void CreateAccountButtonController(ActionEvent e)

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorPaneLoginExistButton(ActionEvent e) {

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorPanePasswordButton(ActionEvent e) {

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void accountCreatedSuccesfullyButton(ActionEvent e) {

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorLoginValidation(ActionEvent e) {

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorPasswordValidtionButtonController(ActionEvent e) {

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorSomethinkWrongButton(ActionEvent e) {

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorAvaratValidtionButtonController(ActionEvent e) {

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     * @throws IOException throws if an error occurs
     */
    @FXML
    private void backButtonController(ActionEvent e) throws IOException {

    }


    /**
     * Method is invokes when account is creat succesfully, and clean the form
     * 
     * 
     */
    public void accountCreatedSuccesfullyNotification() {


    }

    /**
     * Method clean the form
     * 
     * 
     */
    private void cleanForm() {

    }

    /**
     * Method which invokes when login is taken
     */
    public void errorNotification() {

    }

    /**
     * Method which invokes when any error
     */
    public void errorSomethinkWrong() {

    }

    /**
     * Method which load Login view
     * 
     * @throws IOException throws if an error occurs
     */
    private void LoadLoingLauncher() throws IOException {

    }

    /**
     * Method also invokes the error informationS
     * 
     * @param password users new password
     * @return Boolean true when password is longer than 4
     * @throws StringLengthException throws if password is length isn't 4 length at
     *                               least
     */
    public boolean passwordValidation(String password) throws StringLengthException {

    }

    /**
     * Method also invokes the error information
     * 
     * @param password      users new password
     * @param checkPassword users new password check
     * @return boolean true when passwords is same
     * @throws StringSameValidation throws if passwords isn't the same
     */
    public boolean passwordCheckValidation(String password, String checkPassword) throws StringSameValidation {

    }


    /**
     * Method also invokes the error information
     * 
     * @param string name of the lgoin
     * @return boolean true when password is longer than zero length
     */
    private boolean loginValidation(String string) {

    }

    /**
     * 
     * Setter for that is user created succesfully or not
     */
    public void setAllCorrect(boolean userIsCreated) {
        allCorect = userIsCreated;
    }

    /**
     * 
     * Getter for that is user created succesfully or not
     */
    private boolean getAllCorrect() {
        return allCorect;
    }

}