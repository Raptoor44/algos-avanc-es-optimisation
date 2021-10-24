package optiChainesProd.optimisateur;

import java.util.ArrayList;

import optiChainesProd.atelier.Atelier;

public class OptimisateurAtelierCorrec22 implements OptimisateurAtelier {

	@Override
	public ResultatOptimisation optimiserAtelier(Atelier atelier) {


		long tempsOptiC0 = atelier.getChaine(0).getTempsEntree()
				+ atelier.getChaine(0).getPoste(0).getTempsTraitement();
		
		
		long tempsOptiC1 = atelier.getChaine(1).getTempsEntree()
				+ atelier.getChaine(1).getPoste(0).getTempsTraitement();
		

		
		for(int j = 1 ; j < atelier.getLongueurChaines() - 1 ; j++) {
			
			long nouvTempsOptiC0 = 0;
			
		tempsOptiC0 =	Math.min(tempsOptiC0, 
					tempsOptiC1 + atelier.getTempsChangement(1, 0, j-1)
					+ atelier.getChaine(0).getPoste(j).getTempsTraitement());
		
		
		tempsOptiC1 = Math.min(tempsOptiC1, tempsOptiC0 + atelier.getTempsChangement(0, 1, j -1)) + 
				atelier.getChaine(1).getPoste(j).getTempsTraitement();
		tempsOptiC0 = nouvTempsOptiC0;
		}
	
		//tempsOptiC0 : le temps MINI pour arriver à l'issue du dernier poste de la chaine 0
		//tempsOptiC0 : le temps MINI pour arriver à l'issue du dernier poste de la chaine 1
		long tempsOpti = Math.min(tempsOptiC0 + atelier.getChaine(0).getTempsSortie(),
				tempsOptiC1 + atelier.getChaine(1).getTempsSortie());
		
		//tempsOpti : le temps le plus court pour traverser tout l'atelier.
		return new ResultatOptimisation(new ArrayList<Integer>(), tempsOpti);
	}

}
