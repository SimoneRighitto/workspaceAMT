/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab3.services;

import ch.heigvd.amt.lab3.model.Measure;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author RigHitZ
 */
@Stateless
public class MeasuresManager implements MeasuresManagerLocal {

    @EJB
    private DataManagerLocal dataManager;
    
    @Override
    public void addMeasure(Measure m) {
        dataManager.insertData(m);
    }

    @Override
    public List<Measure> getMeasures() {
        return dataManager.getData();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
