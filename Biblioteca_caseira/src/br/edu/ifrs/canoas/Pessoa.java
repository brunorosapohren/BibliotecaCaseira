/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas;

import br.edu.ifrs.canoas.data.Data;

/**
 * Classe superpai abstrata Pessoa, possui tudo genérico
 * @author Bruno-PC
 */
public abstract class Pessoa {
    /*
    * Atributos
    */
    private String nome;
    private Data dataNascimento;

    /**
     * Construtor vazio
     */

    public Pessoa(){}
    
    /*
    * Métodos
    */
    
    /*
    * Retorna uma String contendo tudo do objeto Pessoa
    */
    public String toString(){
        return "Nome da pessoa: " + nome + "\n Data nascimento: " + dataNascimento.toString();
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna o nome da Pessoa
     * @return
     */

    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome da Pessoa
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a data de nascimento da Pessoa
     * @return
     */
    public Data getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Altera a data de nascimento da Pessoa
     * @param dataNascimento
     */
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
