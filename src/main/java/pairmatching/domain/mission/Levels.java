package pairmatching.domain.mission;

import java.util.ArrayList;
import java.util.List;

public class Levels {

    List<Level> levelList = new ArrayList<>();

    public Levels(){
        levelList.add(new Level("레벨1"));
        levelList.add(new Level("레벨2"));
        levelList.add(new Level("레벨3"));
        levelList.add(new Level("레벨4"));
        levelList.add(new Level("레벨5"));
    }
    public Level get(int index) {
        return levelList.get(index);
    }
}
