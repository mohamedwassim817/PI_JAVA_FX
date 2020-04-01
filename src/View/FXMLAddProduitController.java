/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Produit;
import Services.ProduitService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class FXMLAddProduitController implements Initializable {

    @FXML
    private TextField model;
    @FXML
    private TextField type;
    @FXML
    private TextField price;
    @FXML
    private TextField quantity;
    @FXML
    private ImageView image;
    @FXML
    private Button ajouter;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Image img = new Image(new FileInputStream("C:\\images\\Capture.PNG"));
            
            
            image.setImage(img);
            //Setting the image view 1 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLAddProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }    

    @FXML
    private void ajout(ActionEvent event) {
        ProduitService ps=new ProduitService();
        Produit T=new Produit();    
        T.setModel(model.getText());
        T.setType(type.getText());
        T.setPhoto("Capture.PNG");
        T.setPrice(price.getText());
        T.setQuantity(quantity.getText());
       
        ps.add(T);
    }
    
}
