package com.elena.casestudy.movieordersystem.dto;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;
	@NotEmpty
	private String poster;
	private int quantity;
	private Double price;
	public MovieDto(Long id, String name, String description, String poster) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.poster = poster;
	}
}
