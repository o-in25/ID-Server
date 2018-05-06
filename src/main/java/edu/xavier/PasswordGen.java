package edu.xavier;

import edu.xavier.service.WordReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by o_in25 on 5/6/18.
 */
public class PasswordGen {
    public String password;
    private Random random;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int getRandomWordBetween(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public PasswordGen() {
        try {
            random = new Random();
            WordReader wordReader = new WordReader("/Users/o_in25/project3/ID-Server/src/main/java/edu/xavier/utility/words.txt", true);
            String p1 = wordReader.getRandomWordOfLength(3);
            String p2 = wordReader.getRandomWordOfLength(4);
            String p3 = wordReader.getRandomWordOfLength(5);
            HashMap<Integer, String> specialChars = new HashMap<>();
            specialChars.put(0, "1");
            specialChars.put(1, "@");
            specialChars.put(2, "!");
            specialChars.put(3, "#");
            specialChars.put(4, "&");
            specialChars.put(5, "%");
            specialChars.put(6, "(");
            specialChars.put(7, ")");
            specialChars.put(8, "*");
            specialChars.put(9, "$");
            String randChar1 = specialChars.get(getRandomWordBetween(0, specialChars.size()));
            String randChar2 = specialChars.get(getRandomWordBetween(0, specialChars.size()));
            password = p1 + randChar1 + p2.toUpperCase() + randChar2 + p3;

        } catch (IOException err) {
            System.out.println(err);
        }

    }
}
