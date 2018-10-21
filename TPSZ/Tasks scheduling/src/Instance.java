public class Instance {
    private Task tasks[];

    public Instance(int tasksCount) {
        if(tasksCount > 0)
            this.tasks = new Task[tasksCount];
    }
    public Instance(Task tasks[]) {
        this.tasks = tasks;
    }

    public Task[] getTasks() {
        return tasks;
    }
}
