package net.javaguides.pru1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.pru1.dto.MovieDto;
import net.javaguides.pru1.dto.RankingDto;
import net.javaguides.pru1.service.MovieManagementService;
import net.javaguides.pru1.dto.Message;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	private MovieManagementService movieManagementService;
	
	
	//build add
	@PostMapping
	public ResponseEntity<Message> createMovie(@Valid @RequestBody MovieDto movieDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Message message=new Message("unable to create",bindingResult.getFieldError().getDefaultMessage());
			//MovieDto savedMovie =movieManagementService.createMovie(movieDto);
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}
		MovieDto savedMovie =movieManagementService.createMovie(movieDto);
		Message message=new Message(null,null);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
		//return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
	}
	
	//build get by id
	@GetMapping("{id}")
	public ResponseEntity<MovieDto> getMovieById(@PathVariable("id") Long movieId){
		MovieDto movieDto=movieManagementService.getMovieById(movieId);
		return ResponseEntity.ok(movieDto);
	}
	
	//all
	@GetMapping
	public ResponseEntity<List<MovieDto>> getAllMovies(){
		List<MovieDto> movies=movieManagementService.getMovies();
		return ResponseEntity.ok(movies);
	}
	
	//calificacion
	@PutMapping("{id}/ratings")
	public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") Long id, @RequestBody RankingDto rankingDto){
		MovieDto movieDto=movieManagementService.updateMovie(id, rankingDto);
		return new ResponseEntity<>(movieDto,HttpStatus.CREATED);
		
	}

}
