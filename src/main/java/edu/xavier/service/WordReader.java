package edu.xavier.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordReader {
    private HashMap<String, String> stringMap;
    private HashMap<Integer, String> numericalMap;
    private HashMap<Integer, String> validWords;
    private Set<String> keys;
    private Iterator<String> iterator;
    private Random random;
    private ArrayList<String> restrictedWords;

    public WordReader(String path, boolean isResticted) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        int i = 0;
        String line;
        stringMap = new HashMap<>();
        numericalMap = new HashMap<>();
        validWords = new HashMap<>();
        while((line = bufferedReader.readLine()) != null) {
            String word = bufferedReader.readLine();
            // build the map
            stringMap.put(word, word);
            numericalMap.put(i, word);
            i++;
        }
        keys = stringMap.keySet();
        random = new Random();
        restrictedWords = new ArrayList<>();
        if(isResticted) {
            setValidWords(3, 4);
        }
    }


    private int getRandomWordBetween(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public boolean isWord(String word) {
        return stringMap.containsValue(word);
    }


    public void restrictWord(String word) {
        restrictedWords.add(word);
    }

    // sets for 3 and 4 letter words
    private void setValidWords(int num1, int num2) {
        iterator = keys.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            String next = iterator.next();
            if(next.length() == num1 || next.length() == num2) {
                validWords.put(i, next);
                i++;
            }
        }
    }

    public String getRandomWordOfLength(int length) {
        int stop = validWords.size();
        int start = 0;
        boolean found = false;
        String word = null;
        while(!found) {
            if(start == stop) {
                // time to stop
                word = "No word of length " + length + " found";
                found = true;
            } else {
                int random = getRandomWordBetween(0, validWords.size());
                String next = validWords.get(random);
                if(next.length() == length && !restrictedWords.contains(next)) {
                    // found
                    word = next;
                    found = true;
                } else {
                    start++;
                }
            }
        }
        return word;

    }
}
