package dtu.examproject.main;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

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



    public void registerHours(String projectName, String activityName, String employee, double hours) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!userExists(employee)) throw new Exception("User does not exist");
        else if (!projectExists(projectName)) throw new Exception("Project does not exist");
        else getProject(projectName).registerHours(activityName, employee, hours);
    }

    public void setProjectLead(String projectName, String user) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!userExists(user)) throw new Exception("User does not exist");
        else if (!projectExists(projectName)) throw new Exception("Project does not exist");
        else getProject(projectName).setProjectLead(user);
    }


    public void setActivityHourBudget(String projectName, String activityName, int budget) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(projectName)) throw new Exception("Project does not exist");
        else if (!getProject(projectName).activityExists(activityName)) throw new Exception("Activity does not exist");
        else if (!Objects.equals(activeUser, getProject(projectName).getProjectLead()))
            throw new Exception("User does not have the required permissions to do that");
        else getProject(projectName).setActivityHourBudget(activityName, budget);
    }

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


    public void createActivity(String project, String activity) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else if (getProject(project).activityExists(activity)) throw new Exception("Activity already exists");
        else if (getProject(project).getProjectLead().isEmpty())
            getProject(project).createActivity(activity);
        else if (!Objects.equals(activeUser, getProject(project).getProjectLead()))
            throw new Exception("User does not have the required permissions to do that");
        else getProject(project).createActivity(activity);
    }

    public void setActivityStart(String project, String activity, int start) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else if (!(Objects.equals(getProject(project).getProjectLead(), activeUser))) throw new Exception("User does not have the required permissions to do that");
        else getProject(project).getActivity(activity).setStartDate(start);
    }

    public void setActivityEnd(String project, String activity, int end) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else getProject(project).getActivity(activity).setEndDate(end);
    }

    public int getActivityStart(String project, String activity) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else return getProject(project).getActivity(activity).getStartDate();

    }
    public int getActivityEnd(String project, String activity) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else return getProject(project).getActivity(activity).getEndDate();
    }

    public void associateEmployeeWithActivity(String project, String activity, String user) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!userExists(user)) throw new Exception("User does not exist");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else if (!getProject(project).activityExists(activity)) throw new Exception("Activity does not exist");
        else if (!userIsAssociatedWithProject(project, user)) throw new Exception("User is not associated with project");
        else getProject(project).getActivity(activity).addEmployee(user);

    }

    public List<String> getAssociatedEmployees(String project) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else if (!Objects.equals(activeUser, getProject(project).getProjectLead())) throw new Exception("User does not have the required permissions to do that");
        else return getProject(project).getAvalibleEmployees();
    }

    public Map<Activity, Double> getHourDistribution(String project) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else if (!Objects.equals(activeUser, getProject(project).getProjectLead()))
            throw new Exception("User does not have the required permissions to do that");
        else return getProject(project).getHourDistribution();
    }


    public double getRegisteredTime(String user) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!userExists(user)) throw new Exception("User does not exist");
        else {
            double hours = 0;
            for (Project p : projectList) {
                for (Activity a : p.getActivities()) {
                    try {
                        hours += a.getEmployeeHours(user);
                    } catch (Exception e) {
                        // Do nothing
                    }
                }
            }
            return hours;
        }
    }
}
