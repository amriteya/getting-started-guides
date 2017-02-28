package hello;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "moviedb", type = "movie")
public class Movie {

	@Id
	private String id;

	private String name;

	private Integer year;

	private List<String> genre;

	public Movie() {
	}

	public Movie(String id, String name, Integer year, List<String> genre) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year=" + year + ", genre=" + genre + "]";
	}

}
