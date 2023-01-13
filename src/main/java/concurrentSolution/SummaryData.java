package concurrentSolution;

public class SummaryData {
    Integer Date;
    Integer totalClicks;

    public SummaryData() {
    }

    public SummaryData(Integer date, Integer totalClicks) {
        Date = date;
        this.totalClicks = totalClicks;
    }

    public Integer getDate() {
        return Date;
    }

    public void setDate(Integer date) {
        Date = date;
    }

    public Integer getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(Integer totalClicks) {
        this.totalClicks = totalClicks;
    }

    @Override
    public String toString() {
        return "SummaryData{" +
                "Date=" + Date +
                ", totalClicks='" + totalClicks + '\'' +
                '}';
    }
}
