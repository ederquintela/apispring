package br.caixa.gov.apisisra.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.caixa.gov.apisisra.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

