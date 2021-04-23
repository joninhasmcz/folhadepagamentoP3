package classesJava;

public class TimeCard {
    private String employeeId;
    private String entry;
    private String exit;

    public TimeCard(String employeeId, String entry, String exit) {
        this.employeeId = employeeId;
        this.entry = entry;
        this.exit = exit;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }
}
