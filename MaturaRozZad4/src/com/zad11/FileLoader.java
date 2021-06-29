package com.zad11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    String[] output;
    List<String> tmp = new ArrayList<>();

    public void read() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("../instrukcje.txt");
        readFromFile(inputStream);
    }

    private void readFromFile(InputStream inputStream) throws IOException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) !=null) {
                    line = line.trim();
                    if ((line.length()) !=0){
                        tmp.add(line);
                    }
                }
        }
        output = tmp.toArray(new String[0]);
    }
}
