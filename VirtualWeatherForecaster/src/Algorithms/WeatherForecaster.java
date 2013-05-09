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

        ArrayList<Double> rtn = null;
        // calculate SimpleMovingAverage
        ArrayList<Double> lstSimpleMovingAverage = SimpleMovingAverage.List(last, days);
        // calculate DoubleMovingAverage
        ArrayList<Double> lstDoubleMovingAverage = DoubleMovingAverage.Get(last, days);
        // calculate DoubleMovingAverage 
        ArrayList<Double> lstExponentialSmoothing = ExponentialSmoothing.Get(last, days);
        //calculate DoubleExponentialSmoothing
        ArrayList<Double> lstDoubleExponentialSmoothing = DoubleExponentialSmoothing.Get(last, days);
        setError((double) Error.GetError(last, lstSimpleMovingAverage, days));
        rtn = lstSimpleMovingAverage;
        double tmp = Error.GetError(last, lstDoubleMovingAverage, days);
        if (tmp < getError()) {
            setError(tmp);
            rtn = lstDoubleMovingAverage;
            tmp = Error.GetError(last, lstExponentialSmoothing, days);
            System.out.println(error+"dma"+lstDoubleMovingAverage);
        } else if (tmp < error) {
            setError(tmp);
            rtn = lstExponentialSmoothing;
            tmp = Error.GetError(last, lstDoubleExponentialSmoothing, days);
            System.out.println(error+"es");
        } else if (tmp < error) {
            setError(tmp);
            rtn = lstDoubleExponentialSmoothing;
            System.out.println(error+"des");
        }
        setError(Error.GetError(last, lstDoubleExponentialSmoothing, days));
        return lstDoubleExponentialSmoothing;
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
