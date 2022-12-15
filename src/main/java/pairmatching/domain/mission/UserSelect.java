package pairmatching.domain.mission;

public class UserSelect {

    Course course;
    Level level;
    Mission mission;

    public UserSelect(Course course, Level level, Mission mission) {
        this.course  = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }
    public Mission getMission() {
        return mission;
    }
    @Override
    public String toString(){
        return course.getCourse() + level.getLevel() + mission.getMission();
    }
}
