import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;


public class TaskList {
    public TaskItem e;
    ArrayList<TaskItem> task = new ArrayList<>();

    public void SetTaskList(TaskItem tasklist) {
        task.add(tasklist);
        this.e = tasklist;
    }

    public TaskItem getTaskList() {

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
            for (int i=0; i<task.size(); i++){
                output.format("%s%n",task.get(i).getTitle());
                output.format("%s%n", task.get(i).getDue_Date());
                output.format("%s%n",task.get(i).getDescription());
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
            System.out.println("File was not found. \n");
        }
        String line;

        try{ while (true) {
            assert br!=null;
            if ((line =br.readLine()) == null) break;
            TaskItem task = new TaskItem();
            task.setTitle(line);
            line= br.readLine();
            task.setDue_Date(line);
            line =br.readLine();
            task.setDescription(line);
            newlist.add(task);
        }
            br.close();

        } catch(FileNotFoundException e){
            System.out.println("Please enter a valid file\n");
        }
        catch (NullPointerException e) {
            System.out.println("No file found. ");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        if(newlist.isEmpty()) {
            throw new IllegalArgumentException("The list was empty. Please provide a file with contacts.");
        }
        System.out.println("The file was successfully added. \n");
        return newlist;
    }

    @Override
    public String toString() {

        return e.toString();
    }
}




