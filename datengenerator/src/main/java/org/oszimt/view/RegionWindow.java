package org.oszimt.view;

import org.oszimt.model.Land;
import org.oszimt.model.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class RegionWindow extends JPanel {

    JSpinner spinner = null;

    MainWindow mainWindow = null;

    JCheckBox female = null;

    Region region = null;
    ActionListener switchToResult = (e -> {
        if(region != null) {
            List<Land> countries = region.getLaender();
            for(Land land : countries) {
                if(land.getLandName().equals(e.getActionCommand())){
                    mainWindow.switchToResult(land,(int)spinner.getValue(),female.isSelected());
                }
            }
        }
    });

    public RegionWindow(MainWindow mainWindow) {
        super();
        this.mainWindow = mainWindow;
    }

    public void setRegion(Region region){
        this.region = region;
        JPanel contentContainer = new JPanel(new BorderLayout());
        JPanel countryPanel = new JPanel(new GridLayout(0,3));
        if(region != null) {
            List<Land> countries = region.getLaender();
            for(Land land : countries) {
                Button landBtn = new Button(land.getLandName());
                landBtn.addActionListener(switchToResult);
                countryPanel.add(landBtn);
            }
        }
        contentContainer.add(countryPanel,BorderLayout.CENTER);
        JPanel choiceContainer = new JPanel();
        female = new JCheckBox();
        JLabel checkBox = new JLabel("Weibliche Namen?");
        choiceContainer.add(checkBox);
        choiceContainer.add(female);
        SpinnerModel value = new SpinnerNumberModel(0,0,1000,5);
        spinner = new JSpinner(value);
        choiceContainer.add(spinner);
        contentContainer.add(choiceContainer,BorderLayout.SOUTH);
        add(contentContainer);
    }


}