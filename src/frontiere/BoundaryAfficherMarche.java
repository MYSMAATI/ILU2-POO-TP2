package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infoMarche = controlAfficherMarche.donnerInfoMarche();
		
		if(infoMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard. \n");
		} else {
			int i = 0;
			String vendeur, quantite, produit;
			
			System.out.println(nomAcheteur + ", vous trouverez au marché : \n");
			while(i < infoMarche.length) {
				vendeur = infoMarche[i];
				i++;
				quantite = infoMarche[i];
				i++;
				produit = infoMarche[i];
				i++;
				
				System.out.println("- " + vendeur + " qui vend " + quantite + " " + produit);
			}
		}
	}
}
