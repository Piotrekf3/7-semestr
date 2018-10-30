import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Instance {
    private ArrayList<Task> tasks;
    private int goalFunction;
    private int startTime;

    public Instance() {
        this.tasks = new ArrayList<>();
        this.goalFunction = 0;
        this.startTime = 0;
    }

    public Instance(Task tasks[]) {
        this.tasks = new ArrayList<>(Arrays.asList(tasks));
        this.goalFunction = 0;
        this.startTime = 0;
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
            writer.write(this.goalFunction + " " + h + " " + 0 + " " + getTasksId());
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

    public void schedule(double h) {
        int deadline = (int) Math.floor(sumProcessingTime() * h);
        computeGoalFunction(h, deadline);

        int currentTime = 0;
        ArrayList<Task> scheduledTasks = new ArrayList<>(this.tasks.size());
        for(int i=0; i<this.tasks.size(); i++) {
            if(currentTime < deadline) {

            }
            else {

            }
        }
    }

    private void computeGoalFunction(double h, int deadline) {
        int currentTime = startTime;
        int offset = 0;
        for(Task task : this.tasks) {
            currentTime += task.getProcessingTime();
            offset = deadline - currentTime;
            this.goalFunction += offset > 0 ? Math.abs(offset) * task.getEarlyPenalty() : Math.abs(offset) * task.getLatePenalty();
        }
    }

    private int
}
