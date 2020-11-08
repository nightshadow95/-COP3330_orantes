import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;


public class TaskList<E> {
    public E e;
    ArrayList<E> task = new ArrayList<>();

    public void SetTaskList(E e) {
        task.add(e);
        this.e = e;
    }

    public E getTaskList() {

        return e;
    }

    public TaskItem updatetocomplete(TaskItem task) {
        task.setDescription(task.getDescription() + " *C*");
        return task;
    }

    public TaskItem updatetoincomplete(TaskItem task) {
        task.setDescription(task.getDescription().replace("*C*", ""));
        return task;
    }

    public void SaveTaskList(String filename) {
        try (Formatter output = new Formatter(filename)) {
            for (E items : task) {
                output.format("%s\n", items.toString());
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public ArrayList<TaskItem> LoadTaskList(String filename) {
        ArrayList<TaskItem> newlist = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        String line;
        String Title = "                ";
        String Date="2013-02-03";
        String Description="                                                     ";


        try{ while ((line =br.readLine()) != null) {
            int counter = 0;
            Title = "          ";
            StringBuilder duedate = new StringBuilder(Date);
            StringBuilder title = new StringBuilder(Title);
            StringBuilder description = new StringBuilder(Description);
            TaskItem task = new TaskItem();
            for (int i = 0; i < 10; i++) {
                duedate.setCharAt(i, line.charAt(i));
            }
            for (int j = 11; j < line.length(); j++) {
                if (line.charAt(j) == ':') {
                    break;
                }
                title.setCharAt(counter, line.charAt(j));
                counter++;
            }
            counter = 0;
            for (int k = Date.length() + title.toString().trim().length() + 2; k < line.length(); k++) {
                description.setCharAt(counter, line.charAt(k));
                counter++;
            }
            task.setTitle(title.toString().trim().toLowerCase());
            task.setDescription(description.toString().trim().toLowerCase());
            task.setDue_Date(duedate.toString().trim());
            newlist.add(task);
        }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(newlist.isEmpty()) {
            System.out.println("The list was empty. Please provide a file with tasks.\n");
            return null;
        }
        return newlist;
    }

    @Override
    public String toString() {

        return e.toString();
    }
}




