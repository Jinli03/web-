package good;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class ArcaneCleaningScheduler {
    private Map<String, Date> cleaningSchedule;

    public ArcaneCleaningScheduler() {
        cleaningSchedule = new HashMap<>();
    }

    public void scheduleCleaning(String area, Date date) {
        cleaningSchedule.put(area, date);
    }

    public void printCleaningSchedule() {
        System.out.println("Kitchen Cleaning Schedule:");
        cleaningSchedule.forEach((area, date) ->
                System.out.println(area + " - " + date.toString()));
    }

    // 示例用法
    public static void main(String[] args) {
        ArcaneCleaningScheduler scheduler = new ArcaneCleaningScheduler();
        scheduler.scheduleCleaning("Grill Area", new Date());
        scheduler.scheduleCleaning("Prep Station", new Date());
        scheduler.printCleaningSchedule();
    }
}
