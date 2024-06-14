package infrastructure.messaging;

import domain.entities.Room;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class RoomDeserializer extends ObjectMapperDeserializer<Room> {
    public RoomDeserializer() {
        super(Room.class);
    }
}