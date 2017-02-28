package hello;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService{

	@Autowired
	private MovieRepository repository;

	public List<Movie> findByName(String name) {
		return repository.findByName(name);
	}

	public List<Movie> findByYear(Integer year) {
		return repository.findByYear(year);
	}

	public List<Movie> findByGenre(String genre) {
		return repository.findByGenre(genre);
	}
	
	public List<Movie> findByGenreIn(Collection<String> genres) {
		return repository.findByGenreIn(genres);
	}
	
	public List<Movie> findByYearBefore(Integer year) {
		return repository.findByYearBefore(year);
	}

}

