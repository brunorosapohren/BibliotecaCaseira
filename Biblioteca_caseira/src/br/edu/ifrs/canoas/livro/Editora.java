/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

import br.edu.ifrs.canoas.conexao.Conexao;
import br.edu.ifrs.canoas.endereco.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe contendo os dados de Editora
 * @author Bruno-PC
 */
public class Editora {
    /*
    * Atributos
    */
    private int id;
    private String nome;
    private Endereco endereco;

    /**
     * Construtor vazio
     */

    public Editora(){}
    
    /*
    * Métodos
    */
    
    /*
    * Retorna uma String contendo os dados de Editora
    */
    public String toString(){
        return "Nome da editora: " + nome + "\n Endereço: \n" + endereco.toString();
    }
    
    ///// Active Record

    /**
     * Operação de CRUD responsável por cadastrar no Banco de Dados a Editora
     * @return
     */
    public boolean insert()
    {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql =  "INSERT INTO Editora(id_editora, nome, pais, cidade) " + "VALUES (editora_sequencia.nextval,?,?,?)";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);    
            ps.setString(1, this.nome);
            ps.setString(2, this.endereco.getPais());
            ps.setString(3, this.endereco.getCidade());
            ps.executeUpdate();                      
        }catch(SQLException e){
            System.out.println("Problema no momento de inserir.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Método estático que seleciona os dados de Editora cadastrados no Banco de Dados e retorna uma List contendo eles
     * @return
     */
    public static List<Editora> getAll()
    {
        ArrayList<Editora> edit = new ArrayList<>();
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql = "SELECT * FROM Editora ORDER BY nome";
        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                Editora e = new Editora();
                Endereco end = new Endereco();
                e.setId(rs.getInt("id_editora"));
                e.setNome(rs.getString("nome"));
                end.setPais(rs.getString("pais"));
                end.setCidade(rs.getString("cidade"));
                e.setEndereco(end);
                edit.add(e);
            }            
        }catch(SQLException e){
            System.out.println("Problema no momento de selecionar os dados de Editora.");
            e.printStackTrace();
            return null;
        }
        return edit;
    }
    
    /**
     * Parte do CRUD responsável por remover do Banco de Dados a Editora requisitada
     * @return
     */
    public boolean remove() 
    {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql =  "DELETE FROM Editora " + "WHERE id_editora = ?";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Problema no momento de remover.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Parte do CRUD responsável por editar e atualizar as informações de uma Editora requisitada
     * @return
     */
    public boolean update() 
    {
        Conexao c = new Conexao();
        Connection con = c.getConexao();
        String sql =  "UPDATE Editora SET nome = ?, cidade = ?, pais = ? " + "WHERE ( id_editora = ?)";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);   
            ps.setString(1, this.nome);
            ps.setString(2, this.endereco.getCidade());
            ps.setString(3, this.endereco.getPais());
            
            ps.setInt(4, this.id);
            
            ps.executeUpdate();           
        }catch(SQLException e){
            System.out.println("Problema no momento de atualizar os dados de Editora.");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna o nome da Editora
     * @return
     */


    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome da Editora
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o objeto Endereco da Editora
     * @return
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Altera o objeto Endereco da Editora
     * @param endereco
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o id da Editora
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o id da Editora
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
