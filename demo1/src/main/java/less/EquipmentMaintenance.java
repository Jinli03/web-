package good;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class EquipmentMaintenance {
    private String equipmentName;
    private Date lastMaintenanceDate;
    private int maintenanceIntervalDays;

    public EquipmentMaintenance(String equipmentName, Date lastMaintenanceDate, int maintenanceIntervalDays) {
        this.equipmentName = equipmentName;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.maintenanceIntervalDays = maintenanceIntervalDays;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public Date getNextMaintenanceDate() {
        long nextMaintenance = lastMaintenanceDate.getTime() + ((long) maintenanceIntervalDays * 24 * 60 * 60 * 1000);
        return new Date(nextMaintenance);
    }
}

class GastronomicEquipmentMaintenanceScheduler {
    private Map<String, EquipmentMaintenance> maintenanceSchedule;

    public GastronomicEquipmentMaintenanceScheduler() {
        maintenanceSchedule = new HashMap<>();
    }

    public void scheduleMaintenance(String equipmentName, Date lastMaintenanceDate, int intervalDays) {
        EquipmentMaintenance maintenance = new EquipmentMaintenance(equipmentName, lastMaintenanceDate, intervalDays);
        maintenanceSchedule.put(equipmentName, maintenance);
    }

    public void printMaintenanceSchedule() {
        System.out.println("Equipment Maintenance Schedule:");
        for (EquipmentMaintenance maintenance : maintenanceSchedule.values()) {
            System.out.println(maintenance.getEquipmentName() + " - Next Maintenance: " + maintenance.getNextMaintenanceDate());
        }
    }

    // 示例用法
    public static void main(String[] args) {
        GastronomicEquipmentMaintenanceScheduler scheduler = new GastronomicEquipmentMaintenanceScheduler();
        scheduler.scheduleMaintenance("Oven", new Date(), 90);
        scheduler.scheduleMaintenance("Refrigerator", new Date(), 180);
        scheduler.printMaintenanceSchedule();
    }
}
