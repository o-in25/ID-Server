package edu.xavier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    public Word word;


    @RequestMapping("/id")
    public Word greeting(@RequestParam(value="id", defaultValue="word") String word) {
        return new Word();
    }
}
