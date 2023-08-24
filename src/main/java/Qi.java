import java.util.Scanner;
public class Qi {
    public static void main(String[] args) {
        Bot qi = new Bot("Qi");
        qi.greeting();

        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals("bye")) {
                break;
            }

            if (str.equals("list")) {
                qi.showTask();
                continue;
            }

            if (str.startsWith("mark ")) {
                int taskIdx = Integer.parseInt(str.substring(5));
                qi.markTask(taskIdx);
                continue;
            }

            if (str.startsWith("unmark ")) {
                int taskIdx = Integer.parseInt(str.substring(7));
                qi.unmarkTask(taskIdx);
                continue;
            }

            if (str.startsWith("todo")) {
                try {
                    String task = str.substring(5);
                    qi.addTask(task);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     ☹ OOPS!!! The description of a todo cannot be empty.");
                    System.out.println("    ____________________________________________________________");
                }
                continue;
            }

            if (str.startsWith("deadline")) {
                // find the first slash
                int idx = 9;
                while (idx < str.length() && str.charAt(idx) != '/') {
                    idx++;
                }
                try {
                    String task = str.substring(9, idx - 1);
                    String deadline = str.substring(idx + 4);
                    qi.addTask(task, deadline);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     ☹ OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println("    ____________________________________________________________");
                }
                continue;
            }

            if (str.startsWith("event")) {
                // find the first slash
                int idx1 = 6;
                while (idx1 < str.length() && str.charAt(idx1) != '/') {
                    idx1++;
                }

                // find the second slash
                int idx2 = idx1 + 1;
                while (idx2 < str.length() && str.charAt(idx2) != '/') {
                    idx2++;
                }

                try {
                    String task = str.substring(6, idx1 - 1);
                    String startTime = str.substring(idx1 + 6, idx2 - 1);
                    String endTime = str.substring(idx2 + 4);
                    qi.addTask(task, startTime, endTime);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("    ____________________________________________________________");
                    System.out.println("     ☹ OOPS!!! The description of an event cannot be empty.");
                    System.out.println("    ____________________________________________________________");
                }
                continue;
            }

            System.out.println("    ____________________________________________________________");
            System.out.println("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            System.out.println("    ____________________________________________________________");
        }
        qi.goodBye();
    }
}
