package com.jcneto.tp3_cq;



public class TraducteurMorseStub implements TraducteurMorse {

    @Override
    public String toAlpha(String morse) {
        // Scénario 1
        if (morse.equals("."))
            return "E";
        else if (morse.equals(".."))
            return "I";
        else if (morse.equals("..."))
            return "S";
        else if (morse.equals("...."))
            return "H";
        else if (morse.equals("....."))
            return "5";
        else if (morse.equals("..... "))
            return "5";
        else if (morse.equals("..... ."))
            return "5E";
        // Scénario 2
        else if (morse.equals("....."))
            return "";
        return "";
    }

    @Override
    public String toMorse(String alpha) {
        if (alpha.equals("J"))
            return ".---";
        else if (alpha.equals("O"))
            return "---";
        else if (alpha.equals("A"))
            return ".-";
        else if (alpha.equals("C"))
            return "-.-. ";
        else if (alpha.equals("R"))
            return ".-. ";
        else if (alpha.equals("L"))
            return ".-.. ";
        else if (alpha.equals("S"))
            return "... ";
        else if (alpha.equals(" "))
            return "/ ";
        return "";
    }

    @Override
    public String nettoyerAlpha(String alpha) {
        String alphaToReturn = alpha;
        alphaToReturn = alphaToReturn.toUpperCase().replaceAll("Ã", "A");
        return alphaToReturn;
    }

    @Override
    public String getNomProgrammeurs() {
        return "C'est un Stub !!! 😱😱😱😱";
    }

}
