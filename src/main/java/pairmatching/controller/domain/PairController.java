package pairmatching.controller.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.util.ResourceReader;
import pairmatching.domain.RematchingIndex;
import pairmatching.domain.mission.UserSelect;
import pairmatching.domain.pair.Crew;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {

    Pair pair;
    Pairs pairs = new Pairs();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ResourceReader resourceReader = new ResourceReader();

    private final List<String> backendCrewNames = resourceReader.getBackendCrewList();
    private final List<String> frontendCrewNames= resourceReader.getFrontendCrewList();

    public Pair makeBackendPair(UserSelect userSelect, MissionController missionController) {
        pair = new Pair(userSelect, getBackendCrewList(missionController));
        if (pairs.notHavePair(pair)) {
            pairs.addPair(pair);
            return pair;
        }
        return reMatching(pair);
    }

    public Pair makeFrontendPair(UserSelect userSelect, MissionController missionController) {
        pair = new Pair(userSelect, getFrontendCrewList(missionController));
        if (pairs.notHavePair(pair)) {
            pairs.addPair(pair);
            return pair;
        }
        return reMatching(pair);
    }

    public Pair searchBackendPair(UserSelect userSelect) {
        try {
            return pairs.getPair(userSelect);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return null;
        }
    }

    public Pair searchFrontendPair(UserSelect userSelect) {
        try {
            return pairs.getPair(userSelect);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return null;
        }
    }

    public void initializePairs() {
        pairs.clear();
    }

    private Pair reMatching(Pair pair) {
        RematchingIndex rematchingIndex = inputView.readRematching();
        if (rematchingIndex == RematchingIndex.YES) {
            pairs.removePair(pair);
            pairs.addPair(pair);
            return pair;
        }
        return null;
    }

    private List<Crew> getBackendCrewList(MissionController missionController) {
        List<Crew> backendCrew = new ArrayList<>();
        for (String backendCrewName : backendCrewNames) {
            backendCrew.add(new Crew(missionController.getBackend(), backendCrewName));
        }
        return backendCrew;
    }

    private List<Crew> getFrontendCrewList(MissionController missionController) {
        List<Crew> frontendCrew = new ArrayList<>();
        for (String frontendCrewName : frontendCrewNames) {
            frontendCrew.add(new Crew(missionController.getFrontend(), frontendCrewName));
        }
        return frontendCrew;
    }
}
