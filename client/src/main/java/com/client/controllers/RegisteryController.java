package com.client.controllers;

<<<<<<< Updated upstream
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
=======
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import com.client.ClientCore;
import com.client.helpers.Routes;
import com.client.helpers.exceptions.StringLengthException;
import com.client.helpers.exceptions.StringSameValidation;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class responsible for controlling the layout of the login screen and the
 * functionality.
 */
public class RegisteryController implements Initializable {

    @FXML
    private Button btnBack;
    private Button buttonCreateAccount;
    @FXML
    private TextField newLogin; 
    private TextField newPassword;
    private TextField checkNewPassword;
    @FXML
    Pane errorRegisteryNewAccount;
    Pane errorPanePassword;
    Pane accountCreatedSuccesfully;
    Pane errorPanePasswordValidation;
    Pane errorSomethinkWrong;
    Pane  errorrThisLoginIsToShort;

    private static Stage stage;
    private static Parent root;


    /**
>>>>>>> Stashed changes
     * Method for initialize controller and send it to server
     * 
     * @param url            users url
     * @param resourceBundle users resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
<<<<<<< Updated upstream

=======
        ClientCore.getInstance().setRegisteryController(this);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    private void CreateAccountButtonController(ActionEvent e)
=======
    private void createAccountButtonController(ActionEvent e)
            throws NumberFormatException, StringSameValidation, Exception {

        if (e.getSource() == buttonCreateAccount) {
            if (loginValidation(newLogin.getText().toString())) {
                if (passwordValidation(newPassword.getText())) {
                    if (passwordCheckValidation(newPassword.getText().toString(),
                            checkNewPassword.getText().toString())) {
                        if (avatatValidation(avatarChoiceBox.getValue())) {
                            ClientCore.getInstance().reqCreateNewAccount(newLogin.getText(), newPassword.getText(),
                                    Integer.parseInt(avatarChoiceBox.getValue().split(" ")[1]));
                            TimeUnit.MILLISECONDS.sleep(20);
                            if (getAllCorrect()) {
                                cleanForm();
                            }
                        }
                    }
                }
            }

            if (e.getSource() == btnBack) {
                loadLoingLauncher();
            }

        }
>>>>>>> Stashed changes

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorPaneLoginExistButton(ActionEvent e) {
<<<<<<< Updated upstream

=======
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(errorRegisteryNewAccount);
        transition.setToX(0);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorPanePasswordButton(ActionEvent e) {
<<<<<<< Updated upstream

=======
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(errorPanePassword);
        transition.setToX(0);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void accountCreatedSuccesfullyButton(ActionEvent e) {
<<<<<<< Updated upstream

=======
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(false);
        transition.setNode(accountCreatedSuccesfully);
        transition.setToX(0);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorLoginValidation(ActionEvent e) {
<<<<<<< Updated upstream

=======
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(false);
        transition.setNode(errorrThisLoginIsToShort);
        transition.setToX(0);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorPasswordValidtionButtonController(ActionEvent e) {
<<<<<<< Updated upstream

=======
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(errorPanePasswordValidation);
        transition.setToX(0);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorSomethinkWrongButton(ActionEvent e) {
<<<<<<< Updated upstream

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    private void errorAvaratValidtionButtonController(ActionEvent e) {

=======
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(errorSomethinkWrong);
        transition.setToX(0);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     * @throws IOException throws if an error occurs
     */
    @FXML
    private void backButtonController(ActionEvent e) throws IOException {
<<<<<<< Updated upstream

    }


=======
        loadLoingLauncher();
    }

>>>>>>> Stashed changes
    /**
     * Method is invokes when account is creat succesfully, and clean the form
     * 
     * 
     */
    public void accountCreatedSuccesfullyNotification() {
<<<<<<< Updated upstream

=======
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(true);
        transition.setNode(accountCreatedSuccesfully);
        transition.setToX(-300);
        transition.play();
>>>>>>> Stashed changes

    }

    /**
     * Method clean the form
     * 
     * 
     */
    private void cleanForm() {
<<<<<<< Updated upstream

=======
        newLogin.setText("");
        newPassword.setText("");
        checkNewPassword.setText("");
>>>>>>> Stashed changes
    }

    /**
     * Method which invokes when login is taken
     */
    public void errorNotification() {
<<<<<<< Updated upstream

=======
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(true);
        transition.setNode(errorRegisteryNewAccount);
        transition.setToX(-300);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method which invokes when any error
     */
    public void errorSomethinkWrong() {
<<<<<<< Updated upstream

=======
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(true);
        transition.setNode(errorSomethinkWrong);
        transition.setToX(-300);
        transition.play();
>>>>>>> Stashed changes
    }

    /**
     * Method which load Login view
     * 
     * @throws IOException throws if an error occurs
     */
<<<<<<< Updated upstream
    private void LoadLoingLauncher() throws IOException {

=======
    private void loadLoingLauncher() throws IOException {
        stage = (Stage) buttonCreateAccount.getScene().getWindow();
        root = FXMLLoader.load(Routes.viewsRoute("LoginIntoLauncher.fxml"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(Routes.styleRoute("app.css"));
        stage.setScene(scene);
        stage.show();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

=======
        if (password.length() > 4) {
            return true;
        } else {
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(errorPanePasswordValidation);
            transition.setToX(-300);
            transition.play();
            return false;
        }
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

    }


=======
        if (password.equals(checkPassword)) {
            return true;
        } else {
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(errorPanePassword);
            transition.setToX(-300);
            transition.play();
            return false;
        }
    }

>>>>>>> Stashed changes
    /**
     * Method also invokes the error information
     * 
     * @param string name of the lgoin
     * @return boolean true when password is longer than zero length
     */
    private boolean loginValidation(String string) {

<<<<<<< Updated upstream
=======
        if (string.length() > 0) {
            return true;
        } else {
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(errorrThisLoginIsToShort);
            transition.setToX(-300);
            transition.play();
            return false;
        }
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
