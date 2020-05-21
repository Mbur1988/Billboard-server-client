package Clients.ControlPanel.ControlPanelTools;

import Clients.ControlPanel.ControlPanelInterface.SchedulePanel;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

import static Clients.ControlPanel.ControlPanelInterface.ControlPanelInterface.schedulePanel;

public class DateChooser {

    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);    // Is there a better way to do these???

    JLabel lbl_date = new JLabel("", JLabel.CENTER);
    String day = "";
    JDialog dlg_date;

    JButton[] button = new JButton[49];

    public void displayDate() {
        for (int x = 7; x < button.length; x++)
            button[x].setText("");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, 1);
        int weekDay = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int numDays = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        for (int i = 6 + weekDay, day = 1; day <= numDays; i++, day++)
            button[i].setText("" + day);
        lbl_date.setText(sdf.format(cal.getTime()));
        dlg_date.setTitle("Select date");
    }

    public String setPickedDate() {
        if (day.equals(""))
            return day;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "dd-MM-yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, Integer.parseInt(day));
        return sdf.format(cal.getTime());
    }

    public DateChooser(JPanel parent) {
        dlg_date = new JDialog();
        dlg_date.setModal(true);

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        JPanel cal = new JPanel(new GridLayout(7, 7));
        cal.setPreferredSize(new Dimension(500, 200));

        for (int i = 0; i < button.length; i++) {
                final int selection = i;

                button[i] = new JButton();
                button[i].setFocusPainted(false);

                if (i > 6) {
                    button[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            day = button[selection].getActionCommand();
                            dlg_date.dispose();
                        }
                    });
                }

                if (i < 7) {
                    button[i].setText(days[i]);
                    button[i].setForeground(Color.gray);  // colour can be changed...
                }

                cal.add(button[i]);

        }

        JPanel chooserWindow = new JPanel(new GridLayout(1, 3));

        JButton b_prev = new JButton("<");

        b_prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                month--;
                displayDate();
            }
        });

        chooserWindow.add(b_prev);
        chooserWindow.add(lbl_date);
        JButton b_next = new JButton(">");

        b_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                month++;
                displayDate();
            }
        });

        chooserWindow.add(b_next);
        displayDate();
        dlg_date.add(cal, BorderLayout.CENTER);
        dlg_date.add(chooserWindow, BorderLayout.NORTH);
        dlg_date.pack();
        dlg_date.setLocationRelativeTo(parent);
        dlg_date.setVisible(true);
    }

    public static void chooseDate() {
        JLabel lbl_date = new JLabel("Date:");
        JLabel tf_date = new JLabel("                   ");
        JButton b_selDate = new JButton("Select Date");
        schedulePanel.add(lbl_date);
        schedulePanel.add(tf_date);
        schedulePanel.add(b_selDate);

        b_selDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_date.setText(new DateChooser(schedulePanel).setPickedDate());
                String storeDate = tf_date.getText(); // This will store the date for anyone who needs it... convenient right? Thanks Shane. You're welcome guys!
            }
        });

    }

}