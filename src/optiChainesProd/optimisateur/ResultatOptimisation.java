/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optiChainesProd.optimisateur;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author rvenant
 */
public class ResultatOptimisation {

    //Tableau d'indices de chaîne indiquant pour chaque poste la chaîne à utiliser
    private final List<Integer> chaineParPoste;
    //Le temps total de parcous
    private final Long tempsTotal;

    public ResultatOptimisation(List<Integer> chaineParPoste, Long tempsTotal) {
        this.chaineParPoste = Collections.unmodifiableList(chaineParPoste);;
        this.tempsTotal = tempsTotal;
    }

    public List<Integer> getChaineParPoste() {
        return this.chaineParPoste;
    }

    public Long getTempsTotal() {
        return tempsTotal;
    }

}
