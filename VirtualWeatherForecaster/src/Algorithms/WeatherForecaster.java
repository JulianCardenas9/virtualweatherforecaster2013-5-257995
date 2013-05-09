/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.ArrayList;

/**
 *
 * @author Fabian
 */
public class WeatherForecaster {
    
    public ArrayList<Double> Get(ArrayList<Double> last, int days ){
        
        // calcular SimpleMovingAverage
        ArrayList<Double> lstSimpleMovingAverage = SimpleMovingAverage.List(last, days);
        
        // calcular DoubleMovingAverage
        ArrayList<Double> lstDoubleMovingAverage = DoubleMovingAverage.Get(last, days);
        // calcular DoubleMovingAverage 
        ArrayList<Double> lstExponentialSmoothing = ExponentialSmoothing.Get(last,days);
        
        ArrayList<Double> lstDoubleExponentialSmoothing = DoubleExponentialSmoothing.Get(last,days);
        
        double errorDES= DoubleExponentialSmoothing.Geterror(last, lstDoubleExponentialSmoothing, days);
                System.out.println(errorDES);
        double errorES= ExponentialSmoothing.Geterror(last, lstExponentialSmoothing, days);
                System.out.println(errorES);        
                
        //return lstExponentialSmoothing;
        //return lstDoubleMovingAverage;
        return lstDoubleExponentialSmoothing;
    }
}
