package no.ntnu.crudrest;

import no.ntnu.crudrest.Entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

}
