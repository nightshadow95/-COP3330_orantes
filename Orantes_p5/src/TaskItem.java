import java.text.ParsePosition;
import java.text.SimpleDateFormat;


public class TaskItem {

    private String Title;
    private String Description;
    private String Due_Date;


    public TaskItem(String Title, String Description, String Due_Date) {
        try {
            if(isLegalDate(Due_Date) && Title.length() >= 1){
                this.Due_Date = Due_Date;
                this.Title = Title;
                this.Description = Description;
            }
            else{
                System.out.println("Please enter the right format for the date: YYYY-MM-DD. This task was not added");
            }
        }catch(IllegalArgumentException e) {
            System.out.println("Please enter the right format for the date: YYYY-MM-DD");
        }
    }

    private boolean isLegalDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return sdf.parse(date, new ParsePosition(0)) != null;
    }

    public TaskItem() {

    }

    public boolean setTitle(String Title) {
            if (Title.length() < 1) {
                System.out.printf("[Warning] Title must be at least 1 Characters long. The task item was not added to the list\n\n");
                return false;
            } else {
                this.Title = Title;
                return true;
            }
    }

    public void setDescription(String description) {
            this.Description = description;
    }

    public String getTitle() {

        return Title;
    }

    public boolean setDue_Date(String Due_Date) {
           if(isLegalDate(Due_Date)){
               this.Due_Date = Due_Date;
               return true;
           }
           else{
               System.out.println("Please enter the right format for the date: YYYY-MM-DD. This task was not added.\n\n");
               return false;
           }
    }


    public String getDescription() {
        return Description;
    }

    public String getDue_Date() {
        return Due_Date;
    }

    @Override
    public String toString() {

        return Due_Date+" "+Title+ ": "+Description;
    }


}


