package main.dao;

import main.model.Student;
import main.util.DBUtil;

import java.sql.*;
import java.util.*;
import java.io.FileInputStream;

public class StudentDAO {
    private Properties queries;

    public StudentDAO() {
        try {
            queries = new Properties();
            queries.load(new FileInputStream("src/properties/queries.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addStudent(Student s) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queries.getProperty("insert"))) {

            stmt.setString(1, s.getRollNo());
            stmt.setString(2, s.getName());
            stmt.setString(3, s.getGrade());
            stmt.setString(4, s.getEmail());
            stmt.setString(5, s.getPhone());
            stmt.setString(6, s.getAddress());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student s) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queries.getProperty("update"))) {

            stmt.setString(1, s.getName());
            stmt.setString(2, s.getGrade());
            stmt.setString(3, s.getEmail());
            stmt.setString(4, s.getPhone());
            stmt.setString(5, s.getAddress());
            stmt.setString(6, s.getRollNo());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(String rollNo) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queries.getProperty("delete"))) {

            stmt.setString(1, rollNo);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Student getStudent(String rollNo) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queries.getProperty("select_one"))) {

            stmt.setString(1, rollNo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getString("roll_no"),
                        rs.getString("name"),
                        rs.getString("grade"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queries.getProperty("select_all"));
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getString("roll_no"),
                        rs.getString("name"),
                        rs.getString("grade"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
