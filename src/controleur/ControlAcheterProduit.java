package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nomVisiteur) {
		return controlVerifierIdentite.verifierIdentite(nomVisiteur);
	}
	
	public String[] getCommercant(String produit) {
		Gaulois[] commercantsGaulois = village.rechercherVendeursProduit(produit);
		String[] commercants = new String[commercantsGaulois.length];
		
		for (int i = 0; i < commercantsGaulois.length; i++) {
			commercants[i] = commercantsGaulois[i].getNom();
		}
		
		return commercants;
	}
	
	public int acheterProduit(Gaulois vendeur, int quantite) {
		
		return 1;
	}

}
