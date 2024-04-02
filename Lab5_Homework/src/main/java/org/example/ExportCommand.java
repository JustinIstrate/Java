package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class ExportCommand implements Command{
    private DocumentRepository repo;

    public ExportCommand(DocumentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void executeCommand() throws CommandExecutionException {
        List<String> documents = repo.listDocuments(); // Retrieve document names from repository
        if (documents.isEmpty()) {
            System.out.println("No documents found in the repository.");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(documents);
            Files.write(Paths.get("repository.json"), json.getBytes());
        } catch (IOException e) {
            throw new CommandExecutionException("Error exporting repo: " + e.getMessage());
        }
    }
}
