/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;
/**
 *
 * @author Jaserranoj
 */
public class DoubleExponentialSmoothing {
   public static ArrayList<Double> Get(ArrayList<Double> lastDays, int days ){
       
      // Formula

//      Ft = Unadjusted forecast (before trend)
//      Tt = Estimated trend
//      AFt = Trend-adjusted forecast
//      Ft = a* At-1 + (1- a) * (Ft-1 + Tt-1)

//      Tt = b* (At-1-Ft-1) + (1- b) * Tt-1

//      AFt = Ft + Tt  
       
        double alpha = 0.5;
        double beta = 0.5;
         double init = 0;
         
        
        ArrayList<Double> ForecastAFt = new ArrayList<Double>();
        ArrayList<Double> ForecastFt = new ArrayList<Double>();
        ArrayList<Double> ForecastTt = new ArrayList<Double>();
        ArrayList<Double> last = (ArrayList) lastDays.clone();
       
       // for(int j=0;j<days;j++)
       // {
            int t=last.size();
            
            //si la lista contiene elementos
            if(t>0)
            {
            
            ForecastFt.add(lastDays.get(0));    
            ForecastTt.add(init);    
            ForecastAFt.add(ForecastFt.get(0) + ForecastTt.get(0));
                for(int i=1 ; i < days; i++)
                {
                    ForecastFt.add((alpha*lastDays.get(i-1))+((1-alpha)*(ForecastFt.get(i-1)+ForecastTt.get(i-1))));
                    ForecastTt.add((beta*(lastDays.get(i-1)-ForecastFt.get(i-1)))+((1-beta)*(ForecastTt.get(i-1))));
                      ForecastAFt.add(ForecastFt.get(i) + ForecastTt.get(i));
                }
                
              
                
                }

        
        
        return ForecastAFt;
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
