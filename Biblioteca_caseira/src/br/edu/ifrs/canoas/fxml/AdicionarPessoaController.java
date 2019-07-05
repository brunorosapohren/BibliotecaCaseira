/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 * Controller responsável por controlar o adicionar, remover, listar e editar Pessoas no Banco de Dados
 * @author Bruno-PC
 */
public class AdicionarPessoaController implements Initializable {

    @FXML
    private TableView<?> tabelaPessoa;
    @FXML
    private TableColumn<?, ?> nomePessoa;
    @FXML
    private TableColumn<?, ?> dataNascimento;
    @FXML
    private TableColumn<?, ?> tipoPessoa;
    @FXML
    private Button excluirPessoaBT;
    @FXML
    private Button adicionarPessoaBT;
    @FXML
    private Button cancelarBT;
    @FXML
    private Button editarPessoaBT;
    @FXML
    private TextField nomeCadastro;
    @FXML
    private TextField dataNascimentoCadastro;
    @FXML
    private RadioButton donoRadioBT;
    @FXML
    private RadioButton locatarioRadioBT;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void excluirPessoa(ActionEvent event) {
    }

    @FXML
    private void adicionarPessoa(ActionEvent event) {
    }

    /**
    * Ao clicar em cancelar, usuário é enviado de volta ao menu(TelaInicial)
    */
    @FXML
    private void sairMenu(ActionEvent event) {
        Main.trocarTelaBiblioteca("TelaInicial.fxml");
    }

    @FXML
    private void editarPessoa(ActionEvent event) {
    }
    
}
