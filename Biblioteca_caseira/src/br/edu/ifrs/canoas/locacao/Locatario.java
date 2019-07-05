/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.locacao;

import br.edu.ifrs.canoas.Pessoa;
import java.util.ArrayList;

/**
 *  Classe filha de Pessoa responsável por dizer quem pegou um LivroFisico
 * @author Bruno-PC
 */
public class Locatario extends Pessoa{
    /*
    * Atributos
    */
    private ArrayList<Locacao> locacoes;

    /**
     * Construtor vazio
     */

    public Locatario(){}
    
    /*
    * Métodos
    */

    /**
     * Adiciona um objeto Locação passado nas locações do Locatario
     * @param locacao
     */

    public void addLocacoesFeitas(Locacao locacao)
    {
        this.locacoes.add(locacao);
    }
    
    /**
     * Lista as locações feitas pelo Locatario
     */
    public void listarSuasLocacoes()
    {
        int quantidadeLocacoes=0;
        boolean temLocacao=false;
        
        for(Locacao l: locacoes){
            quantidadeLocacoes++;
            System.out.println(quantidadeLocacoes + " - " + l.getQualLivro() + "\n");
            temLocacao=true;
        }
        
        if(temLocacao){
            System.out.println("\n ->Ao total foram locados por "+ getNome() +": " + quantidadeLocacoes);
        }else{
            System.out.println("\nEsta pessoa não tem locações relacionadas.");
        }
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna um ArrayList de Locação
     * @return
     */


    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    /**
     * Altera o ArrayList de Locação
     * @param locacoes
     */
    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    
}
