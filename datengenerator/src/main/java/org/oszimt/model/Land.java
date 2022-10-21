package org.oszimt.model;

import java.util.ArrayList;

public class Land {

    private ArrayList<Vornamen> vornamen;
    private ArrayList<Namen> namen;
    private String landName;

    public Land(ArrayList<Vornamen> vornamen,ArrayList<Namen> namen,String landName) {
        this.vornamen = vornamen;
        this.namen = namen;
        this.landName = landName;
    }
  
}