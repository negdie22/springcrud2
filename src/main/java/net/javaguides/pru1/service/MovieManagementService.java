package net.javaguides.pru1.service;

import java.util.List;

import net.javaguides.pru1.dto.MovieDto;
import net.javaguides.pru1.dto.RankingDto;

public interface MovieManagementService {
	
	MovieDto createMovie(MovieDto movieDto);
	MovieDto getMovieById(Long movieId);
	List<MovieDto> getMovies();
	
	MovieDto updateMovie(Long id, RankingDto rankingDto);
	
}
