package compilateur;

public abstract class Ident implements Constantes {

	private int type;
	private String nom;
	final static int VAR = 0;
	final static int CONST = 1;
	final static int FONC = 2;
	final static int PARAM = 3;
	

	public Ident(int type, String nom) {
		this.type = type;
		this.nom = nom;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return "Type : " + type + " Nom : " + getNom() + " Valeur : " + getValeur()+"\n" ; 
	}
	public abstract int getValeur();
	
	public abstract void setValeur(int valeur);

	public abstract int getForme();
	
	public abstract void setOffset(int o);
	
	public abstract void calculerOffset(int taille);
}
