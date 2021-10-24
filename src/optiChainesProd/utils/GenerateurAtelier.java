/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optiChainesProd.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import optiChainesProd.atelier.Atelier;
import optiChainesProd.atelier.Chaine;
import optiChainesProd.atelier.Poste;
import optiChainesProd.atelier.impl.AtelierSimple;
import optiChainesProd.atelier.impl.ChaineSimple;
import optiChainesProd.atelier.impl.PosteSimple;

/**
 *
 * @author rvenant
 */
public class GenerateurAtelier {

    /**
     * Créer un atelier de 2 chaines composées de nbPostes pour chacunes d'entre
     * elles, avec des temps de traitement, d'entrée, de sortie et de changement
     * calculés aléatoirement entre min et max.
     * @param nbPostes le nombre de postes
     * @param min la borne inférieure d'un temps
     * @param max la borne supérieure d'un temps
     * @return l'atelier
     */
    public static Atelier genererAtelierAleatoire(int nbPostes, long min, long max) {
        final Chaine c0 = genererChaineAleatoire(nbPostes, min, max);
        final Chaine c1 = genererChaineAleatoire(nbPostes, min, max);
        final ArrayList<Long> tempsChangement0a1 = new ArrayList<>(
                Arrays.asList(GenerateurTemps.generateRandomSequence(
                        nbPostes - 1, min, max)));
        final ArrayList<Long> tempsChangement1a0 = new ArrayList<>(
                Arrays.asList(GenerateurTemps.generateRandomSequence(
                        nbPostes - 1, min, max)));
        return new AtelierSimple(c0, c1, tempsChangement0a1, tempsChangement1a0);
    }

    /**
     * Créer une chaîne composée de nbPostes, avec des temps de traitement, 
     * d'entrée et de sortie calculés aléatoirement entre min et max.
     * @param nbPostes le nombre de postes
     * @param min la borne inférieure d'un temps
     * @param max la borne supérieure d'un temps
     * @return la chaîne
     */
    public static Chaine genererChaineAleatoire(int nbPostes, long min, long max) {
        final List<Poste> postesChaine = Arrays.stream(
                GenerateurTemps.generateRandomSequence(nbPostes, min, max))
                .map(t -> (Poste) new PosteSimple(t))
                .collect(Collectors.toList());
        return new ChaineSimple(postesChaine,
                GenerateurTemps.generateRandomValue(min, max),
                GenerateurTemps.generateRandomValue(min, max));
    }
}
