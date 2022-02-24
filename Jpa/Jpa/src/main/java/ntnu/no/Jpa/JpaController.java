package ntnu.no.Jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JpaController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }


    @RequestMapping(value = "/createproject", method = RequestMethod.POST)
    public String createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }

    @RequestMapping(value = "/readproject", method = RequestMethod.GET)
    public List<Project> readProject(){
        return projectService.readProjects();
    }


    @RequestMapping(value = "/updateproject", method = RequestMethod.PUT)
    public String updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }


    @RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.DELETE)
    public String deleteProject(@PathVariable Integer id){
        return projectService.deleteProject(id);
    }
}
