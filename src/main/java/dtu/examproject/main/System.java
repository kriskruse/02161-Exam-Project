package dtu.examproject.main;

import java.util.List;
import java.util.ArrayList;

public class System {

    private List<String> userList = new ArrayList<>();
    private List<Project> projectList = new ArrayList<>();
    private String activeUser = "";

    public System(){
        this.userList.add("admn"); // Add a admin user as default
    }

    public Boolean loggedIn() {return !activeUser.isEmpty();}
    public void logout() {activeUser = "";}
    public Boolean userExists(String user) {return userList.contains(user);}
    public Boolean projectExists(String projectName) {return projectList.stream().anyMatch(p -> p.getProjectName().equals(projectName));}
    public Project getProject(String projectName) {return projectList.stream().filter(p -> p.getProjectName().equals(projectName)).findFirst().get();}
    public List<Project> getProjectList() {return projectList;}
    public String getActiveUser() {return activeUser;}



    public void addUser(String user) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (userList.contains(user)) throw new Exception("A user with those initials already exists");
        else userList.add(user);
    }

    public void login(String user) throws Exception {
        if (userList.contains(user)) this.activeUser = user;
        else throw new Exception("Cannot login as unregistered user");
    }

    public void createProject(String projectName) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (projectExists(projectName)) throw new Exception("A project with that name already exists");
        else projectList.add(new Project(projectName));
    }
    
    public void addActivityToProject(String projectName, String activityName) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(projectName)) throw new Exception("Project does not exist");
        else getProject(projectName).createActivity(activityName);
    }

    public void addUserToProject(String projectName, String user) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!userExists(user)) throw new Exception("User does not exist");
        else if (!projectExists(projectName)) throw new Exception("Project does not exist");
        else getProject(projectName).addEmployee(user);
    }

    public void addUserToActivity(String projectName, String activityName, String user) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!userExists(user)) throw new Exception("User does not exist");
        else if (!projectExists(projectName)) throw new Exception("Project does not exist");
        else getProject(projectName).addEmployeeToActivity(activityName, user);
    }

    public Boolean userIsAssociatedWithProject(String projectName, String user) {
        return getProject(projectName).isAssociated(user);
    }

    public Boolean userIsAssociatedWithActivity(String projectName, String activityName, String user) {
        return getProject(projectName).getActivity(activityName).isAssociated(user);
    }


}
