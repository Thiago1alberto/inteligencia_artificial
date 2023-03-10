package jogadores;

import java.util.Random;
import jogo.Tabuleiro;

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
