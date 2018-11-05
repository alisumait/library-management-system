/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javafx.scene.control.ComboBox;
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
public class SearchController implements Initializable {

    

    @FXML
    private Button borrow;
    @FXML
    private Button goback;
    @FXML
    TableView <Bookstable> table;
    @FXML
    TableColumn<Bookstable, String> namecolumn;
    @FXML
    TableColumn<Bookstable, String> isbncolumn;
    @FXML
    TableColumn<Bookstable, String> authorcolumn;
    @FXML
    TableColumn<Bookstable, String> publishercolumn;
    @FXML
    TableColumn<Bookstable, String> statuscolumn;
    @FXML
    private Button refreash;
    @FXML
    private ComboBox category;
    @FXML
    private TextField addbn;
    @FXML
    private TextField addisbn;
    @FXML
    private TextField addauthor;
    @FXML
    private TextField addpublisher;
    @FXML
    private Button searchb;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
             namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
     

            isbncolumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
    

            authorcolumn.setCellValueFactory(new PropertyValueFactory<>("author"));
    

            publishercolumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
            
            statuscolumn.setCellValueFactory(new PropertyValueFactory<>("status"));
           
            table.setItems(getBookstables());
            
            category.getItems().addAll("Sci-Fi","Business","Novels","All");

         }
    
    
    @FXML
     public void isCat(ActionEvent event) throws IOException{

         String output = category.getSelectionModel().getSelectedItem().toString();
         SearchController v = new SearchController();
            switch (output) {
                case "Sci-Fi":
                    
                    table.setItems(getSciBooks());
                    break;

                case "Novels":
                    table.setItems(getNovels());
                    break;

                case "Business":
                   table.setItems(getBusiness());
                    break;
                case "All":
                   table.setItems(getBookstables());
                    break;
                default:
                   table.setItems(getBookstables());
                    break;
            

             
         }
     }
     
     @FXML
     public ObservableList<Bookstable> getSearch(){
     
     
      ObservableList<Bookstable> bookstables = FXCollections.observableArrayList();
    
                try{
                    try (Scanner inputStream = new Scanner(new FileInputStream("Books.txt"))) {
                        inputStream.useDelimiter(",");
                        
                        while(inputStream.hasNextLine()){
                            
                            String name = inputStream.next();
                            ArrayList<String> names = new ArrayList<>();
                            names.add(name);
                            
                            
                            String isbn = inputStream.next();
                            ArrayList<String> isbns = new ArrayList<>();
                            isbns.add(isbn);
                            
                            String author = inputStream.next();
                            ArrayList<String> authors = new ArrayList<>();
                            authors.add(author);
                            
                            
                            String publisher = inputStream.next();
                            ArrayList<String> publishers = new ArrayList<>();
                            publishers.add(publisher);
                            
                            String status = inputStream.next();
                            ArrayList<String> statuss = new ArrayList<>();
                            statuss.add(status);
                            inputStream.nextLine();
                            
                            
                            
                            bookstables.add(new Bookstable(name.contains(addbn.getText()),addisbn.getText(),addauthor.getText(),addpublisher.getText(),"Available"));
                            
                            
                        }
                        
                        return bookstables;
                    }
                    
                    
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
                return bookstables;
     
     }
     
     @FXML
     public void Searchb(ActionEvent event) {
     
     table.setItems(getSearch());
     }
     
     @FXML
    public ObservableList<Bookstable> getBookstables(){
    
    ObservableList<Bookstable> bookstables = FXCollections.observableArrayList();
    
                try{
                    try (Scanner inputStream = new Scanner(new FileInputStream("Books.txt"))) {
                        inputStream.useDelimiter(",");
                        
                        while(inputStream.hasNextLine()){
                            
                            String name = inputStream.next();
                            ArrayList<String> names = new ArrayList<>();
                            names.add(name);
                            
                            
                            String isbn = inputStream.next();
                            ArrayList<String> isbns = new ArrayList<>();
                            isbns.add(isbn);
                            
                            String author = inputStream.next();
                            ArrayList<String> authors = new ArrayList<>();
                            authors.add(author);
                            
                            
                            String publisher = inputStream.next();
                            ArrayList<String> publishers = new ArrayList<>();
                            publishers.add(publisher);
                            
                            String status = inputStream.next();
                            ArrayList<String> statuss = new ArrayList<>();
                            statuss.add(status);
                            inputStream.nextLine();
                            
                            bookstables.add(new Bookstable(name,isbn,author,publisher,status));
                            
                            
                        }
                        
                        return bookstables;
                    }
                    
                    
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
                return bookstables;
    }
    
     @FXML
    public ObservableList<Bookstable> getSciBooks(){
    
    ObservableList<Bookstable> bookstables = FXCollections.observableArrayList();
    
                try{
                    try (Scanner inputStream = new Scanner(new FileInputStream("Sci-Fi.txt"))) {
                        inputStream.useDelimiter(",");
                        
                        while(inputStream.hasNextLine()){
                            
                            String name = inputStream.next();
                            ArrayList<String> names = new ArrayList<>();
                            names.add(name);
                            
                            
                            String isbn = inputStream.next();
                            ArrayList<String> isbns = new ArrayList<>();
                            isbns.add(isbn);
                            
                            String author = inputStream.next();
                            ArrayList<String> authors = new ArrayList<>();
                            authors.add(author);
                            
                            
                            String publisher = inputStream.next();
                            ArrayList<String> publishers = new ArrayList<>();
                            publishers.add(publisher);
                            
                            String status = inputStream.next();
                            ArrayList<String> statuss = new ArrayList<>();
                            statuss.add(status);
                            inputStream.nextLine();
                            
                            bookstables.add(new Bookstable(name,isbn,author,publisher,status));
                            
                            
                        }
                        
                        return bookstables;
                    }
                    
                    
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
                return bookstables;
    }

     @FXML
    public ObservableList<Bookstable> getNovels(){
    
    ObservableList<Bookstable> bookstables = FXCollections.observableArrayList();
    
                try{
                    try (Scanner inputStream = new Scanner(new FileInputStream("Novels.txt"))) {
                        inputStream.useDelimiter(",");
                        
                        while(inputStream.hasNextLine()){
                            
                            String name = inputStream.next();
                            ArrayList<String> names = new ArrayList<>();
                            names.add(name);
                            
                            
                            String isbn = inputStream.next();
                            ArrayList<String> isbns = new ArrayList<>();
                            isbns.add(isbn);
                            
                            String author = inputStream.next();
                            ArrayList<String> authors = new ArrayList<>();
                            authors.add(author);
                            
                            
                            String publisher = inputStream.next();
                            ArrayList<String> publishers = new ArrayList<>();
                            publishers.add(publisher);
                            
                            String status = inputStream.next();
                            ArrayList<String> statuss = new ArrayList<>();
                            statuss.add(status);
                            inputStream.nextLine();
                            
                            bookstables.add(new Bookstable(name,isbn,author,publisher,status));
                            
                            
                        }
                        
                        return bookstables;
                    }
                    
                    
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
                return bookstables;
    }

    
     @FXML
    public ObservableList<Bookstable> getBusiness(){
    
    ObservableList<Bookstable> bookstables = FXCollections.observableArrayList();
    
                try{
                    try (Scanner inputStream = new Scanner(new FileInputStream("Business.txt"))) {
                        inputStream.useDelimiter(",");
                        
                        while(inputStream.hasNextLine()){
                            
                            String name = inputStream.next();
                            ArrayList<String> names = new ArrayList<>();
                            names.add(name);
                            
                            
                            String isbn = inputStream.next();
                            ArrayList<String> isbns = new ArrayList<>();
                            isbns.add(isbn);
                            
                            String author = inputStream.next();
                            ArrayList<String> authors = new ArrayList<>();
                            authors.add(author);
                            
                            
                            String publisher = inputStream.next();
                            ArrayList<String> publishers = new ArrayList<>();
                            publishers.add(publisher);
                            
                            String status = inputStream.next();
                            ArrayList<String> statuss = new ArrayList<>();
                            statuss.add(status);
                            inputStream.nextLine();
                            
                            bookstables.add(new Bookstable(name,isbn,author,publisher,status));
                            
                            
                        }
                        
                        return bookstables;
                    }
                    
                    
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
                return bookstables;}
    
     @FXML
        // TODO
    public void table(ActionEvent event) throws IOException{
    
    table.getColumns().addAll(namecolumn, isbncolumn, authorcolumn, publishercolumn);
    
    searchb.setOnAction(e -> Searchb(event));
    
    refreash.setOnAction(e -> {
        try {
            refreashMethod(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    
    borrow.setOnAction(e -> {
        try {
            borrowMethod(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    
    goback.setOnAction(e -> {
        try {
            mem(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
    
    }
    
    
    
    @FXML
    public void mem(ActionEvent event) throws IOException{
    
    
    Parent p2 = FXMLLoader.load(getClass().getResource("memberScene.fxml"));
        Scene shome = new Scene(p2);
        Stage st2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st2.setScene(shome);
        st2.show();}
    
    
    @FXML
    public void borrowMethod(ActionEvent event) throws FileNotFoundException, IOException{

        
        ObservableList<Bookstable> bookSelected,allbooks;
       allbooks = table.getItems();
       bookSelected = table.getSelectionModel().getSelectedItems();
    
        
       String a = bookSelected.get(0).getName();
       String e = bookSelected.get(0).getStatus();
       
        
        Path path = Paths.get("Books.txt");
Charset charset = StandardCharsets.UTF_8;

String content = new String(Files.readAllBytes(path), charset);
content = content.replaceAll(e, a+" - "+"Borrowed");
Files.write(path, content.getBytes(charset));

    }

     @FXML
    public void refreashMethod(ActionEvent event) throws IOException{
    
    
        Parent p3 = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene f = new Scene(p3);
        Stage st3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st3.setScene(f);
        st3.show();
        SearchController fs = new SearchController();
        fs.getBookstables();
    }

}
    

    


