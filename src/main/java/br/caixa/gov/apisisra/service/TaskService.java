package br.caixa.gov.apisisra.service;

import org.springframework.stereotype.Service;

import br.caixa.gov.apisisra.model.Task;
import br.caixa.gov.apisisra.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

	private final TaskRepository repository;

	public TaskService(TaskRepository repository) {
		this.repository = repository;
	}

	public List<Task> findAll() {
		return repository.findAll();
	}

	public Task save(Task task) {
		return repository.save(task);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
