package se.amanda.databasuppgift;

import java.sql.Date;

public class WorkRole {
    private int roleId;
    private String title;
    private String description;
    private double salary;
    private Date creationDate;

    public WorkRole(String title, String description, double salary, Date creationDate) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creationDate = creationDate;
    }

    public WorkRole(int roleId, String title, String description, double salary, Date creationDate) {
        this.roleId = roleId;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.creationDate = creationDate;
    }
    public int getRoleId() {
        return roleId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Workrole{" +
                "roleId=" + roleId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", creation date=" + creationDate +
                '}';
    }

}
