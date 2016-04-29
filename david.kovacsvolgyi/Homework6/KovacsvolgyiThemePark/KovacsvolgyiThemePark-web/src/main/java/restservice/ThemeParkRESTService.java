package restservice;

import dto.ThemeParkDTO;
import entity.ThemePark;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import service.ThemeParkService;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Path("/")
@SessionScoped
public class ThemeParkRESTService implements Serializable {

    @Inject
    ThemeParkService themeParkService;

    @Path("/add")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ThemePark addThemePark(ThemePark themePark) {

        return themeParkService.createThemePark(themePark);//TODO: hogy az adatbázisba generáltat adja vissza
    }

    @Path("/health")
    @GET
    public String checkHealth() {
        return "I'm okay";
    }

    @Path("/{id}")
    @GET
    public ThemeParkDTO getThemeParkDTO(@PathParam(value = "id") Long id) {
        return themeParkService.getThemeParkByIdDTO(id);
    }
    @Path("rendes/{id}")
    @GET
    public ThemePark getThemePark(@PathParam(value = "id") Long id) {
        return themeParkService.getThemeParkById(id);
    }
}
