package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.mission.UserSelect;

public class Pairs {

    private static final String ERROR_NO_PAIR = "[ERROR] 매칭 이력이 없습니다.";

    List<Pair> pairs = new ArrayList<>();

    public void addPair(Pair pair) {
        pairs.add(pair);
    }

    public boolean notHavePair(Pair pair) {
        for (Pair eachPair : pairs) {
            if (eachPair.getKey().equals(pair.getKey())) {
                return false;
            }
        }
        return true;
    }

    public void removePair(Pair pair) {
        pairs.removeIf(eachPair -> eachPair.getKey().equals(pair.getKey()));
    }

    public Pair getPair(UserSelect userSelect) {
        for (Pair pair : pairs) {
            if (pair.getKey().equals(userSelect.toString())) {
                return pair;
            }
        }
        throw new IllegalArgumentException(ERROR_NO_PAIR);
    }

    public void clear() {
        pairs.clear();
    }
}
