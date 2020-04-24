package classes;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Integer> q = new ArrayList<>();

    int getQueueByTime(int time) {
        return new RandomNum(new Data().getQueueDelayTimeLimit()).getSeed();
    }
}
