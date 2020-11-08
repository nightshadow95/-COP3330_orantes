public class TaskItem {

    private String Title;
    private String Description;
    private String Due_Date;


    public TaskItem(String Title, String Description, String Due_Date) {
        if(Title.length()<1) {
            System.out.println("[Warning] Title must be at least 1 Characters long. The task item was not added to the list");
            return;
        }
        this.Title = Title;
        this.Description = Description;
        boolean isDate;
        String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";
        isDate = Due_Date.matches(datePattern);
        if(isDate == false) {
            System.out.println("[WARNING] Invalid date format. The task item was not added to the list.");
            this.Due_Date = "error";
            return;
        }
        this.Due_Date = Due_Date;
    }

    public TaskItem() {

    }

    public void setTitle(String Title) {
        if(Title.length()<1) {
            System.out.println("[Warning] Title must be at least 1 Characters long. The task item was not added to the list");
            this.Title = "error";
            return;
        }
        else{this.Title = Title;}
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {

        return Title;
    }

    public void setDue_Date(String Due_Date) {
        boolean isDate;
        String datePattern = "\\d{4}-\\d{1,2}-\\d{1,2}";
        isDate = Due_Date.matches(datePattern);
        if(isDate == false) {
            System.out.println("[WARNING] Invalid date format. The task item was not added to the list.");
            this.Due_Date = "error";
            return;
        }
        this.Due_Date = Due_Date;
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


