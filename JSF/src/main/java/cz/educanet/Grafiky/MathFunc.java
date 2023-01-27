package cz.educanet.Grafiky;

import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.LinePlot;
import tech.tablesaw.plotly.components.Axis;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.components.Line;
import tech.tablesaw.plotly.traces.BarTrace;
import tech.tablesaw.plotly.traces.ScatterTrace;
import tech.tablesaw.plotly.traces.Trace;

import java.util.Arrays;

public class MathFunc {
    public static void main(String[] args) {
        //Lineární Funkce
       /* double[] xValues = {-400,400};
        double[] yValues = {-400,400};

        Figure fig = LinePlot.create(
                "Linear Function",
                "X axis", xValues,
                "Y axis", yValues
        );
        Plot.show(fig);
        */
        /*
         //Kvadratická Funkce
        double[] a = new double[200];
        double[] b = new double[200];

        int j = -100;
        for (int i = 0; i < a.length; i++) {
            a[i] = (double) j;
            b[i] = a[i] * a[i];
            j++;
        }
        Figure fig = LinePlot.create(
                "Linear Function",
                "X axis", a,
                "Y axis", b
        );
        Plot.show(fig);*/

      /*  double[] a = new double[200];
        double[] b = new double[200];

        double[] c = new double[200];
        double[] d = new double[200];

        int j = -100;
        for (int i = 0; i < a.length; i++) {
            a[i] = (double) j;
            b[i] = Math.sin((double)j/10);
            j++;
        }
        int k = -100;
        for (int i = 0; i < c.length; i++) {
            c[i] = (double) k;
            d[i] = Math.cos((double)k/10);
            k++;
        }

        Axis xAxis = Axis.builder()
                .title("X axis title")
                .build();

        Layout layout = Layout.builder()
                .title("My Title")
                .height(650)
                .width(650)
                .build();

        Trace trace = ScatterTrace
                .builder(a, b)
                .mode(ScatterTrace.Mode.LINE)
                .build();

        Trace trace2 = ScatterTrace
                .builder(c, d)
                .mode(ScatterTrace.Mode.LINE)
                .build();
        Figure fig = new Figure(layout, trace, trace2);
        Plot.show(fig);
*/
    }
}
