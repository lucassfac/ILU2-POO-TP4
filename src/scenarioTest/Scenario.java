package scenarioTest;

import personnages.Gaulois;
import produit.IProduit;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;

import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		IVillage village = new IVillage() {
			private Gaulois[] villageois = new Gaulois[10];
			private IEtal[] marche = new IEtal[5];
			
			@Override
			public <P extends IProduit> boolean installerVendeur(Etal<P> etal,Gaulois vendeur, P[] produit,
					int prix) {
				int i = 0;
				while (i < 5 && marche[i] != null) {
					i++;
				}
				if (i == 5) {
					return false;
				}
				etal.installerVendeur(vendeur, produit, prix);
				marche[i] = etal;
				return true;
			}
			
			@Override
			public void acheterProduit(String produit, int quantiteSouhaitee) {
				int quantiteSouhaiteeInitial = quantiteSouhaitee;
				int quantiteAchetee = 0;
				int i = 0;
				while (marche[i]!= null && quantiteSouhaitee > 0) {
					int quantite = marche[i].contientProduit(produit, quantiteSouhaitee);
					if (quantite > 0) {
						int prixPaye = marche[i].acheterProduit(quantite);
						quantiteSouhaitee -= quantite;
						System.out.println("A l'étal n°" + i + ", j'achète " + quantite + " " + produit + " et je paye " + prixPaye + ".");
						quantiteAchetee += quantite;
					}
					i++;
				}
				System.out.println("Je voulais " + quantiteSouhaiteeInitial + " " + produit + ", j'en ai acheté " + quantiteAchetee + "\n");
			}
			
			@Override 
			public String toString() {
				StringBuilder presentation = new StringBuilder();
				for (int i = 0; i < 5; i++) {
					if (marche[i] != null) {
						presentation.append(marche[i].etatEtal() + "\n");
					}
				}
				return presentation.toString();
			}
			
		};
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}
