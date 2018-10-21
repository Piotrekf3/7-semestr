import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InstancesLoader {
    private String filename;

    public InstancesLoader(String filename) {
        this.filename = filename;
    }

    public Instance[] load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            int instancesCount = readNumber(reader);
            int tasksCount;
            for(int instanceNumber=0; instanceNumber<instancesCount; instanceNumber++) {
                tasksCount = readNumber(reader);
                for(int taskNumber=0; taskNumber<tasksCount; taskNumber++) {

                }
            }


        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return new Instance[] {};
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private int readNumber(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        line = line.replaceAll("\\s+","");
        return Integer.parseInt(line);
    }
}
