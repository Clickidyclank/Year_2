package Controllers;

import Other_Objects.Class_Group;
import Other_Objects.Module_Grade;
import Person_super.Name;
import Person_super.Student;
import Person_super.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class Database_controller {


    private static final String DATABASEURL = "jdbc:mysql://localhost/school";
    private Connection connection;

    Database_controller() {
        //how we connect to the database
        {
            try {
                this.connection = DriverManager.getConnection(DATABASEURL, "root", "root");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    ObservableList<Class_Group> loadClassGroups() {
        //loads class groups into
        ObservableList<Class_Group> classGroupObservableList = FXCollections.observableList(new ArrayList<>());

        Statement statement;
        ResultSet tableSet;
        ResultSet studentSet;

        try {
            statement = connection.createStatement();
            tableSet = statement.executeQuery("SHOW TABLES WHERE Tables_in_school != \"teachers\"");

            //array list of strings with classgroupnames
            ArrayList<String> classGroupNames = new ArrayList<>();

            //for each row we take whats in colume 1 and add to the array list
            while (tableSet.next()) {
                classGroupNames.add(tableSet.getString(1));
            }

            //creates class groups from arraylist of names
            for (String s : classGroupNames) {

                Class_Group classGroup = new Class_Group(s);

                String sql = "SELECT * FROM " + s;
                studentSet = statement.executeQuery(sql);


                while (studentSet.next()) {
                    Student student = new Student(
                            new Name(studentSet.getString(1), studentSet.getString(2), studentSet.getString(3)),
                            studentSet.getString(4), studentSet.getInt(5), studentSet.getString(6), classGroup);
                    student.addModule(new Module_Grade(studentSet.getString(7), studentSet.getInt(8)));
                    student.addModule(new Module_Grade(studentSet.getString(9), studentSet.getInt(10)));
                    student.addModule(new Module_Grade(studentSet.getString(11), studentSet.getInt(12)));
                    student.addModule(new Module_Grade(studentSet.getString(13), studentSet.getInt(14)));
                    student.addModule(new Module_Grade(studentSet.getString(15), studentSet.getInt(16)));
                    student.addModule(new Module_Grade(studentSet.getString(17), studentSet.getInt(18)));


                    classGroup.getStudentArrayList().add(student);
                }
                classGroupObservableList.add(classGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classGroupObservableList;

    }

    ObservableList<Teacher> loadTeachers() {

        ObservableList<Teacher> teacherObservableList = FXCollections.observableList(new ArrayList<>());

        Statement statement;
        ResultSet resultSet;


        try {
            statement = connection.createStatement();


            //creates class groups from arraylist of names


            String sql = "SELECT * FROM teachers";
            resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                Teacher teacher = new Teacher(
                        new Name(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)),
                        resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));
                teacherObservableList.add(teacher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherObservableList;

    }


    public void addStudent(Student student) {

        try {
            String sql = "insert into " + student.getClass_group().getName() +
                    "(fname,lname,mname,email,phoneNum,DOB,m1,grade1,m2,grade2,m3,grade3,m4,grade4,m5,grade5,m6,grade6) " +
                    "values(\"" + student.getName().getFname() + "\", \"" + student.getName().getLname() + "\", \"" + student.getName().getMname() + "\", \"" +
                    student.getEmail() + "\"," + student.getPhoneNum() + ",\"" + student.getDob() + "\", \"" + student.getModules().get(0).getModule() + "\"," +
                    student.getModules().get(0).getGrade() + ",\"" + student.getModules().get(1).getModule() + "\"," +
                    student.getModules().get(1).getGrade() + ",\"" + student.getModules().get(2).getModule() + "\"," +
                    student.getModules().get(2).getGrade() + ",\"" + student.getModules().get(3).getModule() + "\"," +
                    student.getModules().get(3).getGrade() + ",\"" + student.getModules().get(4).getModule() + "\"," +
                    student.getModules().get(4).getGrade() + ",\"" + student.getModules().get(5).getModule() + "\"," +
                    student.getModules().get(5).getGrade() + ")";
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeStudent(Student student) {

        try {
            String sql = "delete from " + student.getClass_group().getName() + " where phoneNum = " + student.getPhoneNum();


            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createClass(String className) {
        try {
            String sql = "create table if not exists " + className + " (fname varchar (255) ,\n" +
                    "    lname varchar (255),\n" +
                    "    mname varchar (255),\n" +
                    "    email varchar (255),\n" +
                    "    phoneNum int (255),\n" +
                    "    DOB varchar (255),\n" +
                    "    primary key(phoneNum),\n" +
                    "    m1 varchar(255),\n" +
                    "    grade1 int(255),\n" +
                    "    m2 varchar(255),\n" +
                    "    grade2 int(255),\n" +
                    "    m3 varchar(255),\n" +
                    "    grade3 int(255),\n" +
                    "    m4 varchar(255),\n" +
                    "    grade4 int(255),\n" +
                    "    m5 varchar(255),\n" +
                    "    grade5 int(255),\n" +
                    "    m6 varchar(255),\n" +
                    "    grade6 int(255));";

            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addTeacher(Teacher teacher) {

        try {
            String sql = "insert into teachers (fname,lname,mname,email,phoneNum,degree) " +
                    "values(\"" + teacher.getName().getFname() + "\", \"" + teacher.getName().getLname() + "\", \"" + teacher.getName().getMname() + "\", \"" +
                    teacher.getEmail() + "\"," + teacher.getPhoneNum() + ",\"" + teacher.getDegree() + "\")";
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void removeTeacher(Teacher teacher) {
        try {
            String sql = "delete from teachers where phoneNum = " + teacher.getPhoneNum();


            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
