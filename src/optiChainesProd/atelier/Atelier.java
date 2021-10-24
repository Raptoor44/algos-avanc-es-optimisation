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
public interface Atelier {

    /**
     * Fournit le nombre de postes d'une chaine de l'atelier, toutes les chaînes
     * ayant le même nombre de poste.
     *
     * @return la longueur d'une chaine
     */
    int getLongueurChaines();

    /**
     * Fournit le nombre de chaînes de l'atelier.
     *
     * @return le nombre de chaînes
     */
    int getNbChaines();

    /**
     * Retourne la chaîne d'indice i (0 ≤ i < getNbChaines()). @param i l
     *
     * 'indice de la chaîne @return la chaîne d'indice i
     */
    Chaine getChaine(int i);

    /**
     * Donne le temps de changement du poste d'indice indicePosteDepart de la
     * chaîne d'indice indiceChaineA vers le poste d'indice indicePosteDepart +
     * 1 de la chaîne d'indice indiceChaineB.
     *
     * @param indiceChaineA l'indice de la chaîne de départ
     * @param indiceChaineB l'indice de la chaîne de d'arrivée
     * @param indicePosteDepart l'indice du poste de départ
     * @return le temps de changement (unité définie par l'utilisateur)
     */
    long getTempsChangement(int indiceChaineA, int indiceChaineB, int indicePosteDepart);
}
