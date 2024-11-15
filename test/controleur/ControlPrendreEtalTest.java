package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
		controlEmmenager = new ControlEmmenager(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(controlPrendreEtal.resteEtals(), true);
		
		controlEmmenager.ajouterGaulois("Bonemine1", 10);
		controlEmmenager.ajouterGaulois("Bonemine2", 10);
		controlEmmenager.ajouterGaulois("Bonemine3", 10);
		controlEmmenager.ajouterGaulois("Bonemine4", 10);
		controlEmmenager.ajouterGaulois("Bonemine5", 10);
		controlPrendreEtal.prendreEtal("Bonemine1", "fleurs", 5);
		controlPrendreEtal.prendreEtal("Bonemine2", "fleurs", 5);
		controlPrendreEtal.prendreEtal("Bonemine3", "fleurs", 5);
		controlPrendreEtal.prendreEtal("Bonemine4", "fleurs", 5);
		controlPrendreEtal.prendreEtal("Bonemine5", "fleurs", 5);
		
		assertEquals(controlPrendreEtal.resteEtals(), false);
		
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertEquals(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 5), 0);
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertEquals(controlPrendreEtal.verifierIdentite("Bonemine"), true);
	}

}
