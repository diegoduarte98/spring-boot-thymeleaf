package com.example.springbootthymeleaf;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	private Long id;
	private String autor;
	private String titulo;
	private String texto;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
}
