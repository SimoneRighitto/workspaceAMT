/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab3.services;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RigHitZ
 */
@Local
public interface DataManagerLocal {
    
public void insertData(Object o);

public List getData();
    
}

