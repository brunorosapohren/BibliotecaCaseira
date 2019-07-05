/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.endereco;

/**
 * Classe para registrar o endereço
 * @author Bruno-PC
 */
public class Endereco {
    /*
    Atributos
    */
    
    private String cidade;
    private String pais;
    
    /**
     * Construtor vazio
     */

    public Endereco(){}
    
    /*
    Métodos
    */
    
    /*
    * Retorna uma String contendo as informações do endereço
    */
    public String toString()
    {
        return "Cidade: " + cidade + "\n País: " + pais;
    }
    
    /*
    Get e Set
    */

    /**
     * Retorna a cidade do Endereço
     * @return
     */


    public String getCidade() {
        return cidade;
    }

    /**
     * Altera a cidade do Endereço
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Retorna o país do Endereço
     * @return
     */
    public String getPais() {
        return pais;
    }

    /**
     * Altera o país do Endereço
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
