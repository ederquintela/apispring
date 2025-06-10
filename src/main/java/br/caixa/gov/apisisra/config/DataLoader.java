package br.caixa.gov.apisisra.config;

import br.caixa.gov.apisisra.model.Task;
import br.caixa.gov.apisisra.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

	private final TaskRepository repository;

	public DataLoader(TaskRepository repository) {
		this.repository = repository;
	}

	List<String> bookTitles = List.of(
			"Clean Code", "Clean Architecture", "The Pragmatic Programmer", "Design Patterns",
			"Refactoring", "Effective Java", "Java Concurrency in Practice", "Domain-Driven Design",
			"Spring in Action", "Head First Design Patterns", "Test-Driven Development by Example",
			"Working Effectively with Legacy Code", "Microservices Patterns", "Building Microservices",
			"Continuous Delivery", "Infrastructure as Code", "Soft Skills", "The Clean Coder",
			"Code Complete", "You Don’t Know JS", "JavaScript: The Good Parts", "Eloquent JavaScript",
			"Programming Pearls", "Cracking the Coding Interview", "Algorithms (Sedgewick)",
			"Grokking Algorithms", "Introduction to Algorithms", "Structure and Interpretation of Computer Programs",
			"Functional Programming in Java", "Pro Git", "Agile Software Development", "Extreme Programming Explained",
			"Site Reliability Engineering", "The DevOps Handbook", "Docker Deep Dive", "Kubernetes Up & Running",
			"Spring Boot in Practice", "Reactive Spring", "Mastering Spring Boot", "Learning Python",
			"Fluent Python", "Python Cookbook", "Effective Python", "Think Python", "Python Crash Course",
			"Architecting Modern Java Applications", "Kotlin in Action", "Programming Kotlin", "Scala for the Impatient",
			"Modern C++ Design", "Effective C++", "The Rust Programming Language", "Rust for Rustaceans",
			"Learning Go", "Go in Practice", "The Go Programming Language", "Programming TypeScript",
			"TypeScript Quickly", "Node.js Design Patterns", "NestJS in Action", "React Up and Running",
			"Learning React", "Fullstack React", "Vue.js Up and Running", "Angular in Action",
			"Mastering Angular", "Java Performance", "Java Puzzlers", "Understanding the JVM",
			"Linux Command Line", "The Art of Unix Programming", "Operating Systems: Three Easy Pieces",
			"Computer Networking: A Top-Down Approach", "Compilers: Principles, Techniques, and Tools",
			"Artificial Intelligence: A Modern Approach", "Deep Learning with Python", "Hands-On Machine Learning",
			"Machine Learning Yearning", "Natural Language Processing with Python", "Data Science from Scratch",
			"Big Data Fundamentals", "Streaming Systems", "SQL Performance Explained", "Database Internals",
			"NoSQL Distilled", "Designing Data-Intensive Applications", "Refactoring Databases",
			"Cloud Native Java", "Cloud Native Patterns", "Building Event-Driven Microservices",
			"Architecture Patterns with Python", "Hexagonal Architecture for Java", "DDD Distilled",
			"Software Architecture: The Hard Parts", "Fundamentals of Software Architecture",
			"Software Engineering at Google", "Team Topologies", "Accelerate", "Lean Software Development"
	);

	@Override
	public void run(String... args) throws Exception {
		//repository.save(new Task(null, "Estudar Spring Boot", false));
		//repository.save(new Task(null, "Criar API REST", true));
		//repository.save(new Task(null, "Testar aplicação", false));
		//System.out.println("✅ Dados iniciais carregados com sucesso!");

		for (int i = 0; i < 100; i++) {
			String title = i < bookTitles.size() ? bookTitles.get(i) : "Livro de Tecnologia #" + (i + 1);
			boolean done = i % 2 == 0; // alterna entre true e false
			repository.save(new Task(null, title, done));
		}

		System.out.println("✅ 100 livros de TI inseridos com sucesso!");
	}
}
