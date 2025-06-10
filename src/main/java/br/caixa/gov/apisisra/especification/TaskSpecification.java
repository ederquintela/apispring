package br.caixa.gov.apisisra.especification;

import br.caixa.gov.apisisra.model.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {

    public static Specification<Task> hasId(Long id) {
        return (root, query, cb) -> id == null ? null : cb.equal(root.get("id"), id);
    }

    public static Specification<Task> hasDescription(String description) {
        return (root, query, cb) -> description == null ? null : cb.like(cb.lower(root.get("description")), "%" + description.toLowerCase() + "%");
    }

    public static Specification<Task> isCompleted(Boolean completed) {
        return (root, query, cb) -> completed == null ? null : cb.equal(root.get("completed"), completed);
    }

}
