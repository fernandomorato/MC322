package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	public boolean vivo;
	
	Peca() {
		vivo = false;
	}
	
	void adiciona() {
		vivo = true;
	}
	
	void mata() {
		vivo = false;
	}
}
