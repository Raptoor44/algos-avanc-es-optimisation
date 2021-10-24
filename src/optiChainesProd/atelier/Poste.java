/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optiChainesProd.atelier;

/**
 *
 * @author rvenant
 */
public interface Poste {

    /**
     * Fournit le temps de traitement du poste.
     *
     * @return le temps de traitement (unité définie par l'utilisateur)
     */
    long getTempsTraitement();
}
