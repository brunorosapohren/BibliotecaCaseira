/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.teste;

import br.edu.ifrs.canoas.data.Data;
import br.edu.ifrs.canoas.locacao.Locatario; //está no trecho comentado
import br.edu.ifrs.canoas.locacao.Locacao; //está no trecho comentado
import br.edu.ifrs.canoas.livro.Dono; //está no trecho comentado
import br.edu.ifrs.canoas.livro.Autor;
import br.edu.ifrs.canoas.livro.Tipo;
import br.edu.ifrs.canoas.livro.Editora;
import br.edu.ifrs.canoas.livro.Genero;
import br.edu.ifrs.canoas.Livro; //está no trecho comentado
import java.util.ArrayList;

/**
 * Essa classe estava sendo usava para testar o programa na primeira versão do sistema que foi enviada na semipresencial
 * @author Bruno-PC
 */
public class ClasseTeste {

    /**
     * Responsável por executar e testar os objetos
     * @param args
     */
    public static void main(String[] args){
        ArrayList<Autor> autoresLivro1 = new ArrayList<>();
        Autor autor1 =new Autor();
        autor1.setNome("Roberto Carlos");
        Autor autor2 = new Autor();
        autor2.setNome("Augustinho Carrara");
        autoresLivro1.add(autor2);
        autoresLivro1.add(autor1);
        
        Editora editora = new Editora();
        editora.setNome("Arqueiro manjado");
        
        Genero genero = new Genero();
        genero.setNome("Narrativo");
        
        genero.setSubGrupo("Ficcção científica");
        genero.setDescricao("Autor estrutura uma história baseada em fatos reais, ou não.");
        
        Tipo tipo = new Tipo();
        tipo.setNome("Interativo");
        tipo.setDescricao("Livros em que tu interage, normalmente escrevendo algo neles.");
        
        Data data = new Data();
        data.setDia(3);
        data.setMes(4);
        data.setAno(2020);
        
        /*
        Livro livro1 = new Livro();
        livro1.setNome("As incríveis aventuras de um cara desesperado para entregar isso");
        livro1.setPrecoPago(25.50);
        livro1.setVolume(1);
        livro1.setAno(2019);
        livro1.setGenero(genero);
        livro1.setTipo(tipo);
        livro1.setEditora(editora);
        livro1.setAutores(autoresLivro1);
        
        
        Dono dono1 = new Dono();
        dono1.setNome("Alberto Boberto");
        dono1.setDataNascimento(data);
        dono1.addLivroSeu(livro1);
        
        Locatario locatario = new Locatario();
        locatario.setNome("O locatário");
        locatario.setDataNascimento(data);
        
        Locacao locacao = new Locacao();
        locacao.setQuemPegou(locatario);
        locacao.setQualLivro(livro1);
        locacao.setDataQuePegou(data);
        locacao.setDataQueDevolveu(data);
        
        */
    }
}
