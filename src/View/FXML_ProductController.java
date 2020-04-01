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
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author derba
 */
public class FXML_ProductController implements Initializable {
 double xOffset=0;
double yOffset=0;


    @FXML
    private AnchorPane panell;
    @FXML
    private ScrollPane scroll;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                // TODO


          GridPane grid = new GridPane();

    grid.setPadding(new javafx.geometry.Insets(10,10,10,10));
   
             
       
ProduitService sb=new ProduitService();
List<Produit>lst=sb.FindAll();
int elements=sb.counte();


 grid.setHgap(10);
 grid.setVgap(10);
 int cols=4, colCnt = 0, rowCnt = 0;

    for (int i=0; i<elements; i++) {
FileInputStream input = null;
              try {
                  input = new FileInputStream("C:\\images\\"+lst.get(i).getPhoto());
        
                  Image image = new Image(input);
                  ImageView imageView = new ImageView(image);
                  imageView.setFitHeight(100);
                  imageView.setFitWidth(100);
                  Label label1 = new Label(lst.get(i).getModel());
                  Label label2 = new Label(lst.get(i).getType());
                  Label label3 = new Label(lst.get(i).getQuantity());
                  Label label4 = new Label(lst.get(i).getPrice()+" $");
                  int x=lst.get(i).getId();
                
                  VBox root = new VBox(label1,imageView,label2,label3,label4);
                  grid.add(root,colCnt,rowCnt);
                  colCnt+=1;
                  if (colCnt>cols) {
                      rowCnt++;
                      colCnt=0;
                  }     } catch (FileNotFoundException ex) {
                  Logger.getLogger(FXML_ProductController.class.getName()).log(Level.SEVERE, null, ex);
              } 
    }
 panell.getChildren().add(grid);
    
    

  

    
  
    
    
    
    
    }    
    }