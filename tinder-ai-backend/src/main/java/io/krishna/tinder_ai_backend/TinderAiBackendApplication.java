package io.krishna.tinder_ai_backend;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.krishna.tinder_ai_backend.conversations.ChatMessage;
import io.krishna.tinder_ai_backend.conversations.Conversation;
import io.krishna.tinder_ai_backend.conversations.ConversationRepository;
import io.krishna.tinder_ai_backend.profiles.Gender;
import io.krishna.tinder_ai_backend.profiles.Profile;
import io.krishna.tinder_ai_backend.profiles.ProfileRepository;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner{

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConversationRepository conversationRepository;

	@Autowired
	private OpenAiChatModel chatModel;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("app is running");

		String response = chatModel.call("Who is Dhoni");
		System.out.println(response);
		
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

		Conversation conversation = new Conversation(
			"1",
			profile.id(),
			List.of(new ChatMessage("Hello",profile.id(),LocalDateTime.now()))
		);

		conversationRepository.save(conversation);
		conversationRepository.findAll().forEach(System.out::println);

	}


}
