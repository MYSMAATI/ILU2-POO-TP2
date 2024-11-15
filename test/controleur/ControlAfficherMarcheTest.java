package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		controlEmmenager = new ControlEmmenager(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche);
	}

	@Test
	void testDonnerInfoMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		String[] tableauAttendue1 = {};
		String[] sortie1 = controlAfficherMarche.donnerInfoMarche();
		
		assertArrayEquals(sortie1, tableauAttendue1);
		
		controlEmmenager.ajouterGaulois("Bonemine", 5);
		controlEmmenager.ajouterGaulois("Asterix", 5);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 5);
		controlPrendreEtal.prendreEtal("Asterix", "poissons", 10);
		
		String[] tableauAttendue2 = {"Bonemine", "5", "fleurs", "Asterix", "10", "poissons"};
		String[] sortie2 = controlAfficherMarche.donnerInfoMarche();
		
		assertArrayEquals(sortie2, tableauAttendue2);
		
		
	}

}
