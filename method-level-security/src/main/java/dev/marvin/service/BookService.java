package dev.marvin.service;

import dev.marvin.domain.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final Map<String, Employee> records = Map.of("marvin", new Employee("Marvin Kamau", List.of("Java programming"), List.of("developer", "reader")),
            "rita", new Employee("Rita Muchangi", List.of("The Boys"), List.of("researcher")));

    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name){
        return records.get(name);
    }
}
