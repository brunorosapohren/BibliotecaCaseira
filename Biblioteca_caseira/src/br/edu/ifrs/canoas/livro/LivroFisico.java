/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

import br.edu.ifrs.canoas.Livro;

/**
 * Classe filha do Livro responsável pelos livros físicos (única que pode ser locada)
 * @author Bruno-PC
 */
public class LivroFisico extends Livro{
    /*
    Atributos
    */
    private int numeroImpressao;
    private String tipoPapel;
    private Grafica grafica;

    /**
     * Construtor vazio
     */

    public LivroFisico(){}
    
    /*
    Métodos
    */
    
    
    /*
    Get e Set
    */

    /**
     * Retorna o número de impressão do LivroFisico
     * @return
     */


    public int getNumeroImpressao() {
        return numeroImpressao;
    }

    /**
     * Altera o número de impressão do LivroFisico
     * @param numeroImpressao
     */
    public void setNumeroImpressao(int numeroImpressao) {
        this.numeroImpressao = numeroImpressao;
    }

    /**
     * Retorna o tipo de papel usado na impressão do LivroFisico
     * @return
     */
    public String getTipoPapel() {
        return tipoPapel;
    }

    /**
     * Altera o tipo de papel usado na impressão do LivroFisico
     * @param tipoPapel
     */
    public void setTipoPapel(String tipoPapel) {
        this.tipoPapel = tipoPapel;
    }

    /**
     * Retorna o objeto Gráfica de LivroFisico responsável pela impressão
     * @return
     */
    public Grafica getGrafica() {
        return grafica;
    }

    /**
     * Altera o objeto Gráfica de LivroFisico responsável pela impressão
     * @param grafica
     */
    public void setGrafica(Grafica grafica) {
        this.grafica = grafica;
    }
   
}
