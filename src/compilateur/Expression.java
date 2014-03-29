package compilateur;
import java.util.Stack;


public class Expression implements Constantes {
	private TabIdent tabIdent;
	private Stack<Integer> types = new Stack<Integer>();
	private Stack<Integer> operateur = new Stack<Integer>();

	private  final int[][] tabOpe = {{ENTIER,	ERROR,		ERROR	},
								     {BOOLEAN,	ERROR,		ERROR	},
								     {BOOLEAN,	BOOLEAN,	ERROR	},
								     {ERROR,	BOOLEAN,	ERROR	}};

	
	public Expression(TabIdent tabIdent) {
		super();
		this.tabIdent = tabIdent;
	}
	
	public void empilerOperation(int ope)
	{
		operateur.push(ope);
	}
	
	public void empilerType(int type)
	{
		this.types.push(type);
	}
	
	public int depilerOperation()
	{
		return operateur.pop();
	}
	
	public int depilerType()
	{
		return types.pop();
	}
	public int getSommetTypes()
	{
		return types.peek();
	}
	
	public int getSommetOp()
	{
		return operateur.peek();
	}
	
	public void controleAffectation(String ident, Token tok)
	{
		if (tabIdent.existeIdent(ident))
		{
			Ident id = tabIdent.chercheIdent(ident);
			if (id.getType()!=types.peek())
			{
				System.out.println("Erreur (l."+tok.beginLine+"): le type de la partie droite n'est pas le meme que la partie gauche "+id.getNom()+" a la ligne "+tok.beginLine);
			}
		}
		else
		{
			System.out.println("Erreur (l."+tok.beginLine+"): l'identifiant n'existe pas a la ligne "+tok.beginLine);
		}
		
	}
	
	
	public boolean operation(Token tok)
	{
		int ope = operateur.pop();
		if (ope==NEG || ope == NOT)
		{
			return true;
		}
		else
		{
			int type1 = types.pop();
			int type2 = types.pop();
			if (type1==type2)
			{
				switch (ope)
				{
					case PLUS:
					case MOINS:
					case MUL:
					case DIV:
						if (tabOpe[0][type1]==ERROR)
							System.out.println("Erreur (l."+tok.beginLine+"): l'expression n'est pas correcte.");
						types.push(tabOpe[0][type1]);
						break;
						
					case INF:
					case SUP:
					case INFEG:
					case SUPEG:
						if (tabOpe[1][type1]==ERROR)
							System.out.println("Erreur (l."+tok.beginLine+"): l'expression n'est pas correcte.");
						types.push(tabOpe[1][type1]);
						break;
		
					case EGAL:
					case NEGAL:
						if (tabOpe[2][type1]==ERROR)
							System.out.println("Erreur (l."+tok.beginLine+"): l'expression n'est pas correcte.");
						types.push(tabOpe[2][type1]);				
						break;
						
					case ET:
					case OU:
						if (tabOpe[3][type1]==ERROR)
							System.out.println("Erreur (l."+tok.beginLine+"): l'expression n'est pas correcte.");
						types.push(tabOpe[3][type1]);
						
						break;
				}
				return true;
			}
			else
			{
				System.out.println("Erreur (l."+tok.beginLine+"): l'expression n'est pas correcte.");
				types.push(ERROR);
				return false;
			}
		}
	}
	


	public void empilerEnt(int a) {
		empilerType(ENTIER);
	}
	
	public void empilerBool(int a) {
		empilerType(BOOLEAN);
	}
	
	public void empilerIdent(String nomIdent,Token tok)
	{
		if (tabIdent.existeIdent(nomIdent))
		{
			Ident ident = tabIdent.chercheIdent(nomIdent);
			empilerType(ident.getType());
		}
		else
		{
			System.out.println("Erreur (l."+tok.beginLine+"): la variable "+nomIdent+" n'existe pas.");
			empilerType(ERROR);
		}
	}

	public TabIdent getTabIdent() {
		return tabIdent;
	}

	public void setTabIdent(TabIdent tabIdent) {
		this.tabIdent = tabIdent;
	}
	
	public void testExprBool(Token tok)
	{
		if (types.peek() != BOOLEAN)
		{
			System.out.println("Erreur (l."+tok.beginLine+"): l'expression n'est pas booleenne.");			
		}
	}
	
	public void affichePile(Token token)
	{
		System.out.println("token: "+token+" l"+token.beginLine);
		System.out.println(types);
	}
	
	public void clear()
	{
		types.clear();
		operateur.clear();
	}
	
	public void testExpr(int type,Token tok)
	{
		if (types.peek() != type)
		{
			System.out.println("Erreur (l."+tok.beginLine+"): l'expression n'a pas le bon type.");			
		}
	}
	
}
