package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Level;
import pairmatching.domain.mission.MissionList;
import pairmatching.domain.mission.Missions;
import pairmatching.domain.Operation;
import pairmatching.domain.ResourceReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class SystemController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ResourceReader resourceReader = new ResourceReader();
    MissionList missionList = new MissionList();
    Missions missions = new Missions();

    List<String>backendCrewList = resourceReader.getBackendCrewList();
    List<String>frontendCrewList = resourceReader.getFrontendCrewList();

    public void run(){
        missions.addMissionList(missionList.getLevelOneMissionList());
        missions.addMissionList(missionList.getLevelTwoMissionList());
        missions.addMissionList(missionList.getLevelThreeMissionList());
        missions.addMissionList(missionList.getLevelFourMissionList());
        missions.addMissionList(missionList.getLevelFiveMissionList());
        Operation operation = inputView.readOperation();
        if(operation == Operation.MATCHING){
            outputView.printCourseAndMission(Level.getLevels(), missions);
        }
        if(operation == Operation.SEARCHING){

        }
        if(operation == Operation.INITIALIZING){

        }
    }
}
