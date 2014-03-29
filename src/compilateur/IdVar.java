package compilateur;


public class IdVar extends Ident {
	private int offset;

	public IdVar(int type, String nom, int offset) {
		super(type, nom);
		this.offset = offset;
	}
	
	public IdVar(int type, String nom) {
		super(type, nom);
	}

	public int getValeur() {
		return offset;
	}

	public void setValeur(int offset) {
		this.offset = offset;
	}

	public int getForme() {
		return VAR;
	}
	
	public void setOffset(int offset) {
		setValeur(offset);
	}

	@Override
	public void calculerOffset(int taille) {
		// TODO Auto-generated method stub
	}

}
