package org.oszimt.view;

import org.oszimt.model.Land;
import org.oszimt.model.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegionWindow extends JPanel {

    public RegionWindow(Region region) {
        super();
        ActionListener callResultWindow = (e -> {
            List<Land> countries = region.getLaender();
            for(Land land : countries) {
                if(land.getLandName().equals(e.getActionCommand())){
                    Container bContainer = ((Button)e.getSource()).getParent();
                    bContainer.removeAll();
                    ((Button)e.getSource()).getParent().add(new ResultWindow(land,true,30));
                }
            }
        });
        List<Land> countries = region.getLaender();
        JPanel contentContainer = new JPanel(new BorderLayout());
        JPanel countryPanel = new JPanel(new GridLayout(5,0));
        for(Land land : countries) {
            Button landBtn = new Button(land.getLandName());
            landBtn.addActionListener(callResultWindow);
            countryPanel.add(landBtn);
        }
        contentContainer.add(countryPanel);
        add(contentContainer);
        setSize(600, 500);
        setVisible(true);
    }
}