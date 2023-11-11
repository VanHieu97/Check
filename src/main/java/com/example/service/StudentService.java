package com.example.service;

import com.example.connectdatabase.DatabaseConnection;
import com.example.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudent<Student>{
    Connection connection = DatabaseConnection.getConnection();

    public StudentService() {
    }

    @Override
    public void add(Student student) {
        String sql = "insert into student(name, email, birthday, address, classId)\n" +
                "values (?, ? ,? ,? ,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setDate(3, Date.valueOf(student.getBirthday()));
            statement.setString(4,student.getAddress());
            statement.setInt(5,student.getClassId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "select s.id, s.name, s.email, s.birthday, s.address,c.id, c.name as className\n" +
                "from student s\n" +
                "         join classroom c on c.id = s.classId\n" +
                "where s.deleteFlag = 0";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                String address = resultSet.getString("address");
                int classId = resultSet.getInt("classId");
                String className = resultSet.getString("className");
                Student student = new Student(id,name,email,birthday,address,classId,className);
                list.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void edit(int id, Student student) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }
}
