/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;


public class ProduitService  {
private Connection connection=utils.connect.getInstance().getCnx();
    private Statement ste;
    private PreparedStatement ps;
    private ResultSet rs;

    public void add(Produit T) {
     String req ="insert into Produit(user_id,model,type,price,quantity,photo) values('"+15+"','"+T.getModel()+"','"+T.getType()+"','"+T.getPrice()+"','"+T.getQuantity()+"','"+T.getPhoto()+"')";
        try {
            ste=connection.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Produit> FindAll() {
        ArrayList<Produit> list =  new ArrayList<Produit>();
        String req="select * from Produit";
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int id=rs.getInt("id");
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
               
              
                //list.add(new Societe(Id , nom, tel ,adresse,image));
               Produit s = new Produit( model, type ,price,quantity,photo);
               s.setId(id);
               list.add(s);
              
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        return list; 
    }

    public Produit Find(int id) {
     String req="select * from Produit where id = '"+id+"'";
           Produit s = new Produit();
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
          
               String idusr= rs.getString("user_id");
               String model =rs.getString("model");
               String type =rs.getString("type");
               String price =rs.getString("price");
               String quantity =rs.getString("quantity");
               String photo =rs.getString("photo");
                //list.add(new Societe(Id , nom, tel ,adresse,image));
             s.setId(id);
             s.setModel(model);
             s.setPhoto(photo);
             s.setPrice(price);
             s.setQuantity(quantity);
             s.setType(type);
             
             }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }

        return s;
    }
    
    public int counte() {
        String req="select count(*) as qte from Produit";
      int x=0;
        try {
            ste=connection.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
               int num=rs.getInt("qte");
        return num;
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        
          
    return 0;
    }

  
    public void remove(Produit T) {
    String req="delete from Produit where id = '"+T.getId()+"'";

          try {
             ste=connection.createStatement();
            ste.executeUpdate(req);
           
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }


    public void Modif(Produit T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
