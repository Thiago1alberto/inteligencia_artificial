package jogo;

public class Tabuleiro {
    private int sizeTabuleiro;    
    private int[][] tabuleiro;
    int simboloVez;
    int totalJogadas;
    
    public Tabuleiro(int sizeTabuleiro){
        this.sizeTabuleiro = sizeTabuleiro;
        this.tabuleiro = new int[sizeTabuleiro][sizeTabuleiro];
        this.inicializarTabuleiro();
    }    
      
    public int[][] getTabuleiro(){
        int tabuleiroGet[][] = new int[this.sizeTabuleiro][this.sizeTabuleiro];
        for(int i = 0; i < sizeTabuleiro; i++){
            for(int j = 0; j < sizeTabuleiro; j++){
                tabuleiroGet[i][j] = this.tabuleiro[i][j];
            }
        }        
        return tabuleiroGet;
    }
    
    public int getSimboloVez(){
        return this.simboloVez;
    }
    
    //símbolo 0: O
    //símbolo 1: X
    public int jogar(int linha, int coluna, int simbolo){
        if(this.simboloVez == simbolo){
            if(this.tabuleiro[linha][coluna] == -1){
                tabuleiro[linha][coluna] = simbolo;                
            }else{
                System.out.println("Posição ocupada. Você perdeu sua vez.");
            }
            if(this.simboloVez == 0){
                this.simboloVez = 1;
            }else{
                this.simboloVez = 0;
            }
            this.totalJogadas++;
        }else{
            System.out.println("Não é a sua vez de jogar ou jogada inválida!");
        }
        
        this.imprimirTabuleiro();
        return this.jogadorVenceu();  
    }
    
    public void inicializarTabuleiro(){
        for(int i = 0; i < sizeTabuleiro; i++){
            for(int j = 0; j < sizeTabuleiro; j++){
                this.tabuleiro[i][j] = -1;
            }
        }
        this.totalJogadas = 0;
        this.simboloVez = 1;        
    }
    
    private void imprimirTabuleiro(){
        for(int i = 0; i < sizeTabuleiro; i++){
            System.out.println();
            for(int j = 0; j < sizeTabuleiro; j++){
                //if(j !=0)
                //    System.out.print("|");
                if(this.tabuleiro[i][j] == -1){
                    System.out.print(" ");
                }else if(this.tabuleiro[i][j] == 1){
                    System.out.print("X");
                }else{
                    System.out.print("O");                
                }
                if(j != this.sizeTabuleiro-1)
                    System.out.print("|");        
            }
        }
    }
    
    //return 1: vogador utilizando símbolo 1 venceu
    //return 0: vogador utilizando símbolo 0 venceu
    //return 2: jogo terminou sem vencedor
    //return -1: jogo não terminou    
    private int jogadorVenceu(){
        int soma1 = 0;        
        int soma0 = 0;        
        
        //Vencedor linha:
        for(int i = 0; i < sizeTabuleiro; i++){
            soma1 = 0;
            soma0 = 0;
            for(int j = 0; j < sizeTabuleiro; j++){
                if(tabuleiro[i][j] == 1){
                    soma1++;
                }
                if(tabuleiro[i][j] == 0){
                    soma0++;
                }
            }
            if(soma1 == this.sizeTabuleiro)
                return 1;
            if(soma0 == this.sizeTabuleiro)
                return 0;
        }
        
        
        //Vencedor coluna:
        for(int i = 0; i < sizeTabuleiro; i++){
            soma1 = 0;
            soma0 = 0;
            for(int j = 0; j < sizeTabuleiro; j++){
                if(tabuleiro[j][i] == 1){
                    soma1++;
                }
                if(tabuleiro[j][i] == 0){
                    soma0++;
                }
            }
            if(soma1 == this.sizeTabuleiro)
                return 1;
            if(soma0 == this.sizeTabuleiro)
                return 0;    
        }
        
        //Diagonal principal
        soma1 = 0;
        soma0 = 0;
        for(int i = 0; i < sizeTabuleiro; i++){
            if(tabuleiro[i][i] == 1){
                soma1++;
            }
            if(tabuleiro[i][i] == 0){
                soma0++;
            }
        }
        if(soma1 == this.sizeTabuleiro)
            return 1;
        if(soma0 == this.sizeTabuleiro)
            return 0;
        
        //Diagonal principal
        soma1 = 0;
        soma0 = 0;
        for(int i = 0; i < sizeTabuleiro; i++){
            if(tabuleiro[i][sizeTabuleiro-i-1] == 1){
                soma1++;
            }
            if(tabuleiro[i][sizeTabuleiro-i-1] == 0){
                soma0++;
            }
        }
        if(soma1 == this.sizeTabuleiro)
            return 1;
        if(soma0 == this.sizeTabuleiro)
            return 0;   
            
        if(this.totalJogadas == this.sizeTabuleiro*this.sizeTabuleiro)
            return 2;//jogo terminou sem vencedor empate
        
        return -1;//jogo não terminou
    }
}
