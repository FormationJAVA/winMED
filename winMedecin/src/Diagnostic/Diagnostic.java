package Diagnostic;

public class Diagnostic {

	public Mesure mesure;
	public Etat etatBC = Etat.Normal;
	public Etat etatTA = Etat.Normal;
	
	public Diagnostic (Mesure m)
	{
		this.mesure = m;
		if (this.mesure.bc>100 )
			etatBC = Etat.Eleve;
		if (this.mesure.bc<50 )
			etatBC = Etat.Bas;
		if (this.mesure.ta>14 )
			etatTA = Etat.Eleve;
		if (this.mesure.ta<6 )
			etatTA = Etat.Bas;
	}
}
