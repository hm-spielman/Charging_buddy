package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
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
        PVSystem pvSystem = new PVSystem(user);

        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        panel.setPreferredSize(new Dimension(500, 250));

        JLabel label = new JLabel("Charging Buddy");
        label.setBounds(230, 10, 100, 50);

        JLabel information = new JLabel("Willkommen bei Charging Buddy");
        information.setBounds(10, 200, 500, 50);

        JButton btnAddUser = new JButton("Add User");
        btnAddUser.setBounds(10, 50, 90, 30);
        JTextField fieldAddUser = new JTextField("Max M.");
        fieldAddUser.setBounds(125, 55, 90, 25);
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setName(fieldAddUser.getText());
                information.setText("Neuer User hinzugefügt: " + user.getName());
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
                information.setText("Neues Auto hinzugefügt: " + fieldAddCar.getText() + " || Vorhandene Autos: " + user.getCarNames());
            }
        });


        JTextField fieldDriveDep = new JTextField("2023-02-10T13:50:55");
        fieldDriveDep.setBounds(125, 135, 130, 25);
        fieldDriveDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.addDriveList(fieldDriveDep.getText());
                System.out.println("Neuer Abfahrtzeitpunkt: " + fieldDriveDep.getText());
            }
        });

        JTextField fieldDriveArr = new JTextField("2023-02-10T14:50:55");
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
                information.setText("Geplante Fahrt: " + user.getDrives().get(0).getCarName() + " || Dauer: " + user.getDrives().get(0).getAwayTime() + "h");
            }
        });

        JButton btnAddChargeTime = new JButton("Charge");
        btnAddChargeTime.setBounds(10, 170, 90, 30);
        JTextField fieldChargeTimeWeekDayNumber = new JTextField("5");
        fieldChargeTimeWeekDayNumber.setBounds(125, 175, 80, 25);
        JTextField fieldChargeTimeFrom = new JTextField("14");
        fieldChargeTimeFrom.setBounds(215, 175, 35, 25);
        JTextField fieldChargeTimeTo = new JTextField("15");
        fieldChargeTimeTo.setBounds(265, 175, 25, 25);

        btnAddChargeTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pvSystem.chargeBatteryWithString(fieldChargeTimeWeekDayNumber.getText(), fieldChargeTimeFrom.getText(), fieldChargeTimeTo.getText());
                information.setText(pvSystem.getCanBeCharged());
            }
        });



        panel.add(btnAddUser);
        panel.add(fieldAddUser);
        panel.add(btnAddCar);
        panel.add(fieldAddCar);
        panel.add(btnAddDrive);
        panel.add(fieldDriveDep);
        panel.add(fieldChargeTimeWeekDayNumber);
        panel.add(fieldDriveArr);
        panel.add(fieldDriveBatUsage);
        panel.add(btnAddChargeTime);
        panel.add(fieldChargeTimeTo);
        panel.add(fieldChargeTimeFrom);
        panel.add(label);
        panel.add(information);
        panel.setVisible(true);

        return panel;
    }
}