package org.oszimt.model;

import java.util.ArrayList;

public class Vornamen {
    private boolean female;
    private ArrayList<String> vornamen;

    public Vornamen(ArrayList<String> vornamen,boolean female) {
        this.female = female;
        this.vornamen = vornamen;
    }

    public boolean getFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public ArrayList<String> getVornamen() {
        return vornamen;
    }

    public void setVornamen(ArrayList<String> vornamen) {
        this.vornamen = vornamen;
    }
}