package net.javaguides.pru1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {
	private Long id;
	
	@NotNull(message = "titulo no puede estar vacio")
	@NotBlank(message = "titulo no puede estar vacio")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(max = 50)
	private String title;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "^(Action|Science|Fiction)$")
	private String category;
	
	@Min(value = 1888)
	@Max(value = 2024)
	private Integer releaseYear;
	
	private Float rateAverage;
	private Integer voteCount;
	

}
