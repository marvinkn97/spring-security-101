package dev.marvin.service;

import dev.marvin.domain.Document;
import dev.marvin.repository.DocumentRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    public Document getDocument(String code){
        return documentRepository.findDocument(code);
    }
}
