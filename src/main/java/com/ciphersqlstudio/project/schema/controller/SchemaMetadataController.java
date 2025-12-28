package com.ciphersqlstudio.project.schema.controller;

import com.ciphersqlstudio.project.schema.dto.SchemaMetadataResponse;
import com.ciphersqlstudio.project.schema.service.SchemaMetadataService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class SchemaMetadataController {

    private final SchemaMetadataService service;

    public SchemaMetadataController(SchemaMetadataService service) {
        this.service = service;
    }

    @GetMapping("/{id}/schema")
    public SchemaMetadataResponse getSchema(@PathVariable Long id) {
        return service.getSchemaMetadata(id);
    }
}
