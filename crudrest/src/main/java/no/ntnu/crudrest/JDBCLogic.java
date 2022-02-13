package no.ntnu.crudrest;

import java.sql.*;
import java.time.LocalDate;

public class JDBCLogic {
    private static Connection con = connect();


    public static Connection connect() {

        //getting the JDBC sql lite driver
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //path for database and connection
        try {
            con = DriverManager.getConnection("jdbc:sqlite:empty_db.db");
            System.out.println("Connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public ResultSet showAllProjects() {
        PreparedStatement prepared;
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM Project";
            prepared = con.prepareStatement(sql);
            result = prepared.executeQuery();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String UpdateDeadline(String endDate, int projectID) {
        PreparedStatement prepared;
        try{
            prepared = connect().prepareStatement("UPDATE Project SET endDate = (?) WHERE projectID = (?)");
            prepared.setObject(1, LocalDate.parse(endDate));
            prepared.setInt(2,projectID);
            prepared.execute();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return "Update Completed";
    }

    public ResultSet getPlansWithLeastCost() {
        PreparedStatement prepared;
        ResultSet result = null;
        try {
            prepared = con.prepareStatement("SELECT Project.name AS 'Project', Plan.name AS 'Plan', MIN(planCost.totalCost) AS 'Cost' FROM Plan, " +
                    "(SELECT PlanEmployee.pID, SUM(Employee.cost) AS totalCost FROM PlanEmployee" +
                    " INNER JOIN Employee ON PlanEmployee.eID = Employee.eID" +
                    " GROUP BY PlanEmployee.pID) AS planCost" +
                    " INNER JOIN Project ON Plan.projectID = Project.projectID " +
                    " WHERE Plan.pID = planCost.pID" +
                    " GROUP BY Project.projectID" +
                    " ORDER BY Plan.name");
            result = prepared.executeQuery();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
