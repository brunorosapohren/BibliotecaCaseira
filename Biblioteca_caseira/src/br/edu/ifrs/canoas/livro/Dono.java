/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.livro;

import br.edu.ifrs.canoas.Livro;
import br.edu.ifrs.canoas.Pessoa;
import java.util.ArrayList;

/**
 * Classe filha de Pessoa responsável pelo registro do Dono do livro
 * @author Bruno-PC
 */
public class Dono extends Pessoa{
    /*
    * Atributos
    */
    private int id;
    private ArrayList<Livro> livros;

    /**
     * Construtor vazio
     */

    public Dono(){}
    
    /*
    * Métodos
    */

    /**
     * Adiciona Livro no ArrayList de livros que o Dono possui
     * @param livro
     */

    public void addLivroSeu(Livro livro){
        this.livros.add(livro);
    }
    
    /**
     * Lista todos os livros que o Dono possui
     */
    public void listarSeusLivros(){
        int quantidadeLivrosSeus=0;
        boolean temLivro=false;
        
        for(Livro l: livros){
            quantidadeLivrosSeus++;
            System.out.println(quantidadeLivrosSeus + " - " + l.getNome() + "\n");
            temLivro=true;
        }
        
        if(temLivro){
            System.out.println("\n ->Quantidade de livros pertencentes a " + getNome() + ": " + quantidadeLivrosSeus);
        }else{
            System.out.println("\nEsta pessoa não tem livros relacionados.");
        }
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna um ArrayList dos Livros que o Dono possui
     * @return
     */


    public ArrayList<Livro> getLivros() {
        return livros;
    }

    /**
     * Altera o ArrayList dos livros que o Dono possui
     * @param livros
     */
    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    /**
     * Retorna o id do Dono
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Altera o id do Dono
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
