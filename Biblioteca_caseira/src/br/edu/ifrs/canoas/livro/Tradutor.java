/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

/**
 * Classe que informa um possível Tradutor do Livro
 * @author Bruno-PC
 */
public class Tradutor {
    /*
    Atributos
    */
    private String nome;

    /**
     * Construtor vazio
     */

    public Tradutor(){}
    
    /*
    Métodos
    */
    
    /*
    * Retorna uma String contendo os dados do Tradutor
    */
    public String toString()
    {
        return "Nome do tradutor: " + nome;
    }
    
    /*
    Get e Set
    */

    /**
     * Retorna o nome do Tradutor
     * @return
     */


    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do Tradutor
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
