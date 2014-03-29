package compilateur;
public class YVMasm extends YVM {
	private int cmptChaine = 0;

	public YVMasm(String nomFich) {
		super(nomFich,".asm");
	}

	public void entete() {
		Ecriture.ecrireString(o,"; ");
		super.entete();
		Ecriture.ecrireStringln(o,"extrn lirent:proc, ecrent:proc, ecrbool:proc, ecrch:proc, ligsuiv:proc");
		Ecriture.ecrireStringln(o,".model SMALL");
		Ecriture.ecrireStringln(o,".586");
		Ecriture.ecrireStringln(o,"");
		Ecriture.ecrireStringln(o,".CODE");
	}

	public void iadd() {
		Ecriture.ecrireString(o,"; ");
		super.iadd();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"add ax,bx");
		Ecriture.ecrireStringln(o,"push ax");
	}


	public void isub() {
		Ecriture.ecrireString(o,"; ");
		super.isub();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"sub ax,bx");
		Ecriture.ecrireStringln(o,"push ax");
	}

	public void imul() {
		Ecriture.ecrireString(o,"; ");
		super.imul();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"imul bx");
		Ecriture.ecrireStringln(o,"push ax");
	}

	public void idiv() {
		Ecriture.ecrireString(o,"; ");
		super.idiv();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"cwd");
		Ecriture.ecrireStringln(o,"idiv bx");
		Ecriture.ecrireStringln(o,"push ax");
	}

	public void inot() {
		Ecriture.ecrireString(o,"; ");
		super.inot();
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"not ax");
		Ecriture.ecrireStringln(o,"push ax");
	}


	public void ior() {
		Ecriture.ecrireString(o,"; ");
		super.ior();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"or ax,bx");
		Ecriture.ecrireStringln(o,"push ax");
	}

	public void iand() {
		Ecriture.ecrireString(o,"; ");
		super.iand();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"and ax,bx");
		Ecriture.ecrireStringln(o,"push ax");
	}


	public void ineg() {
		Ecriture.ecrireString(o,"; ");
		super.ineg();
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"neg ax");
		Ecriture.ecrireStringln(o,"push ax");
	}

	public void iinf() {
		Ecriture.ecrireString(o,"; ");
		super.iinf();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"cmp ax,bx");
		Ecriture.ecrireStringln(o,"jge $+6");
		Ecriture.ecrireStringln(o,"push -1");
		Ecriture.ecrireStringln(o,"jmp $+4");
		Ecriture.ecrireStringln(o,"push 0");
	}

	public void isup() {
		Ecriture.ecrireString(o,"; ");
		super.isup();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"cmp ax,bx");
		Ecriture.ecrireStringln(o,"jle $+6");
		Ecriture.ecrireStringln(o,"push -1");
		Ecriture.ecrireStringln(o,"jmp $+4");
		Ecriture.ecrireStringln(o,"push 0");
	}

	public void iinfegal() {
		Ecriture.ecrireString(o,"; ");
		super.iinfegal();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"cmp ax,bx");
		Ecriture.ecrireStringln(o,"jg $+6");
		Ecriture.ecrireStringln(o,"push -1");
		Ecriture.ecrireStringln(o,"jmp $+4");
		Ecriture.ecrireStringln(o,"push 0");
	}

	public void isupegal() {
		Ecriture.ecrireString(o,"; ");
		super.isupegal();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"cmp ax,bx");
		Ecriture.ecrireStringln(o,"jl $+6");
		Ecriture.ecrireStringln(o,"push -1");
		Ecriture.ecrireStringln(o,"jmp $+4");
		Ecriture.ecrireStringln(o,"push 0");
	}

	public void iegal() {
		Ecriture.ecrireString(o,"; ");
		super.iegal();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"cmp ax,bx");
		Ecriture.ecrireStringln(o,"jne $+6");
		Ecriture.ecrireStringln(o,"push -1");
		Ecriture.ecrireStringln(o,"jmp $+4");
		Ecriture.ecrireStringln(o,"push 0");
	}

	public void idiff() {
		Ecriture.ecrireString(o,"; ");
		super.idiff();
		Ecriture.ecrireStringln(o,"pop bx");
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"cmp ax,bx");
		Ecriture.ecrireStringln(o,"je $+6");
		Ecriture.ecrireStringln(o,"push -1");
		Ecriture.ecrireStringln(o,"jmp $+4");
		Ecriture.ecrireStringln(o,"push 0");
	}

	public void iload(int offset) {
		Ecriture.ecrireString(o,"; ");
		super.iload(offset);
		String signe = "";
		if (offset>=0) signe = "+";
		Ecriture.ecrireStringln(o,"push word ptr [bp"+signe+offset+"]");
	
	}

	public void istore(int offset) {
		Ecriture.ecrireString(o,"; ");
		super.istore(offset);
		Ecriture.ecrireStringln(o,"pop ax");
		String signe = "";
		if (offset>=0) signe = "+";
		Ecriture.ecrireStringln(o,"mov word ptr [bp"+signe+offset+"],ax");

	}

	public void iconst(int valeur) {
		Ecriture.ecrireString(o,"; ");
		super.iconst(valeur);
		Ecriture.ecrireStringln(o,"push word ptr "+valeur);
	}

	public void ifeq(String etiquette) {
		Ecriture.ecrireString(o,"; ");
		super.ifeq(etiquette);
		Ecriture.ecrireStringln(o,"pop ax");
		Ecriture.ecrireStringln(o,"cmp ax,0");
		Ecriture.ecrireStringln(o,"je "+etiquette);
	}

	public void igoto(int etiquette) {
		Ecriture.ecrireString(o,"; ");
		super.igoto(etiquette);
		Ecriture.ecrireStringln(o,"jmp "+etiquette);
	}

	public void ouvrePrinc(int offset) {
		Ecriture.ecrireString(o,"; ");
		super.ouvrePrinc(offset);
		Ecriture.ecrireStringln(o,"mov bp,sp");
		Ecriture.ecrireStringln(o,"sub sp,"+offset);
	}

	public void queue() {
		Ecriture.ecrireString(o,"; ");
		super.queue();
		Ecriture.ecrireStringln(o,"nop");
		Ecriture.ecrireStringln(o,"EXITCODE");
		Ecriture.ecrireStringln(o,"end debut");
	}

	public void ecrireEnt() {
		Ecriture.ecrireString(o,"; ");
		super.ecrireEnt();
		Ecriture.ecrireStringln(o,"call ecrent");
	}

	public void ecrireChaine(String s) {
		Ecriture.ecrireString(o,"; ");
		super.ecrireChaine(s);
		Ecriture.ecrireStringln(o,".DATA");
		String tmp = s.substring(0, s.length()-1);
		Ecriture.ecrireStringln(o,"mess"+cmptChaine+" DB "+tmp+"$\"");
		Ecriture.ecrireStringln(o,".CODE");
		Ecriture.ecrireStringln(o,"lea dx,mess"+cmptChaine);
		Ecriture.ecrireStringln(o,"push dx");
		Ecriture.ecrireStringln(o,"call ecrch");
		cmptChaine++;
	}

	public void ecrireBool() {
		Ecriture.ecrireString(o,"; ");
		super.ecrireBool();
		Ecriture.ecrireStringln(o,"call ecrbool");
	}

	public void lireEnt(int offset) {
		Ecriture.ecrireString(o,"; ");
		super.lireEnt(offset);
		String signe = "";
		if (offset>=0) signe = "+";
		Ecriture.ecrireStringln(o,"lea dx,[bp"+signe+offset+"]");
		Ecriture.ecrireStringln(o,"push dx");
		Ecriture.ecrireStringln(o,"call lirent");
	}

	public void aLaLigne() {
		Ecriture.ecrireString(o,"; ");
		super.aLaLigne();
		Ecriture.ecrireStringln(o,"call ligsuiv");
	}
	
	public void ouvreBloc(int taille) {
		Ecriture.ecrireString(o,"; ");
		super.ouvreBloc(taille);
		Ecriture.ecrireStringln(o, "enter " +taille + ",0");
	}
	
	public void fermeBloc(int taille) {
		Ecriture.ecrireString(o,"; ");
		super.fermeBloc(taille);
		Ecriture.ecrireStringln(o, "leave ");
		Ecriture.ecrireStringln(o, "ret " + taille);
	}
	
	public void ireturn(int offset) {
		Ecriture.ecrireString(o,"; ");
		super.ireturn(offset);
		Ecriture.ecrireStringln(o, "pop ax");
		String signe = "";
		if (offset>=0) signe = "+";
		Ecriture.ecrireStringln(o, "mov [bp" + signe + offset + "],ax");
	}
	
	public void reserveRetour() {
		Ecriture.ecrireString(o,"; ");
		super.reserveRetour();
		Ecriture.ecrireStringln(o, "sub sp,2");
	}
	
	public void call(String nom) {
		Ecriture.ecrireString(o,"; ");
		super.call(nom);
		Ecriture.ecrireStringln(o, "call " +nom);
	}
	
	public void nomFonc(String nom) {
		Ecriture.ecrireString(o,"; ");
		super.nomFonc(nom);
		Ecriture.ecrireStringln(o, nom+":");
	}
	
	public void debut() {
		Ecriture.ecrireStringln(o,"debut:");
		Ecriture.ecrireStringln(o,"STARTUPCODE");	
	}

}