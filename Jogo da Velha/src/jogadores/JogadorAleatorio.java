/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogadores;

import java.util.Random;
import jogo.Tabuleiro;

/**
 *
 * @author tarci
 */
public class JogadorAleatorio extends Jogador{

    public JogadorAleatorio(String nome) {
        super(nome);
    }

    @Override
    public int[] jogar(int[][] tabuleiro) {
        int[] jogada = new int[2];
        Random r = new Random();
        int i;
        int j;
        for(int k = 0; k < tabuleiro.length*tabuleiro.length*10; k++){//1000 tentativas de jogadas válidas
            i = r.nextInt(tabuleiro.length);
            j = r.nextInt(tabuleiro.length);
            if(tabuleiro[i][j] == -1){
                jogada[0] = i;
                jogada[1] = j;
                return jogada;                
            }
        }
        return null;
    }    
}
