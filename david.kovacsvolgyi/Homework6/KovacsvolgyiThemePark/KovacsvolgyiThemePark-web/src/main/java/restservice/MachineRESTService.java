package restservice;

import entity.Machine;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.MachineService;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Path("/machine")
public class MachineRESTService {
    @Inject
    MachineService machineService;
    
    @Path("/{id}")
    @GET
    public Machine getMachine(@PathParam(value="id") Long id){
        return machineService.getMachineById(id);
    }
    
    @Path("/")
    @GET
    public List<Machine> getMachine(){
        return machineService.getBuyableMachines();
    }
    
}
