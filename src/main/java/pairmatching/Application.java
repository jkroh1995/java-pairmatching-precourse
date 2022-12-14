package pairmatching;

import pairmatching.controller.SystemController;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        SystemController systemController = new SystemController();
        systemController.makeAllMissions();
        systemController.run();
    }
}
