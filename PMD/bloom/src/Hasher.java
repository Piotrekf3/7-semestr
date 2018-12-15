import java.util.ArrayList;
import java.util.Random;

public class Hasher {

    private ArrayList<Integer> a;
    private ArrayList<Integer> b;
    private int mod;

    public Hasher(int max, int mod, int hashFunctionsNumber) {
        this.mod = mod;
        this.a = generateRandomArray(max, hashFunctionsNumber);
        this.b = generateRandomArray(max, hashFunctionsNumber);
    }

    public int hash(int value, int functionNumber) {
        if(functionNumber >= 0 && functionNumber < this.getFunctionsCount()) {
            return (int)(((long)this.a.get(functionNumber) * value + b.get(functionNumber)) % mod);
        }
        System.err.println("Invalid hash function number");
        return 0;
    }

    public int getFunctionsCount() {
        return this.a.size();
    }

    private ArrayList<Integer> generateRandomArray(int max, int hashFunctionsNumber) {
        ArrayList<Integer> array = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i<hashFunctionsNumber; i++) {
            array.add(rand.nextInt(max - 1) + 1);
        }
        return array;
    }
}
