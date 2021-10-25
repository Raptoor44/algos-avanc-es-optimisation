package optiChainesProd.optimisateur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import optiChainesProd.atelier.Atelier;

public class OptimisateurAtelierCorrec22 implements OptimisateurAtelier {

	public ResultatOptimisation optimiserAtelier(Atelier atelier) { // version antoine

		Long tempsOptiC0 = atelier.getChaine(0).getTempsEntree()
				+ atelier.getChaine(0).getPoste(0).getTempsTraitement();
		Long tempsOptiC1 = atelier.getChaine(1).getTempsEntree()
				+ atelier.getChaine(1).getPoste(0).getTempsTraitement();

		List<Integer> liste = new ArrayList<Integer>();

		for (int j = 1; j < atelier.getLongueurChaines() - 1; j++) {

			long nouvTempsOptiC0 = Math.min(tempsOptiC0, tempsOptiC1 + atelier.getTempsChangement(1, 0, j - 1)
					+ atelier.getChaine(0).getPoste(j).getTempsTraitement());

			tempsOptiC1 = Math.min(tempsOptiC1, tempsOptiC0 + atelier.getTempsChangement(0, 1, j - 1)
					+ atelier.getChaine(1).getPoste(j).getTempsTraitement());

			tempsOptiC0 = nouvTempsOptiC0;

			if (tempsOptiC0 < tempsOptiC1) {
				liste.add(0);
			} else {
				liste.add(1);
			}

		}

		long tempsOpti = Math.min(tempsOptiC0 + atelier.getChaine(0).getTempsSortie(),
				tempsOptiC1 + atelier.getChaine(1).getTempsSortie());

		// TODO: Retourner liste (0 ou 1 pour atelier0 ou atelier1)

		return new ResultatOptimisation(liste, tempsOpti);
	}

	public ResultatOptimisation optimiserAtelier_correction(Atelier atelier) { // Correction du prof

		Long tempsOptiC0 = atelier.getChaine(0).getTempsEntree()
				+ atelier.getChaine(0).getPoste(0).getTempsTraitement();
		Long tempsOptiC1 = atelier.getChaine(1).getTempsEntree()
				+ atelier.getChaine(1).getPoste(0).getTempsTraitement();
		// Retenir les indices de chaines précédentes dans un tableau de deux dimensions
		// de aille 2(chaine-1)
		// à la chiane 0, au poste d'indice 4, si je suis dans le meilleur chemin,
		// j'étais à la
		// cahine d'indice 1 au poste précédent ; tab[0, 4] =1
		final int[][] idxChainesPrec = new int[2][atelier.getLongueurChaines() - 1];

		for (int j = 1; j < atelier.getLongueurChaines() - 1; j++) {

			long nouvTempsOptiC0;

			if (tempsOptiC0 < tempsOptiC1 + atelier.getTempsChangement(1, 0, j - 1)) {
				nouvTempsOptiC0 = tempsOptiC0 + atelier.getChaine(0).getPoste(j).getTempsTraitement();
				idxChainesPrec[0][j - 1] = 0;
			} else {
				nouvTempsOptiC0 = tempsOptiC1 + atelier.getTempsChangement(1, 0, j - 1)
						+ atelier.getChaine(0).getPoste(j).getTempsTraitement();
				idxChainesPrec[0][j - 1] = 1;

			}

			if (tempsOptiC1 < tempsOptiC0 + atelier.getTempsChangement(0, 1, j - 1)) {
				tempsOptiC1 = tempsOptiC1 + atelier.getChaine(1).getPoste(j).getTempsTraitement();
				idxChainesPrec[1][j - 1] = 1;
			} else {
				tempsOptiC1 = tempsOptiC1 + atelier.getChaine(1).getPoste(j).getTempsTraitement();
				idxChainesPrec[1][j - 1] = 0;
			}

			tempsOptiC0 = nouvTempsOptiC0;

		}

		long tempOpti;
		int idxMeilleureChaine;
		if (tempsOptiC0 + atelier.getChaine(0).getTempsSortie() < tempsOptiC1 + atelier.getChaine(1).getTempsSortie()) {
			tempOpti = tempsOptiC0 + atelier.getChaine(1).getTempsSortie();
			idxMeilleureChaine = 0;
		} else {
			tempOpti = tempsOptiC1 + atelier.getChaine(0).getTempsSortie();
			idxMeilleureChaine = 1;
		}


		LinkedList<Integer> idxMeilleurParcours = new LinkedList<>();
		idxMeilleurParcours.addFirst(idxMeilleureChaine);
		for (int j = atelier.getLongueurChaines() - 2; j >= 0; j--) {
			idxMeilleureChaine = idxChainesPrec[idxMeilleureChaine][j];
			idxMeilleurParcours.addFirst(idxMeilleureChaine);
		}

		long tempsOpti = Math.min(tempsOptiC0 + atelier.getChaine(0).getTempsSortie(),
				tempsOptiC1 + atelier.getChaine(1).getTempsSortie());

		// TODO: Retourner liste (0 ou 1 pour atelier0 ou atelier1)

		return new ResultatOptimisation(idxMeilleurParcours, tempsOpti);
	}
}
