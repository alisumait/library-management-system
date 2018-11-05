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
public class SearchmController implements Initializable {

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
    private TextField addbn;
    @FXML
    private TextField addisbn;
    @FXML
    private TextField addauthor;
    @FXML
    private TextField addpublisher;
    @FXML
    private Button deleteb;
    @FXML
    private Button changestatus;
    @FXML
    private ComboBox category;
    @FXML
    private Button addb;
    @FXML
    private Button refreash;
    @FXML
    private TextField newcat;
    @FXML
    private Button deletecat;
    
    
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
            
           category.getItems().addAll("All","Sci-Fi","Novels","Business");
    }    
    
    
     @FXML
     public void deleteCat(ActionEvent event) throws IOException{
     
     
          String output = category.getSelectionModel().getSelectedItem().toString();
          try{

    		File file = new File(output+".txt");
    		if(file.delete()){
    	
    		}

    	}catch(Exception e){
            e.getMessage();
    	}
         
          category.getItems().removeAll(output);
     }
    
     @FXML
     public void isCat(ActionEvent event) throws IOException{

         String output = category.getSelectionModel().getSelectedItem().toString();
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
            if (output.equals(newcat.getText())) {
                
                table.setItems(getnewcat());
             
         }
     }
     
     
     @FXML
     public void addCat(ActionEvent event) throws IOException{
                    
             PrintWriter pr = new PrintWriter(new FileOutputStream(newcat.getText()+".txt"));
                         pr.close();
                        category.getItems().addAll(newcat.getText());
                        newcat.clear();
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
    public ObservableList<Bookstable> getnewcat()  {
    
    
    ObservableList<Bookstable> bookstables = FXCollections.observableArrayList();
    
                try{
                    try (Scanner inputStream = new Scanner(new FileInputStream(newcat.getText()+".txt"))) {
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
                return bookstables;
    }

    
     @FXML
        // TODO
    public void table(ActionEvent event) throws IOException{
 
    table.getColumns().addAll(namecolumn, isbncolumn, authorcolumn, publishercolumn);
    
     deletecat.setOnAction(e -> {
        try {
            deleteCat(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
     
     refreash.setOnAction(e -> {
        try {
            refreashMethod(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    
    
    addb.setOnAction(e -> {
        try {
            addMethod(event);
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
    
    deleteb.setOnAction(e -> {
        try {
            deleteMethod(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    
    changestatus.setOnAction(e -> {
        try {
            changeStatus(event);
        } catch (IOException ex) {
            Logger.getLogger(SearchmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
   
    }

    
    @FXML
    public void refreashMethod(ActionEvent event) throws IOException{
    
    
        Parent p3 = FXMLLoader.load(getClass().getResource("Searchm.fxml"));
        Scene f = new Scene(p3);
        Stage st3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st3.setScene(f);
        st3.show();
        SearchController fs = new SearchController();
        fs.getBookstables();
    }
   
   
    @FXML
    public void changeStatus(ActionEvent event) throws IOException{
    
        ObservableList<Bookstable> bookSelected,allbooks;
       allbooks = table.getItems();
       bookSelected = table.getSelectionModel().getSelectedItems();
    
        
       String a = bookSelected.get(0).getName();
       String e = bookSelected.get(0).getStatus();
       
        
        Path path = Paths.get("Books.txt");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll(e, a+" - "+"Available");
        Files.write(path, content.getBytes(charset));

    
    
    }
    
    @FXML
    public void lib(ActionEvent event) throws IOException{
    
    
        Parent p6 = FXMLLoader.load(getClass().getResource("librarianScene.fxml"));
        Scene lhome = new Scene(p6);
        Stage st6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st6.setScene(lhome);
        st6.show();}
    
    
    @FXML
    public void addMethod(ActionEvent event) throws FileNotFoundException{

        
        Bookstable bookstable = new Bookstable();
        bookstable.setName(addbn.getText());
        bookstable.setIsbn(addisbn.getText());
        bookstable.setAuthor(addauthor.getText());
        bookstable.setPublisher(addpublisher.getText());
        bookstable.setStatus("Available");
        table.getItems().add(bookstable);
        
       String w = category.getSelectionModel().getSelectedItem().toString();
        PrintWriter adder = new PrintWriter(new FileOutputStream("Books.txt", true));
        adder.print(addbn.getText());
        adder.print(",");
        adder.print(addisbn.getText());
        adder.print(",");
        adder.print(addauthor.getText());
        adder.print(",");
        adder.print(addpublisher.getText());
        adder.print(",");
        adder.print(addbn.getText()+" - "+"Available");
        adder.print(",");
        adder.println(addbn.getText());
        
        PrintWriter adder1 = new PrintWriter(new FileOutputStream(w+".txt", true));
        adder1.print(addbn.getText());
        adder1.print(",");
        adder1.print(addisbn.getText());
        adder1.print(",");
        adder1.print(addauthor.getText());
        adder1.print(",");
        adder1.print(addpublisher.getText());
        adder1.print(",");
        adder1.print(addbn.getText()+" - "+"Available");
        adder1.print(",");
        adder1.println(addbn.getText());
        adder.close();
        adder1.close();
        
        
        addbn.clear();
        addauthor.clear();
        addisbn.clear();
        addpublisher.clear();

                }

    @FXML
    public void deleteMethod(ActionEvent event) throws FileNotFoundException, IOException{
    
       ObservableList<Bookstable> bookSelected,allbooks;
       allbooks = table.getItems();
       bookSelected = table.getSelectionModel().getSelectedItems();
    
       
       String a = bookSelected.get(0).getName();
       String b = bookSelected.get(0).getIsbn();
       String c = bookSelected.get(0).getAuthor();
       String d = bookSelected.get(0).getPublisher();
       String e = bookSelected.get(0).getStatus();
       
       
       bookSelected.forEach(allbooks::remove);
        
        
        
        File inputFile = new File("Books.txt");
        File tempFile = new File("BooksTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = a+","+b+","+c+","+d+","+e+","+a;
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
        
        //------------------------------------------------------------------------------
        
        
        File inputFile1 = new File("Sci-Fi.txt");
        File tempFile1 = new File("BooksTemp.txt");

        BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1));

        String lineToRemove1 = a+","+b+","+c+","+d+","+e+","+a;
        String currentLine1;

        while((currentLine1 = reader1.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine1.trim();
            if(trimmedLine.equals(lineToRemove1)) continue;
            writer1.write(currentLine1 + System.getProperty("line.separator"));
        }
        writer1.close(); 
        reader1.close(); 
        inputFile1.delete();
        boolean successful1 = tempFile1.renameTo(inputFile1);
        
        //-----------------------------------------------------------------------------
        
        File inputFile2 = new File("Novels.txt");
        File tempFile2 = new File("BooksTemp.txt");

        BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(tempFile2));

        String lineToRemove2 = a+","+b+","+c+","+d+","+e+","+a;
        String currentLine2;

        while((currentLine2 = reader2.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine2.trim();
            if(trimmedLine.equals(lineToRemove2)) continue;
            writer2.write(currentLine2 + System.getProperty("line.separator"));
        }
        writer2.close(); 
        reader2.close(); 
        inputFile2.delete();
        boolean successful2 = tempFile2.renameTo(inputFile2);
        
        //-------------------------------------------------------------------------------
        
        File inputFile3 = new File("Business.txt");
        File tempFile3 = new File("BooksTemp.txt");

        BufferedReader reader3 = new BufferedReader(new FileReader(inputFile3));
        BufferedWriter writer3 = new BufferedWriter(new FileWriter(tempFile3));

        String lineToRemove3 = a+","+b+","+c+","+d+","+e+","+a;
        String currentLine3;

        while((currentLine3 = reader3.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine3.trim();
            if(trimmedLine.equals(lineToRemove3)) continue;
            writer3.write(currentLine3 + System.getProperty("line.separator"));
        }
        writer3.close(); 
        reader3.close(); 
        inputFile3.delete();
        boolean successful3 = tempFile3.renameTo(inputFile3);
        
        //----------------------------------------------------------------------------
        
        File inputFile4 = new File(newcat.getText()+".txt");
        File tempFile4 = new File("BooksTemp.txt");

        BufferedReader reader4 = new BufferedReader(new FileReader(inputFile4));
        BufferedWriter writer4 = new BufferedWriter(new FileWriter(tempFile4));

        String lineToRemove4 = a+","+b+","+c+","+d+","+e+","+a;
        String currentLine4;

        while((currentLine4 = reader4.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine4.trim();
            if(trimmedLine.equals(lineToRemove4)) continue;
            writer4.write(currentLine4 + System.getProperty("line.separator"));
        }
        writer4.close(); 
        reader4.close(); 
        inputFile4.delete();
        boolean successful4 = tempFile4.renameTo(inputFile4);
        
    }}

    

