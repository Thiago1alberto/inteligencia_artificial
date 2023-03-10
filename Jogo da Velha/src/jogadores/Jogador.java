package jogadores;

import jogo.Tabuleiro;


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
