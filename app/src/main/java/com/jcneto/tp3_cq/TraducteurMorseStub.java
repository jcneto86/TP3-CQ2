package com.jcneto.tp3_cq;


public class TraducteurMorseStub implements TraducteurMorse {

    @Override
    public String toAlpha(String morse) {
        // Scénario 1
        if (morse.equals(" "))
            return " ";
        else if (morse.equals("."))
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
        return "";
    }

    @Override
    public String toMorse(String alpha) {
        alpha = nettoyerAlpha(alpha);
        if (alpha.equals("J"))
            return ".--- ";
        else if (alpha.equals("JO"))
            return ".--- ---";
        else if (alpha.equals("JOA"))
            return ".--- --- .-";
        else if (alpha.equals("JOAO"))
            return ".--- --- .- ---";
        else if (alpha.equals("JOAO "))
            return ".--- --- .- --- /";
        else if (alpha.equals("JOAO C"))
            return ".--- --- .- --- / -.-.";
        else if (alpha.equals("JOAO CA"))
            return ".--- --- .- --- / -.-. .-";
        else if (alpha.equals("JOAO CAR"))
            return ".--- --- .- --- / -.-. .- .-.";
        else if (alpha.equals("JOAO CARL"))
            return ".--- --- .- --- / -.-. .- .-. .-..";
        else if (alpha.equals("JOAO CARLO"))
            return ".--- --- .- --- / -.-. .- .-. .-.. ---";
        else if (alpha.equals("JOAO CARLOS"))
            return ".--- --- .- --- / -.-. .- .-. .-.. --- ...";
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
