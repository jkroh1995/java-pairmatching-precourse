package pairmatching.domain.pair;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.mission.UserSelect;

public class Pair {

    Map<UserSelect, List<Crew>> pair = new HashMap();

    public Pair(UserSelect userSelect, List<Crew> backendCrewList) {
        backendCrewList = Randoms.shuffle(backendCrewList);
        pair.put(userSelect, backendCrewList);
    }

    public String getKey() {
        StringBuilder key= new StringBuilder();
        for(UserSelect userSelect : pair.keySet()){
            key.append(userSelect.toString());
        }
        return key.toString();
    }

    public List<List<String>> getPairList(UserSelect userSelect) {
        List<Crew>crewList = getCrewList(userSelect);
        List<List<String>>pairList = new ArrayList<>();
        evenNumberCrews(crewList, pairList);
        oddNumberCrews(crewList, pairList);
        return pairList;
    }

    private List<Crew> getCrewList(UserSelect userSelect){
        for(UserSelect eachUserSelect : pair.keySet()){
            if (eachUserSelect.toString().equals(userSelect.toString())){
                return pair.get(eachUserSelect);
            }
        }
        return null;
    }

    private void oddNumberCrews(List<Crew> crewList, List<List<String>> pairList) {
        if(crewList.size()%2!=0){
            makeOddNumberPairList(crewList, pairList);
        }
    }

    private void makeOddNumberPairList(List<Crew> crewList, List<List<String>> pairList) {
        for(int index = 0; index< crewList.size()-2; index+=2){
            if (lastPair(crewList, pairList, index)) {
                break;
            }
            List<String>eachPair = new ArrayList<>();
            eachPair.add(crewList.get(index).getName());
            eachPair.add(crewList.get(index+1).getName());
            pairList.add(eachPair);
        }
    }

    private boolean lastPair(List<Crew> crewList, List<List<String>> pairList, int index) {
        if(index == crewList.size()-3){
            List<String>eachPair = new ArrayList<>();
            eachPair.add(crewList.get(index).getName());
            eachPair.add(crewList.get(index +1).getName());
            eachPair.add(crewList.get(index +2).getName());
            pairList.add(eachPair);
            return true;
        }
        return false;
    }

    private void evenNumberCrews(List<Crew> crewList, List<List<String>> pairList) {
        if(crewList.size()%2==0){
            makeEvenNumberPairList(crewList, pairList);
        }
    }

    private void makeEvenNumberPairList(List<Crew> crewList, List<List<String>> pairList) {
        for(int index = 0; index< crewList.size()-1; index+=2){
            List<String>eachPair = new ArrayList<>();
            eachPair.add(crewList.get(index).getName());
            eachPair.add(crewList.get(index+1).getName());
            pairList.add(eachPair);
        }
    }
}
