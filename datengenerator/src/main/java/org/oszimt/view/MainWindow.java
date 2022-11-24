package org.oszimt.view;

import org.oszimt.model.Land;
import org.oszimt.model.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainWindow extends JFrame{

    MainPanel mPanel = new MainPanel(this);
    RegionWindow regionWindow = new RegionWindow(this);

    ResultWindow resultWindow = new ResultWindow(this);

    CardLayout layout = new CardLayout();
    JPanel cards = new JPanel(layout);

    public MainWindow() {
        super("Namensgenerator");

        cards.add("main",mPanel);
        cards.add("region",regionWindow);
        cards.add("result",resultWindow);
        getContentPane().setLayout(new BorderLayout());
        add(cards,BorderLayout.CENTER);
        setSize(700, 700);
        setVisible(true);
        layout.show(cards, "main");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void switchToRegion(Region region) {
        regionWindow.setRegion(region);
        layout.show(cards,"region");
        cards.remove(mPanel);
        cards.add("main",mPanel);
    }

    public void switchToResult(Land chosenCountry,int n,boolean female){
        resultWindow.setResult(chosenCountry,n,female);
        layout.show(cards,"result");
        cards.remove(regionWindow);
        regionWindow = new RegionWindow(this);
        cards.add("region",regionWindow);
    }

    public void switchToMain() {
        layout.show(cards,"main");
        cards.remove(resultWindow);
        resultWindow = new ResultWindow(this);
        cards.add("result",resultWindow);
    }

    
}
