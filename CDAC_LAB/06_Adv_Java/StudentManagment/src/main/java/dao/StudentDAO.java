package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBUtil;



public class StudentDAO {

    public boolean saveStudent(Student student) {

        boolean status = false;

        String sql = "INSERT INTO student(name, email, phone, course, age) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getAge());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }


    public List<Student> getAllStudents() {

        List<Student> studentList = new ArrayList<>();

        String sql = "SELECT * FROM student";

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setCourse(rs.getString("course"));
                student.setAge(rs.getInt("age"));

                studentList.add(student);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
}