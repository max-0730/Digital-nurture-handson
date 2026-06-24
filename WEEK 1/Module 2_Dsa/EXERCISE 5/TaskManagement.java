class Task {

    int taskId;
    String taskName;
    String status;

    Task next;

    Task(int taskId,
         String taskName,
         String status) {

        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagement {

    static Task head = null;

    // Add Task
    public static void addTask(int id,
                               String name,
                               String status) {

        Task newTask =
                new Task(id, name, status);

        if (head == null) {

            head = newTask;
            return;
        }

        Task temp = head;

        while (temp.next != null) {

            temp = temp.next;
        }

        temp.next = newTask;
    }

    // Search Task
    public static void searchTask(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {

                System.out.println(
                        "Task Found: "
                                + temp.taskName
                                + " - "
                                + temp.status);

                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    // Traverse Tasks
    public static void displayTasks() {

        Task temp = head;

        while (temp != null) {

            System.out.println(
                    "ID: " + temp.taskId +
                    ", Name: " + temp.taskName +
                    ", Status: " + temp.status);

            temp = temp.next;
        }
    }

    // Delete Task
    public static void deleteTask(int id) {

        if (head == null) {

            System.out.println("List Empty");
            return;
        }

        if (head.taskId == id) {

            head = head.next;

            System.out.println("Task Deleted");
            return;
        }

        Task temp = head;

        while (temp.next != null &&
                temp.next.taskId != id) {

            temp = temp.next;
        }

        if (temp.next == null) {

            System.out.println("Task Not Found");
            return;
        }

        temp.next = temp.next.next;

        System.out.println("Task Deleted");
    }

    public static void main(String[] args) {

        addTask(
                101,
                "Design Module",
                "Pending");

        addTask(
                102,
                "Develop Module",
                "In Progress");

        addTask(
                103,
                "Testing",
                "Pending");

        System.out.println(
                "All Tasks:");

        displayTasks();

        System.out.println(
                "\nSearching Task 102:");

        searchTask(102);

        System.out.println(
                "\nDeleting Task 102:");

        deleteTask(102);

        System.out.println(
                "\nTasks After Deletion:");

        displayTasks();
    }
}