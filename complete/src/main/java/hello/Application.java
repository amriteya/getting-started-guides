package hello;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// save a couple of movies
		repository.save(new Movie("tt1979320", "Rush", 2013, Arrays.asList("Action", "Biography", "Drama")));
		repository.save(new Movie("tt0111161", "The Shawshank Redemption", 1994, Arrays.asList("Crime", "Drama")));

		List<Movie> response = repository.findByName("Rush");
		System.out.println(response);

		response = repository.findByGenre("Drama");
		System.out.println(response);

		response = repository.findByGenreIn(Arrays.asList("Drama"));
		System.out.println(response);

		response = repository.findByYear(2013);
		System.out.println(response);

		response = repository.findByYearBefore(2000);
		System.out.println(response);
	}
}
