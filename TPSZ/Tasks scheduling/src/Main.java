public class Main {
    public static void main(String[] args) {
        String instancesPath = "instances/";
        double h = 0.8;
        Instance[] instances = new InstancesLoader(instancesPath + "sch1000.txt").load();
        for(int i=0; i<instances.length; i++) {
            instances[i].schedule(h);
            instances[i].saveToFile(i, h);
        }
//        if(Tester.test(instancesPath + "sch10.txt", "results/n10k3h2.txt"))
//            System.out.println("Ok");
//        else
//            System.out.println("!OK");
    }
}
