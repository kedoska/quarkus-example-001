package apps.api;
import java.util.List;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import domain.entities.Room;
import domain.repositories.RoomRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@GraphQLApi
@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)   
public class RoomResource {

    @Inject
    RoomRepository roomRepository;

    @Query("allRooms")
    @Description("Get all rooms")
    @GET
    public List<Room> getRooms() {
        return roomRepository.listAll();
    }

    @Mutation
    @POST
    @Transactional
    public Room addRoom(Room room) {
        roomRepository.persist(room);
        return room;
    }

    @Mutation
    @DELETE
    @Path("/{id}")
    @Transactional
    public boolean deleteRoom(Long id) {
        return roomRepository.deleteById(id);
    }

}
