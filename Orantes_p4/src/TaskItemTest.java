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
        TaskItem Item = new TaskItem("title", "description", "1995-01-08");
        Item.setDue_Date("1995/08/01");
        boolean ValidDate = Item.getDue_Date().equals("1995/08/01");
        assertFalse(ValidDate);
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
        boolean ValidTitle = Item.getTitle().equals("");
        assertTrue(ValidTitle);
    }

    @Test
    public void CreatingTaskItemFailsWithInvalidDueDate() {
        TaskItem Item = new TaskItem("title", "description", "1995/09/34");
        boolean ValidDate = Item.getDue_Date().equals("");
        assertFalse(ValidDate);
    }

    @Test
    public void CreatingTaskItemTitleSucceedswithValidTitle() {
        TaskItem Item = new TaskItem("title", "description", "1995/09/34");
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
