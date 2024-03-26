package org.example;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("John Stones", "341");
        Person p2 = new Person("Cristi Nelu", "351");
        Document d1 = new Document("homework", "pdf");
        Document d2 = new Document("landscape", "png");

        String masterDirectory = "./folder";
        File personDir1 = new File(masterDirectory, p1.id());
        File personDir2 = new File(masterDirectory, p2.id());

        personDir1.mkdirs();
        personDir2.mkdirs();
        File newFile1 = new File(personDir1, d1.name() + "." + d1.fileType());
        File newFile2 = new File(personDir2, d2.name() + "." + d2.fileType());
        try {
            newFile1.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            newFile2.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DocumentRepository repo = new DocumentRepository(masterDirectory);
        repo.displayDirectory();
    }
}