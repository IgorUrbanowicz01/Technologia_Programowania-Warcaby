package com.client;

import com.client.helpers.Routes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application {

    public void createWindow() {
        launch();
    }

    /**
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Stage stage = new Stage();
        ClientCore.getInstance().programStage = primaryStage;
        // FXML loader
        Parent sceneRoot = FXMLLoader.load(Routes.viewsRoute("StartView.fxml"));
        // Basic scene
        Scene scene = new Scene(sceneRoot, 800, 600);
        scene.getStylesheets().add(Routes.styleRoute("app.css"));

        // Stage settings
        primaryStage.setTitle("WarcabyGame");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(windowEvent -> ClientCore.getInstance().close());
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();

    }

}