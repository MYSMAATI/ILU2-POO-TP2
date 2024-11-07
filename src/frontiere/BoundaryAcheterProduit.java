package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	
	public void afficherCommercant(String[] commercant) {
		for(int i = 1; i <= commercant.length ; i++) {
			System.out.println(i + " - " + commercant[i-1] + "\n");
		}
	}

	public void acheterProduit(String nomAcheteur) {
		if (! controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut " +
					" être un habitant de notre village pour commercer ici");
		} else {
			System.out.println("Quel produit voulez vous acheter ?");
			String produit = scan.next();
			
			String[] commercant = controlAcheterProduit.getCommercant(produit);
			
			if(commercant.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			} else {
				System.out.println("Chez quel commerçant voulez vous acheter des " 
							+ produit + " ? \n");
				afficherCommercant(commercant);
				
				//choix marchand
				
				int choixUtilisateur = Clavier.entrerEntier();
				
			}
		}
	}
}
