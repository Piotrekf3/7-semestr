import java.util.ArrayList;
import java.util.Arrays;

public class Instance {
    private ArrayList<Task> tasks;

    public Instance() {
        this.tasks = new ArrayList<>();
    }

    public Instance(Task tasks[]) {
        this.tasks = new ArrayList<>(Arrays.asList(tasks));
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task[] getTasks() {
        return this.tasks.toArray(new Task[0]);
    }
}
