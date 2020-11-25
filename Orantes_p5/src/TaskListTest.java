import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);

        TaskItem Item2 = new TaskItem("title1", "description1", "2008-08-07");
        list.SetTaskList(Item2);

        assertEquals(2, list.task.size());
    }

    @Test
    public void StoringTaskItemintoTaskList() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        System.out.println(list.task);
        assertTrue(list.getTaskList().equals(Item));
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        list.updatetocomplete(Item);
        assertEquals("2008-08-07 title: description *C*", Item.toString());

    }

    @Test
    public void updateListItemtoIncomplete() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        list.updatetocomplete(Item);
        list.updatetoincomplete(Item);
        assertEquals("2008-08-07 title: description ", list.toString());
    }

    @Test
    public void RemovingItemFromTasklist() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        list.task.remove(Item);
        assertEquals("[]", list.task.toString());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskItem Item2 = new TaskItem("code project", "I have no life", "2015-06-03");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        list.SetTaskList(Item2);
        list.task.remove(Item);
        assertEquals(1, list.task.size());
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        list.task.get(0).setDue_Date("2014-01-03");
        assertEquals("2014-01-03", list.task.get(0).getDue_Date());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        list.task.get(0).setDescription("better description");
        assertEquals("better description", list.task.get(0).getDescription());
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        list.task.get(0).setTitle("better title");
        assertEquals("better title", list.task.get(0).getTitle());
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        ArrayList<TaskItem> tasks;
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        tasks = list.LoadTaskList("students.txt");
        list.SetTaskList(tasks.get(0));
        assertEquals("2090-02-02 title: description", list.getTaskList().toString());
    }

    @Test
    public void newTaskListIsEmpty() {
        ArrayList<TaskItem> tasks;
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertThrows(IllegalArgumentException.class, () -> {
            list.LoadTaskList("pain.txt");
        });
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.task.get(10).getDescription();
        });
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertEquals("description", list.task.get(0).getDescription());
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.task.get(10).getDue_Date();
        });
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertEquals("2008-08-07", list.task.get(0).getDue_Date());
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.task.get(10).getTitle();
        });
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertEquals("title", list.task.get(0).getTitle());
    }

    @Test
    public void newListIsEmpty() {
        TaskList list = new TaskList();
        assertThrows(IllegalArgumentException.class, () -> {
            list.LoadTaskList("pain.txt");
        });
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        TaskItem Item = new TaskItem("title", "description", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.task.remove(10);
        });
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem Item = new TaskItem("title", "description *C*", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        list.updatetoincomplete(list.task.get(0));
        assertEquals("description ", list.task.get(0).getDescription());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskItem Item = new TaskItem("title", "description *C*", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.updatetoincomplete(list.task.get(10));
        });
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {
        TaskItem Item = new TaskItem("title", "description *C*", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        Item.setDue_Date("2012/01/01");
        assertEquals("2008-08-07", Item.getDue_Date());

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem Item = new TaskItem("title", "description *C*", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.task.get(10).setDue_Date("2012-03-04");
        });
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() {
        TaskItem Item = new TaskItem("title", "description *C*", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        Item.setDue_Date("2044-44-44");
        assertEquals("2008-08-07", Item.getDue_Date());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem Item = new TaskItem("title", "description *C*", "2008-08-07");
        TaskList list = new TaskList();
        list.SetTaskList(Item);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.updatetocomplete(list.task.get(10));
        });
    }


}
