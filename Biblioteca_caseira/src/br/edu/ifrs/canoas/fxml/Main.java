package br.edu.ifrs.canoas.fxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe responsável por iniciar e redirecionar as telas do sistema
 * @author Aluno
 */
public class Main extends Application {
    private static Stage st;
 
    /**
     * Troca a tela da biblioteca quando solicitado
     * @param c
     */
    public static void trocarTelaBiblioteca(String c)
    {
        Parent root = null;
        try 
        {
            root = FXMLLoader.load( Main.class.getResource(c));
        } catch (IOException ex) {
            System.out.println("Problema com o FXML");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        st.setScene(scene);
        st.show();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        st = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
