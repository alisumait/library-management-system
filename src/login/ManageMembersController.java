/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alisu
 */
public class ManageMembersController implements Initializable {

    
    @FXML
    private Button goback;
    @FXML
    TableView <Members> table;
    @FXML
    TableColumn<Members, String> namecolumn;
    @FXML
    TableColumn<Members, String> passcolumn;
    @FXML
    TableColumn<Members, String> emailcolumn;
    @FXML
    private TextField memname;
    @FXML
    private TextField mempass;
    @FXML
    private TextField mememail;
    @FXML
    private Button deletemem;
    @FXML
    private Button addmem;
    @FXML
    private Button refreash;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
             namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
     

            passcolumn.setCellValueFactory(new PropertyValueFactory<>("pass"));
    

            emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    

            
            table.setItems(getMembers());

    }    

    
     @FXML
    final ObservableList<Members> getMembers(){
    
    ObservableList<Members> members = FXCollections.observableArrayList();
    
     
    try{
                 try (Scanner inputStream = new Scanner(new FileInputStream("members.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String name = inputStream.next();
                         ArrayList<String> names = new ArrayList<>();
                         names.add(name);
                         
                         
                         String pass = inputStream.next();
                         ArrayList<String> passes = new ArrayList<>();
                         passes.add(pass);
                         
                          String email = inputStream.next();
                         ArrayList<String> emails = new ArrayList<>();
                         emails.add(email);
                         
                         inputStream.nextLine();

    members.add(new Members(name,pass,email));
    
     
    }
                     
    return members;
                 }
    
    
    }
     catch (Exception e){
                    System.out.println(e.getMessage());
            }
    return members;
    }
    
    
     @FXML
        // TODO
    public void table(ActionEvent event) throws IOException{
   
    table.getColumns().addAll(namecolumn, passcolumn, emailcolumn);
    
      
     refreash.setOnAction(e -> {
        try {
            refreashMethod(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    
    
    addmem.setOnAction(e -> {
        try {
            addMember(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    
    goback.setOnAction(e -> {
        try {
            lib(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchmController.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
    
    deletemem.setOnAction(e -> {
        try {
            deleteMember(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    }

    @FXML
    public void refreashMethod(ActionEvent event) throws IOException{
    
    
        Parent p2 = FXMLLoader.load(getClass().getResource("manageMembers.fxml"));
        Scene shome = new Scene(p2);
        Stage st2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st2.setScene(shome);
        st2.show();}
    
    
    
    @FXML
    public void lib(ActionEvent event) throws IOException{
    
    
        Parent p6 = FXMLLoader.load(getClass().getResource("librarianScene.fxml"));
        Scene lhome = new Scene(p6);
        Stage st6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st6.setScene(lhome);
        st6.show();}
    
    
    @FXML
    public void addMember(ActionEvent event) throws FileNotFoundException{

        
        Members members = new Members();
        members.setName(memname.getText());
        members.setPass(mempass.getText());
        members.setEmail(mememail.getText());
        table.getItems().add(members);
        
       
        PrintWriter adder = new PrintWriter(new FileOutputStream("members.txt", true));
        adder.print(memname.getText());
        adder.print(",");
        adder.print(mempass.getText());
        adder.print(",");
        adder.print(mememail.getText());
        adder.print(",");
        adder.println(memname.getText());
        adder.close();
        
        
        memname.clear();
        mempass.clear();
        mememail.clear();

                }

    @FXML
    public void deleteMember(ActionEvent event) throws FileNotFoundException, IOException{
    
       ObservableList<Members> memberSelected,allMembers;
       allMembers = table.getItems();
       memberSelected = table.getSelectionModel().getSelectedItems();
    
        
       String a = memberSelected.get(0).getName();
       String b = memberSelected.get(0).getPass();
       String c = memberSelected.get(0).getEmail();
       
        
       memberSelected.forEach(allMembers::remove);
        
        
        
        File inputFile = new File("Members.txt");
        File tempFile = new File("MembersTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = a+","+b+","+c+","+a;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        inputFile.delete();
        boolean successful = tempFile.renameTo(inputFile);
  
    }}
