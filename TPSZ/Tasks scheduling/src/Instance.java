import java.io.*;
import java.util.*;

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
        String filename = "results//n" + this.tasks.size() + "k" + instanceNumber + "h" + h + ".txt";
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

        int currentTime = 0;
        ArrayList<Task> scheduledTasks = new ArrayList<>(this.tasks.size());
        Collections.sort(this.tasks, new SortByEarlyPenalty());

        for(int i=0; i<this.tasks.size(); i++) {
            currentTime += this.tasks.get(i).getProcessingTime();
            if(currentTime > deadline) {
                Collections.sort(this.tasks.subList(i, this.tasks.size()), new SortByLatePenalty());
                break;
            }
        }
        computeGoalFunction(h, deadline);
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

//    private int findMinPenaltyId(boolean earlyPenaly = false) {
//        int min = this.tasks.get(0).getEarlyPenalty();
//        int index = 0;
//        int penalty;
//        for(int i=1; i<this.tasks.size(); i++) {
//            penalty = this.tasks.get(i).getEarlyPenalty();
//            if(penalty < min) {
//                min = penalty;
//                index = i;
//            }
//        }
//
//        return index;
//    }
}
