/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.tharaka.librarymgt.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import lk.tharaka.librarymgt.model.BorrowBooksTM;

/**
 * FXML Controller class
 *
 * @author THARAKA
 */
public class BorrowBooksController implements Initializable {

    @FXML
    private JFXComboBox<String> membIDBorrow;
    @FXML
    private JFXComboBox<String> bookIDBorrow;
    @FXML
    private JFXDatePicker borrowDate;
    @FXML
    private TableView<BorrowBooksTM> tblBorrow;
    @FXML
    private JFXButton addBorrow;
    @FXML
    private JFXButton cancelBorrow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void borrowAdding(MouseEvent event) {
    }

    @FXML
    private void borrowCanceling(MouseEvent event) {
    }
    
}
