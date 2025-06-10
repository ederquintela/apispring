package br.caixa.gov.apisisra.service;

import br.caixa.gov.apisisra.dto.TaskDTO;
import br.caixa.gov.apisisra.especification.TaskSpecification;
import br.caixa.gov.apisisra.model.Task;
import br.caixa.gov.apisisra.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

	private final TaskRepository repository;
	private final ModelMapper modelMapper;

	public TaskService(TaskRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

    public Page<Task> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

	public List<Task> findAll() {
		return repository.findAll();
	}

	public Task save(TaskDTO taskDTO) {
		return repository.save(this.convertToEntity(taskDTO));
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

	public Page<Task> findAll(TaskDTO taskDTO, Pageable pageable) {

		Specification<Task> spec = Specification
				.where(TaskSpecification.hasId(taskDTO.getId()))
				.and(TaskSpecification.hasDescription(taskDTO.getDescription()))
				.and(TaskSpecification.isCompleted(taskDTO.getCompleted()));

		return repository.findAll(spec, pageable);

	}

	public Task convertToEntity(TaskDTO dto) {
		return modelMapper.map(dto, Task.class);
	}

	public TaskDTO convertToDTO(Task task) {
		return modelMapper.map(task, TaskDTO.class);
	}
}
