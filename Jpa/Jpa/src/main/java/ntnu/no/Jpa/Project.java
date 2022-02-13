package ntnu.no.Jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Project {
    @Id
    private int id;

    private String name;

    private String leader;

    private int budget;

    private LocalDate startDate;

    private LocalDate endDate;

    public Project() {

    }

    protected Project(int id, String name, String leader, int budget, String startDate, String endDate) {
        super();
        this.id = id;
        this.name = name;
        this.leader = leader;
        this.budget = budget;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public boolean isValid(){
        return id > 0 && name != null && leader != null && budget > 0 && startDate != null && endDate !=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
