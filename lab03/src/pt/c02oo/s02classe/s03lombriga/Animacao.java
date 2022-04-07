package pt.c02oo.s02classe.s03lombriga;
import pt.c02oo.s02classe.s03lombriga.*;

public class Animacao {
	AquarioLombriga aquarioLombriga;
	String estadoAtual, animacao;
	int indiceAtual;
	public Animacao(String animacao) {
		int	tamanhoAquario = Character.getNumericValue(animacao.charAt(0)) * 10 + Character.getNumericValue(animacao.charAt(1));
		int	tamanhoLombriga = Character.getNumericValue(animacao.charAt(2)) * 10 + Character.getNumericValue(animacao.charAt(3));
		int	posInicial = Character.getNumericValue(animacao.charAt(4)) * 10 + Character.getNumericValue(animacao.charAt(5));
		aquarioLombriga = new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posInicial);
		estadoAtual = aquarioLombriga.apresenta();
		this.animacao = animacao;
		this.indiceAtual = 6;
	}
	
	public String apresenta() {
		estadoAtual = aquarioLombriga.apresenta();
		return estadoAtual;
	}
	
	public void passo() {
		char ch = animacao.charAt(indiceAtual);
		if (ch == 'C') {
			aquarioLombriga.crescer();
		} else if (ch == 'M') {
			aquarioLombriga.mover();
		} else {
			aquarioLombriga.virar();
		}
		indiceAtual++;
	}
}
