package com.zad11;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	FileLoader fl = new FileLoader();
        try {
            fl.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Całkowita dlugość napisu (zadanie 4.1) : "+Searcher.getLenghtOfString(fl.output));
        System.out.println("Najdłuższy ciąg komend (zadanie 4.2) : "+Searcher.getInstructions(fl.output));
        System.out.print("Najcześciej dopisywana litera w ciągu (zadanie 4.3) : ");
        Searcher.getMostQuantityLetter(fl.output);
        System.out.println("Napis utworzony z komend (zadanie 4.4) : "+Searcher.putStreamFromCommands(fl.output));
        System.out.println();
    }

}
