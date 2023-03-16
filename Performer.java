import java.util.HashMap;

public class Performer implements Save<Task> {
    private String name;

    private HashMap<String, HashMap<Integer, Task>> pTask = new HashMap<>();
    
    public HashMap<String, HashMap<Integer, Task>> getpTask() {
        return pTask;
    }

    public Performer(String name) {
        this.name = name;
    }

    public Performer() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save(Task task) {
        listTasks.put(listTasks.size() + 1, task);
        this.pTask.put(this.name, listTasks);
    }
    
    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
