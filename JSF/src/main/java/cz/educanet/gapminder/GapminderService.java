package cz.educanet.gapminder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class GapminderService {

    private GapminderRepository gp = new GapminderRepository();

    public List<Integer> getGM() {
        return gp.getGM().stream().map(GapminderBean::getYear).distinct().collect(Collectors.toList());
    }

    public Integer getYearParam() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return Integer.parseInt(params.get("year"));
    }

    public List<GapminderBean> getCountriesByYear() {
        return gp.getGM().stream().filter(i -> i.getYear() == getYearParam()).collect(Collectors.toList());
    }

    public List<Continent> getContinentAndLifeExp() {
        List<Continent> continents = new ArrayList<>();
        List<GapminderBean> g1 = gp.getGM();
        for (int i = 0; i < g1.stream().map(GapminderBean::getContinent).distinct().toList().size(); i++) { // 6x
            Continent c = new Continent(g1.stream().map(GapminderBean::getContinent).distinct().toList().get(i));
            continents.add(c);
        }
        for (int i = 0; i < g1.size(); i++) {
            for (Continent continent : continents) { //6x
                if (g1.get(i).getContinent().equals(continent.getName())) {
                    continent.setTotalLife(continent.getTotalLife() + 1);
                    continent.setTotal(continent.getTotal() + g1.get(i).getLifeExp());
                }
            }
        }
        return continents;
    }

}
