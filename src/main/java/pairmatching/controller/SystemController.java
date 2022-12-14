package pairmatching.controller;

import pairmatching.controller.domain.MissionController;
import pairmatching.controller.domain.PairController;
import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Level;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.mission.UserSelect;
import pairmatching.domain.OperationIndex;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class SystemController {


    MissionController missionController = new MissionController();
    PairController pairController = new PairController();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        OperationIndex operation = inputView.readOperation();
        isMatching(operation);
        isSearching(operation);
        isInitializing(operation);
    }

    private void isMatching(OperationIndex operation) {
        if (operation == OperationIndex.MATCHING) {
            outputView.printCourseAndMission(Level.getLevels(), missionController.getMissions());
            operateMatching();
        }
    }

    private void isSearching(OperationIndex operation) {
        if (operation == OperationIndex.SEARCHING) {
            outputView.printCourseAndMission(Level.getLevels(), missionController.getMissions());
            operateSearching();
        }
    }

    private void isInitializing(OperationIndex operation) {
        if (operation == OperationIndex.INITIALIZING) {
            operateInitialize();
        }
    }

    private void operateMatching() {
        UserSelect userSelect = inputView.readUserSelect();
        if (userSelect.getCourse().equals(Course.BACKEND.getCourse())) {
            matchBackendCrew(userSelect);
        }
        if (userSelect.getCourse().equals(Course.FRONTEND.getCourse())) {
            matchFrontendCrew(userSelect);
        }
    }

    private void matchFrontendCrew(UserSelect userSelect) {
        Pair pair = pairController.makeFrontendPair(userSelect);
        if (pair != null) {
            outputView.printPair(pair.getPairList(userSelect));
            run();
            return;
        }
        operateMatching();
    }

    private void matchBackendCrew(UserSelect userSelect) {
        Pair pair = pairController.makeBackendPair(userSelect);
        if (pair != null) {
            outputView.printPair(pair.getPairList(userSelect));
            run();
            return;
        }
        operateMatching();
    }

    private void operateSearching() {
        UserSelect userSelect = inputView.readUserSelect();
        if (userSelect.getCourse().equals(Course.BACKEND.getCourse())) {
            searchBackendCrew(userSelect);
        }
        if (userSelect.getCourse().equals(Course.FRONTEND.getCourse())) {
            searchFrontendCrew(userSelect);
        }
    }

    private void searchFrontendCrew(UserSelect userSelect) {
        Pair pair = pairController.searchFrontendPair(userSelect);
        if (pair != null) {
            outputView.printPair(pair.getPairList(userSelect));
            run();
            return;
        }
        run();
    }

    private void searchBackendCrew(UserSelect userSelect) {
        Pair pair = pairController.searchBackendPair(userSelect);
        if (pair != null) {
            outputView.printPair(pair.getPairList(userSelect));
            run();
            return;
        }
        run();
    }

    private void operateInitialize() {
        pairController.initializePairs();
        outputView.printInitialize();
        run();
    }

    public void makeAllMissions() {
        missionController.makeMissions();
    }
}
