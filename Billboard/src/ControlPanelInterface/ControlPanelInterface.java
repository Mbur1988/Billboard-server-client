package ControlPanelInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ControlPanelInterface {

    static JFrame controlPanelScreen = new JFrame();
    static JPanel createPanel = new JPanel();
    static JPanel listPanel = new JPanel();
    static JPanel schedulePanel = new JPanel();
    static JPanel passwordPanel = new JPanel();
    static JPanel editUserPanel = new JPanel();

    // Get the size of the screen.
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int screenWidth = screenSize.width;
    static int screenHeight = screenSize.height;

    public static void controlPanelScreen() throws IOException {

        //Create the Control Panel Screen window and set it the size of the screen.
//        JFrame controlPanelScreen = new JFrame();
        controlPanelScreen.setExtendedState(JFrame.MAXIMIZED_BOTH);
        controlPanelScreen.setResizable(false);

        // Create the individual panels.





        // Create the tabbed pane.
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(0,0,screenWidth,screenHeight);

        // Elements for each pane:

        CreatePanel.createPanelScreen();
        ListPanel.listPanelScreen();
        SchedulePanel.schedulePanelScreen();
        ChangePWPanel.changePWScreen();
        EditUsersPanel.editUserScreen();

        // Schedule Billboards Panel:
        JLabel label_Schedule = new JLabel("What's on when");

        // Edit Users panel:
        JLabel label_EditUsers = new JLabel("Edit Users");


        // Add the tabs to the tab pane.
        tabs.add("Create Billboard",createPanel);
        tabs.add("List Billboards",listPanel);
        tabs.add("Schedule Billboard",schedulePanel);
        tabs.add("Change Password",passwordPanel);
        tabs.add("Edit Users", editUserPanel);

        controlPanelScreen.add(tabs);
        controlPanelScreen.setLayout(null);
        controlPanelScreen.setUndecorated(true);
        controlPanelScreen.setVisible(true);
        controlPanelScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
