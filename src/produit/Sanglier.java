package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier","kilogramme");
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String decrireProduit() {
		return super.getNom() + " de " + poids + " kg chassé par " + chasseur.getNom() + ".";
	}
	
	@Override
	public int calculerPrix(int prix) {
		return (poids * prix) / 1000;
	}
}