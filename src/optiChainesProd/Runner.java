/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optiChainesProd;

import optiChainesProd.atelier.Atelier;
import optiChainesProd.optimisateur.OptimisateurAtelier;
import optiChainesProd.optimisateur.OptimisateurAtelierCorrec22;
import optiChainesProd.optimisateur.ResultatOptimisation;
import optiChainesProd.utils.GenerateurAtelier;

/**
 *
 * @author rvenant
 */
public class Runner {

    public static void main(String[] args) {
        final int nbPostes = 10000; //Nombre de postes de chaque chaîne

        //Génère aléatoirement l'atelier
        final Atelier a = 
                GenerateurAtelier.genererAtelierAleatoire(nbPostes, 1, 20);
        //Créer l'optimiseur
        final OptimisateurAtelier oa = new OptimisateurAtelierCorrec22(); //TODO : instancier l'optimisateur

        System.out.println("Début Optimisation");
        final long startTime = System.nanoTime();
        ResultatOptimisation ro = oa.optimiserAtelier(a);
        long lengthTime = System.nanoTime();
        lengthTime = Math.floorDiv(lengthTime - startTime, 1000000);

        System.out.println("Durée de l'opti (en ms) : " + lengthTime);
        System.out.println("Temps min de traitement de l'atelier : " + ro.getTempsTotal());
        System.out.println("Enchaine des postes entre chaine : " + ro.getChaineParPoste().toString());

    }
}
