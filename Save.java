import java.util.ArrayList;
public class Save {

    private ArrayList<ArrayList<String>> pTask = new ArrayList<>();
    private ArrayList<String> listTasks;
    int index = 0;
    
    public ArrayList<ArrayList<String>> getpTask() {
        return pTask;
    }
   
    public void save(Task task, Performer pf) {
        this.listTasks = new ArrayList<>();
        this.listTasks.add(String.format("%s", pTask.size() + 1));
        this.listTasks.addAll(task.getT());
        this.listTasks.add(pf.toString());
        this.pTask.add(this.listTasks);
    }

    @Override
    public String toString() {
        return String.format("%s", pTask);
    }
}
