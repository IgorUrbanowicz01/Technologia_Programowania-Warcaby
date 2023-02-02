package com.client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import com.client.ClientCore;
import com.client.helpers.Routes;
import com.client.helpers.exceptions.StringLengthException;
import com.client.helpers.exceptions.StringSameValidation;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class responsible for controlling the layout of the login screen and the
 * functionality.
 */
public class RegisteryController implements Initializable {

    @FXML
    private Button buttonBack;
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
    Pane errorSomethingWrong;
    Pane errorThisLoginIsToShort;

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
        ClientCore.getInstance().setRegisteryController(this);
    }

    private boolean allCorrect = false;

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
    public void createAccountButtonController(ActionEvent e)
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

            if (e.getSource() == buttonBack) {
                loadLoginLauncher();
            }

        }

    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    public void errorPaneLoginExistButton(ActionEvent e) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(errorRegisteryNewAccount);
        transition.setToX(0);
        transition.play();
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    public void errorPanePasswordButton(ActionEvent e) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(errorPanePassword);
        transition.setToX(0);
        transition.play();
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    public void accountCreatedSuccesfullyButton(ActionEvent e) {
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(false);
        transition.setNode(accountCreatedSuccesfully);
        transition.setToX(0);
        transition.play();
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    public void errorLoginValidation(ActionEvent e) {
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(false);
        transition.setNode(errorThisLoginIsToShort);
        transition.setToX(0);
        transition.play();
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    public void errorPasswordValidationButtonController(ActionEvent e) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(errorPanePasswordValidation);
        transition.setToX(0);
        transition.play();
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     */
    @FXML
    public void errorSomethingWrongButton(ActionEvent e) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(errorSomethingWrong);
        transition.setToX(0);
        transition.play();
    }

    /**
     * Method to close the error pane
     * 
     * @param e users actionEvent
     * @throws IOException throws if an error occurs
     */
    @FXML
    public void backButtonController(ActionEvent e) throws IOException {
        loadLoginLauncher();
    }

    /**
     * Method is invokes when account is creat succesfully, and clean the form
     * 
     * 
     */
    public void accountCreatedSuccesfullyNotification() {
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(true);
        transition.setNode(accountCreatedSuccesfully);
        transition.setToX(-300);
        transition.play();

    }

    /**
     * Method clean the form
     * 
     * 
     */
    private void cleanForm() {
        newLogin.setText("");
        newPassword.setText("");
        checkNewPassword.setText("");
    }

    /**
     * Method which invokes when login is taken
     */
    public void errorNotification() {
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(true);
        transition.setNode(errorRegisteryNewAccount);
        transition.setToX(-300);
        transition.play();
    }

    /**
     * Method which invokes when any error
     */
    public void errorSomethingWrong() {
        TranslateTransition transition = new TranslateTransition();
        accountCreatedSuccesfully.setVisible(true);
        transition.setNode(errorSomethingWrong);
        transition.setToX(-300);
        transition.play();
    }

    /**
     * Method which load login view
     * 
     * @throws IOException throws if an error occurs
     */
    public void loadLoginLauncher() throws IOException {
        stage = (Stage) buttonCreateAccount.getScene().getWindow();
        root = FXMLLoader.load(Routes.viewsRoute("LoginIntoLauncher.fxml"));
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(Routes.styleRoute("app.css"));
        stage.setScene(scene);
        stage.show();
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
        if (password.length() > 4) {
            return true;
        } else {
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(errorPanePasswordValidation);
            transition.setToX(-300);
            transition.play();
            return false;
        }
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

    /**
     * Method also invokes the error information
     * 
     * @param string name of the lgoin
     * @return boolean true when password is longer than zero length
     */
    public boolean loginValidation(String string) {
        if (string.length() > 0) {
            return true;
        } else {
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(errorThisLoginIsToShort);
            transition.setToX(-300);
            transition.play();
            return false;
        }
    }

    /**
     * 
     * Setter for that is user created succesfully or not
     */
    public void setAllCorrect(boolean userIsCreated) {
        allCorrect = userIsCreated;
    }

    /**
     * 
     * Getter for that is user created succesfully or not
     */
    private boolean getAllCorrect() {
        return allCorrect;
    }
}
