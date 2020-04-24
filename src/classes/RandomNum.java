package classes;

import java.util.Random;

public class RandomNum {
    private int seed;
    public RandomNum(int bound) {
        if (bound == 0) {
            this.seed = 0;
        }
        else {
            this.seed = new Random().nextInt(bound);
        }
    }

    public int getSeed() {
        if (seed == 0) {
            return 1;
        }
        else return seed;
    }
}
