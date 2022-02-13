package ntnu.no.Jpa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {


    private List<Project> projects = new ArrayList<>();

    public List<Project> getAllProjects(){
        return projects;
    }

    public Project getProject(int id){
        return (Project) projects.stream().filter(project -> project.getId() == id);
    }

    public void addProject(Project project){
        projects.add(project);
    }

    public void updateProject(String id, Project project){
        for(int i = 0; i < projects.size(); i++){
            Project p = projects.get(i);
            if(){

            }
        }
    }
}
