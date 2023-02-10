package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class FXGUI extends JFrame {

    public FXGUI() throws IOException {
        JFrame frame = new JFrame("Charging Buddy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.getHSBColor(144, 238,144));

        frame.add(createMainPanel(), BorderLayout.CENTER);


        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() throws IOException {
        User user = new User("User", 80000, new ArrayList<>(), new ArrayList<>());

        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        panel.setPreferredSize(new Dimension(500, 250));

        JLabel label = new JLabel("Charging Buddy");
        label.setBounds(230, 10, 100, 50);

        JButton btnAddUser = new JButton("Add User");
        btnAddUser.setBounds(10, 50, 90, 30);
        JTextField fieldAddUser = new JTextField("Max M.");
        fieldAddUser.setBounds(125, 55, 90, 25);
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setName(fieldAddUser.getText());
                System.out.println("Neuer User: " + user.getName());
            }
        });


        JButton btnAddCar = new JButton("Add Car");
        btnAddCar.setBounds(10, 90, 90, 30);
        JTextField fieldAddCar = new JTextField("Tesla 3");
        fieldAddCar.setBounds(125, 95, 90, 25);
        btnAddCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addCar(fieldAddCar.getText(), 60, 60, 4);
                System.out.println("Neues Auto hinzugefügt: " + user.getCarNames());
            }
        });


        JTextField fieldDriveDep = new JTextField("2018-05-05T11:50:55");
        fieldDriveDep.setBounds(125, 135, 130, 25);
        fieldDriveDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addDriveList(fieldDriveDep.getText());
                System.out.println("Neuer Abfahrtzeitpunkt: " + fieldDriveDep.getText());
            }
        });

        JTextField fieldDriveArr = new JTextField("2018-05-05T12:50:55");
        fieldDriveArr.setBounds(265, 135, 130, 25);
        fieldDriveArr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addDriveList(fieldDriveArr.getText());
                System.out.println("Neuer Ankunftszeitpunkt: " + fieldDriveArr.getText());
            }
        });
        JTextField fieldDriveBatUsage = new JTextField("10");
        fieldDriveBatUsage.setBounds(405, 135, 30, 25);
        fieldDriveBatUsage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addDriveList(fieldDriveBatUsage.getText());
                System.out.println("Neuer geplanter Verbrauch: " + fieldDriveBatUsage.getText());
            }
        });

        JButton btnAddDrive = new JButton("Add Drive");
        btnAddDrive.setBounds(10, 130, 90, 30);
        btnAddDrive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addDriveByString(fieldDriveDep.getText(), fieldDriveArr.getText(), fieldDriveBatUsage.getText());
                System.out.println("Geplante Fahrt: " + user.getDrives().get(0).getCarName() + "|| Dauer: " + user.getDrives().get(0).getAwayTime() + "h");
                System.out.println(user.getDriveList());
            }
        });

        JButton btnAddChargeTime = new JButton("Charge");
        btnAddChargeTime.setBounds(10, 170, 90, 30);
        JTextField fieldChargeTimeFrom = new JTextField("From");
        fieldChargeTimeFrom.setBounds(125, 175, 30, 25);
        JTextField fieldChargeTimeTo = new JTextField("To");
        fieldChargeTimeTo.setBounds(160, 175, 30, 25);

        panel.add(btnAddUser);
        panel.add(fieldAddUser);
        panel.add(btnAddCar);
        panel.add(fieldAddCar);
        panel.add(btnAddDrive);
        panel.add(fieldDriveDep);
        panel.add(fieldDriveArr);
        panel.add(fieldDriveBatUsage);
        panel.add(btnAddChargeTime);
        panel.add(fieldChargeTimeTo);
        panel.add(fieldChargeTimeFrom);
        panel.add(label);
        panel.setVisible(true);

        return panel;
    }
}