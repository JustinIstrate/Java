package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    private String docName;

    public ViewCommand(String docName) {
        this.docName = docName;
    }

    @Override
    public void executeCommand() throws CommandExecutionException {
        File file = new File(docName);

        if (!file.exists()) {
            throw new CommandExecutionException("The document or directory doesn't exist!");
        }

        if (file.isDirectory()) {
            System.out.println("Opening directory: " + docName);
        } else {
            openFile(file);
        }
    }

    private void openFile(File file) throws CommandExecutionException {
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new CommandExecutionException("Error opening document: " + e.getMessage());
        }
    }
}
