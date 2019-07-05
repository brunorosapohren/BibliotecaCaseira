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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 * Controller responsável por controlar o registro e finalizações das Locações
 * @author Bruno-PC
 */
public class RegistrarLocacaoController implements Initializable {

    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> nomeLocatario;
    @FXML
    private TableColumn<?, ?> nomeLivro;
    @FXML
    private TableColumn<?, ?> dataPegou;
    @FXML
    private Button devolvidoBT;
    @FXML
    private TableView<?> tabelaLivroNovaLocacao;
    @FXML
    private TableColumn<?, ?> livrosDisponiveis;
    @FXML
    private TableView<?> tabelaPessoaNovaLocacao;
    @FXML
    private TableColumn<?, ?> pessoaLocataria;
    @FXML
    private TextField dataQuePegou;
    @FXML
    private Button registrarLocacaoBT;
    @FXML
    private Button cancelarBT;
    @FXML
    private TextField dataDevolucao;

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
    private void devolverLivro(ActionEvent event) {
    }

    @FXML
    private void registrarLocacao(ActionEvent event) {
    }

    /*
    * Retorna para o menu(TelaInicial) quando pressionado o botão "Cancelar"
    */
    @FXML
    private void voltarMenu(ActionEvent event) {
        Main.trocarTelaBiblioteca("TelaInicial.fxml");
    }
    
}
