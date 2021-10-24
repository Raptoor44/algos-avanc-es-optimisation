/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optiChainesProd.atelier;

import java.util.Iterator;

/**
 *
 * @author rvenant
 */
public interface Chaine {

    /**
     * Fournit le nombre de poste de la chaîne.
     *
     * @return la longueur de la chaîne
     */
    int getLongueur();

    /**
     * Fournit le temps d'entrée sur la chaîne.
     *
     * @return le temps de d'entrée (unité définie par l'utilisateur)
     */
    long getTempsEntree();

    /**
     * Fournit le temps de sortie de la chaîne.
     *
     * @return le temps de sortie (unité définie par l'utilisateur)
     */
    long getTempsSortie();

    /**
     * Fournit le poste d'indice i de la chaîne (0 ≤ i < getLongueur()). @param
     * i
     *
     * l'indice du poste @return le poste d'indice i
     */
    Poste getPoste(int i);

    /**
     * Fournit un itérateur sur les postes de la chaine.
     *
     * @return l'iterateur de postes
     */
    Iterator<Poste> postesIterator();
}
