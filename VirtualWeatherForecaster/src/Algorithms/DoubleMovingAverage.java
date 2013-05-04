/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;
import java.util.ArrayList;

/**
 *
 * @author Juancho
 */
public class DoubleMovingAverage {
    
    public static ArrayList<Double> Get(ArrayList<Double> last, int days ){
        
        ArrayList<Double> lstForecast = new ArrayList<>();
        double m = 0;
        double mprime = 0;
        double total = 0;
        double a;
        double b;
        
        for(int k=0; k<days; k++)
        {
            int t=last.size();
            
            //Si la lista contiene elementos
            if(t > 0)
            {
                for(int j=0; j<t; j++)
                {
                    total = 0;
                    
                    for(int i=0; i<t; i++)
                    {
                        total += last.get(i);
                    }
                    
                    if(j==0){
                        m = total/t;
                    }
                    
                    mprime += total/t;
                    t--;
                    //lstForecast.add(total);
                }
                mprime = mprime/t;
                a = 2*m-mprime;
                b = (2/(t-1))*(m-mprime);
                
                last.add(a+b*days);
                lstForecast.add(a+b*days);
            }
        }
        return lstForecast;
    }
}
