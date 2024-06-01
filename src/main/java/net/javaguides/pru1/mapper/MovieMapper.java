package net.javaguides.pru1.mapper;

import net.javaguides.pru1.dto.MovieDto;
import net.javaguides.pru1.entity.Movie;

public class MovieMapper {
	
	public static MovieDto maptoMovieDto (Movie movie) {
		return new MovieDto(
				movie.getId(),
				movie.getTitle(),
				movie.getCategory(),
				movie.getReleaseYear(),
				movie.getRateAverage(),
				movie.getVoteCount()
		);
	}
	public static Movie maptoMovie (MovieDto movieDto) {
		return new Movie(
				movieDto.getId(),
				movieDto.getTitle(),
				movieDto.getCategory(),
				movieDto.getReleaseYear(),
				movieDto.getRateAverage(),
				movieDto.getVoteCount()
		);
	}

}
