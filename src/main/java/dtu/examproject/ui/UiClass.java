package dtu.examproject.ui;

import dtu.examproject.main.Activity;
import dtu.examproject.main.TimeRegistration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UiClass extends JFrame implements ActionListener {

    public static TimeRegistration system = new TimeRegistration();
    // worker buttons
    public JButton bWorkerFunctions, bAddUser, bSetProjectLead, bSelectActivityTimeUsed,
            bGetRegisteredTime, bAddUserToActivity, bAddActivity, bAddProject;
    // project lead buttons
    public JButton bSetActivityHourBudget, bSeeAvalibleUsers, bSeeDistributionOfHours, bSetStartEndTime,
            bSetNewProjectLead, bUserLogout;
    public JTextArea txtarea;
    public JTextField txtfld;
    public JLabel txt1, txt2, txtusername;
    public static String username = "placeholder";

    public UiClass() {

        getContentPane().setLayout(new BorderLayout());

        Dimension btnsize = new Dimension(190, 40);
        Dimension txtsize = new Dimension(150, 30);


        bWorkerFunctions = new JButton("Worker Functions");
        bWorkerFunctions.addActionListener(this);
        bWorkerFunctions.setMaximumSize(btnsize);
        bWorkerFunctions.setAlignmentX(Component.CENTER_ALIGNMENT);

        bAddUser = new JButton("Add User");
        bAddUser.addActionListener(this);
        bAddUser.setMaximumSize(btnsize);
        bAddUser.setAlignmentX(Component.CENTER_ALIGNMENT);

        bSetProjectLead = new JButton("Set Project Lead");
        bSetProjectLead.addActionListener(this);
        bSetProjectLead.setMaximumSize(btnsize);
        bSetProjectLead.setAlignmentX(Component.CENTER_ALIGNMENT);

        bSelectActivityTimeUsed = new JButton("Select Activity Time Used");
        bSelectActivityTimeUsed.addActionListener(this);
        bSelectActivityTimeUsed.setMaximumSize(btnsize);
        bSelectActivityTimeUsed.setAlignmentX(Component.CENTER_ALIGNMENT);

        bGetRegisteredTime = new JButton("Get Registered Time");
        bGetRegisteredTime.addActionListener(this);
        bGetRegisteredTime.setMaximumSize(btnsize);
        bGetRegisteredTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        bAddUserToActivity = new JButton("Add User To Activity");
        bAddUserToActivity.addActionListener(this);
        bAddUserToActivity.setMaximumSize(btnsize);
        bAddUserToActivity.setAlignmentX(Component.CENTER_ALIGNMENT);

        bAddActivity = new JButton("Add Activity");
        bAddActivity.addActionListener(this);
        bAddActivity.setMaximumSize(btnsize);
        bAddActivity.setAlignmentX(Component.CENTER_ALIGNMENT);

        bAddProject = new JButton("Add Project");
        bAddProject.addActionListener(this);
        bAddProject.setMaximumSize(btnsize);
        bAddProject.setAlignmentX(Component.CENTER_ALIGNMENT);

        bSetActivityHourBudget = new JButton("Set Activity Hour Budget");
        bSetActivityHourBudget.addActionListener(this);
        bSetActivityHourBudget.setMaximumSize(btnsize);
        bSetActivityHourBudget.setAlignmentX(Component.CENTER_ALIGNMENT);

        bSeeAvalibleUsers = new JButton("See Avalible Users");
        bSeeAvalibleUsers.addActionListener(this);
        bSeeAvalibleUsers.setMaximumSize(btnsize);
        bSeeAvalibleUsers.setAlignmentX(Component.CENTER_ALIGNMENT);

        bSeeDistributionOfHours = new JButton("See Distribution Of Hours");
        bSeeDistributionOfHours.addActionListener(this);
        bSeeDistributionOfHours.setMaximumSize(btnsize);
        bSeeDistributionOfHours.setAlignmentX(Component.CENTER_ALIGNMENT);

        bSetStartEndTime = new JButton("Set Activity Start End Time");
        bSetStartEndTime.addActionListener(this);
        bSetStartEndTime.setMaximumSize(btnsize);
        bSetStartEndTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        bSetNewProjectLead = new JButton("Set New Project Lead");
        bSetNewProjectLead.addActionListener(this);
        bSetNewProjectLead.setMaximumSize(btnsize);
        bSetNewProjectLead.setAlignmentX(Component.CENTER_ALIGNMENT);

        bUserLogout = new JButton("Logout");
        bUserLogout.addActionListener(this);
        bUserLogout.setMaximumSize(btnsize);
        bUserLogout.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
        txt1 = new JLabel("            User Buttons");
        txt1.setMaximumSize(txtsize);
        txt1.setAlignmentX(CENTER_ALIGNMENT);
        p1.add(txt1);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add first button
        /*
         * p1.add(bWorkerFunctions);
         * // Create a small filler (between 1st and 2nd button)
         * p1.add(Box.createRigidArea(new Dimension(110, 5)));
         * // Add second button
         */
        p1.add(bAddProject);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        p1.add(bAddActivity);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        p1.add(bSelectActivityTimeUsed);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        p1.add(bGetRegisteredTime);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        p1.add(bAddUserToActivity);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        p1.add(bSetProjectLead);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        p1.add(bAddUser);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        p1.add(bUserLogout);
        p1.add(Box.createRigidArea(new Dimension(110, 170)));

        txtusername = new JLabel("  Signed in as "+username);
        txtusername.setMaximumSize(txtsize);
        txtusername.setAlignmentX(CENTER_ALIGNMENT);
        p1.add(txtusername);

 
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));

        txt2 = new JLabel("     Project Lead Buttons");
        txt2.setMaximumSize(txtsize);
        txt2.setAlignmentX(CENTER_ALIGNMENT);
        p2.add(txt2);
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        p2.add(bSetActivityHourBudget);
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        p2.add(bSeeAvalibleUsers);
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        p2.add(bSeeDistributionOfHours);
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        p2.add(bSetStartEndTime);
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        p2.add(bSetNewProjectLead);


        getContentPane().add(p1, BorderLayout.WEST);
        System.out.print("here now and username is ");
        System.out.println(username);
        if (username.equals("admn")) {
            System.out.println("showing admin panel");
            getContentPane().add(p2, BorderLayout.EAST);
        }

        txtarea = new JTextArea();
        JScrollPane scrollpane = new JScrollPane(txtarea);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        txtarea.setEditable(false);
        txtfld = new JTextField(40);

    }

    // --------------------------------------------------- WORKER BUTTON ACTIONS
    public void actionPerformed(ActionEvent actionEvent) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (actionEvent.getSource() == bWorkerFunctions) {
            System.exit(0);

        } else if (actionEvent.getSource() == bAddUser) {
            dialogPanel dialog = new dialogPanel(frame, "Register user", "Enter", "User name (4 characters)");
            dialog.setVisible(true);
            String name = dialog.getName();
            if (name == null) {
                return;
            }
            try {
                system.addUser(name);
                txtarea.append("Added user: " + name + "\n");
            } catch (Exception e) {
                txtarea.append(e.getMessage() + "\n");
            }

        } else if (actionEvent.getSource() == bSetProjectLead) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    dialogPanel dialog = new dialogPanel(frame, "Enter a project", "Enter", "Project name");
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    if (name1 == null) {
                        return;
                    }

                    dialogPanel dialog2 = new dialogPanel(frame, "Enter an employee", "Enter", "Employee name");
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name2 == null) {
                        return;
                    }
                    try {
                        system.setProjectLead(name1, name2);
                        txtarea.append("Set: " + name2 + " as the leader of the project " + name1 + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        txtarea.append(e.getMessage() + "\n");
                    }
                }
            });
        } else if (actionEvent.getSource() == bSelectActivityTimeUsed) {
            dialogPanel dialog = new dialogPanel(frame, "Enter project name", "Enter", "Cancel");
            dialog.setVisible(true);
            String p = dialog.getName();
            if (p == null) {
                return;
            }

            dialogPanel dialog2 = new dialogPanel(frame, "Enter activity name", "Enter", "Cancel");
            dialog2.setVisible(true);
            String a = dialog2.getName();
            if (a == null) {
                return;
            }

            dialogPanel dialog4 = new dialogPanel(frame, "Enter an employee", "Enter", "Cancel");
            dialog4.setVisible(true);
            String e = dialog4.getName();
            if (e == null) {
                return;
            }

            dialogPanel dialog3 = new dialogPanel(frame, "Enter week", "Enter", "Cancel");
            dialog3.setVisible(true);
            int week = Integer.parseInt(dialog3.getName());
            if (week == 0) {
                return;
            }

            dialogPanel dialog5 = new dialogPanel(frame, "Enter number of hours", "Enter", "Cancel");
            dialog5.setVisible(true);
            double hours = Double.parseDouble(dialog5.getName());

            try {
                system.registerHours(p,a,e,week,hours);
                txtarea.append("Employee " + e + " now has " + hours + " hours of work registered in activity "+a+" for week "+week+"\n");
            } catch (Exception ee) {
                System.out.println(ee);
                txtarea.append(ee.getMessage() + "\n");
            }


        } else if (actionEvent.getSource() == bGetRegisteredTime) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    dialogPanel dialog = new dialogPanel(frame, "Enter an employee", "Enter", "Cancel");
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        try {
                            double time = system.getRegisteredTime(name);
                            txtarea.append("The user: " + name + " has " + time + " hours registered" + "\n");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            txtarea.append(e.getMessage() + "\n");
                        }

                    }
                }
            });
        } else if (actionEvent.getSource() == bAddUserToActivity) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    dialogPanel dialog = new dialogPanel(frame, "Enter a project", "Enter", "Cancel");
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    if (name1 == null) {
                        return;
                    }

                    dialogPanel dialog2 = new dialogPanel(frame, "Enter an activity", "Enter", "Cancel");
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name2 == null) {
                        return;
                    }

                    dialogPanel dialog3 = new dialogPanel(frame, "Enter an employee", "Enter", "Cancel");
                    dialog3.setVisible(true);
                    String name3 = dialog3.getName();
                    if (name3 == null) {
                        return;
                    }
                    try {
                        system.addUserToActivity(name1, name2, name3);
                        txtarea.append("Added user: " + name3 + " to the activity " + name2
                                + " in the project " + name1 + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        txtarea.append(e.getMessage() + "\n");
                    }
                }
            });

        } else if (actionEvent.getSource() == bAddActivity) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    dialogPanel dialog = new dialogPanel(frame, "Enter a project", "Enter", "Cancel");
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    if (name1 == null) {
                        return;
                    }
                    dialogPanel dialog2 = new dialogPanel(frame, "Enter an activity", "Enter", "Cancel");
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name2 == null) {
                        return;
                    }
                    try {
                        system.createActivity(name1, name2);
                        txtarea.append("Created activity: " + name2 + " in the project " + name1 + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        txtarea.append(e.getMessage() + "\n");
                    }
                }
            });
        } else if (actionEvent.getSource() == bAddProject) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    dialogPanel dialog = new dialogPanel(frame, "Enter a project name", "Enter", "Cancel");
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name == null) {
                        return;
                    }
                    try {
                        system.createProject(name);
                        txtarea.append("Created project: " + name + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        txtarea.append(e.getMessage() + "\n");
                    }

                }
            });
        }
        // ------------------------------------------------ PROJECT LEAD BUTTON ACTIONS
        else if (actionEvent.getSource() == bSetNewProjectLead) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    dialogPanel dialog = new dialogPanel(frame, "Enter a project", "Enter", "Cancel");
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name == null) {
                        return;
                    }

                    dialogPanel dialog2 = new dialogPanel(frame, "Enter an employee", "Enter", "Cancel");
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name2 == null) {
                        return;
                    }
                    try {
                        system.setProjectLead(name, name2);
                        txtarea.append("Set: " + name2 + " as project leader in " + name + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        txtarea.append(e.getMessage() + "\n");
                    }
                }
            });
        }

        else if (actionEvent.getSource() == bSetStartEndTime) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {

                    dialogPanel dialog = new dialogPanel(frame, "Enter a project", "Enter", "Cancel");
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    if (name1 == null) {
                        return;
                    }
                    dialogPanel dialog2 = new dialogPanel(frame, "Enter an activity", "Enter", "Cancel");
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name2 == null) {
                        return;
                    }
                    dialogPanel dialog3 = new dialogPanel(frame, "Enter a start week for activity", "Enter", "Cancel");
                    dialog3.setVisible(true);
                    int intValue3 = Integer.parseInt(dialog3.getName());

                    dialogPanel dialog4 = new dialogPanel(frame, "Enter an end week for activity", "Enter", "Cancel");
                    dialog4.setVisible(true);
                    int intValue4 = Integer.parseInt(dialog4.getName());

                    try {
                        system.setActivityStart(name1, name2, intValue3);
                        system.setActivityEnd(name1, name2, intValue4);
                        txtarea.append("Activity: " + name2 + " starts " + intValue3 + " and ends "
                                + intValue4 + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        txtarea.append(e.getMessage() + "\n");
                    }
                }
            });
        }

        else if (actionEvent.getSource() == bSeeDistributionOfHours) {


            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    dialogPanel dialog = new dialogPanel(frame, "Enter a project", "Enter", "Cancel");
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name == null) {
                        return;
                    }
                    Map<Activity, Double> hourDistributionMap;
                    try {
                        hourDistributionMap = system.getHourDistribution(name);
                    } catch (Exception e) {
                        txtarea.append(e.getMessage() + "\n");
                        return;
                    }
                    for (Map.Entry<Activity, Double> entry : hourDistributionMap.entrySet()) {
                        Activity activity = entry.getKey();
                        Double hours = entry.getValue();
                        txtarea.append("Activity: " + activity.getTitle() + ", budgeted hours: " + (activity.getBudgetedHours()) + ", registered hours: " + hours+"\n");
                    }


                }
            });
        }

        else if (actionEvent.getSource() == bSeeAvalibleUsers) {
            dialogPanel dialog = new dialogPanel(frame, "Enter project name", "Enter project", "Cancel");
            dialog.setVisible(true);
            String project = dialog.getName();
            if (project == null) {
                return;
            }

            dialogPanel dialog2 = new dialogPanel(frame, "Enter start week", "Enter Week", "Cancel");
            dialog2.setVisible(true);
            int startWeek = Integer.parseInt(dialog2.getName());

            dialogPanel dialog3 = new dialogPanel(frame, "Enter end week", "Enter Week", "Cancel");
            dialog3.setVisible(true);
            int endWeek = Integer.parseInt(dialog3.getName());

            try {
                Map<String, Double> availableEmployees = system.getAvailableEmployees(project, startWeek, endWeek);

                List<Map.Entry<String, Double>> sortedEmployees = new ArrayList<>(availableEmployees.entrySet());
                sortedEmployees.sort(Map.Entry.comparingByValue());
                for (Map.Entry<String, Double> entry : sortedEmployees) {
                    txtarea.append("Employee: " + entry.getKey() + ", Hours registered: " + entry.getValue() + "\n");
                }
            } catch (Exception ee) {
                System.out.println("An error occurred: " + ee.getMessage());
                txtarea.append(ee.getMessage() + "\n");
            }
        }

        else if (actionEvent.getSource() == bSetActivityHourBudget) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    dialogPanel dialog = new dialogPanel(frame, "Enter a project", "Enter", "Cancel");
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    if (name1 == null) {
                        return;
                    }

                    dialogPanel dialog2 = new dialogPanel(frame, "Enter an activity", "Enter", "Cancel");
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name2 == null) {
                        return;
                    }

                    dialogPanel dialog3 = new dialogPanel(frame, "Enter a budget in hours", "Enter", "Cancel");
                    dialog3.setVisible(true);
                    int intValue = Integer.parseInt(dialog3.getName());
                    try {
                        system.setActivityHourBudget(name1, name2, intValue);
                        txtarea.append("Activity: " + name2 + " from project " + name1
                                + " now has a budget of " + intValue + "\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        txtarea.append(e.getMessage() + "\n");
                    }


                }
            });
        }
    }

    public static void main(String[] args) {
        UiClass simplegui = new UiClass();
        showLoginDialog(simplegui);
        System.out.println("ok starting now");
        simplegui.setTitle("SimpleGui"); // Set title on window
        simplegui.setSize(800, 600); // Set size
        simplegui.setResizable(false); // Allow the window to be resized
        simplegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // simplegui.setVisible(true);

    }

    private static void showLoginDialog(JFrame parent) {
        JTextField textField = new JTextField(20);
        JButton loginButton = new JButton("Log In");
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter username:"));
        panel.add(textField);
        panel.add(loginButton);

        ActionListener loginAction = e -> {
            username = textField.getText();
            parent.dispose();
            UiClass simplegui = new UiClass();
            simplegui.setTitle("Project Registration Software");
            simplegui.setSize(900, 600);
            simplegui.setResizable(false);
            simplegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simplegui.setVisible(true);
            JOptionPane.showMessageDialog(simplegui, "Logged in as: " + username);
            try {
                system.login("admn");
                system.addUser(username);
                system.logout();
                system.login(username);
            } catch (Exception excep) {
                System.out.println(excep.getMessage());
            }
            if (system.loggedIn()){System.out.println("logged in");}
            else{System.out.println("not logged in");}
        };

        loginButton.addActionListener(loginAction);

        textField.addActionListener(loginAction); // Listen for "Enter" key press

        JOptionPane.showMessageDialog(parent, panel, "Log In", JOptionPane.PLAIN_MESSAGE);
    }

    public class dialogPanel extends JDialog{
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public dialogPanel(Frame parent, String title, String btnText, String labelText) {
            super(parent, title, true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton(btnText);

            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    name = nameField.getText();
                    dispose(); // Close the dialog
                }
            });

            nameField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        name = nameField.getText();
                        dispose();
                    }
                }
            });
            panel.add(new JLabel(labelText), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(450, 100);
            setLocationRelativeTo(parent);
        }
        public String getName() {
            return name;
        }
    }
}
