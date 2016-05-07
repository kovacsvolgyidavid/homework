package restservice;

import entity.Guest;
import entity.ThemePark;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import service.ThemeParkService;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Path("/themepark")
@SessionScoped
public class ThemeParkRESTService implements Serializable {

    @Inject
    ThemeParkService themeParkService;

    @Path("/add")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ThemePark addThemePark(ThemePark themePark) {
        return themeParkService.createThemePark(themePark);
    }

    @Path("/health")
    @GET
    public String checkHealth() {
        return "I'm okay";
    }

    @Path("{id}")
    @GET
    public ThemePark getThemePark(@PathParam(value = "id") Long id) {//TODO: ha null-t ad vissza exception!
        return themeParkService.getThemeParkById(id);
    }

    @Path("/{id}/guests")
    @POST
    @Consumes("application/json")
    public Guest addUserToThemePark(@PathParam(value = "id") Long id, Guest guest) {
        return themeParkService.addGuestToThemePark(id, guest);
    }

    @Path("/{id}/guests")
    @GET
    @Produces("application/json")
    public List<Guest> getGuests(@PathParam(value = "id") Long id) {
        return themeParkService.getGuests(id);
    }

    @Path("/{id}/guests")
    @PUT
    @Consumes("application/json")
    public Guest deleteUserToThemePark(@PathParam(value = "id") Long id, Guest guest) {
        return themeParkService.deleteGuestFromThemePark(id, guest);
    }
}
