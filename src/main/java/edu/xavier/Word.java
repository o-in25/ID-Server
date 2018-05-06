package edu.xavier;

import edu.xavier.service.WordReader;

import java.io.IOException;

public class Word {

    public String threeLetterWord;
    public String fourLetterWord;

    public String getThreeLetterWord() {
        return threeLetterWord;
    }

    public void setThreeLetterWord(String threeLetterWord) {
        this.threeLetterWord = threeLetterWord;
    }

    public String getFourLetterWord() {
        return fourLetterWord;
    }

    public void setFourLetterWord(String fourLetterWord) {
        this.fourLetterWord = fourLetterWord;
    }

    public Word() {
        try {
            WordReader wordReader = new WordReader("/Users/o_in25/project3/ID-Server/src/main/java/edu/xavier/utility/words.txt", true);
            threeLetterWord = wordReader.getRandomWordOfLength(3);
            fourLetterWord = wordReader.getRandomWordOfLength(4);
            System.out.print(threeLetterWord);
            System.out.print(fourLetterWord);
        } catch (IOException err) {
            System.out.println(err);
        }
    }

}
