/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab3.services;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author RigHitZ
 */
@Singleton
public class DataManager implements DataManagerLocal {

    public List<Object> data = new LinkedList<>();

    @Override
    public void insertData(Object o) {
        data.add(o);
    }

    @Override
    public List getData() {
        return new LinkedList(data);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
