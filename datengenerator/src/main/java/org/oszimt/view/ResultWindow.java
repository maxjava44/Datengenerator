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
    MainWindow mainWindow;


    public ResultWindow(MainWindow mainWindow) {
        super(new BorderLayout());
        this.mainWindow = mainWindow;
    }

    public void setResult(Land chosenCountry,int n,boolean female) {
        ActionListener callMainWindow = (e -> mainWindow.switchToMain());
        JTextArea f = new JTextArea();
        f.setEditable(false);
        f.setBackground(null);
        f.setBorder(null);

        String text = "";

        for(String name : GenerateNames.generateNames(chosenCountry,n,female)){
            text += name + System.lineSeparator();
        }
        f.setText(text);
        JScrollPane scrollPain = new JScrollPane(f);
        f.setCaretPosition(0);
        add(scrollPain,BorderLayout.CENTER);

        Button backBtn = new Button("Zurück zum Anfang");
        backBtn.addActionListener(callMainWindow);
        add(backBtn,BorderLayout.SOUTH);
    }

}