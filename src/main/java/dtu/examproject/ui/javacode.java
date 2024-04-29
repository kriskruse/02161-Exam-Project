package dtu.examproject.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;

import dtu.examproject.main.Activity;
import dtu.examproject.main.Project;
import dtu.examproject.main.TimeRegistration;

public class javacode extends JFrame implements ActionListener {

    public static TimeRegistration system = new TimeRegistration();
    private static final long serialVersionUID = 1L;
    // worker buttons
    public JButton bWorkerFunctions, bAddUser, bSetProjectLead, bSelectActivityTimeUsed,
            bGetRegisteredTime, bAddUserToActivity, bAddActivity, bAddProject; // Buttons
    // project lead buttons
    public JButton bSetActivityHourBudget, bSeeAvalibleUsers, bSeeDistributionOfHours, bSetStartEndTime,
            bSetNewProjectLead; // Buttons
    public JTextArea txtarea; // Large text area in the middle of the window
    public JTextField txtfld; // Small text field at the bottom of the window
    public JLabel txt1, txt2;
    public static String username = "placeholder";
    public static String password;
    // public JTextField txtfld2;

    public javacode() {

        // Set a BorderLayout on the main window
        getContentPane().setLayout(new BorderLayout());

        // Define a standard button size - 100 x 30 pixels
        Dimension btnsize = new Dimension(190, 40);
        Dimension txtsize = new Dimension(150, 30);

        // Create a button and set max size and alignment (relative to the surrounding
        // container)
        bWorkerFunctions = new JButton("Worker Functions");
        bWorkerFunctions.addActionListener(this);
        bWorkerFunctions.setMaximumSize(btnsize);
        bWorkerFunctions.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the second button
        bAddUser = new JButton("Add User");
        bAddUser.addActionListener(this);
        bAddUser.setMaximumSize(btnsize);
        bAddUser.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the clear button
        bSetProjectLead = new JButton("Set Project Lead");
        bSetProjectLead.addActionListener(this);
        bSetProjectLead.setMaximumSize(btnsize);
        bSetProjectLead.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bSelectActivityTimeUsed = new JButton("Select Activity Time Used");
        bSelectActivityTimeUsed.addActionListener(this);
        bSelectActivityTimeUsed.setMaximumSize(btnsize);
        bSelectActivityTimeUsed.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bGetRegisteredTime = new JButton("Get Registered Time");
        bGetRegisteredTime.addActionListener(this);
        bGetRegisteredTime.setMaximumSize(btnsize);
        bGetRegisteredTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bAddUserToActivity = new JButton("Add User To Activity");
        bAddUserToActivity.addActionListener(this);
        bAddUserToActivity.setMaximumSize(btnsize);
        bAddUserToActivity.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bAddActivity = new JButton("Add Activity");
        bAddActivity.addActionListener(this);
        bAddActivity.setMaximumSize(btnsize);
        bAddActivity.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bAddProject = new JButton("Add Project");
        bAddProject.addActionListener(this);
        bAddProject.setMaximumSize(btnsize);
        bAddProject.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bSetActivityHourBudget = new JButton("Set Activity Hour Budget");
        bSetActivityHourBudget.addActionListener(this);
        bSetActivityHourBudget.setMaximumSize(btnsize);
        bSetActivityHourBudget.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bSeeAvalibleUsers = new JButton("See Avalible Users");
        bSeeAvalibleUsers.addActionListener(this);
        bSeeAvalibleUsers.setMaximumSize(btnsize);
        bSeeAvalibleUsers.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bSeeDistributionOfHours = new JButton("See Distribution Of Hours");
        bSeeDistributionOfHours.addActionListener(this);
        bSeeDistributionOfHours.setMaximumSize(btnsize);
        bSeeDistributionOfHours.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bSetStartEndTime = new JButton("Set Activity Start End Time");
        bSetStartEndTime.addActionListener(this);
        bSetStartEndTime.setMaximumSize(btnsize);
        bSetStartEndTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Same for the last button
        bSetNewProjectLead = new JButton("Set New Project Lead");
        bSetNewProjectLead.addActionListener(this);
        bSetNewProjectLead.setMaximumSize(btnsize);
        bSetNewProjectLead.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a container (JPanel) to hold the first four buttons
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
        // Filler
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add third button
        p1.add(bAddActivity);
        // Filler
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add final button
        p1.add(bSelectActivityTimeUsed);
        // Filler
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add final button
        p1.add(bGetRegisteredTime);
        // Filler
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add final button
        p1.add(bAddUserToActivity);
        // Filler
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add final button
        p1.add(bSetProjectLead);
        // Filler
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add final button
        p1.add(bAddUser);

        // Create a container (JPanel) to hold the first four buttons
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));

        txt2 = new JLabel("     Project Lead Buttons");
        txt2.setMaximumSize(txtsize);
        txt2.setAlignmentX(CENTER_ALIGNMENT);
        p2.add(txt2);
        // Create a small filler (above the first button)
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add first button
        p2.add(bSetActivityHourBudget);
        // Create a small filler (between 1st and 2nd button)
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add second button
        p2.add(bSeeAvalibleUsers);
        // Filler
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add third button
        p2.add(bSeeDistributionOfHours);
        // Filler
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add final button
        p2.add(bSetStartEndTime);
        // Filler
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add final button
        p2.add(bSetNewProjectLead);

        // Add container (panel with buttons) to (left side of) main window

        getContentPane().add(p1, BorderLayout.WEST);
        System.out.print("here now and username is ");
        System.out.println(username);
        if (username.equals("admn")) {
            System.out.println("login as admin");
            getContentPane().add(p2, BorderLayout.EAST);
        }

        // Create a JTextArea (inside a JScrollPane) in the center part
        txtarea = new JTextArea();
        JScrollPane scrollpane = new JScrollPane(txtarea);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        txtarea.setEditable(false);
        // Create a textfield (approx. size = 40 characters)
        txtfld = new JTextField(40);

    }


    // --------------------------------------------------- WORKER BUTTON ACTIONS
    // -------------------------------------------------------
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bWorkerFunctions) {
            System.exit(0);
        } else if (actionEvent.getSource() == bAddUser) {

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    NameInputDialog dialog = new NameInputDialog(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        // JOptionPane.showMessageDialog(frame, "Name entered: " + name);
                        try {
                            system.addUser(name);
                            txtarea.append("Added user: " + name + "\n");
                        } catch (Exception e) {
                            String errorMessage = e.getMessage();
                            txtarea.append(errorMessage + "\n");
                        }

                    }
                }
            });

        } else if (actionEvent.getSource() == bSetProjectLead) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    bSetProjectLeadMethod dialog = new bSetProjectLeadMethod(frame);
                    bSetProjectLeadMethod dialog2 = new bSetProjectLeadMethod(frame);
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name1 != null) {
                        if (name2 != null) {
                            try {
                                system.setProjectLead(name1, name2);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            txtarea.append("Set: " + name2 + " as the leader of the project " + name1 + "\n");
                        }
                    }
                }
            });
        } else if (actionEvent.getSource() == bSelectActivityTimeUsed) {
            /*
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    bAddUserToActivityMethod dialog = new bAddUserToActivityMethod(frame);
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    dialog.setVisible(true);
                    String name2 = dialog.getName();
                    dialog.setVisible(true);
                    String name3 = dialog.getName();
                    int intValue = Integer.parseInt(name3);
                    if (name1 != null) {
                        if (name2 != null) {
                            if (name3 != null) {
                                try {
                                    system.setActivityHourBudget(name1, name2, intValue);
                                    txtarea.append("Activity: " + name2 + " from project " + name1
                                            + " now has a budget of " + name3 + "\n");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                }
            });*/
        } else if (actionEvent.getSource() == bGetRegisteredTime) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    bGetRegisteredTimeMethod dialog = new bGetRegisteredTimeMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        try {
                            double time = system.getRegisteredTime(name);
                            txtarea.append("The user: " + name + " has " + time + " hours registered" + "\n");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                }
            });
        } else if (actionEvent.getSource() == bAddUserToActivity) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    bAddUserToActivityMethod dialog1 = new bAddUserToActivityMethod(frame);
                    dialog1.setVisible(true);
                    String name1 = dialog1.getName();
                    bAddUserToActivityMethod dialog2 = new bAddUserToActivityMethod(frame);
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    bAddUserToActivityMethod dialog3 = new bAddUserToActivityMethod(frame);
                    dialog3.setVisible(true);
                    String name3 = dialog3.getName();
                    if (name1 != null) {
                        if (name2 != null) {
                            if (name3 != null) {
                                try {
                                    system.addUserToActivity(name1, name2, name3);
                                    txtarea.append("Added user: " + name3 + " to the activity " + name2
                                            + " in the project " + name1 + "\n");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                }
            });

        } else if (actionEvent.getSource() == bAddActivity) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    bAddActivityMethod dialog = new bAddActivityMethod(frame);
                    bAddActivityMethod dialog2 = new bAddActivityMethod(frame);
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name1 != null) {
                        if (name2 != null) {
                            try {
                                system.createActivity(name1, name2);
                                txtarea.append("Created activity: " + name2 + " in the project " + name1 + "\n");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                txtarea.append(e + "\n");
                            }

                        }
                    }
                }
            });
        } else if (actionEvent.getSource() == bAddProject) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dialogPanel dialog = new dialogPanel(frame, "Enter project name", "Create Project", "Cancel");

                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        try {
                            system.createProject(name);
                            txtarea.append("Created project: " + name + "\n");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            txtarea.append(e + "\n");
                        }
                    }
                }
            });
        }
        // ------------------------------------------------ PROJECT LEAD BUTTON ACTIONS
        // ----------------------------------------------------
        else if (actionEvent.getSource() == bSetNewProjectLead) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    bSetNewProjectLeadMethod dialog = new bSetNewProjectLeadMethod(frame);
                    bSetNewProjectLeadMethod dialog2 = new bSetNewProjectLeadMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    if (name != null) {
                        if (name2 != null) {
                            try {
                                system.setProjectLead(name, name2);
                                txtarea.append("Set: " + name2 + " as project leader in " + name + "\n");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                txtarea.append(e + "\n");
                            }
                        }
                    }
                }
            });
        }

        else if (actionEvent.getSource() == bSetStartEndTime) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    bSetStartEndTimeMethod dialog = new bSetStartEndTimeMethod(frame);
                    bSetStartEndTimeMethod dialog2 = new bSetStartEndTimeMethod(frame);
                    bSetStartEndTimeMethod dialog3 = new bSetStartEndTimeMethod(frame);
                    bSetStartEndTimeMethod dialog4 = new bSetStartEndTimeMethod(frame);
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    dialog3.setVisible(true);
                    String name3 = dialog3.getName();
                    dialog4.setVisible(true);
                    String name4 = dialog4.getName();
                    int intValue3 = Integer.parseInt(name3);
                    int intValue4 = Integer.parseInt(name4);
                    if (name1 != null && name2 != null && name3 != null && name4 != null){
                        try {
                            system.setActivityStart(name1, name2, intValue3);
                            system.setActivityEnd(name1, name2, intValue4);
                            txtarea.append("Activity: " + name2 + " starts " + intValue3 + " and ends "
                                    + intValue4 + "\n");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            });
        }

        else if (actionEvent.getSource() == bSeeDistributionOfHours) {


            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    bSeeDistributionOfHoursMethod dialog = new bSeeDistributionOfHoursMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        Map<Activity, Double> hourDistributionMap;
                        try {
                            hourDistributionMap = system.getHourDistribution(name);
                        } catch (Exception e) {
                            txtarea.append(e + "\n");
                            return;
                        }
                        for (Map.Entry<Activity, Double> entry : hourDistributionMap.entrySet()) {
                            Activity activity = entry.getKey();
                            Double hours = entry.getValue();
                            txtarea.append("Activity: " + activity.getTitle() + ", Hours: " + hours+"\n");
                        }

                    }
                }
            });
        }

        else if (actionEvent.getSource() == bSeeAvalibleUsers) {
            /*
             * try {
             * system.addUser("User1");
             * system.addUser("User2");
             * system.addUser("User3");
             * } catch (Exception eeee) {
             * System.out.println("An error occurred: " + eeee.getMessage());
             * }
             * 
             * // Create a project
             * try {
             * system.createProject("Project1");
             * 
             * // Add users to the project
             * system.addUserToProject("Project1", "User1");
             * system.addUserToProject("Project1", "User2");
             * system.addUserToProject("Project1", "User3");
             * } catch (Exception eee) {
             * System.out.println("An error occurred: " + eee.getMessage());
             * }
             */
            try {
                txtarea.append("List of employees assigned to a project, without an activity" + "\n");
                List<Project> projects = system.getProjectList();
                System.out.println("Available Employees:");
                for (Project project : projects) {
                    Map<String,Double> availableEmployees = project.getAvailableEmployees();
                    for (String employee : availableEmployees.keySet()) {
                        txtarea.append(employee + " (Project: " + project.getProjectName() + ")" + "\n");
                    }
                }
            } catch (Exception ee) {
                System.out.println("An error occurred: " + ee.getMessage());
            }

        }

        else if (actionEvent.getSource() == bSetActivityHourBudget) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    SetProjectHourBudgetMethod dialog = new SetProjectHourBudgetMethod(frame);
                    SetProjectHourBudgetMethod dialog2 = new SetProjectHourBudgetMethod(frame);
                    SetProjectHourBudgetMethod dialog3 = new SetProjectHourBudgetMethod(frame);
                    dialog.setVisible(true);
                    String name1 = dialog.getName();
                    dialog2.setVisible(true);
                    String name2 = dialog2.getName();
                    dialog3.setVisible(true);
                    String name3 = dialog3.getName();
                    int intValue = Integer.parseInt(name3);
                    if (name1 != null) {
                        if (name2 != null) {
                            if (name3 != null) {
                                try {
                                    system.setActivityHourBudget(name1, name2, intValue);
                                    txtarea.append("Activity: " + name2 + " from project " + name1
                                            + " now has a budget of " + name3 + "\n");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        javacode simplegui = new javacode();
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
            javacode simplegui = new javacode();
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



    // ------------------------------------ bAddUser function
    // -------------------------------------
    public class NameInputDialog extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public NameInputDialog(Frame parent) {
            super(parent, "Enter Name", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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

            panel.add(new JLabel("Enter Name:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ------------------------------------ bSetProjectLead function
    // -------------------------------------
    public class bSetProjectLeadMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bSetProjectLeadMethod(Frame parent) {
            super(parent, "Enter first a project, and then a leader", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Input:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(300, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ---------------------------------------- bSetProjectActivitiesMethod
    // -------------------------------------
    public class bSetProjectActivitiesMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bSetProjectActivitiesMethod(Frame parent) {
            super(parent, "Enter first a project, then an activity", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Input:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(320, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ---------------------------------------- bSelectActivityTimeUsedMethod
    // -------------------------------------
    public class bSelectActivityTimeUsedMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bSelectActivityTimeUsedMethod(Frame parent) {
            super(parent, "Enter how much time has been used on the activity", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Enter Time:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(300, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ---------------------------------------- bGetRegisteredTimeMethod
    // -------------------------------------
    public class bGetRegisteredTimeMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bGetRegisteredTimeMethod(Frame parent) {
            super(parent, "Who would you like to see the registered hours for", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Enter name:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(300, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ---------------------------------------- SetProjectHourBudgetMethod
    // -------------------------------------
    public class SetProjectHourBudgetMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public SetProjectHourBudgetMethod(Frame parent) {
            super(parent, "Enter a project, activity and then a time in hours", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Input:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(340, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ------------------------------------------ bSetNewProjectLeadMethod
    // ------------------------------------------
    public class bSetNewProjectLeadMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bSetNewProjectLeadMethod(Frame parent) {
            super(parent, "Enter first a project and then a new leader", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Input:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(300, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ------------------------------------------ bSetStartEndTimeMethod
    // --------------------------------------------
    public class bSetStartEndTimeMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bSetStartEndTimeMethod(Frame parent) {
            super(parent, "Enter project, activity, start, and end", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Input:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(300, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ------------------------------------------ bSeeDistributionOfHoursMethod
    // -------------------------------------
    public class bSeeDistributionOfHoursMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bSeeDistributionOfHoursMethod(Frame parent) {
            super(parent, "What project would you like to see the distribution for", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Enter project name:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(365, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ------------------------------------------ bAddUserToActivityMethodb
    // ---------------------------------------
    public class bAddUserToActivityMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bAddUserToActivityMethod(Frame parent) {
            super(parent, "Enter a project, an activity, and a user", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Input:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(300, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

    }

    // ------------------------------------------ bAddActivityMethod
    // ---------------------------------------
    public class bAddActivityMethod extends JDialog {
        private JTextField nameField;
        private JButton okButton;
        private String name;

        public bAddActivityMethod(Frame parent) {
            super(parent, "Enter first a project and then a name", true);
            JPanel panel = new JPanel(new BorderLayout());
            nameField = new JTextField();
            okButton = new JButton("OK");

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
            panel.add(new JLabel("Input:"), BorderLayout.NORTH);
            panel.add(nameField, BorderLayout.CENTER);
            panel.add(okButton, BorderLayout.SOUTH);
            getContentPane().add(panel);
            pack();
            setSize(300, 100);
            setLocationRelativeTo(parent);
        }

        public String getName() {
            return name;
        }

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
            setSize(300, 100);
            setLocationRelativeTo(parent);
        }
        public String getName() {
            return name;
        }
    }
}