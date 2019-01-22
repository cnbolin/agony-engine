package com.agonyengine.service;

import com.agonyengine.model.map.Room;
import com.agonyengine.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomFactory.class);
    private static final int TILE_SIZE = 3;
    private static final float TILE_SIZEf = (float)TILE_SIZE;

    private RoomRepository roomRepository;

    public RoomFactory(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room get(long x, long y, long z) {
        return roomRepository
            .findByLocationXAndLocationYAndLocationZ(x, y, z)
            .orElseGet(() -> generateTile(x, y, z));
    }

    private Room generateTile(long x, long y, long z) {
        long centerX = computeTileCenter(x);
        long centerY = computeTileCenter(y);
        Room queried = null;
        List<Room> generated = new ArrayList<>();

        for (long x1 = centerX - 1; x1 <= centerX + 1; x1++) {
            for (long y1 = centerY - 1; y1 <= centerY + 1; y1++) {
                Room room = new Room();

                room.getLocation().setX(x1);
                room.getLocation().setY(y1);
                room.getLocation().setZ(z);

                generated.add(room);

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Generated room: ({}, {}, {})",
                        room.getLocation().getX(),
                        room.getLocation().getY(),
                        room.getLocation().getZ()
                    );
                }

                if (x1 == x && y1 == y) {
                    queried = room;
                }
            }
        }

        if (queried == null) {
            throw new IllegalStateException("Failed to generate requested tile!");
        }

        roomRepository.saveAll(generated);

        return queried;
    }

    static long computeTileCenter(long coordinate) {
        return TILE_SIZE * (long)Math.floor((coordinate + 1) / TILE_SIZEf);
    }
}
