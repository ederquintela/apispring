package br.caixa.gov.apisisra.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.caixa.gov.apisisra.model.Task;
import br.caixa.gov.apisisra.repository.TaskRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private final TaskRepository repository;

	public DataLoader(TaskRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Task(null, "Estudar Spring Boot", false));
		repository.save(new Task(null, "Criar API REST", true));
		repository.save(new Task(null, "Testar aplicação", false));
		System.out.println("✅ Dados iniciais carregados com sucesso!");
	}
}
