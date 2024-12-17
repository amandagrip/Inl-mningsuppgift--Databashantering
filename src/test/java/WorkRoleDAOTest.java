import org.junit.jupiter.api.*;
import se.amanda.databasuppgift.JDBCHelper;
import se.amanda.databasuppgift.WorkRoleDAOImpl;
import se.amanda.databasuppgift.WorkRole;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class WorkRoleDAOTest {

    private static Connection connection;
    private static WorkRoleDAOImpl workRoleDAO;

    @BeforeAll
    public static void setUp() throws SQLException {
        //connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        connection = JDBCHelper.getConnection();
        workRoleDAO = new WorkRoleDAOImpl();

//        try (Statement stmt = connection.createStatement()) {
//            stmt.execute("CREATE TABLE work_role (" +
//                    "role_id INT AUTO_INCREMENT PRIMARY KEY, " +
//                    "title VARCHAR(50), " +
//                    "description VARCHAR(255), " +
//                    "salary DOUBLE, " +
//                    "creation_date DATE)");
//        }
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testInsertAndGetWorkRole() throws SQLException {

        WorkRole workRole = new WorkRole("Systemutvecklare", "Kodar", 60000.0, Date.valueOf("2024-01-01"));
        workRoleDAO.insertWorkRole(workRole);

        List<WorkRole> workRoles = workRoleDAO.getAllWorkRoles();
        assertEquals(1, workRoles.size());

        WorkRole testRole = workRoles.get(0);
        assertEquals("Systemutvecklare", testRole.getTitle());
        assertEquals("Kodar", testRole.getDescription());
        assertEquals(60000.0, testRole.getSalary());
        assertEquals(Date.valueOf("2024-01-01"), testRole.getCreationDate());
    }
}



