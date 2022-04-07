package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamanhoAquario;
	int tamanhoLombriga;
	int posAtual;
	boolean esquerda;
	
	public AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posInicial) {
		this.tamanhoAquario = tamanhoAquario;
		this.tamanhoLombriga = tamanhoLombriga;
		this.posAtual = posInicial;
		this.esquerda = true;
	}
	
	public void crescer() {
		if (posAtual + tamanhoLombriga <= tamanhoAquario)
			tamanhoLombriga++;
	}
	
	public void mover() {
		if (esquerda) {
			if (posAtual == 1)
				virar();
			else
				posAtual--;
		} else {
			if (posAtual == tamanhoAquario)
				virar();
			else
				posAtual++;
		}
	}
	
	public void virar() {
		if (esquerda)
			posAtual = posAtual + tamanhoLombriga - 1;
		else
			posAtual = posAtual - tamanhoLombriga + 1;
		esquerda = !esquerda;
	}
	
	public String apresenta() {
		String aquario = new String();
		if (esquerda) {
			for (int i = 1; i < posAtual; i++)
				aquario += '#';
			aquario += '0';
			for (int i = posAtual + 1; i <= posAtual + tamanhoLombriga - 1; i++)
				aquario += '@';
			for (int i = posAtual + tamanhoLombriga; i <= tamanhoAquario; i++)
				aquario += '#';
		} else {
			for (int i = 1; i < posAtual - tamanhoLombriga + 1; i++) {
				aquario += '#';
			}
			for (int i = posAtual - tamanhoLombriga + 1; i < posAtual; i++) {
				aquario += '@';
			}
			aquario += '0';
			for (int i = posAtual + 1; i <= tamanhoAquario; i++) {
				aquario += '#';
			}
		}
		return aquario;
	}
}
