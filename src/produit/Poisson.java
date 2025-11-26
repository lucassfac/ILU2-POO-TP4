package produit;

public class Poisson extends Produit {
	private String datePeche;
	
	
	public Poisson(String datePeche) {
		super("poisson","pièce");
		this.datePeche = datePeche;
	}
	
	
	@Override
	public String decrireProduit() {
		return super.getNom() + " pêchés " + datePeche;
	}
	
}
