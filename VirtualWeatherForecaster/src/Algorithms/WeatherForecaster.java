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
    
    private double error = 0;
            
    public ArrayList<Double> Get(ArrayList<Double> last, int days) {

        ArrayList<Double> lst = null;
        // calculate SimpleMovingAverage
        ArrayList<Double> lstSimpleMovingAverage = SimpleMovingAverage.List(last, days);
        // calculate DoubleMovingAverage
        ArrayList<Double> lstDoubleMovingAverage = DoubleMovingAverage.Get(last, days);
        // calculate DoubleMovingAverage 
        ArrayList<Double> lstExponentialSmoothing = ExponentialSmoothing.Get(last, days);
        //calculate DoubleExponentialSmoothing
        ArrayList<Double> lstDoubleExponentialSmoothing = DoubleExponentialSmoothing.Get(last, days);
        
        double smaError = Error.GetError(last, lstSimpleMovingAverage, days);
        double dmaError = Error.GetError(last, lstDoubleMovingAverage, days);
        double esError = Error.GetError(last, lstExponentialSmoothing, days);
        double desError = Error.GetError(last, lstDoubleExponentialSmoothing, days);
        
        System.out.println("smaError " + smaError + "::::"+lstSimpleMovingAverage);
        System.out.println("dmaError " + dmaError + "::::"+lstDoubleMovingAverage);
        System.out.println("esError " + esError + "::::"+lstExponentialSmoothing);
        System.out.println("desError " + desError + "::::"+lstDoubleExponentialSmoothing);
        
        //si sma es el de menor error
        if(smaError<dmaError && smaError<esError && smaError<desError)
        {
            lst = lstSimpleMovingAverage;
            error = smaError;
        }
        else if(dmaError<smaError && dmaError<esError && dmaError<desError)
        {
            lst = lstDoubleMovingAverage;
            error = dmaError;
        }
        else if(esError<smaError && esError<dmaError && esError<desError)
        {
            lst = lstExponentialSmoothing;
            error = esError;
        }
        else if(desError<smaError && desError<dmaError && desError<esError)
        {
            lst = lstDoubleExponentialSmoothing;
            error = desError;
        }
        
        return lst;
    }

    /**
     * @return the error
     */
    public double getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(double error) {
        this.error = error;
}
}
