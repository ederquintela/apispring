package br.caixa.gov.apisisra.dto;

import lombok.*;

@Data
@Getter
@Setter
public class TaskDTO {
    private Long id;
    private String description;
    private Boolean completed;
}
