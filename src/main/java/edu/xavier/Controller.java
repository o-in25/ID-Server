package edu.xavier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public Word word;


    @RequestMapping("/id")
    public Word id(@RequestParam(value="id", defaultValue="word") String word) {
        return new Word();
    }


    @RequestMapping("/four")
    public String fourWord(@RequestParam(value="id", defaultValue="word") String word) {
        return new Word().getFourLetterWord();
    }

    @RequestMapping("/three")
    public String threeWord(@RequestParam(value="id", defaultValue="word") String word) {
        return new Word().getThreeLetterWord();
    }

    @RequestMapping("/password")
    public PasswordGen password(@RequestParam(value="id", defaultValue="word") String word) {
        return new PasswordGen();
    }
}
