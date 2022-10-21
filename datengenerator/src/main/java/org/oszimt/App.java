package org.oszimt;


import org.oszimt.model.Region;

import java.nio.file.Paths;

public class App 
{
    public static void main( String[] args )
    {
        Region afrika = new Region(Paths.get(".","regionen","Afrika").toAbsolutePath().normalize().toString());
    }

    
}
