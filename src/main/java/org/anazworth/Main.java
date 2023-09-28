package org.anazworth;

import org.hibernate.cfg.Configuration;

import java.util.Scanner;

import static org.anazworth.ToDoService.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        sessionFactory.getSchemaManager().exportMappedObjects(true);


        var service = new ToDoService();

        ToDoService.initialGreeting();


        while (true) {
            System.out.print(ANSI_CYAN + "\n> " + ANSI_RESET);
            String input;
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();

            if (input.equals("help")) {
                helpPrompt();
            } else if (input.startsWith("a ")) {
                String task = input.substring(2);
                service.addItem(task);
            } else if (input.startsWith("r ")) {
                int id = Integer.parseInt(input.substring(2));
                service.removeItem(id);
            } else if (input.startsWith("c ")) {
                int id = Integer.parseInt(input.substring(2));
                service.completeItem(id);
            } else if (input.startsWith("v") || input.equals("ls")) {
                printToDoList();
            } else if (input.startsWith("h")) {
                printToDoHistory();
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }

        }
    }
}