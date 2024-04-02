package org.example;

import java.io.File;
import java.util.*;

public class ShellApplication {
    public static void main(String[] args) {
        DocumentRepository repo = new DocumentRepository("C:\\Users\\theon\\Desktop\\FACULTATE\\Semestrul 2\\java\\Java\\Lab5_Homework");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("The commands are view/export/report.Enter command followed by args: ");
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            try {
                Command command = createCommand(tokens, repo);
                if (command == null) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    command.executeCommand();
                }
            } catch (CommandExecutionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static Command createCommand(String[] tokens, DocumentRepository repo) throws CommandExecutionException {
        if (tokens.length < 1) {
            throw new CommandExecutionException("No command entered!");
        }
        String commandName = tokens[0];
        switch (commandName) {
            case "view":
                if (tokens.length < 2) {
                    throw new CommandExecutionException("You didnt enter a document name!");
                }
                return new ViewCommand(tokens[1]);
            case "report":
                return new ReportCommand(repo);
            case "export":
                return new ExportCommand(repo);
            case "exit":
                return null;
            default:
                throw new CommandExecutionException("Invalid command. Please use view/report/export/exit!");
        }
    }
}
