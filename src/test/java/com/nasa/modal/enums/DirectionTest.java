package com.nasa.modal.enums;

import com.nasa.model.enums.Direction;
import com.nasa.model.enums.Rotation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author marcos.barbero
 */
public class DirectionTest {

    @Test
    public void testRotate_returnValidDirection_shouldNotReturnError() {
        // North
        Direction rotate = Direction.rotate(Direction.NORTH, Rotation.LEFT);
        assertEquals(rotate, Direction.WEST);
        rotate = Direction.rotate(Direction.NORTH, Rotation.RIGHT);
        assertEquals(rotate, Direction.EAST);

        // West
        rotate = Direction.rotate(Direction.WEST, Rotation.LEFT);
        assertEquals(rotate, Direction.SOUTH);
        rotate = Direction.rotate(Direction.WEST, Rotation.RIGHT);
        assertEquals(rotate, Direction.NORTH);

        // South
        rotate = Direction.rotate(Direction.SOUTH, Rotation.LEFT);
        assertEquals(rotate, Direction.EAST);
        rotate = Direction.rotate(Direction.SOUTH, Rotation.RIGHT);
        assertEquals(rotate, Direction.WEST);

        // East
        rotate = Direction.rotate(Direction.EAST, Rotation.LEFT);
        assertEquals(rotate, Direction.NORTH);
        rotate = Direction.rotate(Direction.EAST, Rotation.RIGHT);
        assertEquals(rotate, Direction.SOUTH);
    }
}
