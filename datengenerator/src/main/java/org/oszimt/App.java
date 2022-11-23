package org.oszimt;


import org.oszimt.model.Region;

import java.io.File;
import java.io.FileFilter;
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
        System.out.println(regions);
    }

    
}
