/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.fxml;

import br.edu.ifrs.canoas.endereco.Endereco;
import br.edu.ifrs.canoas.livro.Editora;
import br.edu.ifrs.canoas.livro.Tipo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 * Controller responsável por controlar o cadastro, edição, remoção do Livro; e também cadastro, listagem, edição e remoção de Editora e Tipo
 * @author Bruno-PC
 */
public class CadastrarLivroController implements Initializable {

    @FXML
    private TableView<?> generoTabelaCadastro;
    @FXML
    private TableColumn<?, ?> nomeGeneroCadastro;
    @FXML
    private TableColumn<?, ?> subgrupoGeneroCadastro;
    @FXML
    private Button cancelarBT;
    @FXML
    private Button cadastrarLivroBT;
    @FXML
    private Button cadastrarNovoGeneroBT;
    @FXML
    private TableView<Tipo> tipoTabelaCadastro; //Lista na tabela para cadastrar - CRUD
    @FXML
    private TableColumn<?, ?> nomeTipoCadastro;
    @FXML
    private TableView<Editora> editoraTabelaCadastro; //Lista na tabela para cadastrar - CRUD
    @FXML
    private TableColumn<?, ?> nomeEditoraCadastro;
    @FXML
    private TableView<?> pessoaTabelaCadastro;
    @FXML
    private TableColumn<?, ?> nomePessoaCadastro;
    @FXML
    private TextField nomeLivroCadastro;
    @FXML
    private TextField volumeLivroCadastro;
    @FXML
    private TextField anoLivroCadastro;
    @FXML
    private TextField precoLivroCadastro;
    @FXML
    private TextField qtdLivroCadastro;
    @FXML
    private TextField dataAquisicaoLivroCadastro;
    @FXML
    private TableView<?> tradutorTabelaCadastro;
    @FXML
    private TableColumn<?, ?> nomeTradutorCadastro;
    @FXML
    private TableView<?> autorTabelaCadastro;
    @FXML
    private TableColumn<?, ?> nomeAutorCadastro;
    @FXML
    private TableView<?> graficaFisicoTabelaCadastro;
    @FXML
    private TableColumn<?, ?> nomeGraficaFisicoCadastro;
    @FXML
    private Button cadastrarNovoTipoBT;
    @FXML
    private TextField formaAdquiridaDigitalCadastro;
    @FXML
    private TextField plataformaDigitalCadastro;
    @FXML
    private TextField papelFisicoCadastro;
    @FXML
    private TextField nImpressaoFisicoCadastro;
    @FXML
    private TextField nomeGeneroCadastroCadastro;
    @FXML
    private TextField descricaoGeneroCadastroCadastro;
    @FXML
    private TextField nomeTipoCadastroCadastro; //Para cadastrar TIPO
    @FXML
    private TextField descricaoTipoCadastroCadastro;  //Para cadastrar TIPO
    @FXML
    private Button editarGeneroBT;
    @FXML
    private Button excluirGeneroBT;
    @FXML
    private Button editarTipoBT;
    @FXML
    private Button excluirTipoBT;
    @FXML
    private TextField subgrupoGeneroCadastroCadastro;
    @FXML
    private TextField nomeEditoraCadastroCadastro;  //Para cadastrar EDITORA
    @FXML
    private TextField paisEditoraCadastroCadastro;  //Para cadastrar EDITORA
    @FXML
    private TextField cidadeEditoraCadastroCadastro;  //Para cadastrar EDITORA
    @FXML
    private Button cadastrarNovaEditoraBT;
    @FXML
    private Button editarEditoraBT;
    @FXML
    private Button excluirEditoraBT;

    
    private ObservableList listaTipos;
    private ObservableList listaEditoras;
    
    
    @FXML
    private Button editarFinalizarTipoBT;
    @FXML
    private Button editarFinalizarEditoraBT;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaTipos = tipoTabelaCadastro.getItems();
        listaEditoras = editoraTabelaCadastro.getItems();
        
        nomeTipoCadastro.setCellValueFactory(new PropertyValueFactory("nome"));
        nomeEditoraCadastro.setCellValueFactory(new PropertyValueFactory("nome"));
        
        for(Tipo t : Tipo.getAll()){
           listaTipos.add(t);
        }
        
