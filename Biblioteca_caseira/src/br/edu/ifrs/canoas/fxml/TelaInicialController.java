/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.fxml;

import br.edu.ifrs.canoas.Livro;
import br.edu.ifrs.canoas.livro.Dono;
import br.edu.ifrs.canoas.livro.LivroFisico;
import br.edu.ifrs.canoas.livro.Tipo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 * Controller principal(menu) responsável por listar Livros, quantidade total dos Livros e redirecionar para as outras telas do sistema
 * @author Bruno-PC
 */
public class TelaInicialController implements Initializable {

    @FXML
    private Button adicionarLivroBT;
    @FXML
    private Label label;
    @FXML
    private Button adicionarPessoaBT;
    @FXML
    private Button exitBT;
    @FXML
    private Label qtdLivros;
    @FXML
    private Button addLocacaoBT;
    @FXML
    private TableView<Livro> tabela;
    @FXML
    private TableColumn<?, ?> nomeColuna;
    @FXML
    private TableColumn<?, ?> anoColuna;
    @FXML
    private TableColumn<?, Tipo> tipoColuna;//
    @FXML
    private TableColumn<?, ?> generoColuna;
    @FXML
    private TableColumn<?, Dono> donoColuna;//
    @FXML
    private Button editarLivroBT;
    @FXML
    private Button excluirLivroBT;

    /**
     * Initializes the controller class.
     */
    private ObservableList listaLivros;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Livro l = new LivroFisico();
        qtdLivros.setText(String.valueOf(l.mostrarQtdLivros()));
        listaLivros = tabela.getItems();
        nomeColuna.setCellValueFactory(new PropertyValueFactory("nome"));
        anoColuna.setCellValueFactory(new PropertyValueFactory("ano"));
        for(Livro li : l.getAll()){
           listaLivros.add(li);
        }
    }    

    /*
    * Redireciona para a tela de CadastroLivro quando o botão "Adicionar livro" é pressionado
    */
    @FXML
    private void addLivro(ActionEvent event) {
        Main.trocarTelaBiblioteca("CadastrarLivro.fxml");
    }

    /*
    * Redireciona para a tela de AdicionarPessoa quando o botão "Adicionar pessoa" é pressionado
    */
    @FXML
    private void addPessoa(ActionEvent event) {
        Main.trocarTelaBiblioteca("AdicionarPessoa.fxml");
    }

    /*
    * Finaliza o sistema quando o botão "Sair" é pressionado 
    */
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    /*
    * Redireciona para a tela de RegistrarLocacao quando o botão "Registrar locação" é pressionado
    */
    @FXML
    private void registrarLocacao(ActionEvent event) {
        Main.trocarTelaBiblioteca("RegistrarLocacao.fxml");
    }

    /*
    * Redirecionaria(status: não visivel) para a tela de editar o livro
    */
    @FXML
    private void editarLivro(ActionEvent event) {
        Main.trocarTelaBiblioteca("EditarLivro.fxml");
    }

    /*
    * Excluiria o Livro do Banco de Dados quando Livro fosse seleciona e o botão "Excluir livro" fosse pressionado
    */
    @FXML
    private void excluirLivro(ActionEvent event) {
    }
    
}
