/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.tharaka.librarymgt.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.font.freetype.HBGlyphLayout;
import com.sun.org.apache.bcel.internal.generic.D2F;
import com.sun.scenario.effect.impl.Renderer;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.tharaka.librarymgt.database.DBconnection;
import lk.tharaka.librarymgt.main.LibraryMgt;
import lk.tharaka.librarymgt.model.BookStoreTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author THARAKA
 */
public class BookStoreController implements Initializable {

    @FXML
    private JFXTextField bid_txt;
    @FXML
    private JFXTextField b_isbn_txt;
    @FXML
    private JFXTextField b_name;
    @FXML
    private JFXTextField b_author;
    @FXML
    private JFXTextField b_publication;
    @FXML
    private JFXButton btn_add;
    @FXML
    private TableView<BookStoreTM> tblStore;
    @FXML
    private JFXButton btn_cancel;
    @FXML
    private JFXButton btnReport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblStore.getColumns().get(0).setStyle("-fx-alignment: center");
        tblStore.getColumns().get(1).setStyle("-fx-alignment: center");
        tblStore.getColumns().get(2).setStyle("-fx-alignment: center");
        tblStore.getColumns().get(3).setStyle("-fx-alignment: center");
        tblStore.getColumns().get(4).setStyle("-fx-alignment: center");

        tblStore.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStore.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("isbn"));
        tblStore.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStore.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblStore.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("publication"));

        loadAlltable();

    }

    public void loadAlltable() {
        try {
            Connection connection = DBconnection.getInstance().getConnection();
            Statement s = connection.createStatement();
            ResultSet resultSet = s.executeQuery("SELECT * FROM book");

            ObservableList<BookStoreTM> items = tblStore.getItems();

            items.removeAll(items);

            while (resultSet.next()) {

                BookStoreTM bstm = new BookStoreTM();
                bstm.setId(resultSet.getString("bid"));
                bstm.setIsbn(resultSet.getString("isbn"));
                bstm.setName(resultSet.getString("name"));
                bstm.setAuthor(resultSet.getString("publisher"));
                bstm.setPublication(resultSet.getString("author"));

                items.add(bstm);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookStoreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookStoreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickAdd(ActionEvent event) {
        String sm = "insert into book values(?,?,?,?,?)";
        try {

            Connection connection = DBconnection.getInstance().getConnection();

            PreparedStatement pst = connection.prepareStatement(sm);

            pst.setObject(1, bid_txt.getText());
            pst.setObject(2, b_isbn_txt.getText());
            pst.setObject(3, b_name.getText());
            pst.setObject(5, b_author.getText());
            pst.setObject(4, b_publication.getText());

            int rst = pst.executeUpdate();
            if (rst > 0) {

                loadAlltable();
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookStoreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookStoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickCancel(ActionEvent event) {

    }

    @FXML
    private void goback(MouseEvent event) {

    }

    @FXML
    private void showReport(MouseEvent event) {
        try {
            InputStream strm = getClass().getResourceAsStream("/lk/tharaka/librarymgt/reports/Blank_A4.jasper");
            HashMap map = new HashMap();
            map.put("total", 800.00);
            JasperPrint jasp = JasperFillManager.fillReport(strm, map, DBconnection.getInstance().getConnection());
            JasperViewer.viewReport(jasp);
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookStoreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookStoreController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(BookStoreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
