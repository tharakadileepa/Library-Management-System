/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.tharaka.librarymgt.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.tharaka.librarymgt.database.DBconnection;
import lk.tharaka.librarymgt.model.MemberTM;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author THARAKA
 */
public class MemberRegisterController implements Initializable {

    @FXML
    private JFXTextField txtMembID;
    @FXML
    private JFXTextField txtMembAddress;
    @FXML
    private JFXTextField txtMembName;
    @FXML
    private JFXTextField txtMembContact;
    @FXML
    private TableView<MemberTM> tblmemb;
    @FXML
    private JFXButton btnMembAdd;
    @FXML
    private JFXButton btnMembCancel;
    @FXML
    private JFXButton btnMembShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      tblmemb.getColumns().get(0).setStyle("fx-alignment: center");
      tblmemb.getColumns().get(1).setStyle("fx-alignment: center");
      tblmemb.getColumns().get(2).setStyle("fx-alignment: center");
      tblmemb.getColumns().get(3).setStyle("fx-alignment: center");
      
      
      tblmemb.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("memberID"));
      tblmemb.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("memberName"));
      tblmemb.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("memberContact"));
      tblmemb.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("memberAddress"));
      
    }    

    @FXML
    private void getMember(MouseEvent event) {
    }

    @FXML
    private void removeMem(MouseEvent event) {
    }

    @FXML
    private void showMemReport(MouseEvent event) throws JRException {
         try {
            InputStream is = getClass().getResourceAsStream("/lk/tharaka/librarymgt/reports/member.jasper");
            HashMap map=new HashMap();
            JasperPrint jasp=JasperFillManager.fillReport(is, map,DBconnection.getInstance().getConnection());
            JasperViewer.viewReport(jasp);
            
      
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MemberRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
