package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	public Peca[][] board = new Peca[7][7];
	
	Tabuleiro(char board[][]) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				this.board[i][j] = new Peca();
				if (board[i][j] == ' ') continue;
				if (board[i][j] == 'P') this.board[i][j].adiciona();
				else this.board[i][j].mata();
			}
		}
	}
	
	public void move(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal) {
		board[linhaInicial][colunaInicial].mata();
		board[linhaFinal][colunaFinal].adiciona();
		if (linhaInicial == linhaFinal) {
			if (colunaFinal < colunaInicial) {
				board[linhaInicial][colunaInicial - 1].mata();
			} else {
				board[linhaInicial][colunaInicial + 1].mata();
			}
		} else { // (colunaInicial == colunaFinal)
			if (linhaFinal < linhaInicial) {
				board[linhaInicial - 1][colunaInicial].mata();
			} else {
				board[linhaInicial + 1][colunaInicial].mata();
			}
		}
	}
	
	public char[][] apresenta() {
		 char board[][] = {
		         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
		         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
		         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
		         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
		         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
		         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
		         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
		      };
		 for (int i = 0; i < 7; i++) {
			 for (int j = 0; j < 7; j++) {
				 if (board[i][j] != 'P') continue;
				 if (!this.board[i][j].vivo)
					 board[i][j] = '-'; 
			 }
		 }
		 return board;
	}
}
