package ntnu.no.Jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public String createProject(Project project){
        try{
            if(!projectRepository.existsById(project.getId())){
                projectRepository.save(project);
                return "Project inserted";
            } else {
                return "Project does not exist in DB";
            }
        } catch (Exception e){
            throw e;
        }
    }

    public List<Project> getAllProject(){
        return projectRepository.findAll();
    }

    @Transactional
    public String updateProject(Project project){
        try{
            if(projectRepository.existsById(project.getId())){
                Project projectToBeUpdated = projectRepository.findById(project.getId()).get();
                projectToBeUpdated.setName(project.getName());
                projectToBeUpdated.setLeader(project.getLeader());
                projectToBeUpdated.setBudget(project.getBudget());
                projectRepository.save(projectToBeUpdated);
                return "Project updated";
            } else {
                return "Project does not exist in Db";
            }
        }catch (Exception e){
            throw e;
        }
    }

    @Transactional
    public String deleteProject(Project project){
        try{
            if(projectRepository.existsById(project.getId())){
                projectRepository.delete(project);
                return "Project deleted";
            } else {
                return "Project does not exist in DB";
            }
        } catch (Exception e){
            throw e;
        }
    }


}
