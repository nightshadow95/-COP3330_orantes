import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class App {

    public static void main(String [] args) {

        boolean Continue = true;
        int Answer=0;
        int Answer2=0;
        int counter=0;

        Scanner scan = new Scanner(System.in);
        TaskList<TaskItem> T1 = new TaskList();

        do{
            try{
                while(counter==0) {
                    DisplayMenu();
                    Answer = scan.nextInt();
                    counter++;
                }
                while(Answer==1) {
                    T1.task.clear();
                    System.out.println("New List has been created! \n");
                    NewListMenu();
                    Answer2 = scan.nextInt();
                    Answer = 4;
                }
                while (Answer2 == 1) {
                    System.out.println("Current Tasks\n__________\n\n");
                    for(TaskItem items: T1.task) {
                        System.out.println(T1.task.indexOf(items)+ ") " +items.toString());
                    }
                    System.out.println("\n");
                    NewListMenu();
                    Answer2 = scan.nextInt();
                }

                while(Answer2 ==2) {
                    TaskItem task = new TaskItem();
                    scan.nextLine();
                    System.out.print("Task title: ");
                    task.setTitle(scan.nextLine());
                    System.out.print("Task Description: ");
                    task.setDescription(scan.nextLine());
                    System.out.print("Task due date (yyyy-MM-DD): ");
                    task.setDue_Date(scan.nextLine());
                    if(!task.getTitle().equals("error") && !task.getDue_Date().equals("error"))
                    {
                        T1.SetTaskList(task);
                    }
                    System.out.println("\n");
                    NewListMenu();
                    Answer2 = scan.nextInt();
                    while(Answer2==1){
                        System.out.println("Current Tasks\n__________\n\n");
                        for(TaskItem items: T1.task) {
                            System.out.println(T1.task.indexOf(items)+ ") " +items.toString());
                        }
                        System.out.println("\n");
                        NewListMenu();
                        Answer2 = scan.nextInt();
                    }
                }

                while(Answer2==3){
                    int tasknumber=0;
                    System.out.println("Current Tasks\n__________\n\n");
                    for(TaskItem items: T1.task) {
                        System.out.println(T1.task.indexOf(items)+ ") " +items.toString());
                    }
                    System.out.print("\nWhich tasks will you edit? ");
                    tasknumber = scan.nextInt();
                    if(tasknumber < 0 || tasknumber > T1.task.size()) {
                        System.out.println("Please enter a valid index: ");
                        tasknumber = scan.nextInt();
                    }
                    scan.nextLine();
                    System.out.print("New Task title: ");
                    T1.task.get(tasknumber).setTitle(scan.nextLine());
                    System.out.print("New task Description: ");
                    T1.task.get(tasknumber).setDescription(scan.nextLine());
                    System.out.print("New task due date (yyyy-MM-DD): ");
                    T1.task.get(tasknumber).setDue_Date(scan.nextLine());
                    System.out.println("\n");
                    NewListMenu();
                    Answer2 = scan.nextInt();
                }

                while(Answer2 == 4) {
                    int tasknumber=0;
                    System.out.println("Current Tasks\n__________\n\n");
                    for(TaskItem items: T1.task) {
                        System.out.println(T1.task.indexOf(items)+ ") " +items.toString());
                    }
                    System.out.println("\n");
                    System.out.print("Which task will you remove? ");
                    tasknumber = scan.nextInt();
                    if(tasknumber < 0 || tasknumber > T1.task.size()) {
                        System.out.println("Please enter a valid index: ");
                        tasknumber = scan.nextInt();
                    }
                    T1.task.remove(tasknumber);
                    System.out.println("\n");
                    NewListMenu();
                    Answer2 = scan.nextInt();
                }

                while(Answer2 == 5){
                    int tasknumber;
                    System.out.println("Uncompleted Tasks\n____________\n\n");
                    for(TaskItem items: T1.task) {
                        if(!items.getDescription().contains("*")){
                            System.out.println(T1.task.indexOf(items)+ ") " +items.toString());
                        }
                    }
                    System.out.println("\n Which one would you like to complete?");
                    tasknumber = scan.nextInt();
                    while(tasknumber < 0 || tasknumber > T1.task.size() || T1.task.get(tasknumber).getDescription().contains("*")) {
                        System.out.println("Please enter a valid index: ");
                        tasknumber = scan.nextInt();
                    }
                    T1.updatetocomplete(T1.task.get(tasknumber));
                    NewListMenu();
                    Answer2=scan.nextInt();
                }

                while(Answer2 == 6) {
                    int tasknumber;
                    System.out.println("Completed Tasks\n____________\n\n");
                    for(TaskItem items: T1.task) {
                        if(items.getDescription().contains("*")){
                            System.out.println(T1.task.indexOf(items)+ ") " +items.toString());
                        }
                    }
                    System.out.println("\n");
                    tasknumber = scan.nextInt();
                    while(tasknumber < 0 || tasknumber > T1.task.size() || !T1.task.get(tasknumber).getDescription().contains("*")) {
                        System.out.println("Please enter a valid index: ");
                        tasknumber = scan.nextInt();
                    }
                    T1.updatetoincomplete(T1.task.get(tasknumber));
                    NewListMenu();
                    Answer2=scan.nextInt();
                }

                while(Answer2==7){
                    if(T1.task.isEmpty()){
                        System.out.println("There are no tasks to save. Please enter tasks and then save the list.\n");
                    }
                    else {
                        String Filename;
                        scan.nextLine();
                        System.out.print("Enter the filename to save as: ");
                        Filename = scan.nextLine();
                        T1.SaveTaskList(Filename);
                        System.out.println("Task list has been saved as: " + Filename + "\n");
                    }
                    NewListMenu();
                    Answer2=scan.nextInt();
                }

                if(Answer2 == 8) {
                    counter = 0;
                }

                while(Answer2 < 0 || Answer2 > 8) {
                    System.out.println("Please enter a valid option (1-8)");
                    NewListMenu();
                    Answer2 = scan.nextInt();
                }

                if(Answer ==2){
                    String Filename;
                    ArrayList<TaskItem> newlist;
                    scan.nextLine();
                    System.out.print("Enter the filename to load: ");
                    Filename = scan.nextLine();
                    newlist = T1.LoadTaskList(Filename);
                    if(newlist == null){
                        DisplayMenu();
                        Answer = scan.nextInt();
                    }
                    else {
                        for (TaskItem tasks : newlist) {
                            TaskItem task = new TaskItem();
                            task.setDue_Date(tasks.getDue_Date());
                            task.setDescription(tasks.getDescription());
                            task.setTitle(tasks.getTitle());
                            T1.SetTaskList(task);
                        }
                        System.out.println("File has been saved: " + Filename + "\n");
                        NewListMenu();
                        Answer2 = scan.nextInt();
                        Answer = 4;
                    }
                }

                if(Answer == 3) {
                    Continue=false;
                }

                if(Answer <0 || Answer > 4) {
                    System.out.println("Please enter a valid option (1-3): ");
                    counter=0;
                }
            }catch(InputMismatchException e) {
                System.out.println("Please Enter a valid input (Only integers) please\n");
                scan.next();
            }catch(NullPointerException e) {
                e.printStackTrace();
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        } while (Continue);
    }

    private static void NewListMenu() {
        System.out.println("List Operations Menu\n------------\n1) view the list\n2) Add an item\n3) Edit an item\n4) Remove an item\n" +
                "5) Mark an item as completed\n6) Unmark an item as completed\n7) Save the current list\n8) Quit to the main menu\n");
    }

    private static void DisplayMenu() {
        System.out.println("Main Menu \n_________\n\n1) Create a new list\n2) Load an existing list\n3) quit\n");
    }


}


