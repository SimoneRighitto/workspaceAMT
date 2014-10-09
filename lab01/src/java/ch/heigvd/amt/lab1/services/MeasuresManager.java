
package ch.heigvd.amt.lab1.services;

import ch.heigvd.amt.lab1.model.Measure;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



/**
 *
 * @author Righitto Simone
 */
public class MeasuresManager {
        
    public List<Measure> measures= new LinkedList<>();
    private Random rand = new Random();
    
    
    public List<Measure> getMeasures() {
        int nbrMeasures = 1+(int)(Math.random()*20);
        for (int i = 0; i < nbrMeasures; i++) {
            measures.add(new Measure("measureID"+rand.nextInt(), System.currentTimeMillis(), Math.random()*2000));
        }
        
        return measures;
    }
       
    
    
}
