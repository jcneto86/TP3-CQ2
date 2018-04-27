package com.jcneto.tp3_cq;
/*
 Classe creé pour teste le TraducteurMorseConcrete
*/

import org.junit.Test;
import static org.junit.Assert.*;

public class TraducteurMorseConcreteTest {

    /**
     * toAlphaTest()
     * Fonction pour tester la méthode toAlpha de la classe TraducteurMorseConcrete.
     *
     *
     */
    @Test
    public void toAlphaTest(){
        TraducteurMorse tmc = new TraducteurMorseConcrete();
        assertEquals("SOS",
                tmc.toAlpha("... --- ..."));
        assertEquals("JOAO CARLOS",
                tmc.toAlpha(".--- --- .- --- / -.-. .- .-. .-.. --- ..."));
        assertEquals("SEGES FERTILIOR EST ALIENIS SEMPER IN AGRIS",
                tmc.toAlpha("... . --. . ... / ..-. . .-. - .. .-.. .. --- .-. / . ... - / .- .-.. .. . -. .. ... / ... . -- .--. . .-. / .. -. / .- --. .-. .. ..."));
        assertEquals("ABC",
                tmc.toAlpha(".- -... -.-."));
        assertEquals("SIMUL FLARE SORBEREQUE HAUD FACTU FACILEST",
                tmc.toAlpha("... .. -- ..- .-.. / ..-. .-.. .- .-. . / ... --- .-. -... . .-. . --.- ..- . / .... .- ..- -.. / ..-. .- -.-. - ..- / ..-. .- -.-. .. .-.. . ... -"));
    }

    /**
     * toMorseTest()
     *  Fonction pour tester la méthode toMorse de la classe TraducteurMorseConcrete.
     *
     */
    @Test
    public void toMorseTest(){
        TraducteurMorse tmc = new TraducteurMorseConcrete();
        assertEquals("-- .- -- .-",
                tmc.toMorse("mama"));
        assertEquals(".- .-.. -... . .-. - / -.-. .- -- ..- ... / .---- ----. .---- ...-- / / .---- ----. -.... ----- / .- / --- -... - . -. ..- / .-.. . / .--. .-. .. -..- / -. --- -... . .-.. / -.. . / .-.. .. - - . .-. .- - ..- .-. . / . -. / .---- ----. ..... --... .-.-.-",
                tmc.toMorse("Albert Camus [1913 – 1960] a obtenu le prix Nobel de littérature en 1957."));
        assertEquals(".-.. . -.-. .-. .. - ..- .-. . / -.. . ... / ..- -. .. - . ... / -.. . / -- . ... ..- .-. .",
                tmc.toMorse("l‘écriture des unités de mesure"));
        assertEquals(".-.. . ... / . -. ..-. .- -. - ... / / -- .- -. --. . .- .. . -. - / --. .- .. . -- . -. -",
                tmc.toMorse("Les enfants, […] mangeaient gaiement"));
    }

    /**
     * nettoyerAlphaTest()
     *  Fonction pour tester la méthode nettoyerAlpha de la classe TraducteurMorseConcrete.
     *
     */
    @Test
    public void nettoyerAlphaTest(){
        TraducteurMorse tmc = new TraducteurMorseConcrete();
        assertEquals("JOAO CARLOS",
                tmc.nettoyerAlpha("João Carlos"));
        assertEquals("JOAOHOTMAIL.COM",
                tmc.nettoyerAlpha("joao@hotmail.com"));
        assertEquals("MEME CHOSE",
                tmc.nettoyerAlpha("même chose"));
        assertEquals("LECRITURE DES UNITES DE MESURE",
                tmc.nettoyerAlpha("l‘écriture des unités de mesure"));
        assertEquals("LES ENFANTS  MANGEAIENT GAIEMENT",
                tmc.nettoyerAlpha("Les enfants, […] mangeaient gaiement"));
        assertEquals("ALBERT CAMUS 1913  1960 A OBTENU LE PRIX NOBEL DE LITTERATURE EN 1957.",
                tmc.nettoyerAlpha("Albert Camus [1913 – 1960] a obtenu le prix Nobel de littérature en 1957."));

    }

    /**
     * getNomProgrammeursTest()
     *  Fonction pour tester la méthode getNomProgrammeurs de la classe TraducteurMorseConcrete.
     *
     */
    @Test
    public void getNomProgrammeursTest(){
        TraducteurMorse tmc = new TraducteurMorseConcrete();
        assertEquals("FERNANDES NETO João Carlos & IGIRANEZA A. Brice",
                tmc.getNomProgrammeurs());
    }
}
