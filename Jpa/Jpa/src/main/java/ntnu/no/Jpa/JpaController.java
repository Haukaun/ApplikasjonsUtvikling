package ntnu.no.Jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JpaController {


    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The Library application is on...";
    }

    ////Borrower requests.
    @RequestMapping(value = "project", method = RequestMethod.POST)
    public String createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }

    @RequestMapping(value = "project", method = RequestMethod.GET)
    public List<Project> readProjects(){
        return projectService.getAllProject();
    }

    @RequestMapping(value = "project/{id}", method = RequestMethod.PUT)
    public String updateProject (@RequestBody Project project){
        return projectService.updateProject(project);
    }

    @RequestMapping(value = "project", method = RequestMethod.DELETE)
    public String deleteProject (@RequestBody Project project){
        return  projectService.deleteProject(project);
    }

}
