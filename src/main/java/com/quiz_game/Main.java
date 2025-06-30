package com.quiz_game;

import com.quiz_game.utils.DatabaseInitializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize database with sample questions
        DatabaseInitializer.initializeDatabase();

        // ✅ Load the main quiz view (corrected path)
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/quiz_game/views/quiz.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Quiz Game");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
