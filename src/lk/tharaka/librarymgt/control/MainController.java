/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.tharaka.librarymgt.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author THARAKA
 */
public class MainController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView members;
    @FXML
    private ImageView book_Store;
    @FXML
    private ImageView book_Borrow;
    @FXML
    private ImageView book_Return;
    @FXML
    private Label lblMenu;
    @FXML
    private Label lblDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        
    }    

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
         if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
        
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) throws IOException {
         if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            switch(icon.getId()){
                case "book_Store":
                    lblMenu.setText("Manage Books");
                    lblDescription.setText("Click to add, edit, delete, search or view Books");
                    break;
                case "members":
                    lblMenu.setText("Manage Members");
                    lblDescription.setText("Click to add, edit, delete, search or view members");
                    break;
                case "book_Borrow":
                    lblMenu.setText("Manage Book Borrows");
                    lblDescription.setText("Click if you want to borrow");
                    break;
                case "book_Return":
                    lblMenu.setText("Manage Book Return");
                    lblDescription.setText("Click if you want to return");
                    break;
            }
            
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play(); 
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);            
        
         }
    }

    @FXML
      private void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            Parent root = null;
            
            switch(icon.getId()){
                case "book_Store":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/tharaka/librarymgt/view/BookStore.fxml"));
                    break;
                case "members":
                   root = FXMLLoader.load(this.getClass().getResource("/lk/tharaka/librarymgt/view/MemberRegister.fxml"));
                   break;
//                case "imgOrder":
//                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/PlaceOrderForm.fxml"));
//                    break;
//                case "imgReport":
//                    break;
                
            }
            
            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                
                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
    }
    
        }}

  
}