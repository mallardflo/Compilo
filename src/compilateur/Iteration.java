package compilateur;
import java.util.Stack;


public class Iteration implements Etiquette {

	protected Stack<Integer> stack = new Stack<Integer>();
	protected int nbBoucles = 0; 	
	protected final String labelEtiquetteDebut = "FAIRE";
	protected final String labelEtiquetteFin = "FAIT";
	
	public void nouvelleIteration()
	{
		nbBoucles++;
		stack.push(nbBoucles);
	}
	
	
	public String getEtiquetteFin()
	{
		return labelEtiquetteFin+stack.peek();
	}
	
	public String getEtiquetteDebut()
	{
		return labelEtiquetteDebut+stack.peek();
	}
	
	public String getEtiquetteFinAndFinish()
	{
		return labelEtiquetteFin+stack.pop();
	}

	@Override
	public String getEtiquetteSuivante() {
		return getEtiquetteFin();
	}
}