        for(Editora e : Editora.getAll()){
           listaEditoras.add(e);
        }
        
    }    

    /*
    * Retorna o usuário para o menu(TelaInicial) ao clicar no cancelar
    */
    @FXML
    private void voltarMenu(ActionEvent event) {
        Main.trocarTelaBiblioteca("TelaInicial.fxml");
    }

    @FXML
    private void cadastrarLivro(ActionEvent event) {
    }

    @FXML
    private void cadastrarNovoGenero(ActionEvent event) {
    }

    /*
    * Cadastra um novo Tipo no Banco de Dados ao clicar no "Cadastrar Novo Tipo"
    */
    @FXML
    private void cadastrarNovoTipo(ActionEvent event) {
        Tipo t = new Tipo();
        t.setNome(nomeTipoCadastroCadastro.getText());
        t.setDescricao(descricaoTipoCadastroCadastro.getText());
        if(t.insert())
        {
            listaTipos.add(t);
        }
    }

    @FXML
    private void editarGenero(ActionEvent event) {
    }

    @FXML
    private void excluirGeneroBT(ActionEvent event) {
    }

    /*
    * Edita um Tipo no Banco de Dados após ele ser seleciona e o botão "Editar Tipo"
    */
    @FXML
    private void editarTipo(ActionEvent event) {
        editarTipoBT.setText("Editando Tipo");
        editarTipoBT.setDisable(true);
        Tipo tSelecionado = tipoTabelaCadastro.getSelectionModel().getSelectedItem();
        nomeTipoCadastroCadastro.setText(tSelecionado.getNome());
        descricaoTipoCadastroCadastro.setText(tSelecionado.getDescricao());
        cadastrarNovoTipoBT.setVisible(false);
        editarFinalizarTipoBT.setVisible(true);
    }
    
    /*
    * Exclui um Tipo do Banco de Dados após ser seleciona e o botão "Excluir Tipo" ser pressionado
    */
    @FXML
    private void excluirTipo(ActionEvent event) {
        Tipo tSelecionado = tipoTabelaCadastro.getSelectionModel().getSelectedItem();
        tSelecionado.remove();
        listaTipos.remove(tSelecionado);
    }

    /*
    * Cadastrar uma nova Editora no Banco de Dados quando o botão "Cadastrar Nova Editora" é pressionado
    */
    @FXML
    private void cadastrarNovaEditora(ActionEvent event) {
        Editora e = new Editora();
        Endereco end= new Endereco();
        e.setNome(nomeEditoraCadastroCadastro.getText());
        
        end.setPais(paisEditoraCadastroCadastro.getText());
        end.setCidade(cidadeEditoraCadastroCadastro.getText());
        
        e.setEndereco(end);
        if(e.insert())
        {
            listaEditoras.add(e);
        }
    }

    /*
    * Edita uma Editora no Banco de Dados quando uma é selecionada e o botão "Editar Editora" é pressionado
    */
    @FXML
    private void editarEditora(ActionEvent event) {
        editarEditoraBT.setText("Editando Editora");
        editarEditoraBT.setDisable(true);
        Editora eSelecionado = editoraTabelaCadastro.getSelectionModel().getSelectedItem();
        nomeEditoraCadastroCadastro.setText(eSelecionado.getNome());
        
        paisEditoraCadastroCadastro.setText(eSelecionado.getEndereco().getPais());
        cidadeEditoraCadastroCadastro.setText(eSelecionado.getEndereco().getCidade());
        
        cadastrarNovaEditoraBT.setVisible(false);
        editarFinalizarEditoraBT.setVisible(true);
    }

    /*
    * Exclui uma Editora do Banco de Dados quando uma é selecionada e o botão "Excluir Editora" é pressionado
    */
    @FXML
    private void excluirEditora(ActionEvent event) {
        Editora eSelecionado = editoraTabelaCadastro.getSelectionModel().getSelectedItem();
        eSelecionado.remove();
        listaEditoras.remove(eSelecionado);
    }

    /*
    * Finaliza a edição de um Tipo após o método "editarTipo" quando o botão "Concluir" é selecionado 
    */
    @FXML
    private void editarFinalizarTipo() {
        Tipo t = tipoTabelaCadastro.getSelectionModel().getSelectedItem();
        t.setNome(nomeTipoCadastroCadastro.getText());
        t.setDescricao(descricaoTipoCadastroCadastro.getText());
        t.update();        
        cadastrarNovoTipoBT.setVisible(true);        
        editarFinalizarTipoBT.setVisible(false);
        editarTipoBT.setDisable(false);
        editarTipoBT.setText("Editar Tipo");     
        tipoTabelaCadastro.refresh();
    }

    /*
    * Finaliza a edição de Editora quando o botão "Concluir" é pressionado
    */
    @FXML
    private void editarFinalizarEditora() {
        Editora e = editoraTabelaCadastro.getSelectionModel().getSelectedItem();
        Endereco end= new Endereco();
        e.setNome(nomeEditoraCadastroCadastro.getText());
        
        end.setPais(paisEditoraCadastroCadastro.getText());
        end.setCidade(cidadeEditoraCadastroCadastro.getText());
        
        e.setEndereco(end);
        e.update();        
        
        cadastrarNovaEditoraBT.setVisible(true);        
        editarFinalizarEditoraBT.setVisible(false);
        editarEditoraBT.setDisable(false);
        editarEditoraBT.setText("Editar Editora");     
        editoraTabelaCadastro.refresh();
    }
    
}
