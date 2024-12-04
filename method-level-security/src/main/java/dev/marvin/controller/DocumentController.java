package dev.marvin.controller;

import dev.marvin.domain.Document;
import dev.marvin.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("documents/{code}")
    public Document getDetails(@PathVariable String code){
        return documentService.getDocument(code);
    }
}
