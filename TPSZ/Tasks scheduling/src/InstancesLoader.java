import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InstancesLoader {
    private File file;

    public InstancesLoader(File file) {
        this.file = file;
    }

    public Instance[] load() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {

        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
