package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String ERROR_COURSE = "[ERROR] 존재하지 않는 과정입니다.";
    private final String course;

    Course(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public static String getCourses() {
        List<String> courses = new ArrayList<>();
        for (Course course : Course.values()) {
            courses.add(course.getCourse());
        }
        return String.join(" | ", courses);
    }

    public static void validate(String inputCourse) {
        for (Course course : Course.values()) {
            if (course.getCourse().equals(inputCourse)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_COURSE);
    }
}
