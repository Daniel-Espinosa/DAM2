/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author produccion
 */
public class LoginController implements Initializable {

    @FXML
    private Button loginButton;
    @FXML
    private Button exitButton;
    @FXML
    private Label errorUser;
    @FXML
    private Label errorPass;
    @FXML
    private PasswordField passTextField;
    @FXML
    private TextField userTextField;
    @FXML
    private Button helloWorldButton;
    @FXML
    private VBox vboxGames;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickLogin(ActionEvent event) {
        errorUser.setText("");
        errorPass.setText("");
        if (userTextField.getText().isBlank()) {
            errorUser.setText("Introduce Usuario");
        }
        if (passTextField.getText().isBlank()) {
            errorPass.setText("Introduce Contraseña");
        }
        if(!passTextField.getText().isBlank() && !userTextField.getText().isBlank()){    
        System.out.println("Login");
        }
        
    }

    @FXML
    private void clickExit(ActionEvent event) {
        System.out.println("Adios!");
        System.exit(0);
    }

    @FXML
    private void entroElRaton(MouseEvent event) {
        System.out.println("entro el raton");
    }
    
    private int cont = 0;
    
    @FXML
    private void clickHelloWorldButton(ActionEvent event) {
        try {
            cont++; // Contador para que se vea que cambia!
            
            Pane pane = new Pane(App.loadFXML("AddGame")); //llamo a el pañel generico que solo tiene un puto LABEL!
            
            vboxGames.getChildren().add(pane); //añado el panel generico a una VBOX por poner algo a lo que añadir
            
            Label lb = (Label) pane.lookup("#titulo"); //UN PUTO METODO QUE BUSCA ALGO POR EL ID!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println(lb);
            
            lb.setText("Titulo: " + cont); //seteo al Label con lo que quiero!!!!!!
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
