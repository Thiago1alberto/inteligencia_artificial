/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import jogadores.*;

/**
 *
 * @author tarci
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        Jogador[] jogadores = new Jogador[3];
        jogadores[0] = new JogadorLinhaColuna("LinhaColuna");
        jogadores[1] = new JogadorAleatorio("Aleatório");
        jogadores[2] = new JogadorJustice("Justice");
        
        Campeonato campeonato = new Campeonato(jogadores, 3);
        Participacao[] p = campeonato.runPontosCorridos();
        
        for(int i = 0; i < p.length; i++){
            System.out.println("\n\n### JOGADOR: " + p[i].getNome() + "###");
            System.out.println("Vitórias: " + p[i].getVitorias().size() + " - " + p[i].getVitorias().toString());
            System.out.println("Empates: " + p[i].getEmpates().size() + " - " + p[i].getEmpates().toString());
            System.out.println("Derrotas: " + p[i].getDerrotas().size() + " - " + p[i].getDerrotas().toString());            
        }
        
    }
    
}
