package net.javaguides.pru1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.pru1.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	

}
