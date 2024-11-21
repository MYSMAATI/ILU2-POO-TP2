package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	
	private String afficherCommercant(Gaulois[] commercant) {
		StringBuilder chaine = new StringBuilder();
		for(int i = 1; i <= commercant.length ; i++) {
			chaine.append(i + " - " + commercant[i-1].getNom() + "\n");
		}
		return chaine.toString();
	}

	public void acheterProduit(String nomAcheteur) {
		//Verification identit� de l'acheteur
		if (! controlAcheterProduit.isHabitant(nomAcheteur)) {
			System.out.println("Je suis d�sol� " + nomAcheteur + " mais il faut " +
					" �tre un habitant de notre village pour commercer ici \n");
		} else {		
			//L'acheteur fait partie du village
			String produit = Clavier.entrerChaine("Quel produit voulez vous acheter ? \n");	
			Gaulois[] commercant = controlAcheterProduit.getCommercant(produit);
			
			if(commercant == null) {
				//Personne ne vend le produit recherch�
				System.out.println("D�sol�, personne ne vend ce produit au march� \n");
			} else {
				
				acheterProduitCommercant(nomAcheteur, produit, commercant);
			}
		}
	}
	
	
	
	private void acheterProduitCommercant(String nomAcheteur, String produit, Gaulois[] commercant) {		
		//choix marchand		
		int choixCommercant = Clavier.entrerEntier("Chez quel commer�ant voulez vous acheter des " 
				+ produit + " ? \n" + afficherCommercant(commercant));
		
		System.out.println(nomAcheteur + " se d�place jusqu'�l'�tal du vendeur " + commercant[choixCommercant - 1].getNom() + "\n");
		
		//choix quantit�
		System.out.println("Combien de " + produit + " voulez vous acheter ? \n");
		int quantite = scan.nextInt();
		
		acheterProduitCommercantQuantite(nomAcheteur, produit, commercant, choixCommercant , quantite);
	}
	
	
	
	private void acheterProduitCommercantQuantite(String nomAcheteur, String produit, Gaulois[] commercant, int choixCommercant, int quantite) {	
		int quantiteAchetee = controlAcheterProduit.acheterProduit(commercant[choixCommercant - 1], quantite);
		
		if(quantiteAchetee == 0) {
			//Plus rien de disponible
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !  \n");
			
		} else if (quantiteAchetee < quantite) {
			//Stock limit�
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " 
					+ commercant[choixCommercant - 1].getNom() + " n'en a plus que " + quantiteAchetee + ". " 
					+ nomAcheteur + " ach�te donc tout le stock de " + commercant[choixCommercant - 1].getNom() + ". \n");
		} else {
			//Stock suffisant
			System.out.println(nomAcheteur + " ach�te " + quantite + " " + produit + " � " + commercant[choixCommercant - 1].getNom() + "\n");
		}
	}
}
