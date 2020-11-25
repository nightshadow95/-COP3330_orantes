import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void SettingTaskItemwithInvalidTitle() {
        TaskItem Item = new TaskItem("Title", "description", "1995-01-01");
        Item.setTitle("");
        boolean ValidTitle = Item.getTitle().equals("");
        assertFalse(ValidTitle);
    }

    @Test
    public void SettingTaskItemWithInvalidDueDate() {
        TaskItem Item = new TaskItem("title", "description", "1995-09-09");
        Item.setDue_Date("2001-17-66");
        assertEquals("1995-09-09", Item.getDue_Date());
    }

    @Test
    public void SettingTaskItemSucceedsWithValidTitle() {
        TaskItem Item = new TaskItem("title", "description", "1995-01-08");
        Item.setTitle("New Title");
        boolean ValidTitle = Item.getTitle().equals("New Title");
        assertTrue(ValidTitle);
    }

    @Test
    public void SettingTaskItemSucceedsWithValidDueDate() {
        TaskItem Item = new TaskItem("title", "description", "1995-01-08");
        Item.setDue_Date("2012-01-02");
        boolean ValidDate = Item.getDue_Date().equals("2012-01-02");
        assertTrue(ValidDate);
    }

    @Test
    public void CreatingTaskItemFailsWithInvalidTitle() {
            TaskItem Item = new TaskItem("", "description", "1995-01-08");
        try{
            assertTrue(Item.getTitle().equals(null));
        }catch(NullPointerException e){
            System.out.println("Test passed");
        }
    }

    @Test
    public void CreatingTaskItemFailsWithInvalidDueDate() {
        TaskItem Item = new TaskItem("title", "description", "1995/09/34");
        try{
            assertTrue(Item.getDue_Date().equals(null));
        }catch(NullPointerException e){
            System.out.println("Test passed");
        }

    }

    @Test
    public void CreatingTaskItemTitleSucceedswithValidTitle() {
        TaskItem Item = new TaskItem("title", "description", "1995-01-02");
        boolean ValidTitle = Item.getTitle().equals("title");
        assertTrue(ValidTitle);
    }

    @Test
    public void CreatingTaskItemSucceedsWithValidDueDate() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        boolean ValidDate = Item.getDue_Date().equals("2008-08-07");
        assertTrue(ValidDate);
    }


}
