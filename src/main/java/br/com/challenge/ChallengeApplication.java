package br.com.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		new Initialize();
		SpringApplication.run(ChallengeApplication.class, args);
	}

}
