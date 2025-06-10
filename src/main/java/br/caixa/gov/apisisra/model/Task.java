package br.caixa.gov.apisisra.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "A descrição não pode ser nula")
	private String description;

	@NotNull(message = "O status completed não pode ser nulo")
	private Boolean completed;
	
}
