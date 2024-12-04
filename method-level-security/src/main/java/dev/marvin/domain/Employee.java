package dev.marvin.domain;

import java.util.List;

public record Employee(String name, List<String> books, List<String> roles) {
}
