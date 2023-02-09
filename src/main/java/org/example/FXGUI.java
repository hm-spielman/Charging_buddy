package org.example;

import java.awt.*;
import javax.swing.*;

public class FXGUI extends JFrame {

    private JButton addDriveButton, addCarButton, addChargingTimeButton;
    private JTextArea outputArea;

    public FXGUI() {
        super("Java Swing GUI");
        setLayout(new BorderLayout());

        addDriveButton = new JButton("Fahrt hinzufügen");
        addCarButton = new JButton("Auto hinzufügen");
        addChargingTimeButton = new JButton("Ladezeit hinzufügen");

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(addDriveButton);
        bottomPanel.add(addCarButton);
        bottomPanel.add(addChargingTimeButton);

        add(bottomPanel, BorderLayout.SOUTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}