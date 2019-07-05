/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

import br.edu.ifrs.canoas.Livro;

/**
 * Classe filha do Livro responsável pelos livros digitais
 * @author Bruno-PC
 */
public class LivroDigital extends Livro{
    /*
    Atributos
    */
    private String plataforma;
    private String formaAdquirida;

    /**
     * Construtor vazio
     */

    public LivroDigital(){}
    
    /*
    Métodos
    */
    
    
    /*
    Get e Set
    */

    /**
     * Retorna a plataforma em que se encontra o LivroDigital
     * @return
     */

    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Altera a plataforma em que se encontra o LivroDigital
     * @param plataforma
     */
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * Retorna a forma como foi adquirido o LivroDigital (baixado ou online)
     * @return
     */
    public String getFormaAdquirida() {
        return formaAdquirida;
    }

    /**
     * Altera a forma como foi adquirido o LivroDigital
     * @param formaAdquirida
     */
    public void setFormaAdquirida(String formaAdquirida) {
        this.formaAdquirida = formaAdquirida;
    }
    
}
