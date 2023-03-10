/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogadores;

import jogo.Tabuleiro;

/**
 *
 * @author tarci
 */
public abstract class Jogador {
    private int simbolo;
    private String nome;
    
    public Jogador(String nome){
        this.nome = nome;
        this.simbolo = simbolo;        
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getSimbolo(){
        return this.simbolo;
    }
    
    public void setSimbolo(int simbolo){
        this.simbolo = simbolo;
    }
    
    /**
     *
     * @param tabuleiro
     * @return
     */
    public abstract int[] jogar(int[][] tabuleiro); 
}
