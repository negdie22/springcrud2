package net.javaguides.pru1.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.pru1.dto.MovieDto;
import net.javaguides.pru1.dto.RankingDto;
import net.javaguides.pru1.entity.Movie;
import net.javaguides.pru1.exception.ResourceNotFoundException;
import net.javaguides.pru1.mapper.MovieMapper;
import net.javaguides.pru1.repository.MovieRepository;
import net.javaguides.pru1.service.MovieManagementService;


@Service
@AllArgsConstructor
public class MovieManagementServiceImpl implements MovieManagementService{
	
	private MovieRepository movieRepository;

	@Override
	public MovieDto createMovie(MovieDto movieDto) {
		
		Movie movie=MovieMapper.maptoMovie(movieDto);
		Movie savedMovie=movieRepository.save(movie);
		return MovieMapper.maptoMovieDto(savedMovie);
		
	}

	@Override
	public MovieDto getMovieById(Long movieId) {
		Movie movie= movieRepository.findById(movieId)
				.orElseThrow(()->
				new ResourceNotFoundException("Movie exists with the given id: "+movieId));	
		return MovieMapper.maptoMovieDto(movie);
	}

	@Override
	public List<MovieDto> getMovies() {
		List<Movie> movies= movieRepository.findAll();
		return movies.stream().map((movie)->MovieMapper.maptoMovieDto(movie))
				.collect(Collectors.toList());
	}

	@Override
	public MovieDto updateMovie(Long id, RankingDto rankingDto) {
		
		Movie updatedMoviee=movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie does not exits"));
		Integer votes=updatedMoviee.getVoteCount();
		if(votes==null) {votes=0;}
		Float rate=updatedMoviee.getRateAverage();
		if(rate==null) {rate=(float)1;}
		updatedMoviee.setVoteCount(votes+1);
		updatedMoviee.setRateAverage(((rate*votes)+rankingDto.getValue())/(votes+1));
		Movie movieObj=movieRepository.save(updatedMoviee);
		
		return MovieMapper.maptoMovieDto(movieObj);
	}

	

	

	

	

}
