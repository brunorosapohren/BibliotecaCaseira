/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas;

import br.edu.ifrs.canoas.conexao.Conexao;
import br.edu.ifrs.canoas.data.Data;
import br.edu.ifrs.canoas.livro.Autor;
import br.edu.ifrs.canoas.livro.Dono;
import br.edu.ifrs.canoas.livro.Editora;
import br.edu.ifrs.canoas.livro.Genero;
import br.edu.ifrs.canoas.livro.LivroFisico;
import br.edu.ifrs.canoas.livro.Tipo;
import br.edu.ifrs.canoas.livro.Tradutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe superpai abstrata Livro, possui tudo de genérico
 * @author Bruno-PC
 */
public abstract class Livro {
    /*
    * Atributos
    */
    private int id;
    private String nome;
    private int volume;
    private int ano;
    private boolean lido;
    private double precoPago; // - 0.0 é para quando não se sabe
    private int quantidadeExemplares;
    private Data dataAquisicao; //01/01/0000 para data desconhecida
    private ArrayList<Genero> generos;
    private Tipo tipo;
    private ArrayList<Autor> autores;
    private Editora editora;
    private Dono donoDoLivro;
    private ArrayList<Tradutor> tradutores;

    /**
     * Construtor vazio
     */

    public Livro(){}
    
    /**
     * Construtor setando os valores iniciais do Livro
     * @param lido
     * @param precoPago
     * @param quantidadeExemplares
     * @param dataAquisicao
     */

    public Livro(boolean lido,double precoPago, int quantidadeExemplares,Data dataAquisicao){
        this.lido=false;
        this.precoPago=0.0;
        this.quantidadeExemplares=1;
        this.dataAquisicao.setDia(1);
        this.dataAquisicao.setMes(1);
        this.dataAquisicao.setAno(0);
    }
    
    /*
    * Métodos
    */
    
    /**
    * Retorna uma String com todas as informações sobre Livro
    */
    public String toString(){
        return "Nome livro: " + nome + "\nVolume: " + volume + "\nAno: " + ano + "\nFoi lido? " +((lido)?("Foi"):("Não foi")) + "\nPreço pago no livro(se conhecido): " + precoPago + "\nQuantidade de exemplares: " + quantidadeExemplares + "\nData aquisição: " + dataAquisicao.toString() + "\nGênero: " + listarGeneros(generos) + "\nTipo: " + tipo + "\nAutor(es): " + listarAutores(autores) +"\nEditora: " + editora + " \n Tradutor(es): " + listarTradutores(tradutores) + "\n Dono do livro: " + donoDoLivro;
    }
    
    /**
     * Lista autores que estão envolvidos com o Livro atual
     * Usado no toString
     * @param aut
     * @return
     */
    public String listarAutores(ArrayList<Autor> aut){
        String autor="";
        for(Autor a: aut){
            autor="\n - Nome autor: "+a;
        }
        return autor;
    }
    
    /**
     * Adicionar Autor no ArrauList de Autores
     * @param autor
     */
    public void addAutor(Autor autor){
        this.autores.add(autor);
    }
    
    /**
     * Lista gêneros que compõe o livro atual
     * Usado no toString
     * @param gen
     * @return
     */
    public String listarGeneros(ArrayList<Genero> gen){
        String genero="";
        for(Genero g: gen){
            genero="\n - Nome autor: "+g;
        }
        return genero;
    }
    
    /**
     * Adiciona gênero no ArrayList de Gênero
     * @param genero
     */
    public void addGenero(Genero genero){
        this.generos.add(genero);
    }
    
    /**
     * Lista tradutores que compõe o livro atual
     * Usado no toString
     * @param tr
     * @return
     */
    public String listarTradutores(ArrayList<Tradutor> tr){
        String tradutor="";
        for(Tradutor t: tr){
            tradutor="\n - Nome autor: "+t;
        }
        return tradutor;
    }
    
    /**
     * Adiciona autor no ArrayList de Autor
     * @param tradutor
     */
    public void addTradutor(Tradutor tradutor){
        this.tradutores.add(tradutor);
    }
    
    /**
     * Muda para true o campo lido caso seja informado que a leitura foi finalizada
     */
    public void leituraFinalizada(){
        this.lido=true;
    }
    
