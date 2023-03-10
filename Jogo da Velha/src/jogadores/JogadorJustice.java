package jogadores;

import java.util.List;
import jogo.Tabuleiro;

public class JogadorJustice extends Jogador {

    public JogadorJustice(String nome) {
        super(nome);
    }

    @Override
    public int[] jogar(int[][] tabuleiro) {
        int meuSimbolo = super.getSimbolo();
        int[] minhaJogada = { -1, -1 };
        int melhorJogada = Integer.MIN_VALUE;
        for (int i = 0; i < tabuleiro.length; i++) { //Este loop fornece uma maneira de percorrer todas as posições do tabuleiro e verificar se há uma posição vazia (-1)
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j] == -1) {
                    tabuleiro[i][j] = meuSimbolo;
                    int jogada = melhoresJogadas(tabuleiro, 0, false, meuSimbolo); //O código tenta fazer uma jogada no tabuleiro. Em seguida, chama o método melhoresJogadas para calcular a pontuação da jogada 
                    tabuleiro[i][j] = -1;
                    if (jogada > melhorJogada) { //Se a pontuação da jogada atual for melhor do que a pontuação da jogada mais perfeita encontrada até agora, a jogada atual se tornará a jogada mais perfeita.
                        minhaJogada[0] = i;
                        minhaJogada[1] = j;
                        melhorJogada = jogada;
                    }
                }
            }
        }

        return minhaJogada;
    }

    public static int melhoresJogadas(int[][] tabuleiro, int profundidade, boolean maximo, int simbolo) {
        // Verifica se atingiu a profundidade máxima ou se o jogo acabou
        int valor = verificacao(tabuleiro, simbolo);
        if (tabuleiro.length > 3 && profundidade > 0 || valor != 0) {
            return valor;
        }

        // Verifica se ainda existem jogadas possíveis
        if (!possibilidades(tabuleiro)) {
            return 0;
        }

        // Define o valor inicial de "melhor jogada" de acordo com o modo (maximização
        // ou minimização)
        int melhorJogada = maximo ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        // Percorre todas as jogadas possíveis
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j] == -1) {
                    // Realiza a jogada
                    tabuleiro[i][j] = maximo ? simbolo : -1 * (simbolo - 1);

                    // Calcula o valor da jogada usando a recursão do minimax
                    int valorJogada = melhoresJogadas(tabuleiro, profundidade + 1, !maximo, simbolo);

                    // Desfaz a jogada
                    tabuleiro[i][j] = -1;

                    // Atualiza o valor da melhor jogada
                    if (maximo) {
                        melhorJogada = Math.max(melhorJogada, valorJogada);
                    } else {
                        melhorJogada = Math.min(melhorJogada, valorJogada);
                    }
                }
            }
        }
        return melhorJogada;
    }

    public static int verificarLinhaColunaDiagonal(int[] linhaColunaDiagonal, int simbolo) {
        int tamanho = linhaColunaDiagonal.length;
        int ganhou = 0;
        int perdeu = 0;
        for (int i = 0; i < tamanho; i++) {
            if (linhaColunaDiagonal[i] == simbolo) {
                ganhou++;
            } else if (linhaColunaDiagonal[i] == -1 * (simbolo - 1)) {
                perdeu++;
            }
        }
        if (ganhou == tamanho) {
            return +10;
        } else if (perdeu == tamanho) {
            return -10;
        } else {
            return 0;
        }
    }

    public static int verificacao(int[][] tabuleiro, int simbolo) {
        int tamanho = tabuleiro.length;
        // Verificar linhas
        for (int i = 0; i < tamanho; i++) {
            int[] linha = tabuleiro[i];
            int resultado = verificarLinhaColunaDiagonal(linha, simbolo);
            if (resultado != 0) {
                return resultado;
            }
        }

        // Verificar colunas
        for (int i = 0; i < tamanho; i++) {
            int[] coluna = new int[tamanho];
            for (int j = 0; j < tamanho; j++) {
                coluna[j] = tabuleiro[j][i];
            }
            int resultado = verificarLinhaColunaDiagonal(coluna, simbolo);
            if (resultado != 0) {
                return resultado;
            }
        }

        // Verificar diagonal principal
        int[] diagonalPrincipal = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            diagonalPrincipal[i] = tabuleiro[i][i];
        }
        int resultado = verificarLinhaColunaDiagonal(diagonalPrincipal, simbolo);
        if (resultado != 0) {
            return resultado;
        }

        // Verificar diagonal secundária
        int[] diagonalSecundaria = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            diagonalSecundaria[i] = tabuleiro[i][tamanho - 1 - i];
        }
        resultado = verificarLinhaColunaDiagonal(diagonalSecundaria, simbolo);
        if (resultado != 0) {
            return resultado;
        }

        return 0;
    }

    public static Boolean possibilidades(int tabuleiro[][]) { //verificando se o valor da posição é igual a -1. 
        for (int i = 0; i < tabuleiro.length; i++)
            for (int j = 0; j < tabuleiro.length; j++)
                if (tabuleiro[i][j] == -1) { //Se sim, significa que a posição está vazia e ainda é possível realizar jogadas naquela posição.
                    return true;
                }
        return false;
    }

    public int BuscaDeMelhoresJogadas(JogadorJustice no, int valorMin, int valorMax, char vez) {
        if (vez == '0') {
            char ganhador = 0;
            if (ganhador == 'x')
                return 1;
            else if (ganhador == 'o') {
                return -1;
            } else {
                return 0;
            }
        }
        if (vez == 'x') {
            int aux = Integer.MIN_VALUE;
            for (JogadorJustice next : no.proximo()) {
                aux = Integer.max(aux, BuscaDeMelhoresJogadas(next, valorMin, valorMax, 'o'));
                valorMin = Integer.max(valorMin, aux);
                if (valorMax <= valorMin) {
                    break;
                }
            }
            return aux;
        } else {
            int aux = Integer.MAX_VALUE;
            for (JogadorJustice next : no.proximo()) {
                aux = Integer.min(aux, BuscaDeMelhoresJogadas(next, valorMin, valorMax, 'x'));
                valorMax = Integer.min(valorMax, aux);
                if (valorMax <= valorMin) {
                    break;
                }
            }
            return aux;
        }
    }

    List<JogadorJustice> proximo() {
        List<JogadorJustice> resp = null;
        return resp;
    }
}
