package compilateur;

public class Declaration implements Constantes {
	
/**
 * La table des identifiants 
 */
	private TabIdent tabIdent;
	
/**
 * Le type de l'identifiant courant
 */
	int type;
	
/**
 * Constructeur de declaration
 * @param tabIdent la table des identifiants associee
 */
	public Declaration(TabIdent tabIdent) {
		super();
		this.tabIdent = tabIdent;
		type=ENTIER;
	}
/**
 * Ajoute une constante entiere dans la table des identifiants
 * @param id l'identifiant de la constante a declarer
 * @param entier la valeur entiere a affecter a la constante
 * @param tok le token courant
 */
	public void ajoutConstEntier(String id, int entier, Token tok)
	{
		if (!tabIdent.existeIdent(id))
		{
			tabIdent.rangeIdent(id, new IdConst(ENTIER,id,entier));
		}
		else
		{
			System.out.println("Erreur (l."+tok.beginLine+"): la constante "+id+" est deja declaree.");
		}
	}
	
/**
 * 
 * @param id l'identifiant de la constante a declarer
 * @param ident l'identifiant de la valeur a affecter a la constante
 * @param tok le token courant
 */
	public void ajoutConstIdent(String id, String ident, Token tok)
	{
		if (!tabIdent.existeIdent(id))
		{
			if (tabIdent.existeIdent(ident))
			{
				int entier = tabIdent.chercheIdent(ident).getValeur();
				int type = tabIdent.chercheIdent(ident).getType();
				tabIdent.rangeIdent(id, new IdConst(type,id,entier));
			}
			else
			{
				System.out.println("Erreur (l."+tok.beginLine+"): la constante "+ident+" n'est pas declaree.");
			}
		}
		else
		{
			System.out.println("Erreur (l."+tok.beginLine+"): la constante "+id+" est deja utilisee.");
		}
	}
/**
 * 
 * @param id l'identifiant de la constante a declarer
 * @param val la valeur booleenne a affecter a la constante
 * @param tok le token courant
 */
	public void ajoutConstBool(String id, int val, Token tok)
	{
		if (!tabIdent.existeIdent(id))
		{
			tabIdent.rangeIdent(id, new IdConst(BOOLEAN,id,val));
		}
		else
		{
			System.out.println("Erreur (l."+tok.beginLine+"): la constante "+id+" est deja declaree.");
		}
	}
	
/**
 * Change le type de la variable courante
 * @param type le type de la variable courante
 */
	public void definirTypeVar(int type)
	{
		this.type=type;
	}
	
/**
 * 
 * @param id l'identifiant de la variable a declarer
 * @param tok le token courant
 */
	public void ajoutVariable(String id, Token tok)
	{
		if (!tabIdent.existeIdent(id))
		{
			tabIdent.rangeIdent(id,new IdVar(type,id),-2);
		}
		else
		{
			System.out.println("Erreur (l."+tok.beginLine+"): la variable "+id+" est deja declaree.");			
		}
	}
	

}
