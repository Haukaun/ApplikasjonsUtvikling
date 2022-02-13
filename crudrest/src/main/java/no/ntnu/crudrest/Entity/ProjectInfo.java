package no.ntnu.crudrest.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectInfo {
        @Id
        private String projectName;
        private String planName;
        private int cost;


    public ProjectInfo(String projectName, String planName, int cost) {
            this.projectName = projectName;
            this.planName = planName;
            this.cost = cost;
        }

    public ProjectInfo() {

    }

    public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getPlanName() {
            return planName;
        }

        public void setPlanName(String planName) {
            this.planName = planName;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }


}
