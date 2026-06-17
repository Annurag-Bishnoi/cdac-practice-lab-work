package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Student;
import util.DbConnection;

public class StudentDAO {

    public boolean insertStudent(Student s) throws Exception {
        String sql = "INSERT INTO student(name, email, phone, age, course) VALUES (?, ?, ?, ?, ?)";

        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getPhone());
        ps.setInt(4, s.getAge());
        ps.setString(5, s.getCourse());

        int row = ps.executeUpdate();

        return row > 0;
    }

    public ArrayList<Student> getAllStudents() throws Exception {
        ArrayList<Student> list = new ArrayList<>();

        String sql = "SELECT * FROM student";

        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Student s = new Student();

            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setPhone(rs.getString("phone"));
            s.setAge(rs.getInt("age"));
            s.setCourse(rs.getString("course"));

            list.add(s);
        }

        return list;
    }

    public Student getStudentById(int id) throws Exception {
        Student s = null;

        String sql = "SELECT * FROM student WHERE id = ?";

        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            s = new Student();

            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setPhone(rs.getString("phone"));
            s.setAge(rs.getInt("age"));
            s.setCourse(rs.getString("course"));
        }

        return s;
    }

    public boolean updateStudent(Student s) throws Exception {
        String sql = "UPDATE student SET name=?, email=?, phone=?, age=?, course=? WHERE id=?";

        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getPhone());
        ps.setInt(4, s.getAge());
        ps.setString(5, s.getCourse());
        ps.setInt(6, s.getId());

        int row = ps.executeUpdate();

        return row > 0;
    }

    public boolean deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM student WHERE id=?";

        Connection con = DbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int row = ps.executeUpdate();

        return row > 0;
    }
}