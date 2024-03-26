package org.example;

import java.io.File;

public class DocumentRepository {
    private String masterDirectory;

    public DocumentRepository(String directory) {
        this.masterDirectory = directory;
    }

    public void displayDirectory() {
        File directory = new File(masterDirectory);
        if (directory.exists() && directory.isDirectory()) {
            File[] personDirectories = directory.listFiles();
            if (personDirectories != null) {
                for (File persDirectory : personDirectories) {
                    if (persDirectory.isDirectory()) {
                        System.out.println("Person: " + persDirectory.getName());
                    }
                }
            }
        }
    }
}


