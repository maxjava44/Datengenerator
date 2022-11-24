package org.oszimt.view;

import org.oszimt.controller.GenerateNames;
import org.oszimt.model.Land;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ResultWindow extends JPanel {

    Land chosenCountry = null;
    int n = 0;
    Boolean female = null;


    public ResultWindow(MainWindow mainWindow) {
        super();
        ActionListener callMainWindow = (e -> e.getWhen());
        JPanel contentContainer = new JPanel(new BorderLayout());
        JPanel namenPanel = new JPanel(new GridLayout(1,0));
        if(chosenCountry != null && n != 0 && female != null){
            for(String name : GenerateNames.generateNames(chosenCountry,n,female)){
                namenPanel.add(new Label(name));
            }
        }
        contentContainer.add(namenPanel,BorderLayout.CENTER);
        Button backBtn = new Button("Zurück zum Anfang");
        backBtn.addActionListener(callMainWindow);
        contentContainer.add(backBtn);
        add(contentContainer);
        setSize(600, 500);
        setVisible(true);
    }

}