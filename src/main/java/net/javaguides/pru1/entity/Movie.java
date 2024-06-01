package net.javaguides.pru1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "releaseYear")
	private Integer releaseYear;
	
	@Column(name = "rateAverage")
	private Float rateAverage;
	
	@Column(name = "voteCount")
	private Integer voteCount;
	
	
	
	

}
