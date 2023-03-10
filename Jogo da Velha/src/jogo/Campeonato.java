/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import jogadores.Jogador;

public class Campeonato {
    private Jogador[] jogadores;
    private int tamanhoTabuleiro;
    private Tabuleiro tabuleiro;
    private Random r;
    
    public Campeonato(Jogador[] jogadores, int tamanhoTabuleiro){
        this.jogadores = jogadores;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.tabuleiro = new Tabuleiro(tamanhoTabuleiro);
        r = new Random();
    }
    
    private Jogador partida(Jogador A, Jogador B, Tabuleiro tabuleiro){
        int vencedor = -1; //ainda sem vencedor
        int[] jogada = null;
        int sorteio;
        this.tabuleiro.inicializarTabuleiro();
        //Sorteio do símbolo e de quem começa
        sorteio = r.nextInt(2);
        //System.out.print("############ " + sorteio);
        if(sorteio == 1){
            A.setSimbolo(1);
            B.setSimbolo(0);
        }else{
            A.setSimbolo(0);
            B.setSimbolo(1);
        }
        
        while(vencedor < 0){
            if(A.getSimbolo() == this.tabuleiro.simboloVez){
                jogada = A.jogar(this.tabuleiro.getTabuleiro());
                System.out.print("\nJogador " + A.getNome() + ": " + jogada[0] + "," + jogada[1]);
                vencedor = this.tabuleiro.jogar(jogada[0], jogada[1], A.getSimbolo());              
            }else{
                jogada = B.jogar(this.tabuleiro.getTabuleiro());
                System.out.print("\nJogador " + B.getNome() + ": " + jogada[0] + "," + jogada[1]);
                vencedor = this.tabuleiro.jogar(jogada[0], jogada[1], B.getSimbolo());
            }
        }
                
        if(vencedor == A.getSimbolo())
            return A;
        else if(vencedor == B.getSimbolo())
            return B;
        else
            return null;
    }
    
    public Participacao[] runPontosCorridos(){
        Participacao[] p = new Participacao[this.jogadores.length];
        for(int i = 0; i < p.length; i++){
            p[i] = new Participacao(this.jogadores[i]);
        }
        
        Jogador vencedor;
        for(int i = 0; i < this.jogadores.length; i++){
            for(int j = 0; j < this.jogadores.length; j++){
                if(i == j)
                    continue;
                System.out.println("\n\n[ " + this.jogadores[i].getNome() + " X " + this.jogadores[j].getNome() + " ]");
                vencedor = this.partida(this.jogadores[i], this.jogadores[j], tabuleiro);
                
                if(vencedor != null){//Alguém ganhou!
                    System.out.print("\n" + this.jogadores[i].getNome() + " X " + this.jogadores[j].getNome());
                    if(vencedor.getNome().equalsIgnoreCase(this.jogadores[i].getNome())){
                        System.out.println(" => [ " + this.jogadores[i].getNome() + " ]");
                        p[i].addVitoria(this.jogadores[j].getNome());
                        p[j].addDerrotas(this.jogadores[i].getNome());

                    }else{
                        System.out.println(" => [ " + this.jogadores[j].getNome() + " ]");
                        p[j].addVitoria(this.jogadores[i].getNome());
                        p[i].addDerrotas(this.jogadores[j].getNome());
                    }
                }else{//Empate
                    System.out.println(" => [ empate ]");
                    p[j].addEmpates(this.jogadores[i].getNome());
                    p[i].addEmpates(this.jogadores[j].getNome());
                }
                
                
            }
        }
        
        return p;
    }
    
}
