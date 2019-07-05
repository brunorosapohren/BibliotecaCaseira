/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que efetua a conexão com o Banco de Dados
 * @author Bruno-PC
 */
public class Conexao {
    /*
    Atributos
    */
    private String usuario = "TADS_BD07";
    private String senha = "1234";
    private String servidor = "oracle.canoas.ifrs.edu.br";
    private int porta = 1521;
    private Connection conexao = null;

    /**
     * Construtor vazio
     */

    public Conexao() {}

    /**
     * Construtor setando os campos de Conexão
     * @param usuario
     * @param senha
     */

    public Conexao(
            String usuario,
            String senha) {
        this.senha = senha;
        this.usuario = usuario;
    }

    /*
    Métodos
    */

    /**
     * Efetua a conexão com o banco de dados e retorna a mesma
     * @return
     */

    public Connection getConexao() {
        if (conexao == null) 
        {
            try 
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conexao = DriverManager.getConnection(
                        "jdbc:oracle:thin:@" + this.servidor + ":" + this.porta + ":XE",
                        this.usuario,
                        this.senha);

            } catch (ClassNotFoundException e) {
                System.out.println("Problema no momento da conexão.");
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        return conexao;
    }

    /**
     * Desconecta com o Banco de Dados
     */
    public void desconecta() {
        try 
        {
            conexao.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
