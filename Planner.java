import java.io.IOException;

public class Planner {
    public static void main(String[] args) throws IOException {
        Performer victor = new Performer("Виктор");
        Performer ivan = new Performer("Иван");
        Task task1 = new HighTaskPriority("Сделай красиво");
        Task task2 = new LowTaskPriority("Сделай когда-нибудь");
        Task task3 = new AvarageTaskPriority("Решай задачу");

        Save myList = new Save();
        myList.save(task1, victor);
        myList.save(task2, victor);
        myList.save(task3, ivan);

        System.out.println(myList);
        ImportExport ie = new ImportExport();
        ie.exportExcel(myList);
        ie.importExcel(myList);
    }
}