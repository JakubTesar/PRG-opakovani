import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StateRep stateRep = new StateRep();
        StateService stateService = new StateService();
        stateService.setStates(stateRep.getInput());


       // stateService.getPop33();
       // stateService.getMorePopThanRussia();
        stateService.getMaxEU();
    }
}
