package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(! controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'�tes pas inscrit sur le march� aujourd'hui !");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0] == "true") {
				System.out.println("Vous avez vendu " + donneesEtal[4] +
					" sur "	+ donneesEtal[3] + " " + donneesEtal[2] + ". \n");
				System.out.println("Au revoir " + nomVendeur + 
						", passez une bonne journ�e. \n");
			}
		}
	}
}
