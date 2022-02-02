package no.ntnu.crudrest;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Project {
    @ApiModelProperty
    private int id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String leader;
    @ApiModelProperty
    private int budget;
    @ApiModelProperty
    private Date startDate;
    @ApiModelProperty
    private Date endDate;

    public Project(int id, String name, String leader, int budget, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.leader = leader;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
