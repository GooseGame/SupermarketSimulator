package classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandList {
    private Map<Integer, List<Command>> cl = new HashMap<Integer, List<Command>>();

    CommandList() {
        for (int i = 0; i < new Data().getGameLoop(); i++) {
            cl.put(i, null);
        }
    }
    private void addToRecent(int i, Command command) {
        List<Command> list = cl.get(i);
        list.add(command);
        cl.replace(i, list);
    }
    private void addNew(int i, Command command) {
        cl.replace(i, List.of(command));
    }
    public int size() {
        return cl.size();
    }
    public void add(int i, Command command) {
        if (get(i) != null) {
            addToRecent(i, command);
        }
        else addNew(i, command);
    }
    private List<Command> get(int i) {
        return cl.get(i);
    }
}
