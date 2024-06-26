package dtu.examproject.main;

import java.util.*;

public class TimeRegistration {

    private Set<String> userList = new HashSet<>();
    private List<Project> projectList = new ArrayList<>();
    private String activeUser = "";
    private final int userNameMaxCharLim = 4;

    public TimeRegistration(){
        this.userList.add("admn"); // Add a admin user as default
    }

    public Boolean loggedIn() {return !activeUser.isEmpty();}
    public void logout() {activeUser = "";}
    public Boolean userExists(String user) {return userList.contains(user);}
    public Boolean projectExists(String projectName) {return projectList.stream()
            .anyMatch(p -> p.getProjectName().equals(projectName));}
    public Project getProject(String projectName) {return projectList.stream()
            .filter(p -> p.getProjectName().equals(projectName))
            .findFirst()
            .get();}
    public List<Project> getProjectList() {return projectList;}
    public String getActiveUser() {return activeUser;}


    public void registerHours(String projectName, String activityName,
                              String employee, int week, double hours) throws Exception {
        // change precision of calendar object to day
        Calendar date = Calendar.getInstance();
        date.set(Calendar.WEEK_OF_YEAR, week);
        date.set(Calendar.DAY_OF_WEEK, 1);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!userExists(employee)) throw new Exception("User does not exist");
        else if (!projectExists(projectName)) throw new Exception("Project does not exist");
        else getProject(projectName).registerHours(activityName, employee, date, hours);
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
        else if (!Objects.equals(activeUser, getProject(projectName).getProjectLead()))
            throw new Exception("User does not have the required permissions to do that");
        else getProject(projectName).setActivityHourBudget(activityName, budget);
    }

    public void addUser(String user) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (user.length() > userNameMaxCharLim)
            throw new Exception("User initials must be less than " + (userNameMaxCharLim + 1) + " characters long");
        else userList.add(user);
    }

    public void login(String user) throws Exception {
        if (userList.contains(user)) this.activeUser = user;
        else throw new Exception("Cannot login as unregistered user");
    }

    public void createProject(String projectName) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (projectExists(projectName)) throw new Exception("A project with that name already exists");
        else projectList.add(new Project(projectName, projectList.size() + 1));
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

    public Boolean userIsAssociatedWithActivity(String projectName, String activityName, String user) {
        return getProject(projectName).getActivity(activityName).isAssociated(user);
    }


    public void createActivity(String project, String activity) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
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

    public Map<String,Double> getAvailableEmployees(String project, int startWeek, int endWeek) throws Exception {
        if (!loggedIn()) throw new Exception("User is not logged in");
        else if (!projectExists(project)) throw new Exception("Project does not exist");
        else if (startWeek > endWeek) throw new Exception("Invalid week interval");
        else if (!Objects.equals(activeUser, getProject(project).getProjectLead())) throw new Exception("User does not have the required permissions to do that");
        else return getProject(project).getAvailableEmployees(startWeek, endWeek);
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
                hours += p.getRegisteredTime(user, 0 , 52);

            }
            return hours;
        }
    }

}
