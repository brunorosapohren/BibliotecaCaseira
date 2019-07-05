/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

import br.edu.ifrs.canoas.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por dizer o Tipo do Livro (Narrativa, Romance, Enciclopédia, etc.)
 * @author Bruno-PC
 */
public class Tipo 
{
    /*
    * Atributos
    */
    private int id;
    private String nome;
    private String descricao;

    /**
     * Construtor vazio
     */

    public Tipo(){}
    
    /*
    * Métodos
    */
    
    /*
    * Retorna uma String contendo as informações de Tipo
    */
    public String toString()
    {
        return "Nome do tipo: " + nome + "\n Descrição: " + descricao;
    }
    
    // Active Record

    /**
     * Parte do CRUD responsável por inserir do Banco de Dados o Tipo
     * @return
     */
    public boolean insert()
    {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql =  "INSERT INTO Tipo(id_tipo, nome,descricao) " + "VALUES (tipo_sequencia.nextval,?,?)";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.nome);
            ps.setString(2, this.descricao);
            ps.executeUpdate();           
        }catch(SQLException e){
            System.out.println("Problema no momento da inserção.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Parte estática do CRUD responsável por selecionar todos os Tipos do Banco de Dados e retornar uma List com os Tipos
     * @return
     */
    public static List<Tipo> getAll()
    {
        ArrayList<Tipo> tip = new ArrayList<>();
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql = "SELECT * FROM Tipo ORDER BY nome";
        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                Tipo t = new Tipo();
                t.setId(rs.getInt("id_tipo"));
                t.setNome(rs.getString("nome"));
                t.setDescricao(rs.getString("descricao"));
                tip.add(t);
            }            
        }catch(SQLException e){
            System.out.println("Problema no momento de selecionar os dados de Tipo.");
            e.printStackTrace();
            return null;
        }
        return tip;
    }
    
    /**
     * Parte do CRUD responsável por remover do Banco de Dados o Tipo requisitado
     * @return
     */
    public boolean remove() 
    {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql =  "DELETE FROM Tipo " + "WHERE id_tipo = ?";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Problema no momento da exclusão.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Parte do CRUD responsável pelo edição e atualização das informações no Banco de Dados de Tipo requisitadas
     * @return
     */
    public boolean update() 
    {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql =  "UPDATE Tipo SET nome = ?, descricao = ? " + "WHERE ( id_tipo = ?)";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);     
            ps.setString(1, this.nome);
            ps.setString(2, this.descricao);
            
            ps.setInt(3, this.id);
            
            ps.executeUpdate();           
        }catch(SQLException e){
            System.out.println("Problema no momento de atualizar os dados de Tipo.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna o nome de Tipo
     * @return
     */


    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome de Tipo
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a descrição de Tipo
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição de Tipo
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o id de Tipo
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o id de Tipo
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
