public class Main {
    public static void main(String[] args) {
        InstancesLoader loader = new InstancesLoader("sch10.txt");
        Instance[] instances = loader.load();
        instances[0].saveToFile(0, 0.2);
    }
}
