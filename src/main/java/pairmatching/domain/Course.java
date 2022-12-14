package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String course;

    Course(String course) {
        this.course = course;
    }

    public String getCourse(){
        return course;
    }

    public static String getCourses(){
        List<String>courses = new ArrayList<>();
        for(Course course : Course.values()){
            courses.add(course.getCourse());
        }
        return String.join(" | ",courses);
    }
}
