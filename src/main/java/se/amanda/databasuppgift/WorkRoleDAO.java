package se.amanda.databasuppgift;

import java.sql.SQLException;
import java.util.List;

public interface WorkRoleDAO {

    void insertWorkRole(WorkRole workRole) throws SQLException;

    List<WorkRole> getAllWorkRoles() throws SQLException;

    WorkRole getWorkRoleById(int roleId) throws SQLException;

    void updateWorkRole(WorkRole workRole) throws SQLException;

    void deleteWorkRole(int roleId) throws SQLException;
}


