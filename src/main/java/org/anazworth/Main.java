package org.anazworth;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Scanner;

import static org.anazworth.ToDoService.*;
import static org.hibernate.cfg.AvailableSettings.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

//        sessionFactory.getSchemaManager().exportMappedObjects(true);


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
            } else if (input.startsWith("v")) {
                printToDoList();
            } else if (input.startsWith("h")) {
                printToDoHistory();
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }

//            System.out.print(ANSI_CYAN + "\n> " + ANSI_RESET);
//            input= scanner.nextLine();

//            switch (input) {
//                case "help" -> helpPrompt();
//                case "a" -> {
//                    System.out.println("Enter task:");
//                    String task = System.console().readLine();
//                    service.addItem(task);
//                }
//                case "r" -> {
//                    System.out.println("Enter task id:");
//                    int id = Integer.parseInt(System.console().readLine());
//                    service.removeItem(id);
//                }
//                case "c" -> {
//                    System.out.println("Enter task id:");
//                    int id = Integer.parseInt(System.console().readLine());
//                    service.completeItem(id);
//                }
//                case "v" -> ToDoService.printToDoList();
//                case "h" -> ToDoService.printToDoHistory();
//                case "exit" -> System.exit(0);
//                default -> System.out.println("Invalid command.");
//
//            }

    }
    }
}