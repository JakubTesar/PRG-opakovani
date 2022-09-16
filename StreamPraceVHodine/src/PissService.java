import java.util.*;
import java.util.stream.Collectors;

public class PissService {
    public void getFirstWinners(ArrayList<Piss> pisses) {
        Integer prvniRok = pisses.stream().min(Comparator.comparing(Piss::getYear)).get().getYear();
        System.out.println(prvniRok);
        List<Piss> prvniLidi = pisses.stream().filter(i -> i.getYear() == prvniRok).toList();
        for (int i = 0; i < prvniLidi.size(); i++) {
            System.out.println(prvniLidi.get(i).getWinner());
        }
    }

    public void barackObama(ArrayList<Piss> pisses) {
        String barackSubject = pisses.stream().filter(i -> i.getWinner().equals("Barack Obama")).map(Piss::getSubject).collect(Collectors.joining());
        System.out.println(barackSubject);
    }

    public void wW1(ArrayList<Piss> pisses) {
        List<Piss> wW1 = pisses.stream().filter(i -> i.getYear() >= 1914 && i.getYear() <= 1918).toList();
        for (int i = 0; i < wW1.size(); i++) {
            System.out.println(wW1.get(i).getWinner());
        }
    }

    public void wW2(ArrayList<Piss> pisses) {
        List<Piss> wW2 = pisses.stream().filter(i -> i.getYear() >= 1939 && i.getYear() <= 1945).toList();
        for (int i = 0; i < wW2.size(); i++) {
            System.out.println(wW2.get(i).getWinner());
        }
    }

    public void firstEconomic(ArrayList<Piss> pisses) {
        Integer prvniRok = pisses.stream().filter(i -> i.getSubject().equals("Economics")).min(Comparator.comparing(Piss::getYear)).get().getYear();
        String firstEconom = pisses.stream().filter(i -> i.getSubject().equals("Economics")).filter(i -> i.getYear() == prvniRok).map(Piss::getWinner).collect(Collectors.joining());
        System.out.println(firstEconom + " " + prvniRok);
    }

    public void getWinnersAfterEU(ArrayList<Piss> pisses) {
        Integer euYear = pisses.stream().filter(i -> i.getWinner().equals("European Union")).min(Comparator.comparing(Piss::getYear)).get().getYear();
        List<Piss> afterEU = pisses.stream().filter(i -> i.getYear() > euYear).toList();
        for (int i = 0; i < afterEU.size(); i++) {
            System.out.println(afterEU.get(i).getWinner());
        }
    }

    public void getAll(ArrayList<Piss> pisses) {
        List<String> subjects = pisses.stream().map(Piss::getSubject).distinct().toList();
        List<String> subjects2 = pisses.stream().map(Piss::getSubject).toList();
        HashMap<String, Integer> map = new HashMap<>();
        int a = 0;
        for (int i = 0; i < subjects.size(); i++) {
            for (int j = 0; j < subjects2.size(); j++) {
                if (subjects.get(i).equals(subjects2.get(j))) {
                    a++;
                    map.put(subjects.get(i), a);
                }
            }
            a = 0;
        }

        for (String key : map.keySet()) {
            System.out.println(key + ":   " + map.get(key));
        }
    }

    public void getTwoTimerChamp(ArrayList<Piss> pisses) {

        Set<String> items = new HashSet<>();
        List<String> s = pisses.stream()
                .map(Piss::getWinner)
                .filter(n -> !items.add(n))
                .toList();
        for (String item : s) {
            System.out.println(item);
        }
    }
}
