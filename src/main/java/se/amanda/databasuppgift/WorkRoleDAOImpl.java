package se.amanda.databasuppgift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class WorkRoleDAOImpl implements WorkRoleDAO {

    public void insertWorkRole(WorkRole workRole) throws SQLException {
        String sql = "INSERT INTO work_role (title, description, salary, creation_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, workRole.getTitle());
            pstmt.setString(2, workRole.getDescription());
            pstmt.setDouble(3, workRole.getSalary());
            pstmt.setDate(4, workRole.getCreationDate());
            pstmt.executeUpdate();
        }
    }

    public List<WorkRole> getAllWorkRoles() throws SQLException {
        String sql = "SELECT * FROM work_role";
        List<WorkRole> workRoles = new ArrayList<>();
        try (Connection conn = JDBCHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                WorkRole workRole = new WorkRole(
                        rs.getInt("role_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("salary"),
                        rs.getDate("creation_date")
                );
                workRoles.add(workRole);
            }
        }
        return workRoles;
    }

    public WorkRole getWorkRoleById(int roleId) throws SQLException {
        String sql = "SELECT * FROM work_role WHERE role_id = ?";
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roleId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new WorkRole(
                            rs.getInt("role_id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getDouble("salary"),
                            rs.getDate("creation_date")
                    );
                }
            }
        }
        return null;
    }

    public void updateWorkRole(WorkRole workRole) throws SQLException {
        String sql = "UPDATE work_role SET title = ?, description = ?, salary = ?, creation_date = ? WHERE role_id = ?";
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, workRole.getTitle());
            pstmt.setString(2, workRole.getDescription());
            pstmt.setDouble(3, workRole.getSalary());
            pstmt.setDate(4, workRole.getCreationDate());
            pstmt.setInt(5, workRole.getRoleId());
            pstmt.executeUpdate();
        }
    }

    public void deleteWorkRole(int roleId) throws SQLException {
        String sql = "DELETE FROM work_role WHERE role_id = ?";
        try (Connection conn = JDBCHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roleId);
            pstmt.executeUpdate();
        }
    }
}

