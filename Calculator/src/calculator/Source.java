/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Shanejr
 */
public class Source extends Application {
    
    // create the scene on startup
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
                Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

   