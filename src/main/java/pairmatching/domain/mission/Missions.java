package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Missions {

    List<Mission> missions;

    public Missions(){

    }
    
    public Missions(List<Mission>missions){
        this.missions = missions;
    }
    
    public Missions getLevelOneMissions(){
        List<Mission>missions = Arrays.asList(new Mission("자동차경주"), new Mission("로또"), new Mission("숫자야구게임"));
        return new Missions(missions);
    }

    public Missions getLevelTwoMissions(){
        List<Mission>missions = Arrays.asList(new Mission("장바구니"), new Mission("결제"), new Mission("지하철노선도"));
        return new Missions(missions);
    }

    public Missions getLevelFourMissions(){
        List<Mission>missions = Arrays.asList(new Mission("성능개선"), new Mission("배포"));
        return new Missions(missions);
    }

    public Missions getLevelThreeMissions(){
        return new Missions(new ArrayList<>());
    }

    public Missions getLevelFiveMissions(){
        return new Missions(new ArrayList<>());
    }

    public String toString(){
        List<String>missionName = new ArrayList<>();
        for(Mission mission : missions){
            missionName.add(mission.getMission());
        }
        return String.join(" | ", missionName);
    }
}
