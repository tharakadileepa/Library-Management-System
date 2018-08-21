/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.tharaka.librarymgt.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author THARAKA
 */
public class LibraryMgt extends Application {
    
 

   

    @Override
    public void start(Stage primaryStage){
        
        try {
            Parent root= FXMLLoader.load(this.getClass().getResource("/lk/tharaka/librarymgt/view/Main.fxml"));
            
            Scene sm=new Scene(root);
            
            primaryStage.setTitle("Hello");
            primaryStage.setScene(sm);
            primaryStage.setResizable(false);
            
            primaryStage.show();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(LibraryMgt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        
        
        
    }
     public static void main(String[] args) {
        launch(args);
    }  
}
