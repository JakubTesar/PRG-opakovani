package cz.educanet.gapminder;

import java.util.ArrayList;
import java.util.List;

public class GapminderService {

    private GapminderRepository gp = new GapminderRepository();

    public List<GapminderBean> getGM(){
        List<GapminderBean> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        list = gp.getGM();
        for (int i = 0; i < gp.getGM().size(); i++) {
            if (!a.contains())
            list.add(gp.getGM().get(i));
        }
        return list;
    }

}
