package br.caixa.gov.apisisra.controller;


import br.caixa.gov.apisisra.components.HelloWorld;
import br.caixa.gov.apisisra.doc.DocTaskController;
import br.caixa.gov.apisisra.doc.DocTaskControllerCreate;
import br.caixa.gov.apisisra.doc.DocTaskControllerDelete;
import br.caixa.gov.apisisra.dto.TaskDTO;
import br.caixa.gov.apisisra.model.Task;
import br.caixa.gov.apisisra.service.TaskService;
import br.caixa.gov.apisisra.validator.TaskValidator;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@DocTaskController
public class TaskController {

	private final TaskService service;
    private final TaskValidator validator;
    private final HelloWorld teste;

	public TaskController(TaskService service, TaskValidator validator, HelloWorld teste) {
		this.service = service;
		this.validator = validator;
        this.teste = teste;
	}

	@GetMapping
	public List<Task> getAll() {
		return service.findAll();
	}

	@GetMapping("/pageable")
    public ResponseEntity<Page<Task>> getAll(Pageable pageable) {

        Page<Task> tasks = service.findAll(pageable);
        return ResponseEntity.ok(tasks);

    }

    @PostMapping
    @DocTaskControllerCreate
    public ResponseEntity<?> create(@Valid @RequestBody TaskDTO taskDTO, BindingResult bindingResult) {
		
        // Validação personalizada
        validator.validate(taskDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        Task savedTask = service.save(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDTO, BindingResult bindingResult) {

        Optional<Task> existingTaskOptional = service.findById(id);
        
        if (existingTaskOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Validação personalizada
        validator.validate(taskDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        // Mantém o ID original
        taskDTO.setId(id);

        Task savedTask = service.save(taskDTO);
        return ResponseEntity.ok(savedTask);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {

        Optional<Task> task = service.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

	@DeleteMapping("/{id}")
    @DocTaskControllerDelete
	public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (service.findById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

	@PostMapping("/search")
	public Page<Task> search(@RequestBody TaskDTO taskDTO, Pageable pageable) {

		return service.findAll(taskDTO, pageable);

	}

}
