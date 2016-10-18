package name.dieremieiev.projects.hbeats.model;

public class Capability {
    private String name;
    private String description;
    private Long dayLimit;
    private Long weekLimit;
    private Long monthLimit;

    public Long getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(Long dayLimit) {
        this.dayLimit = dayLimit;
    }

    public Long getWeekLimit() {
        return weekLimit;
    }

    public void setWeekLimit(Long weekLimit) {
        this.weekLimit = weekLimit;
    }

    public Long getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(Long monthLimit) {
        this.monthLimit = monthLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
