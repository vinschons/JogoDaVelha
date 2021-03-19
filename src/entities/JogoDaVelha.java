package entities;

public class JogoDaVelha {
	
	private char[][] tabuleiro;
	private Integer jogadasRestantes;
	private Integer dimensaoTabuleiro;

	public JogoDaVelha(int dimensaoTabuleiro) {
		this.dimensaoTabuleiro = dimensaoTabuleiro;
		this.jogadasRestantes = dimensaoTabuleiro * dimensaoTabuleiro;
		this.tabuleiro = new char[dimensaoTabuleiro][dimensaoTabuleiro];
	}

	public Integer getJogadasRestantes() {
		return jogadasRestantes;
	}
	
	
	public boolean realizaJogada(int x, int y, char a){
		if(a == 'x' || a == 'o') {
			if((x >= 0 && x<tabuleiro.length) && (y >= 0 && y<tabuleiro .length)) {
				if(tabuleiro[x][y] == 0) {
					tabuleiro[x][y] = a;
					jogadasRestantes --;
					System.out.println("Jogada realizada com sucesso!");
					return true;
				}
				else {
					System.out.println("Posição inválida!");
					return false;
				}
			}
		}
		System.out.println("Valor inválido!");
		return false;
	}
	
	private boolean verificaLinha() {
    	for(int i=0; i<tabuleiro.length; i++) {
    		char jogadaMestre = 0;
    		int jogadaIgual = 0;
    		
    		for(int j=0; j<tabuleiro[i].length; j++) {
    			char jogada = tabuleiro[i][j];
    			
    			if(jogada == 0){
    				break;
    			}
    			else {
    				if(jogadaMestre == 0){
    					jogadaMestre = jogada;
        			}
    				if(jogada != jogadaMestre){
        				break;
        			}
    				else {
    					jogadaIgual++;
    				}
    			}
    		}	
    		
    		if(jogadaIgual == tabuleiro[i].length) {
    			return true;
    		}
    	}
    	return false;
    }
	
	private boolean verificaColuna() {
    	for(int i=0; i<tabuleiro.length; i++) {
    		char jogadaMestre = 0;
    		int jogadaIgual = 0;
    		
    		for(int j=0; j<tabuleiro[i].length; j++) {
    			char jogada = tabuleiro[j][i];
    			
    			if(jogada == 0){
    				break;
    			}
    			else {
    				if(jogadaMestre == 0){
    					jogadaMestre = jogada;
        			}	
    				if(jogada != jogadaMestre){
        				break;
        			}
    				else {
    					jogadaIgual++;
    				}
    			}
    		}
    		
    		if(jogadaIgual == tabuleiro.length) {
    			return true;
    		}
    	}
    	return false;
    }
	
	private boolean verificaDiagonal() {
		char jogadaMestre = 0;
		int jogadaIgual = 0;
		
    	for(int i=0; i<tabuleiro.length; i++) {
    		char jogada = tabuleiro[i][i];
			
			if(jogada == 0){
				break;
			}
			else {
				if(jogadaMestre == 0){
					jogadaMestre = jogada;
    			}
				
				if(jogada != jogadaMestre){
    				break;
    			}
				else {
					jogadaIgual++;
				}
			}
    	}
    	
    	if(jogadaIgual == tabuleiro.length) {
			return true;
		}
    	else {
    		return false;
    	}
    }
	
	private boolean verificaDiagonalInversa() {
    	char jogadaMestre = 0;
		int jogadasIguais = 0;
		
    	for(int i=0; i<tabuleiro.length; i++) {
    		char jogada = tabuleiro[i][tabuleiro.length - 1 - i];
			
			if(jogada == 0){
				break;
			}
			else {
				if(jogadaMestre == 0){
					jogadaMestre = jogada;
    			}
				
				if(jogada != jogadaMestre){
    				break;
    			}
				else {
					jogadasIguais++;
				}
			}
    	}
    	
    	if(jogadasIguais == tabuleiro.length) {
			return true;
		}
    	else {
    		return false;
    	}
    }
	
	public boolean verificaGanhador() {
		if(verificaLinha() || verificaColuna() || verificaDiagonal() || verificaDiagonalInversa()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void terminaJogo() {
		jogadasRestantes = 0;
	}
	
	 @Override
	 public String toString() {
		for(int a = 0; a<tabuleiro.length; a++) {
			for(int b = 0; b<tabuleiro.length; b++) {
				if(tabuleiro[a][b] == 0 && b == (dimensaoTabuleiro-1)) {
					System.out.println("|  |");
				}
				else if(tabuleiro[a][b] == 0) {
					System.out.print("|  |");
				}
				else if(b == 0) {
					System.out.print("|" + tabuleiro[a][b] + " |");
				}
				else if(b == (dimensaoTabuleiro-1)){
					System.out.println("|" + tabuleiro[a][b] + " |");
				}
				else {
					System.out.print("|" + tabuleiro[a][b] + " |");
				}
			 }
		}
		return "Dimensões: "
				+dimensaoTabuleiro
				+"x"
				+dimensaoTabuleiro;
	 }
	 
}

