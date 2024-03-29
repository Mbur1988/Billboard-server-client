package Clients.ControlPanel.ControlPanelTools;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static Clients.ControlPanel.ControlPanelInterface.ControlPanelInterface.schedulePanel;
import static Clients.ControlPanel.ControlPanelInterface.ControlPanelInterface.screenWidth;
import static Clients.ControlPanel.ControlPanelTools.DayChooser.minRec;
import static Clients.ControlPanel.ControlPanelTools.Tools.*;

public class DurationSetter {

    public static int duration = 0;
    public static JLabel lbl_duration;
    public static JTextField tf_duration;

    public static void setDuration() {

        lbl_duration = new JLabel("Set duration: ");
        addLabel(schedulePanel, lbl_duration, ((screenWidth / 3)), 380, 180, 50);

        tf_duration = new JTextField("duration (mins)");
        addTextfield(schedulePanel, tf_duration, ((screenWidth / 3)), 420, 160, 40);

        tf_duration.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_duration.setText(null);
            }
            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        tf_duration.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    duration = Integer.parseInt(tf_duration.getText());

                } catch (NumberFormatException i) {
                    if (tf_duration != null) {
                        JOptionPane.showMessageDialog(schedulePanel,
                                "Please set duration in number of minutes.",
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                checkDurationVsRecurrence.checkDVsR(minRec, duration);
                lbl_duration.setText("Set duration: " + duration);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    duration = Integer.parseInt(tf_duration.getText());

                } catch (NumberFormatException i) {
                    if (tf_duration != null) {
//                        JOptionPane.showMessageDialog(schedulePanel,
//                                "Please set duration in number of minutes.",
//                                "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    duration = Integer.parseInt(tf_duration.getText());
                    checkDurationVsRecurrence.checkDVsR(minRec, duration);
                } catch (NumberFormatException i) {
                    if (tf_duration != null) {
                        JOptionPane.showMessageDialog(schedulePanel,
                                "Please set duration in number of minutes.",
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                checkDurationVsRecurrence.checkDVsR(minRec, duration);
                lbl_duration.setText("Set duration: " + duration);

            }
        });
    }

    public static void clearDuration() {
        lbl_duration.setText("Set duration: ");
        tf_duration.setText(null);
        duration = 0;
    }

    public static void updateDuration(int newDuration) {
        duration = newDuration;
        lbl_duration.setText("Set duration: " + duration);
        tf_duration.setText(String.valueOf(duration));
    }
}
