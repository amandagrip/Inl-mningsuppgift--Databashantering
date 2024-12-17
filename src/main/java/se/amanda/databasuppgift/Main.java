package se.amanda.databasuppgift;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WorkRoleDAOImpl workRoleDAO = new WorkRoleDAOImpl();

        try {
            WorkRole workRole = new WorkRole("Lärare", "Lär ut", 40000.0, Date.valueOf("2022-09-19"));
            workRoleDAO.insertWorkRole(workRole);
            System.out.println("Ny arbetsroll tillagd.");

            List<WorkRole> workRoles = workRoleDAO.getAllWorkRoles();
            for (WorkRole role : workRoles) {
                System.out.println(role.getTitle());
            }

            WorkRole getRole = workRoleDAO.getWorkRoleById(3);
            System.out.println("Hämtad arbetsroll: " + getRole);

            if (getRole != null) {
                getRole.setSalary(100000.0);
                workRoleDAO.updateWorkRole(getRole);
                System.out.println("Arbetsrollen uppdaterades.");
            }

            workRoleDAO.deleteWorkRole(3);
            System.out.println("Arbetsrollen togs bort.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

