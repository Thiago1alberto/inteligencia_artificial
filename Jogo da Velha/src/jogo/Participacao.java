/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.util.ArrayList;
import jogadores.Jogador;

/**
 *
 * @author tarci
 */
public class Participacao {
    private Jogador jogador;
    private ArrayList<String> vitorias;
    private ArrayList<String> derrotas;
    private ArrayList<String> empates;
    private int numeroPartidasIniciei;
    
    public Participacao(Jogador jogador){
        this.jogador = jogador;
        this.numeroPartidasIniciei = 0;
        this.derrotas = new ArrayList<>();
        this.empates = new ArrayList<>();
        this.vitorias = new ArrayList<>();
    }
    
    public String getNome(){
        return this.jogador.getNome();
    }
    
    public void addVitoria(String nome){
        this.vitorias.add(nome);
    }
    
    public void addDerrotas(String nome){
        this.derrotas.add(nome);
    }
    
    public void addEmpates(String nome){
        this.empates.add(nome);
    }
    
    public ArrayList<String> getVitorias(){
        return this.vitorias;
    }
    
    public ArrayList<String> getDerrotas(){
        return this.derrotas;
    }
    
    public ArrayList<String> getEmpates(){
        return this.empates;
    }
    
    public int getNumeroTotalPartidas(){
        return this.derrotas.size() + this.vitorias.size() + this.empates.size();
    }
    
    public int getPartidasInicializadas(){
        return this.numeroPartidasIniciei;
    }
    
    public void addPartidasInicializadas(){
        this.numeroPartidasIniciei++;
    }
    
}
