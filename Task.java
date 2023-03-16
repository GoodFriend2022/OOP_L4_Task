import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;

public abstract class Task {
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy HH:mm");  
    private int time;
    private String textTask;
    private Date nowDate;
    private LocalDateTime d; 
    private Date deadline;  
    
    public Task(String textTask, int time) {
        this.textTask = textTask;
        this.nowDate = new Date();
        d = nowDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        d = d.plusDays(time);
        this.deadline = Date.from(d.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public int getTime() {
        return time;
    }
    
    public void setTime(int time) {
        this.time = time;
    }
    
    public String getTextTask() {
        return textTask;
    }
    
    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }
    
    public Date getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return String.format("Добавлена: %s Дедлайн: %s Задача: (%s)", 
            formatForDateNow.format(nowDate), formatForDateNow.format(deadline), textTask);
    }
}
