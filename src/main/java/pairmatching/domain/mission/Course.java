package pairmatching.domain.mission;

import java.util.Objects;

public class Course {

    private static final String ERROR_COURSE = "[ERROR] 존재하지 않는 과정입니다.";
    private static final String FRONTEND = "프론트엔드";
    private static final String BACKEND = "백엔드";

    String course;

    public Course(String course) {
        this.course = course;
        validate();
    }

    private void validate() {
        if (!course.equals(BACKEND) && !course.equals(FRONTEND)) {
            throw new IllegalArgumentException(ERROR_COURSE);
        }
    }

    public static String getCourses() {
        return BACKEND
                + " | "
                + FRONTEND;
    }

    public Course getBackend() {
        return new Course(BACKEND);
    }

    public Course getFrontend() {
        return new Course(FRONTEND);
    }

    public String getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course1 = (Course) o;
        return Objects.equals(course, course1.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}
