/*
 * Simple java program to illustrate a graphical user interface (GUI) with the SWING framework
 * 
 * (C) Copyright 2019, Lars Staalhagen
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class javacode extends JFrame implements ActionListener {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//worker buttons
    public JButton bWorkerFunctions, bAddUser, bSetProjectLead, bSetProjectActivities, bSelectActivityTimeUsed, bGetRegisteredTime, bAddUserToActivity;  // Buttons
    //project lead buttons
    public JButton bSetProjectHourBudget, bSeeAvalibleUsers, bSeeDistributionOfHours, bSetStartEndTime, bSetNewProjectLead;  // Buttons
    public JTextArea txtarea;               // Large text area in the middle of the window
    public JTextField txtfld;               // Small text field at the bottom of the window
    public JLabel txt1, txt2;
    public static String username="hello";
    public static String password;
   //  public JTextField txtfld2;
   
   
    public javacode() {

        // Set a BorderLayout on the main window
        getContentPane().setLayout(new BorderLayout());
        
        // Define a standard button size - 100 x 30 pixels
        Dimension btnsize = new Dimension(180, 40);
        Dimension txtsize = new Dimension(180, 30);
        Dimension p2size = new Dimension(180, 500);
        
        // Create a button and set max size and alignment (relative to the surrounding container)
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
        bSetProjectActivities = new JButton("Set Project Activities");
        bSetProjectActivities.addActionListener(this);
        bSetProjectActivities.setMaximumSize(btnsize);
        bSetProjectActivities.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        bSetProjectHourBudget = new JButton("Set Project Hour Budget");
        bSetProjectHourBudget.addActionListener(this);
        bSetProjectHourBudget.setMaximumSize(btnsize);
        bSetProjectHourBudget.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Same for the last button
        bSeeAvalibleUsers = new JButton("See Avalible Users");
        bSeeAvalibleUsers.addActionListener(this);
        bSeeAvalibleUsers.setMaximumSize(btnsize);
        bSeeAvalibleUsers.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Same for the last button
        bSeeDistributionOfHours = new JButton("See Distribution Of Hours");
        bSeeDistributionOfHours.addActionListener(this);
        bSeeDistributionOfHours.setMaximumSize(btnsize);
        bSeeDistributionOfHours.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Same for the last button
        bSetStartEndTime = new JButton("Set Start End Time");
        bSetStartEndTime.addActionListener(this);
        bSetStartEndTime.setMaximumSize(btnsize);
        bSetStartEndTime.setAlignmentX(Component.RIGHT_ALIGNMENT);

        // Same for the last button
        bSetNewProjectLead = new JButton("Set New Project Lead");
        bSetNewProjectLead.addActionListener(this);
        bSetNewProjectLead.setMaximumSize(btnsize);
        bSetNewProjectLead.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        // Create a container (JPanel) to hold the first four buttons
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
        txt1 = new JLabel("        User Buttons");
        txt1.setMaximumSize(txtsize);
        txt1.setAlignmentX(BOTTOM_ALIGNMENT);
        p1.add(txt1);
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add first button
        /*
        p1.add(bWorkerFunctions);
        // Create a small filler (between 1st and 2nd button)
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add second button
        */
        p1.add(bAddUser);
        // Filler
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add third button
        p1.add(bSetProjectLead);
        // Filler
        p1.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add final button
        p1.add(bSetProjectActivities);
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

        // Create a container (JPanel) to hold the first four buttons
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));

        txt2 = new JLabel("Project Lead Buttons");
        txt2.setMaximumSize(txtsize);
        txt2.setAlignmentX(RIGHT_ALIGNMENT);
        p2.add(txt2);
        // Create a small filler (above the first button)
        p2.add(Box.createRigidArea(new Dimension(110, 5)));
        // Add first button
        p2.add(bSetProjectHourBudget);
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
        p2.setMaximumSize(p2size);
        System.out.print("here now and username is ");
        System.out.println(username);
        if(username.equals("admin")){
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
    
    //--------------------------------------------------- WORKER BUTTON ACTIONS -------------------------------------------------------
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bWorkerFunctions) {
            System.exit(0);
        } else if (e.getSource() == bAddUser) {

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    NameInputDialog dialog = new NameInputDialog(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Name entered: " + name);
                    txtarea.append("Added user: " + name +"\n");

                    }
                }
            });

        } else if (e.getSource() == bSetProjectLead) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bSetProjectLeadMethod dialog = new bSetProjectLeadMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Name entered: " + name);
                    txtarea.append("Project leader set to: " + name +"\n");

                    }
                }
            });
        } else if (e.getSource() == bSetProjectActivities) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bSetProjectActivitiesMethod dialog = new bSetProjectActivitiesMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Activity Entered: " + name);
                    txtarea.append("Activity added: " + name +"\n");

                    }
                }
            });
        } else if (e.getSource() == bSelectActivityTimeUsed) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bSetProjectActivitiesMethod dialog = new bSetProjectActivitiesMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Time Entered: " + name);
                    txtarea.append("Time used for the activity: " + name +"\n");

                    }
                }
            });
        } else if (e.getSource() == bGetRegisteredTime) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bGetRegisteredTimeMethod dialog = new bGetRegisteredTimeMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Activity Entered: " + name);
                    txtarea.append("Time used for the activity: " + name +"\n");

                    }
                }
            });
        } else if (e.getSource() == bAddUserToActivity) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bAddUserToActivityMethod dialog = new bAddUserToActivityMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Username Entered: " + name);
                    txtarea.append("User added to the activity: " + name +"\n");

                    }
                }
            });
        }
        //------------------------------------------------ PROJECT LEAD BUTTON ACTIONS ----------------------------------------------------
        else if (e.getSource() == bSetNewProjectLead) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bSetNewProjectLeadMethod dialog = new bSetNewProjectLeadMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Username Entered: " + name);
                    txtarea.append("User added to the activity: " + name +"\n");

                    }
                }
            });
        }

        else if (e.getSource() == bSetStartEndTime) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bSetStartEndTimeMethod dialog = new bSetStartEndTimeMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Username Entered: " + name);
                    txtarea.append("User added to the activity: " + name +"\n");

                    }
                }
            });
        }

        else if (e.getSource() == bSeeDistributionOfHours) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bSeeDistributionOfHoursMethod dialog = new bSeeDistributionOfHoursMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Username Entered: " + name);
                    txtarea.append("User added to the activity: " + name +"\n");

                    }
                }
            });
        }

        else if (e.getSource() == bSeeAvalibleUsers) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bSeeAvalibleUsersMethod dialog = new bSeeAvalibleUsersMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Username Entered: " + name);
                    txtarea.append("User added to the activity: " + name +"\n");

                    }
                }
            });
        }

        else if (e.getSource() == bSetProjectHourBudget) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    bSetProjectHourBudgetMethod dialog = new bSetProjectHourBudgetMethod(frame);
                    dialog.setVisible(true);
                    String name = dialog.getName();
                    if (name != null) {
                        JOptionPane.showMessageDialog(frame, "Username Entered: " + name);
                    txtarea.append("User added to the activity: " + name +"\n");

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
        simplegui.setSize(800, 600);     // Set size
        simplegui.setResizable(false);    // Allow the window to be resized
		simplegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //simplegui.setVisible(true);
        
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
            simplegui.setTitle("SimpleGui");
            simplegui.setSize(800, 600);
            simplegui.setResizable(false);
            simplegui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simplegui.setVisible(true);
            JOptionPane.showMessageDialog(simplegui, "Logged in as: " + username);
        };
    
        loginButton.addActionListener(loginAction);
    
        textField.addActionListener(loginAction); // Listen for "Enter" key press
    
        JOptionPane.showMessageDialog(parent, panel, "Log In", JOptionPane.PLAIN_MESSAGE);
    }
    // ------------------------------------ bAddUser function -------------------------------------
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
//------------------------------------ bSetProjectLead function -------------------------------------
public class bSetProjectLeadMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bSetProjectLeadMethod(Frame parent) {
        super(parent, "Who would you like to set as project lead", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Name:"), BorderLayout.NORTH);
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
//---------------------------------------- bSetProjectActivitiesMethod -------------------------------------
public class bSetProjectActivitiesMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bSetProjectActivitiesMethod(Frame parent) {
        super(parent, "What activity would you like to add to the project", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Activity:"), BorderLayout.NORTH);
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
//---------------------------------------- bSelectActivityTimeUsedMethod -------------------------------------
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
//---------------------------------------- bGetRegisteredTimeMethod -------------------------------------
public class bGetRegisteredTimeMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bGetRegisteredTimeMethod(Frame parent) {
        super(parent, "What activity would you like to view the time for", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Activity:"), BorderLayout.NORTH);
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
//---------------------------------------- bAddUserToActivityMethod -------------------------------------
public class bAddUserToActivityMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bAddUserToActivityMethod(Frame parent) {
        super(parent, "What user would you like to add to the activity", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Username:"), BorderLayout.NORTH);
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

//------------------------------------------ bSetNewProjectLeadMethod ------------------------------------------
public class bSetNewProjectLeadMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bSetNewProjectLeadMethod(Frame parent) {
        super(parent, "What user would you like to add to the activity", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Username:"), BorderLayout.NORTH);
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
//------------------------------------------ bSetStartEndTimeMethod --------------------------------------------
public class bSetStartEndTimeMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bSetStartEndTimeMethod(Frame parent) {
        super(parent, "What user would you like to add to the activity", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Username:"), BorderLayout.NORTH);
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
//------------------------------------------ bSeeDistributionOfHoursMethod -------------------------------------
public class bSeeDistributionOfHoursMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bSeeDistributionOfHoursMethod(Frame parent) {
        super(parent, "What user would you like to add to the activity", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Username:"), BorderLayout.NORTH);
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
//------------------------------------------ bSeeAvalibleUsersMethod -------------------------------------------
public class bSeeAvalibleUsersMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bSeeAvalibleUsersMethod(Frame parent) {
        super(parent, "What user would you like to add to the activity", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Username:"), BorderLayout.NORTH);
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
//------------------------------------------ bSetProjectHourBudgetMethod ---------------------------------------
public class bSetProjectHourBudgetMethod extends JDialog {
    private JTextField nameField;
    private JButton okButton;
    private String name;

    public bSetProjectHourBudgetMethod(Frame parent) {
        super(parent, "What user would you like to add to the activity", true);
        JPanel panel = new JPanel(new BorderLayout());
        nameField = new JTextField();
        okButton = new JButton("OK");
        
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                dispose(); // Close the dialog
            }
        });

        panel.add(new JLabel("Enter Username:"), BorderLayout.NORTH);
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