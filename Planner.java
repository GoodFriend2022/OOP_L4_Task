public class Planner {
    public static void main(String[] args) {
        Performer victor = new Performer("Виктор");
        Task task1 = new HighTaskPriority("Сделай красиво");
        Task task2 = new LowTaskPriority("Сделай когда-нибудь");
        
        victor.save(task1);
        victor.save(task2);

        System.out.println(victor.getpTask());
    }
}