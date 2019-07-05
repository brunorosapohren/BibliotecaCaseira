/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

/**
 * Classe responsável por dizer qual Gráfica foi que fez o Livro
 * @author Bruno-PC
 */
public class Grafica {
    /*
    Atributos
    */
    private String nome;

    /**
     * Construtor vazio
     */

    public Grafica(){}
    
    /*
    Métodos
    */
    
    /*
    * Retorna uma String contendo os dados de Gráfica
    */
    public String toString()
    {
        return "Nome da Gráfica: " + nome;
    }
    
    /*
    Get e Set
    */

    /**
     * Retorna o nome da Gráfica
     * @return
     */

    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome da Gráfica
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
