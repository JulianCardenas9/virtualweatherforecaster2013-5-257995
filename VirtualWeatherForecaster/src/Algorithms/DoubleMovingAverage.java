/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;
import java.util.ArrayList;

/**
 * Double Exponencial Smoothing:
 * 
 * El algoritmo double exponencial se basa en terminos practicos en aplicar
 * 2 veces el simple moving average.
 * 
 * Sus ecuaciones son las siguientes:
 * 
 * Mt = (Yt + Yt-1 + Yt-2 + ... + Yt-N+1)/N
 * M't = (Mt + Mt-1 + Mt-2 + ... + Mt-N+1)/N
 * at = 2Mt - M't
 * bt = (2/(k-1))*(Mt-M't)
 * Yt+p = at+bt*p
 * 
 * @author Nicolas Camelo
 */
public class DoubleMovingAverage {
    
    public static ArrayList<Double> Get(ArrayList<Double> lastDays, int days ){
        
        ArrayList<Double> lstForecast = new ArrayList<>();
        ArrayList<Double> last = (ArrayList) lastDays.clone();
       
        double m = 0;
        double mprime = 0;
        double total = 0;
        double a;
        double b;
        
        //Pronostico para los siguientes N dias
        for(int k=0; k<days; k++)
        {
            //Si la lista contiene elementos
            if(last.size() > 0)
            {
                //Pronostico para el día k
                for(int j=0; j<days; j++)
                {
                    total = 0;
                    
                    for(int i=0; i<days; i++)
                    {
                        total += last.get(i);
                    }
                    
                    if(j==0){
                        m = total/days;
                    }
                    
                    total = total/days; 
                    last.remove(0);
                    last.add(total);
                    mprime += total;
                }
                mprime = mprime/days;
                a = 2*m-mprime;
                b = (2/(days-1))*(m-mprime);
                last.remove(0);
                last.add(a+b*days);
                lstForecast.add(a+b*days);
            }
        }
        return lstForecast;
    }
}
