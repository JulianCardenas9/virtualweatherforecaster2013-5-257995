/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Error {
    /*
     * calculate the error of the function
     * @param lastDays list of given days by user
     * @param foreCast forecast calculated
     * @param days days been calculated
     * @return give error of the forecast function
     */
     public static Double GetError(ArrayList<Double> lastDays,ArrayList<Double> foreCast, int days ){
     //   ArrayList<Double> lstForecast = new ArrayList<Double>();
        //1/n(sum_n(abs(give-fore/give)))
        double error = 0;
         for (int i = 0; i < days; i++) {
             error=+Math.abs((lastDays.get(i)-foreCast.get(i))/lastDays.get(i));
         }
        
        return error/days;
    }
    
}
