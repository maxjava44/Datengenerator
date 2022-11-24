package org.oszimt.view;

import javax.swing.*;

import org.oszimt.model.Region;

import java.awt.*;
import java.io.File;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainPanel extends JPanel{

    public MainPanel(MainWindow mainWindow) {
        super(new GridLayout(3,0));






        List<Region> regions = new ArrayList<>();
        File[] regionFiles = Paths.get(".","regionen").toFile().listFiles(pathname -> !pathname.toString().contains(".DS_Store"));
        if(regionFiles != null){
            Arrays.stream(regionFiles).forEach(file -> regions.add(new Region(file.toPath().toAbsolutePath().normalize().toString())));
        }

        ActionListener callRegionWindow = (e -> {
            for(Region region : regions){
                if(region.getName().equals(e.getActionCommand())){
                    mainWindow.switchToRegion(region);
                }
            }
        });

        for(Region region : regions) {
            Button regionBtn = new Button(region.getName());
            regionBtn.addActionListener(callRegionWindow);
            add(regionBtn);
        }
    }


}