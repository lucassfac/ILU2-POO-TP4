package produit;

public abstract class Produit implements IProduit{
	private String nom;
	private Unite unite;
	
	protected Produit(String nom,String unite) {
		this.nom = nom;
		switch (unite) {
			case "gramme":
				this.unite = Unite.g;
				break;
			case "kilogramme":
				this.unite = Unite.kg;
				break;
			case "litre":
				this.unite = Unite.l;
				break;
			case "centilitre":
				this.unite = Unite.cl;
				break;
			case "mililitre":
				this.unite = Unite.ml;
				break;
			default:
				this.unite = Unite.piece;
				break;
		}
		
	}
	
	@Override
	public String getNom() {
		return nom;
	}
	
	@Override
	public int calculerPrix(int prix) {
		return prix;
	}
		
}