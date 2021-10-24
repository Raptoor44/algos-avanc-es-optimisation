/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optiChainesProd.utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author rvenant
 */
public final class GenerateurTemps {

    /**
     * Génère une valeur entière alétoire comprise entre min (inclue) et
     * max (inclue)
     *
     * @param min valeur minimale (inclue)
     * @param max valeur maximale (inclue)
     * @return valeur aleatoire
     */
    public static long generateRandomValue(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    /**
     * Génère une séquence de valeurs entière alétoires uniformément réparties
     * dont chaque valeur est comprise entre min (inclue) et max (exclue).
     *
     * @param nbValues nombre de valeurs
     * @param min valeur minimale (incluse)
     * @param max valeur maximale (exclue)
     * @return
     */
    public static Long[] generateRandomSequence(int nbValues, long min, long max) {
        if (nbValues <= 0) {
            throw new IllegalArgumentException("Number of values must be higher than 0");
        }
        if (min <= 0 || min > max) {
            throw new IllegalArgumentException("Minium value must be higher or equal to 0 and lower or equal to max");
        }
        final Long[] values = new Long[nbValues];
        Arrays.parallelSetAll(values, i -> generateRandomValue(min, max));
        return values;
    }
}
