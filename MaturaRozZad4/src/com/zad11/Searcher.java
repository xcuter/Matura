package com.zad11;

import java.util.*;

public class Searcher {

    public static int getLenghtOfString(String[] input){
        int length = 0;
        for (String s : input) {
            if (s.contains(Comands.DOPISZ.toString())) {
                length++;
            }
            if (s.contains(Comands.USUN.toString())) {
                length--;
            }
        }
        return length;
    }

    public static String getInstructions(String[] input){
        String result = "";
        int lenghtOfDopisz=0;
        int leghtOfUsun=0;
        int lenghtOfPrzesun=0;
        int lenghtOfZmien=0;
            for(int i=0;i < input.length-1;i++){
                if(input[i].contains(Comands.DOPISZ.toString())
                        && input[i+1].contains(Comands.DOPISZ.toString())){
                    lenghtOfDopisz++;
                }
                if(input[i].contains(Comands.USUN.toString())
                        && input[i+1].contains(Comands.USUN.toString())){
                    leghtOfUsun++;
                }
                if (input[i].contains(Comands.PRZESUN.toString())
                        && input[i+1].contains(Comands.PRZESUN.toString())){
                    lenghtOfPrzesun++;
                }
                if (input[i].contains(Comands.ZMIEN.toString())
                && input[i+1].contains(Comands.ZMIEN.toString())){
                    lenghtOfZmien++;
                }
            }
            if(lenghtOfDopisz > lenghtOfPrzesun && lenghtOfDopisz > lenghtOfZmien
                && lenghtOfDopisz > leghtOfUsun){
               result = result.concat(Comands.DOPISZ.toString()).concat(" : ").
                        concat(Integer.toString(lenghtOfDopisz-1));
            }else if (lenghtOfPrzesun > lenghtOfDopisz && lenghtOfPrzesun > lenghtOfZmien
                    && lenghtOfPrzesun > leghtOfUsun){
                       result = result.concat(Comands.PRZESUN.toString()).concat(" : ").concat(Integer.toString(lenghtOfPrzesun-1));
            }else if(leghtOfUsun > lenghtOfDopisz && leghtOfUsun > lenghtOfPrzesun
                    && leghtOfUsun > lenghtOfZmien){
                       result = result.concat(Comands.USUN.toString()).concat(" : ").concat(Integer.toString(leghtOfUsun-1));
            }else if(lenghtOfZmien > lenghtOfDopisz && lenghtOfZmien > lenghtOfPrzesun
                    && lenghtOfZmien > leghtOfUsun ) {
                      result =  result.concat(Comands.ZMIEN.toString()).concat(" : ").concat(Integer.toString(lenghtOfZmien-1));
            }
        return result;
    }

    public static void getMostQuantityLetter(String[] input){
        Map<String , Integer> wordsWithQuantity = new LinkedHashMap<>();
        for(int i = 65; i <= 90; i++){
            char tmp = (char) i;
            wordsWithQuantity.put(Character.toString(tmp), 0);
        }

        for (String s : input) {
            String[] result;
            result = s.split(" ");

            if (wordsWithQuantity.containsKey(result[1]) && result[0].contains(Comands.DOPISZ.toString()))
                wordsWithQuantity.replace(result[1], (wordsWithQuantity.get(result[1])) + 1);
        }

        Optional<Map.Entry<String, Integer>> maxEntry = wordsWithQuantity.entrySet().stream().max(Map.Entry.comparingByValue());
        maxEntry.ifPresent(System.out::println);

    }

    public static String putStreamFromCommands(String[] input){
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> alphabet = new ArrayList<>();

        for (int i=65;i <= 90;i++){
            Character tmp = (char) i;
            alphabet.add(tmp.toString());
        }

        for(String s : input){
            String[] tmp;
            tmp = s.split(" ");
            if(tmp[0].equals(Comands.DOPISZ.toString())){
                result.add(tmp[1]);
            }else if(tmp[0].equals(Comands.USUN.toString())){
                if(result.size()!=0) result.remove(result.size()-1);
            }else if(tmp[0].equals(Comands.PRZESUN.toString())){
               if (result.contains(tmp[1])) {
                   if(tmp[1].equals("Z")){
                       result.set(result.indexOf(tmp[1]),"A");
                   }else {
                       int ind = alphabet.indexOf(tmp[1]);
                       result.set(result.indexOf(tmp[1]),alphabet.get(ind+1));
                   }
               }
            }else if (tmp[0].equals(Comands.ZMIEN.toString())) {
                result.set(result.size()-1,tmp[1]);
            }
        }
        return result.toString();
    }

}