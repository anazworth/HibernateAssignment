package org.anazworth;


public class ToDoService {

    private static ToDoRepository repository;

    public ToDoService() {
        repository = new ToDoRepository();
    }

    public void addItem(String task) {
        ToDoItem item = new ToDoItem();
        item.setTask(task);
        item.setDateCreated(new java.util.Date().toString());
        item.setCompleted(false);
        repository.addItem(item);
    }

    public void completeItem(int id) {
        repository.completeItem(id);
    }

    public void removeItem(int id) {
        repository.removeItem(id);
    }

    public static void initialGreeting() {
        System.out.println("\n" + BG_PURPLE + "Hello productive programmer!" + ANSI_RESET);
        System.out.println("\nType 'help' for a list of commands.\n");

    }

    static void printToDoHistory() {
        System.out.println("\n" + BG_GREEN + "Completed Tasks:");
        System.out.println(ANSI_RESET);

        for (ToDoItem item : repository.getAllCompletedItems()) {
            System.out.println(lineBuilder(item));
        }
    }

    public static void printToDoList() {
        System.out.println("\n" + BG_YELLOW + "Items:");
        System.out.println(ANSI_RESET);

        for (ToDoItem item : repository.getAllItems()) {
            System.out.println(lineBuilder(item));
        }
    }
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED = "\u001B[31m";
    static final String BG_PURPLE = "\u001B[45m";
    static final String BG_GREEN = "\u001B[42m";
    static final String BG_YELLOW = "\u001B[43m";

    public static void helpPrompt() {
        System.out.println(ANSI_RESET);
        System.out.println(ANSI_CYAN);
        System.out.println(ANSI_GREEN + "- Add a task:");
        System.out.println(ANSI_RED + "\ta <task>");
        System.out.println(ANSI_GREEN + "- Remove a task:");
        System.out.println(ANSI_RED + "\tr <task id>");
        System.out.println(ANSI_GREEN + "- Mark a task as complete:");
        System.out.println(ANSI_RED + "\tc <task id>");
        System.out.println(ANSI_GREEN + "- View all tasks:");
        System.out.println(ANSI_RED + "\tv");
        System.out.println(ANSI_GREEN + "- View completed tasks:");
        System.out.println(ANSI_RED + "\th");
        System.out.println(ANSI_GREEN + "- Exit program:");
        System.out.println(ANSI_RED + "\texit");
        System.out.println(ANSI_RESET);
    }

    public static String lineBuilder(ToDoItem item) {
        StringBuilder sb = new StringBuilder();
        sb.append(item.getId());
        sb.append(" ");

        if (item.getCompleted()) {
            sb.append(ANSI_GREEN + "[X] " + ANSI_RESET);
        } else {
            sb.append(ANSI_RED + "[ ] " + ANSI_RESET);
        }

        sb.append(ANSI_CYAN).append(item.getTask()).append(ANSI_RESET);

        sb.append("\n\t");
        sb.append("Created: ");
        sb.append(item.getDateCompleted());
        if (item.getCompleted()) {
            sb.append("\t Completed: ");
            sb.append(item.getDateCompleted());
        }

        return sb.toString();
    }
}
