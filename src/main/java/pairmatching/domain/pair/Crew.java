package pairmatching.domain.pair;

import pairmatching.domain.mission.Course;

public class Crew {

    Course course;
    String name;

    public Crew(Course course, String name){
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
