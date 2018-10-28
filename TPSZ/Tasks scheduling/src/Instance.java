import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Instance {
    private ArrayList<Task> tasks;
    private int goalFunction;

    public Instance() {
        this.tasks = new ArrayList<>();
        this.goalFunction = 0;
    }

    public Instance(Task tasks[]) {
        this.tasks = new ArrayList<>(Arrays.asList(tasks));
        this.goalFunction = 0;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task[] getTasks() {
        return this.tasks.toArray(new Task[0]);
    }

    public void saveToFile(int instanceNumber, double h) {
        String filename = "n" + this.tasks.size() + "k" + instanceNumber + "h" + h + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(this.goalFunction + "_" + h + "_" + 0 + "_" + getTasksId());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public int sumProcessingTime() {
        int sum = 0;
        for(Task task : this.tasks) {
            sum += task.getProcessingTime();
        }
        return sum;
    }
    
    private String getTasksId() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Task task : this.tasks) {
            stringBuilder.append(task.getId());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
