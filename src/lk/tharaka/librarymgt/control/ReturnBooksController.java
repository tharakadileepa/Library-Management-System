/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.tharaka.librarymgt.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.mysql.jdbc.PreparedStatement;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.tharaka.librarymgt.database.DBconnection;
import lk.tharaka.librarymgt.model.ReturnBooksTM;

/**
 * FXML Controller class
 *
 * @author THARAKA
 */
public class ReturnBooksController implements Initializable {

    @FXML
    private JFXComboBox<String> membIDReturn;
    @FXML
    private JFXComboBox<String> bookIDReturn;
    @FXML
    private JFXDatePicker dateReturn;
    @FXML
    private TableView<ReturnBooksTM> tblReturn;
    @FXML
    private JFXButton addReturn;
    @FXML
    private JFXButton cancelReturn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblReturn.getColumns().get(0).setStyle("fx-alignment :center");
        tblReturn.getColumns().get(1).setStyle("fx-alignment :center");
        tblReturn.getColumns().get(2).setStyle("fx-alignment :center");
        
        tblReturn.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("membid"));
        tblReturn.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("bookid"));
        tblReturn.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("date"));
  
        
    }    
    

    @FXML
    private void returnadding(MouseEvent event) {
        
        try {
            Connection connection= DBconnection.getInstance().getConnection();
            Statement stm= connection.createStatement();
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReturnBooksController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void returnCanceling(MouseEvent event) {
    }
    
}
