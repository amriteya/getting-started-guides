/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRepositoryTest {
	
	@Autowired
	MovieRepository repository;
	
	Movie rush, shawshank;

	@Before
	public void setUp(){
		
		repository.deleteAll();
		
		rush = repository.save(new Movie("tt1979320", "Rush", 2013, Arrays.asList("Action", "Biography", "Drama")));
		shawshank = repository.save(new Movie("tt0111161", "The Shawshank Redemption", 1994, Arrays.asList("Crime", "Drama")));
		
	}
	
	@Test
	public void findsByName(){
		List<Movie> result = repository.findByName("Rush");
		assertThat(result).hasSize(1).extracting("name").contains("Rush");
	}
	
	@Test
	public void findsByYear(){
		List<Movie> result = repository.findByYear(2013);
		assertThat(result).hasSize(1).extracting("year").contains(new Integer("2013"));
	}
	
	@Test
	public void findsByGenre(){
		List<Movie> result = repository.findByGenre("Drama");
		assertThat(result).hasSize(2).extracting("genre").contains(Arrays.asList("Crime", "Drama"));
	}
	
}
