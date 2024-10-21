package io.krishna.tinder_ai_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.krishna.tinder_ai_backend.profiles.Gender;
import io.krishna.tinder_ai_backend.profiles.Profile;
import io.krishna.tinder_ai_backend.profiles.ProfileRepository;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner{

	@Autowired
	private ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("app is running");
		Profile profile = new Profile(
			"1",
			"Gopikrishna",
			"Srinivasan",
			30,
			"Indian",
			Gender.MALE,
			"Full Stack Developer",
			"foo.jpg",
			"INTP"
		);
		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);
	}


}
