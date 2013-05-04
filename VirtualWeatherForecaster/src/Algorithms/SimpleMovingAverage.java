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
 * @author Juancho
 */
public class SimpleMovingAverage {
    
    public static ArrayList<Double> Get(ArrayList<Double> last, int days ){
        
        ArrayList<Double> lstForecast = new ArrayList<Double>();
        
        for(int j=0;j<days;j++)
        {
            int t=last.size();
            
            //si la lista contiene elementos
            if(t>0)
            {
                double total = 0;

                for(int i=0 ; i < t; i++)
                {
                    total += last.get(i);
                }

                total = total/t;
                last.add(total);
                lstForecast.add(total);
            }
        }
        return lstForecast;
    }
}
