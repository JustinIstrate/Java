package org.example;

import java.io.File;
import java.util.*;

public class DocumentRepository {
    private String masterDirectory;

    public DocumentRepository(String directory) {
        this.masterDirectory = directory;
    }

    public List<String> listDocuments() {
        List<String> documents = new ArrayList<>();
        File directory = new File(masterDirectory);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        documents.add(file.getName());
                    }
                }
            }
        }
        return documents;
    }
}


