/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author jaserranoj
 */
public class ExponentialSmoothing {
      public static ArrayList<Double> Get(ArrayList<Double> lastDays, int days ){
       
          // The simplest form of exponential smoothing is given by the formulae:
          //    So = Xo
          // St = α Xt  +  (1 - α)St-1,   t>0
          // Where alpha α is the smoothing factor, and 0 < α < 1
          
       // Definición del smoothing factor (Coeficiente de suavizado)   
        double alpha = 0.2;
        
        
        
        ArrayList<Double> ForecastES = new ArrayList<Double>();
        ArrayList<Double> last = (ArrayList) lastDays.clone();
        
       // for(int j=0;j<days;j++)
       // {
            int t=last.size();
            
            //si la lista contiene elementos
            if(t>0)
            {
            ForecastES.add(lastDays.get(0));
                
                

                for(int i=1 ; i < days; i++)
                {
                  ForecastES.add((alpha*lastDays.get(i))+((1-alpha)*ForecastES.get(i-1)));
                }
                
                }

        
        
        return ForecastES;
    }
    
    public static double Geterror(ArrayList<Double> lastDays, ArrayList<Double> ForestDays, int days ){
         ArrayList<Double> last = (ArrayList) lastDays.clone();
        
         ArrayList<Double> Forecast = (ArrayList) ForestDays.clone();
         int n=last.size();
         float sum=0;
        for(int i=1 ; i < n; i++)
                {
                 sum+=Math.abs((Forecast.get(i) - last.get(i))/last.get(i));   
                }
    return (sum/n);
    
    }
}

