package compilateur;


import java.util.HashMap;
import java.util.Iterator;

public class TabIdent {
	private HashMap<String, Ident> locaux;
	private int offset = 0;
	
	public TabIdent(){
		locaux = new HashMap<String, Ident>();
	}

	public Ident chercheIdent(String clef) {
		try {
			locaux.get(clef);
		}
		catch (Exception e)
		{
			System.out.println("Erreur : Ident absent dans la table");
		}
		return locaux.get(clef);
	}

	public boolean existeIdent(String clef) {
		return locaux.containsKey(clef);
	}
	

	public boolean existeIdentLocal(String clef) {
		return locaux.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id,int modifOffset) {
		offset += modifOffset;
		id.setOffset(offset);
		locaux.put(clef, id);
	}
	
	public void rangeIdent(String clef, Ident id) {
		locaux.put(clef, id);
	}
	
	public int getValeurIdent(String nomIdent, Token tok)
	{
		Ident i = chercheIdent(nomIdent);
		int val = 0;
		try
		{
			val = i.getValeur();
		}
		catch (Exception e)
		{
			System.out.println("Erreur (l."+tok.beginLine+"): l'identifiant "+nomIdent+" n'est pas declare.");
		}
		
		return val;
	}
	
	public int nombreVariable() {
		int compteur = 0;
		
		Iterator<Ident> i = locaux.values().iterator();
		while (i.hasNext()) {
			if(i.next().getForme() == Ident.VAR) {
				compteur++;
			}
		}
		
		return compteur;
	}
	public void videLocaux()
	{
		locaux.clear();
		offset = 0;
	}
	
	public void ecrireDebug()
	{
		System.out.println(locaux);
	}
	
	
}
