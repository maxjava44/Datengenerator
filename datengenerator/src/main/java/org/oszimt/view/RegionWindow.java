package org.oszimt.view;

import org.oszimt.model.Land;
import org.oszimt.model.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class RegionWindow extends JPanel {

    Region region = null;

    public RegionWindow(MainWindow mainWindow) {
        super();
    }

    public void setRegion(Region region){
        this.region = region;
        JPanel contentContainer = new JPanel(new BorderLayout());
        JPanel countryPanel = new JPanel(new GridLayout(0,3));
        if(region != null) {
            List<Land> countries = region.getLaender();
            for(Land land : countries) {
                Button landBtn = new Button(land.getLandName());
                countryPanel.add(landBtn);
            }
        }
        contentContainer.add(countryPanel,BorderLayout.CENTER);
        add(contentContainer);
    }
}