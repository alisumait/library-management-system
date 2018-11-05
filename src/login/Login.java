/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author alisu
 */
public class Login extends Application {
    Stage window;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
        
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        launch(args);
        
        
    }
    
}
