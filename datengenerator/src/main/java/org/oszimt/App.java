package org.oszimt;


import org.oszimt.controller.GenerateNames;
import org.oszimt.model.Land;
import org.oszimt.model.Region;
import org.oszimt.view.MainWindow;

import java.io.File;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<Region> regions = new ArrayList<>();
        File[] regionFiles = Paths.get(".","regionen").toFile().listFiles(pathname -> !pathname.toString().contains(".DS_Store"));
        if(regionFiles != null){
            Arrays.stream(regionFiles).forEach(file -> regions.add(new Region(file.toPath().toAbsolutePath().normalize().toString())));
        }
        for(Region region : regions) {
            for(Land land : region.getLaender()){
                if(land.getLandName().equals("Argentinien")){
                    Arrays.stream(GenerateNames.generateNames(land, 30,true)).forEach(System.out::println);
                }
            }
        }

        new MainWindow();

    }

    
}
