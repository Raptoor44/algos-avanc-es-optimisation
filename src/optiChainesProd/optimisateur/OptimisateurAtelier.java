/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optiChainesProd.optimisateur;

import optiChainesProd.atelier.Atelier;

/**
 *
 * @author rvenant
 */
public interface OptimisateurAtelier {

    /**
     * Calcul et retourne le temps minimal et l'enchainement des chaines pour un
     * parcours optimal de l'atelier.
     *
     * @param atelier l'atelier
     * @return le résultat de l'optimisation
     */
    ResultatOptimisation optimiserAtelier(Atelier atelier);
}
