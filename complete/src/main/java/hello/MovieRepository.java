package hello;

import java.util.Collection;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, String>{

	List<Movie> findByName(String name);
	List<Movie> findByYear(Integer year);
	List<Movie> findByGenreIn(Collection<String> genres);
	List<Movie> findByGenre(String genre);
	List<Movie> findByYearBefore(Integer year);
	
}