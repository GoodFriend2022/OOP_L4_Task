import java.util.ArrayList;
import java.util.HashMap;

public interface Save<T extends Task> {

    HashMap<Integer, Task> listTasks = new HashMap<>();

    public void save(T task);
}
