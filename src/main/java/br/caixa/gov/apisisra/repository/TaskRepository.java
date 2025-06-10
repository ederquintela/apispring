package br.caixa.gov.apisisra.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.caixa.gov.apisisra.model.Task;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}

