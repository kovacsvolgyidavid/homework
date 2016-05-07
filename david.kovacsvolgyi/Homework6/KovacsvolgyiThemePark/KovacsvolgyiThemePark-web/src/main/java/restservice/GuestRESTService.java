package restservice;

import entity.Guest;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.GuestService;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Path("/guest")
public class GuestRESTService {

    @Inject
    GuestService guestService;

    @Path("/{id}")
    @GET
    public Guest getGuest(@PathParam(value = "id") Long id) {
        return guestService.getGuestById(id);
    }

    @Path("/")
    @GET
    public List<Guest> getGuests() {
        return guestService.getGuestList();
    }

    @Path("/")
    @POST
    //@Consumes("application/json")
    public Guest addGuest(Guest guest) {
        return guestService.addGuest(guest);
    }

}
