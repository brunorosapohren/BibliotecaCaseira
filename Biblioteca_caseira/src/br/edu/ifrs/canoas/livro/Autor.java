/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

import br.edu.ifrs.canoas.Pessoa;

/**
 * Classe filha da Pessoa responsável pelo Autor
 * @author Bruno-PC
 */
public class Autor extends Pessoa{
    /*
    * Atributos
    */
    private String nacionalidade;

    /**
     * Construtor vazio
     */

    public Autor(){}
    
    /*
    * Métodos
    */
    
    /*
    * Retorna uma String com todos os dados de Autor
    */
    public String toString(){
        return "Nacionalidade do autor: " + nacionalidade;
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna a nacionalidade do Autor
     * @return
     */

    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * Altera a nacionalidade do Autor
     * @param nacionalidade
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
