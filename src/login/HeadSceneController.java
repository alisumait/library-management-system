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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alisu
 */
public class HeadSceneController implements Initializable {

    
    @FXML
    private Button lbacky;
    @FXML
    public TextField huser;
    @FXML
    public TextField hpass;
    @FXML
    private TextField hemail;
    @FXML
    private Button generate;
    @FXML
    private Button updatelib;
    @FXML
    private Label reportl;
    @FXML
    private Label uplabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         try {
            huser.setText(User()[0]);
            hpass.setText(User()[1]);
            hemail.setText(User()[2]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibrarianSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }    
    
     @FXML
    public void Updatep(ActionEvent event) throws IOException{

       String a = User()[0];
       String b = User()[1];
       String c = User()[2];
       String d = huser.getText();
       String e = hpass.getText();
       String f = hemail.getText();
       
       Path path = Paths.get("head.txt");
Charset charset = StandardCharsets.UTF_8;

String content = new String(Files.readAllBytes(path), charset);
content = content.replaceAll(a+","+b+","+c+","+a, d+","+e+","+f+","+d);
Files.write(path, content.getBytes(charset));

uplabel.setText("Profile Updated Successfully!");
  

    }
    
    @FXML
    public String[] User() throws FileNotFoundException{
    String[] arr = new String[3];
    int y =0;
        try{Scanner sc = new Scanner (new FileInputStream("User.txt"));
            while (sc.hasNextLine()) {
                arr[y]=sc.nextLine();
                y++;
            }
            sc.close();
    }catch(Exception e){}
    
    return arr;
    }
    
    @FXML
    public void showHeadScene(ActionEvent event) throws IOException{

        updatelib.setOnAction(e -> {
            try {
                Updatep(event);
            } catch (IOException ex) {
                Logger.getLogger(HeadSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        generate.setOnAction(e ->{
            try {
                generateMethod(event);
            } catch (IOException ex) {
                Logger.getLogger(HeadSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        lbacky.setOnAction(e -> {
            try {
                lhomy(event);
            } catch (IOException ex) {
                Logger.getLogger(HeadSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    @FXML
    public void lhomy(ActionEvent event) throws IOException{
        
        Parent p2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene shome = new Scene(p2);
        Stage st2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st2.setScene(shome);
        st2.show();}
    
    @FXML
    public void generateMethod(ActionEvent event) throws IOException{
    
    
        
        File inputFile = new File("Members.txt");
        File tempFile = new File("Report.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

       String lineToRemove=null;
        String currentLine;
        writer.write("Members Information:");
        writer.newLine();
        writer.newLine();
        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        
        File inputFile1 = new File("Books.txt");
        File tempFile1 = new File("Report.txt");

        BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile1));

       String lineToRemove1=null;
        String currentLine1;
        writer.newLine();
        writer.write("--------------------------------------------------------------------------------");
        writer.newLine();
        writer.write("Books Information:");
        writer.newLine();
        writer.newLine();
        while((currentLine1 = reader1.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine1.trim();
            if(trimmedLine.equals(lineToRemove1)) continue;
            writer.write(currentLine1 + System.getProperty("line.separator"));
        }
        
        File inputFile2 = new File("librarians.txt");
        File tempFile2 = new File("Report.txt");

        BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(tempFile2));

       String lineToRemove2=null;
        String currentLine2;
        writer.newLine();
        writer.write("--------------------------------------------------------------------------------");
        writer.newLine();
        writer.write("Librarians Information:");
        writer.newLine();
        writer.newLine();
        while((currentLine2 = reader2.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine2.trim();
            if(trimmedLine.equals(lineToRemove2)) continue;
            writer.write(currentLine2 + System.getProperty("line.separator"));
        }
        
        File inputFile3 = new File("steveClock.txt");
        File tempFile3 = new File("Report.txt");

        BufferedReader reader3 = new BufferedReader(new FileReader(inputFile3));
        BufferedWriter writer3 = new BufferedWriter(new FileWriter(tempFile3));

       String lineToRemove3=null;
        String currentLine3;
        writer.newLine();
        writer.write("--------------------------------------------------------------------------------");
        writer.newLine();
        writer.write("Steve's Attendance:");
        writer.newLine();
        writer.newLine();
        while((currentLine3 = reader3.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine3.trim();
            if(trimmedLine.equals(lineToRemove3)) continue;
            writer.write(currentLine3 + System.getProperty("line.separator"));
        }
        
        
        File inputFile4 = new File("omarClock.txt");
        File tempFile4 = new File("Report.txt");

        BufferedReader reader4 = new BufferedReader(new FileReader(inputFile4));
        BufferedWriter writer4 = new BufferedWriter(new FileWriter(tempFile4));

       String lineToRemove4=null;
        String currentLine4;
        writer.newLine();
        writer.write("--------------------------------------------------------------------------------");
        writer.newLine();
        writer.write("Omar's Attendance:");
        writer.newLine();
        writer.newLine();
        while((currentLine4 = reader4.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine4.trim();
            if(trimmedLine.equals(lineToRemove4)) continue;
            writer.write(currentLine4 + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        reportl.setText("Report Generated Successfully!");
    }}
    
    
    


