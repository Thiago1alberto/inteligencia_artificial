
package jogadores;

import static java.lang.System.in;
import java.util.Scanner;
import jogo.Tabuleiro;


public class Manual extends Jogador{

    public Manual(String nome) {
        super(nome);
    }

    @Override
    public int[] jogar(int[][] tabuleiro) {
        int[] jogada = new int[2];
        Scanner input = new Scanner(in);
        System.out.println("\nDefina sua Jogada (" + this.getSimbolo() + "): ");
        System.out.println("Linha: ");
        jogada[0] = input.nextInt();
        System.out.println("Coluna: ");
        jogada[1] = input.nextInt();
        return jogada;        
    }    
}
