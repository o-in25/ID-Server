package edu.xavier;

import edu.xavier.service.WordReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project3Application {

	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class, args);
	try {
		WordReader wordReader = new WordReader("/Users/o_in25/Desktop/gs-rest-service-master/project_3/src/main/java/edu/xavier/utility/words.txt", true);
		for(int i = 0; i < 15; i++) {
			System.out.println(wordReader.getRandomWordOfLength(4));
		}
	} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