    /**
     * Retorna a quantidade total de Livros que existem no sistema
     * @return
     */
    public int mostrarQtdLivros(){
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql = "SELECT count(Livro.id_livro) as total FROM Livro";
        int qtdLivros = 0;
        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                qtdLivros = rs.getInt("total");           
            }
        }catch(SQLException e){
            System.out.println("Problema no momento de contar a quantidade de Livros.");
            e.printStackTrace();
            return 0;
        }
        return qtdLivros;
    }
    
    /**
     * Pega todos os Livros cadastrados no Banco de Dados e retorna um List de Livros
     * @return
     */
    public List<Livro> getAll()
    {
        ArrayList<Livro> li = new ArrayList<>();
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql = "SELECT * FROM Livro ORDER BY nome";
        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                Livro l = new LivroFisico();
                Tipo t = new Tipo();
                Dono d = new Dono();
                
                l.setId(rs.getInt("id_livro"));
                l.setNome(rs.getString("nome"));
                l.setAno(rs.getInt("ano"));
                
                //pega id_tipo para poder selecionar o tipo cadastrado e repassar para o objeto
                t.setId(rs.getInt("tipo"));
                String sqlTipo = "SELECT * FROM Tipo " + "WHERE id_tipo = ?";
                try{
                    PreparedStatement psTipo = con.prepareStatement(sqlTipo);
                    psTipo.setInt(1, t.getId());
                    ResultSet rsTipo = psTipo.executeQuery();
                    while(rsTipo.next())
                    {
                        t.setNome(rsTipo.getString("nome"));
                    }
                }catch(SQLException e){
                    System.out.println("Problema no momento de selecionar os dados de Tipo dentro de Livro.");
                    e.printStackTrace();
                    return null;
                }
                l.setTipo(t);
                
                //pega id_dono para poder selecionar o tipo cadastrado e repassar para o objeto
                d.setId(rs.getInt("dono"));
                String sqlDono = "SELECT * FROM Dono_Locatario " + "WHERE id_dono_locatario = ?";
                try{
                    PreparedStatement psDono = con.prepareStatement(sqlDono);
                    psDono.setInt(1, d.getId());
                    ResultSet rsDono = psDono.executeQuery();
                    while(rsDono.next())
                    {
                        d.setNome(rsDono.getString("nome"));
                    }
                }catch(SQLException e){
                    System.out.println("Problema no momento de selecionar os dados do Dono dentro de Livro.");
                    e.printStackTrace();
                    return null;
                }
                l.setDonoDoLivro(d);
                
                //Colocar um para Gênero --> problemas no TelaInicial, por isso não foi continuado
 
                li.add(l);
            }            
        }catch(SQLException e){
            System.out.println("Problema no momento de selecionar os dados de Livro.");
            e.printStackTrace();
            return null;
        }
        return li;
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna o nome do Livro
     * @return
     */


    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do Livro
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o volume do Livro
     * @return
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Altera o volume do Livro
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Retorna o ano do Livro
     * @return
     */
    public int getAno() {
        return ano;
    }

    /**
     * Altera o ano do Livro
     * @param ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Retorna o campo lido do Livro para saber se já foi lido ou não
     * @return
     */
    public boolean isLido() {
        return lido;
    }

    /**
     * Altera o campo lido do Livro
     * @param lido
     */
    public void setLido(boolean lido) {
        this.lido = lido;
    }

    /**
     * Retorna o preço que foi pago no Livro
     * @return
     */
    public double getPrecoPago() {
        return precoPago;
    }

    /**
     * Altera o preço que foi pago no Livro
     * @param precoPago
     */
    public void setPrecoPago(double precoPago) {
        this.precoPago = precoPago;
    }

    /**
     * Retorna a quantidade de exemplares do Livro
     * @return
     */
    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    /**
     * Altera a quantidade de exemplares do Livro
     * @param quantidadeExemplares
     */
    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    /**
     * Retorna a data em que o Livro foi adquirido
     * @return
     */
    public Data getDataAquisicao() {
        return dataAquisicao;
    }

    /**
     * Altera a data em que o Livro foi adquirido
     * @param dataAquisicao
     */
    public void setDataAquisicao(Data dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    /**
     * Retorna o objeto Tipo que compõe o Livro
     * @return
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Altera o objeto Tipo que compõe o Livro
     * @param tipo
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna um ArrayList dos Autores que compõe o Livro
     * @return
     */
    public ArrayList<Autor> getAutores() {
        return autores;
    }

    /**
     * Altera o ArrayList dos Autores que compõe o Livro...
     * @param autores
     */
    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    /**
     * Retorna o objeto Editora do Livro
     * @return
     */
    public Editora getEditora() {
        return editora;
    }

    /**
     * Altera o objeto Editora do Livro
     * @param editora
     */
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    /**
     * Retorna o objeto Dono do Livro
     * @return
     */
    public Dono getDonoDoLivro() {
        return donoDoLivro;
    }

    /**
     * Altera o objeto Dono do Livro
     * @param donoDoLivro
     */
    public void setDonoDoLivro(Dono donoDoLivro) {
        this.donoDoLivro = donoDoLivro;
    }

    /**
     * Retorna o id do Livro
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o id do Livro
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna um ArrayList de Gêneros do Livro
     * @return
     */
    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    /**
     * Altera o ArrayList de Gêneros do Livro
     * @param generos
     */
    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    /**
     * Retorna um ArrayList de Tradutores do Livro
     * @return
     */
    public ArrayList<Tradutor> getTradutores() {
        return tradutores;
    }

    /**
     * Altera o ArrayList de Tradutores do Livro
     * @param tradutores
     */
    public void setTradutores(ArrayList<Tradutor> tradutores) {
        this.tradutores = tradutores;
    }
    
}
