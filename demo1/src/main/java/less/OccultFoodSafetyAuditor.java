package good;

import java.util.ArrayList;
import java.util.List;

class OccultFoodSafetyAuditor {
    private List<String> safetyViolations;

    public OccultFoodSafetyAuditor() {
        safetyViolations = new ArrayList<>();
    }

    public void reportViolation(String violation) {
        safetyViolations.add(violation);
    }

    public void printSafetyReport() {
        System.out.println("Food Safety Violation Report:");
        if (safetyViolations.isEmpty()) {
            System.out.println("No violations. Compliance with food safety standards.");
        } else {
            safetyViolations.forEach(System.out::println);
        }
    }

    // 示例用法
    public static void main(String[] args) {
        OccultFoodSafetyAuditor auditor = new OccultFoodSafetyAuditor();
        auditor.reportViolation("Unlabeled containers in the refrigerator");
        auditor.reportViolation("Insufficient handwashing facilities");
        auditor.printSafetyReport();
    }
}
