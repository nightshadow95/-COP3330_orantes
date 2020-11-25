import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {

        public static void main(String [] args) {
            TaskApp task = new TaskApp();
            task.Runprogram();
        }

    TaskList T1 = new TaskList();
    ContactApp app = new ContactApp();
    Scanner scan = new Scanner(System.in);

    private void Runprogram() {
        boolean Continue = true;
        int Answer=0;
        int Answer2=0;
        int counter=0;
        int CAnswer=0;


        do{
            try{
                while(counter==0) {
                    AppMenu();
                    app.clear();
                    Answer = scan.nextInt();
                    counter++;
                }
                    if (Answer == 2) {
                        DisplayMenu();
                        Answer = scan.nextInt();


                        if (Answer == 1) {
                            app.create();
                            NewContactMenu();
                            CAnswer = scan.nextInt();
                            Answer = -1;
                        }

                        if (Answer == 2) {
                            app.Loadlist();
                            NewContactMenu();
                            CAnswer = scan.nextInt();
                            Answer=-1;
                        }
                    }

                        if(CAnswer == 1) {
                            app.Currentlist();
                            NewContactMenu();
                            CAnswer = scan.nextInt();
                            Answer = -1;
                        }
                        while (CAnswer == 2) {
                            app.AddContact();
                            NewContactMenu();
                            CAnswer = scan.nextInt();
                        }
                        while (CAnswer == 3) {
                            app.EditContact();
                            NewContactMenu();
                            CAnswer = scan.nextInt();
                        }
                        while(CAnswer== 4) {
                            app.RemoveContact();
                            NewContactMenu();
                            CAnswer = scan.nextInt();
                        }
                        while(CAnswer == 5){
                            app.SaveList();
                            NewContactMenu();
                            CAnswer = scan.nextInt();
                        }
                        if(CAnswer == 6) {
                            counter=0;
                        }
                        while(CAnswer<0 || CAnswer > 6){
                            System.out.println("Please enter a valid choice 1-6");
                            CAnswer=scan.nextInt();
                        }

                    if (Answer == 3) {
                        Continue = false;
                    }

                    if (Answer == 1) {
                        Create();
                        DisplayMenu();
                        Answer = scan.nextInt();

                        if(Answer == 1) {
                            CurrentList();
                            Answer2 = scan.nextInt();
                            Answer = -1;
                        }

                        if (Answer == 2) {
                            LoadList();
                            NewListMenu();
                            Answer2 = scan.nextInt();
                            Answer=-1;
                        }
                    }
                    while (Answer2 == 1) {
                        CurrentList();
                        Answer2 = scan.nextInt();
                    }

                    while (Answer2 == 2) {
                        InputTaskInfo();
                        Answer2 = scan.nextInt();
                    }

                    while (Answer2 == 3) {
                        EditTaskInfo();
                        Answer2 = scan.nextInt();
                    }

                    while (Answer2 == 4) {
                        RemoveTaskItem();
                        Answer2 = scan.nextInt();
                    }

                    while (Answer2 == 5) {
                       CompleteTaskItem();
                        Answer2 = scan.nextInt();
                    }

                    while (Answer2 == 6) {
                        UncompleteTaskItem();
                        Answer2 = scan.nextInt();
                    }

                    while (Answer2 == 7) {
                       SaveTaskList();
                       Answer2 = scan.nextInt();
                    }

                    if (Answer2 == 8) {
                        counter = 0;
                    }

                    while (Answer2 < 0 || Answer2 > 8) {
                        System.out.println("Please enter a valid option (1-8)");
                        NewListMenu();
                        Answer2 = scan.nextInt();
                    }

                    if (Answer == 2) {
                            LoadTaskList();
                            Answer2 = scan.nextInt();
                            Answer = -1;
                    }

                    if (Answer == 3) {
                        Continue = false;
                    }

                    if (Answer < -1 || Answer > 3) {
                        System.out.println("Please enter a valid option (1-3): ");
                        counter = 0;
                    }

            }catch(InputMismatchException e) {
                System.out.println("Please Enter a valid input (Only integers) please\n");
                scan.next();
            }catch(NullPointerException e) {
                System.out.println("Please enter valid data.\n");
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Please enter a valid index. \n");
            }
            catch(IllegalArgumentException e) {
                System.out.println("The data entered was not valid. Please try again.\n");
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        } while (Continue);
    }

    private void LoadTaskList() {
        String Filename;
        scan.nextLine();
        System.out.print("Enter the filename to load: ");
        Filename = scan.nextLine();
        T1.task.addAll(T1.LoadTaskList(Filename));
            System.out.println("File has been saved: " + Filename + "\n");
        }


    private void SaveTaskList() {
        if (T1.task.isEmpty()) {
            System.out.println("There are no tasks to save. Please enter tasks and then save the list.\n");
        } else {
            String Filename;
            scan.nextLine();
            System.out.print("Enter the filename to save as: ");
            Filename = scan.nextLine();
            T1.SaveTaskList(Filename);
            System.out.println("Task list has been saved as: " + Filename + "\n");
        }
        NewListMenu();
    }

    private void UncompleteTaskItem() {
        int tasknumber;
        System.out.println("Completed Tasks\n____________\n\n");
        for (TaskItem items : T1.task) {
            if (items.getDescription().contains("*")) {
                System.out.println(T1.task.indexOf(items) + ") " + items.toString());
            }
        }
        System.out.println("\n");
        tasknumber = scan.nextInt();
        while (tasknumber < 0 || tasknumber > T1.task.size() || !T1.task.get(tasknumber).getDescription().contains("*")) {
            System.out.println("Please enter a valid index: ");
            tasknumber = scan.nextInt();
        }
        T1.updatetoincomplete(T1.task.get(tasknumber));
        NewListMenu();
    }

    private void CompleteTaskItem() {
        int tasknumber;
        System.out.println("Uncompleted Tasks\n____________\n\n");
        for (TaskItem items : T1.task) {
            if (!items.getDescription().contains("*")) {
                System.out.println(T1.task.indexOf(items) + ") " + items.toString());
            }
        }
        System.out.println("\n Which one would you like to complete?");
        tasknumber = scan.nextInt();
        while (tasknumber < 0 || tasknumber > T1.task.size() || T1.task.get(tasknumber).getDescription().contains("*")) {
            System.out.println("Please enter a valid index: ");
            tasknumber = scan.nextInt();
        }
        T1.updatetocomplete(T1.task.get(tasknumber));
        NewListMenu();
    }

    private void RemoveTaskItem() {
        int tasknumber;
        if(T1.task.isEmpty()){
            System.out.println("There are no tasks to remove.\n\n");
        }
        else {
            System.out.println("Current Tasks\n__________\n\n");
            for (TaskItem items : T1.task) {
                System.out.println(T1.task.indexOf(items) + ") " + items.toString());
            }
            System.out.println("\n");
            System.out.print("Which task will you remove? ");
            tasknumber = scan.nextInt();
            while (tasknumber < 0 || tasknumber > T1.task.size()) {
                System.out.println("Please enter a valid index: ");
                tasknumber = scan.nextInt();
            }
            T1.task.remove(tasknumber);
            System.out.println("\n");
        }
        NewListMenu();
    }

    private void EditTaskInfo() {
        int tasknumber;
        String Title;
        String DueDate;
        String Description;
        if(T1.task.isEmpty()){
            System.out.println("There are no tasks to edit.");
        }
        else {
            System.out.println("Current Tasks\n__________\n\n");
            for (TaskItem items : T1.task) {
                System.out.println(T1.task.indexOf(items) + ") " + items.toString());
            }
            System.out.print("\nWhich tasks will you edit? ");
            tasknumber = scan.nextInt();
            while (tasknumber < 0 || tasknumber > T1.task.size()) {
                System.out.println("Please enter a valid index: ");
                tasknumber = scan.nextInt();
            }
            scan.nextLine();
            System.out.print("New Task title: ");
            Title = scan.nextLine();
            System.out.print("New task due date (yyyy-MM-DD): ");
            DueDate = scan.nextLine();
            System.out.print("New task Description: ");
            Description = scan.nextLine();
            if(Title.isBlank() && DueDate.isBlank()){
                System.out.printf("Enter a valid title and Date. Please try again. ");
            }
            else {
                T1.task.get(tasknumber).setDue_Date(DueDate);
                T1.task.get(tasknumber).setTitle(Title);
                T1.task.get(tasknumber).setDescription(Description);
            }
        }
        System.out.println("\n");
        NewListMenu();
    }

    private void InputTaskInfo() {
        TaskItem task = new TaskItem();
        scan.nextLine();
        System.out.print("Task title: ");
        if(task.setTitle(scan.nextLine())) {
            System.out.print("Task due date (yyyy-MM-DD): ");
            if(task.setDue_Date(scan.nextLine())) {
                System.out.print("Task Description: ");
                task.setDescription(scan.nextLine());
                T1.SetTaskList(task);
            }
            System.out.println("\n");
        }
        NewListMenu();
    }

    private void LoadList() {
        String Filename;
        scan.nextLine();
        System.out.print("Enter the filename to load: ");
        Filename = scan.nextLine();
        T1.task.addAll(T1.LoadTaskList(Filename));
        }


    private void CurrentList() {
        if(T1.task.isEmpty()){
            System.out.println("No current tasks\n\n");
        }
        else {
            System.out.println("Current Tasks\n__________\n\n");
            for (TaskItem items : T1.task) {
                System.out.println(T1.task.indexOf(items) + ") " + items.toString() + "\n");
            }
        }
        NewListMenu();
    }

    private void Create() {
        T1.task.clear();
        System.out.println("New List has been created! \n");
    }

    private static void NewListMenu() {
            System.out.println("List Operations Menu\n------------\n1) view the list\n2) Add an item\n3) Edit an item\n4) Remove an item\n" +
                    "5) Mark an item as completed\n6) Unmark an item as completed\n7) Save the current list\n8) Quit to the main menu\n");
        }

        private static void DisplayMenu() {
            System.out.println("Main Menu \n_________\n\n1) Create a new list\n2) Load an existing list\n3) quit\n");
        }

        private static void AppMenu() {
            System.out.println("Select Your Application\n______________\n\n1) task list\n2) contact list\n3) quit\n");
        }

        private static void NewContactMenu(){
            System.out.println("List Operations Menu\n------------\n1) view the list\n2) Add an item\n3) Edit an item\n4) Remove an item\n" +
                    "5) Save the current list\n6) Quit to the main menu\n");
        }

    }

