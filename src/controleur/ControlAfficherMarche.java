package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	public String[] donnerInfoMarche() {
		String[] infosMarche = village.donnerEtatMarche();
		return infosMarche;
	}
}
