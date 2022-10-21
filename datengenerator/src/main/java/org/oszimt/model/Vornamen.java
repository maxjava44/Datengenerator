package org.oszimt.model;

import java.util.ArrayList;

public class Vornamen {
    private boolean female;
    private ArrayList<String> vornamen;

    public Vornamen(ArrayList<String> vornamen,boolean female) {
        this.female = female;
        this.vornamen = vornamen;
    }
}