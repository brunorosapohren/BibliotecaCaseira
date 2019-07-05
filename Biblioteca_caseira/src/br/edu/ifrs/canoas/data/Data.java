/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.data;

/**
 * Classe que registra as datas do eventos, seja nascimento ou registro de uma locação
 * @author Bruno-PC
 */
public class Data {
    /*
    * Atributos
    */
    private int dia;
    private int mes;
    private int ano;

    /**
     * Construtor vazio
     */

    public Data(){}
    
    /*
    * Métodos
    */
    
    /*
    * Retorna uma String contendo o campo data
    */
    public String toString()
    {
        return dia + "/" + mes + "/" + ano;
    }
    
    /**
     * Verifica a data para saber se é valida
     * @param d
     * @param m
     * @param a
     * @return
     */
    public boolean verificaData(int d,int m,int a)
    {
        if((d>0 && d <= 28) && (m>0 && m<=12) && a>=0)
        {
            return true;
        }else{
            return false;
        }
    }
    
    /*
    * Get e Set
    */

    /**
     * Retorna o dia da Data
     * @return
     */


    public int getDia() {
        return dia;
    }

    /**
     * Altera o dia da Data
     * @param dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Retorna o mês da Data
     * @return
     */
    public int getMes() {
        return mes;
    }

    /**
     * Altera o mês da Data
     * @param mes
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Retorna o ano da Data
     * @return
     */
    public int getAno() {
        return ano;
    }

    /**
     * Altera o ano da Data
     * @param ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
}
