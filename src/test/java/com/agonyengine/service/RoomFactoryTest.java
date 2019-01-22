package com.agonyengine.service;

import com.agonyengine.model.map.Room;
import com.agonyengine.repository.RoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static com.agonyengine.service.RoomFactory.computeTileCenter;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RoomFactoryTest {
    @Mock
    private RoomRepository roomRepository;

    @Captor
    private ArgumentCaptor<Room> roomCaptor;

    private RoomFactory roomFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(roomRepository.save(any(Room.class))).thenAnswer(i -> {
            Room room = i.getArgument(0);

            room.setId(UUID.randomUUID());

            return room;
        });

        roomFactory = new RoomFactory(roomRepository);
    }

    @Test
    public void testGetRoomWest5() {
        assertNotNull(getRoomAndVerify(-5, 0, 0));
    }

    @Test
    public void testGetRoomWest4() {
        assertNotNull(getRoomAndVerify(-4, 0, 0));
    }

    @Test
    public void testGetRoomWest3() {
        assertNotNull(getRoomAndVerify(-3, 0, 0));
    }

    @Test
    public void testGetRoomWest2() {
        assertNotNull(getRoomAndVerify(-2, 0, 0));
    }

    @Test
    public void testGetRoomWest1() {
        assertNotNull(getRoomAndVerify(-1, 0, 0));
    }

    @Test
    public void testGetRoomAtOrigin() {
        assertNotNull(getRoomAndVerify(0, 0, 0));
    }

    @Test
    public void testGetRoomEast1() {
        assertNotNull(getRoomAndVerify(1, 0, 0));
    }

    @Test
    public void testGetRoomEast2() {
        assertNotNull(getRoomAndVerify(2, 0, 0));
    }

    @Test
    public void testGetRoomEast3() {
        assertNotNull(getRoomAndVerify(3, 0, 0));
    }

    @Test
    public void testGetRoomEast4() {
        assertNotNull(getRoomAndVerify(4, 0, 0));
    }

    @Test
    public void testGetRoomEast5() {
        assertNotNull(getRoomAndVerify(5, 0, 0));
    }

    @Test
    public void testGetRoomNorth5() {
        assertNotNull(getRoomAndVerify(0, 5, 0));
    }

    @Test
    public void testGetRoomNorth4() {
        assertNotNull(getRoomAndVerify(0, 4, 0));
    }

    @Test
    public void testGetRoomNorth3() {
        assertNotNull(getRoomAndVerify(0, 3, 0));
    }

    @Test
    public void testGetRoomNorth2() {
        assertNotNull(getRoomAndVerify(0, 2, 0));
    }

    @Test
    public void testGetRoomNorth1() {
        assertNotNull(getRoomAndVerify(0, 1, 0));
    }

    @Test
    public void testGetRoomSouth5() {
        assertNotNull(getRoomAndVerify(0, -5, 0));
    }

    @Test
    public void testGetRoomSouth4() {
        assertNotNull(getRoomAndVerify(0, -4, 0));
    }

    @Test
    public void testGetRoomSouth3() {
        assertNotNull(getRoomAndVerify(0, -3, 0));
    }

    @Test
    public void testGetRoomSouth2() {
        assertNotNull(getRoomAndVerify(0, -2, 0));
    }

    @Test
    public void testGetRoomSouth1() {
        assertNotNull(getRoomAndVerify(0, -1, 0));
    }

    private Room getRoomAndVerify(long queryX, long queryY, long queryZ) {
        Room result = roomFactory.get(queryX, queryY, queryZ);

        assertEquals(queryX, (long)result.getLocation().getX());
        assertEquals(queryY, (long)result.getLocation().getY());
        assertEquals(queryZ, (long)result.getLocation().getZ());

        verify(roomRepository, atLeastOnce()).save(roomCaptor.capture());

        List<Room> generatedRooms = roomCaptor.getAllValues();

        assertEquals(9, generatedRooms.size());

        long centerX = computeTileCenter(queryX);
        long centerY = computeTileCenter(queryY);

        for (long x = centerX - 1; x <= centerX + 1; x++) {
            for (long y = centerY - 1; y <= centerY - 1; y++) {
                final long xCheck = x;
                final long yCheck = y;

                assertTrue(generatedRooms.stream().anyMatch(room ->
                    room.getLocation().getX() == xCheck
                        && room.getLocation().getY() == yCheck
                        && room.getLocation().getZ() == 0
                ));
            }
        }

        return result;
    }
}
