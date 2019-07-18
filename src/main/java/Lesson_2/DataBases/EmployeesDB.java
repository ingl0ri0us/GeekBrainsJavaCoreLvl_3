package Lesson_2.DataBases;

//import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;

public class EmployeesDB {
    private static Connection conn;
    private static Statement statement;

    public static void main(String[] args) throws SQLException {
        try {
            connection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        createTableEmployees();

        addNewEmployee(1, "Ivan", "Ivanov", "Director", 200000.00);
        addNewEmployee(2, "Anna", "Annova", "Accountant", 150000.00);
        addNewEmployee(3, "Petr", "Petrov", "Manager", 100000.00);
        addNewEmployee(4, "Mihail", "Mihalkov", "Specialist", 80000.00);
        addNewEmployee(5, "Taras", "Tarasov", "Specialist", 75000.00);
        addNewEmployee(6, "Sergey", "Sergeev", "Specialist", 70000.00);
        addNewEmployee(7, "Svetlana", "Svetlanova", "Office Manager", 60000.00);

        deleteEmployeeById(7);

        updateSalaryBySurname("Sergeev", 75000.000);

        printAllEmployees();

        deleteAllEmployees();

        dropTable();

        disconnect();
    }

    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:employeesDB.db");
        statement = conn.createStatement();
    }

    public static void disconnect() throws SQLException {
        conn.close();
    }

    public static void addNewEmployee (int id, String name, String surname, String position, double salary) throws SQLException {
      PreparedStatement preparedStatement = conn.prepareStatement("insert into " +
               "employees (employee_id, employee_name, employee_surname, employee_position, employee_salary)" +
               "values (?, ?, ?, ?, ?);");
       preparedStatement.setInt(1, id);
       preparedStatement.setString(2, name);
       preparedStatement.setString(3, surname);
       preparedStatement.setString(4, position);
       preparedStatement.setDouble(5, salary);
       preparedStatement.executeUpdate();
    }
    public static void deleteEmployeeById(int id) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("delete from employees where employee_id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public static void deleteAllEmployees() throws SQLException {
        statement.executeUpdate("delete from employees");
    }

    public static void createTableEmployees() throws SQLException {
        statement.executeUpdate("CREATE TABLE employees (" +
                "employee_id       INTEGER NOT NULL PRIMARY KEY," +
                "employee_name     STRING  NOT NULL," +
                "employee_surname  STRING  NOT NULL," +
                "employee_position STRING  NOT NULL," +
                "employee_salary   DOUBLE  NOT NULL)");
    }

    public static void dropTable() throws SQLException {
        statement.executeUpdate("drop table employees");
    }

    public static void updateSalaryBySurname (String surname, double newSalary) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update employees " +
                                                                        "set employee_salary = ? " +
                                                                        "where employee_surname = ?");
        preparedStatement.setDouble(1, newSalary);
        preparedStatement.setString(2, surname);
        preparedStatement.executeUpdate();
    }

    public static void printAllEmployees() throws SQLException {
        ResultSet rs = statement.executeQuery("select employee_id, employee_name, employee_surname, employee_position, employee_salary " +
                "from employees");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " +
                    rs.getString("employee_name") + " " +
                    rs.getString("employee_surname") + " " +
                    rs.getString("employee_position") + " " +
                    rs.getDouble("employee_salary"));
        }
    }
}
