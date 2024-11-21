package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
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
	
	public Gaulois[] getCommercant(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(Gaulois vendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur.getNom());
		return etal.acheterProduit(quantite);
	}
}
