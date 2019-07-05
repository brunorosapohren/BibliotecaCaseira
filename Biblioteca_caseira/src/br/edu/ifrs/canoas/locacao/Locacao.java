/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.locacao;

import br.edu.ifrs.canoas.data.Data;
import br.edu.ifrs.canoas.livro.LivroFisico;
import java.time.LocalDate;

/**
 * Classe responsável por registrar as Locações efetuadas
 * @author Bruno-PC
 */
public class Locacao {
    /*
    * Atributos
    */
    private boolean devolveu;
    private LivroFisico qualLivro;
    private Data dataQuePegou;
    private Data dataQueDevolveu;
    private Locatario quemPegou;

    /**
     * Construtor vazio
     */

    public Locacao(){}

    /**
     * Construtor setando o devolveu, única coisa que inicia definida
     * @param devolveu
     */

    public Locacao(boolean devolveu){
        this.devolveu=false;
    }
    
    /*
    * Métodos
    */
    
    /*
    * Retorna uma String contendo os dados da Locação feita
    */
    public String toString(){
        return "Quem pegou emprestado? " + quemPegou + "\nQual livro? " + qualLivro + "\nQuando? " + dataQuePegou + "\nDevolveu? " + (devolveu? (dataQueDevolveu):("Não"));
    }
    
    /**
     * Altera o campo devolveu para verdadeiro e registrar a data atual no campo dataQueDevolveu
     */
    public void devolvido(){
        this.devolveu=true;
        //pegando a data de agora e colocando como data que devolveu
        LocalDate data = LocalDate.now();
        this.dataQueDevolveu.setDia(data.getDayOfMonth());
        this.dataQueDevolveu.setMes(data.getMonthValue());
        this.dataQueDevolveu.setAno(data.getYear());
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna o estado de Locação com o devolveu
     * @return
     */

    public boolean isDevolveu() {
        return devolveu;
    }

    /**
     * Altera o estado de Locação com o devolveu
     * @param devolveu
     */
    public void setDevolveu(boolean devolveu) {
        this.devolveu = devolveu;
    }

    /**
     * Retorna o objeto LivroFisico que foi locado
     * @return
     */
    public LivroFisico getQualLivro() {
        return qualLivro;
    }

    /**
     * Altera o objeto LivroFisico que foi locado
     * @param qualLivro
     */
    public void setQualLivro(LivroFisico qualLivro) {
        this.qualLivro = qualLivro;
    }

    /**
     * Retorna a data em que foi locado o LivroFisico
     * @return
     */
    public Data getDataQuePegou() {
        return dataQuePegou;
    }

    /**
     * Altera a data em que foi locado o LivroFisico
     * @param dataQuePegou
     */
    public void setDataQuePegou(Data dataQuePegou) {
        this.dataQuePegou = dataQuePegou;
    }

    /**
     * Retorna a data em que foi devolvido o LivroFisico locado
     * @return
     */
    public Data getDataQueDevolveu() {
        return dataQueDevolveu;
    }

    /**
     * Altera a data em que foi devolvido o LivroFisico locado
     * @param dataQueDevolveu
     */
    public void setDataQueDevolveu(Data dataQueDevolveu) {
        this.dataQueDevolveu = dataQueDevolveu;
    }

    /**
     * Retorna o objeto Locatario de quem pegou o LivroFisico
     * @return
     */
    public Locatario getQuemPegou() {
        return quemPegou;
    }

    /**
     * Altera o objeto Locatario de quem pegou o LivroFisico
     * @param quemPegou
     */
    public void setQuemPegou(Locatario quemPegou) {
        this.quemPegou = quemPegou;
    }
}
