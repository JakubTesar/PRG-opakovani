import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StateService {
    private ArrayList<State> states = new ArrayList<>();

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void getPop33() {
        ArrayList<State> stateArrayList = states;
        List<State> pog = stateArrayList.stream().filter(i -> i.getPopulation() > 200000000).toList();
        for (State state : pog) {
            if (state.getGdp() != 0) {
                double a = state.getGdp() / state.getPopulation();
                System.out.println(state.getName() + " - " + a);
            }
        }
    }

    public void getMorePopThanRussia() {
        List<Long> russia = states.stream().filter(i -> i.getName().equals("Russia")).map(State::getPopulation).toList();
        List<State> pog = states.stream().filter(i -> i.getPopulation() > russia.get(0)).toList();
        for (State state : pog) {
            System.out.println(state.getName());
        }
    }

    public void getMaxEU() {
        List<State> statesEU = states.stream().filter(i -> i.getContinent().equals("Europe")).toList();
        State maxPop = statesEU.stream().max(Comparator.comparing(State::getPopulation)).get();
        List<State> statesEU2 = states.stream().filter(i -> i.getContinent().equals("Europe")).sorted(Comparator.comparing(s -> s.getName().length())).toList();
        for (int i = statesEU2.size() - 1; i >= 0; i--) {
            System.out.println(statesEU2.get(i).getName() + " - " + Math.round((((double)statesEU2.get(i).getPopulation() / (double)maxPop.getPopulation()) * 100) * 100.0) / 100.0);
        }
    }
}
