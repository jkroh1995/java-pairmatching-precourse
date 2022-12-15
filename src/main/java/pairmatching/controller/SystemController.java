package pairmatching.controller;

import pairmatching.controller.domain.MissionController;
import pairmatching.controller.domain.PairController;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.mission.UserSelect;
import pairmatching.domain.Operation;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class SystemController {


    MissionController missionController = new MissionController();
    PairController pairController = new PairController();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Operation operation = inputView.readOperation();
        isMatching(operation);
        isSearching(operation);
        isInitializing(operation);
    }

    private void isMatching(Operation operation) {
        if (operation == Operation.MATCHING) {
            missionController.printCourseAndMission(outputView);
            operateMatching();
        }
    }

    private void isSearching(Operation operation) {
        if (operation == Operation.SEARCHING) {
            missionController.printCourseAndMission(outputView);
            operateSearching();
        }
    }

    private void isInitializing(Operation operation) {
        if (operation == Operation.INITIALIZING) {
            operateInitialize();
        }
    }

    private void operateMatching() {
        missionController.makeUserSelect(inputView);
        if (missionController.isBackEnd()) {
            matchBackendCrew(missionController.getUserSelect());
            return;
        }
        matchFrontendCrew(missionController.getUserSelect());
    }

    private void matchFrontendCrew(UserSelect userSelect) {
        Pair pair = pairController.makeFrontendPair(userSelect, missionController);
        if (pair != null) {
            outputView.printPair(pair.getPairList(userSelect));
            run();
            return;
        }
        operateMatching();
    }

    private void matchBackendCrew(UserSelect userSelect) {
        Pair pair = pairController.makeBackendPair(userSelect, missionController);
        if (pair != null) {
            outputView.printPair(pair.getPairList(userSelect));
            run();
            return;
        }
        operateMatching();
    }

    private void operateSearching() {
        missionController.makeUserSelect(inputView);
        if (missionController.isBackEnd()) {
            searchBackendCrew(missionController.getUserSelect());
            return;
        }
        searchFrontendCrew(missionController.getUserSelect());
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
