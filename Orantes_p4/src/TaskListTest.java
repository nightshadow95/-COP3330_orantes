import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);

        TaskItem Item2 = new TaskItem("title1", "description1", "2008-08-07");
        list.SetTaskList(Item2);

        assertEquals(2, list.task.size());
    }

    @Test
    public void StoringTaskItemintoTaskList() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        System.out.println(list.task);
        assertTrue(list.getTaskList().equals(Item));
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        list.updatetocomplete(Item);
        assertEquals("2008-08-07 title: description *[Completed]*", Item.toString());

    }

    @Test
    public void updateListItemtoIncomplete() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        list.updatetocomplete(Item);
        list.updatetoincomplete(Item);
        assertEquals("2008-08-07 title: description ", list.toString());
    }

    @Test
    public void RemovingItemFromTasklist() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        list.task.remove(Item);
        assertEquals("[]", list.task.toString());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskItem Item2 = new TaskItem("code project", "I have no life", "2015-06-03");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        list.SetTaskList(Item2);
        list.task.remove(Item);
        assertEquals(1, list.task.size());
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        list.task.get(0).setDue_Date("2014-01-03");
        assertEquals("2014-01-03", list.task.get(0).getDue_Date());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        list.task.get(0).setDescription("better description");
        assertEquals("better description", list.task.get(0).getDescription());
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        list.task.get(0).setTitle("better title");
        assertEquals("better title", list.task.get(0).getTitle());
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        ArrayList<TaskItem> tasks;
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        tasks = list.LoadTaskList("pain.txt");
        list.SetTaskList(tasks.get(0));
        assertEquals("2012-03-04 title: deslkjsdlf", list.getTaskList().toString());
    }

    @Test
    public void newTaskListIsEmpty() {
        ArrayList<TaskItem> tasks;
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList<TaskItem> list = new TaskList<>();
        list.SetTaskList(Item);
        tasks = list.LoadTaskList("pain2.txt");
        assertTrue(tasks == null);
    }

}
