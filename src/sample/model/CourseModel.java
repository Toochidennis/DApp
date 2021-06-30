package sample.model;

import java.sql.SQLException;

public class CourseModel extends AppModel{
    private String title;
    private String instructor;
    private String duration;
    private String description;
    private String table;

    public CourseModel() {
    }

    public CourseModel(String title, String instructor, String duration, String description) {
        this.title = title;
        this.instructor = instructor;
        this.duration = duration;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
    
    public boolean insertCourse(String title, String instructor,
                                String duration, String description,
                                String table) throws SQLException {
       if(super.insert(title, instructor, duration, description, table));

        return true;
    }
}
