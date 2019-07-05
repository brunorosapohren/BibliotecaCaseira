/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

/**
 * Classe responsável pelo Gênero dos Livros
 * @author Bruno-PC
 */
public class Genero {
    /*
    * Atributos
    */
    private String nome;
    private String descricao;
    private String subGrupo;

    /**
     * Construtor vazio
     */

    public Genero(){}
    
    /*
    * Métodos
    */
    
    /*
    * Retorna uma String contendo os dados de Gênero
    */
    public String toString(){
        return "Nome do gênero: " + nome + "\n Descrição: " + descricao + "\n Subgrupo: " + subGrupo;
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna o nome do Gênero
     * @return
     */

    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do Gênero
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a descrição do Gênero
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição do Gênero
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o subGrupo do Gênero
     * @return
     */
    public String getSubGrupo() {
        return subGrupo;
    }

    /**
     * Altera o subGrupo do Gênero
     * @param subGrupo
     */
    public void setSubGrupo(String subGrupo) {
        this.subGrupo = subGrupo;
    }
}
