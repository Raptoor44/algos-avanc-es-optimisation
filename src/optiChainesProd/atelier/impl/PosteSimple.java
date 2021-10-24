/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optiChainesProd.atelier.impl;

import optiChainesProd.atelier.Poste;

/**
 *
 * @author rvenant
 */
public class PosteSimple implements Poste {

    private long tempsTraitement;

    public PosteSimple(long tempsTraitement) {
        if (tempsTraitement < 0) {
            throw new IllegalArgumentException("Le temps de traitement d'un poste doit être positif ou nul");
        }
        this.tempsTraitement = tempsTraitement;
    }

    @Override
    public long getTempsTraitement() {
        return this.tempsTraitement;
    }

    public void setTempsTraitement(long tempsTraitement) {
        this.tempsTraitement = tempsTraitement;
    }

}
