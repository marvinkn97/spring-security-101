package dev.marvin.repository;

import dev.marvin.domain.Document;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DocumentRepository {
    private final Map<String, Document> documents = Map.of(
            "abc123", new Document("marvin"),
            "qwe123", new Document("rita"),
            "def123", new Document("imma"));

    public Document findDocument(String code){
        return documents.get(code);
    }
}
