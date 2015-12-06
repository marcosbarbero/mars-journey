package com.nasa.service;

import com.nasa.exception.BadRequestException;
import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.enums.Direction;
import com.nasa.model.enums.Rotation;
import com.nasa.model.repository.impl.ExplorerRoutingRepositoryImpl;
import com.nasa.service.impl.ExplorerRoutingServiceImpl;
import com.nasa.validator.impl.ExplorerStepValidatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for ${@link ExplorerRoutingService}.
 *
 * @author marcos.barbero
 */
public class ExplorerRoutingServiceTest {

    private ExplorerRoutingService service = new ExplorerRoutingServiceImpl(new ExplorerStepValidatorImpl(), new ExplorerRoutingRepositoryImpl());

    @Test
    public void testRotate_shouldNotReturnError() {
        this.service.rotate(Rotation.RIGHT);
    }

    @Test(expected = BadRequestException.class)
    public void testRotate_shouldReturnError() {
        this.service.rotate(null);
    }

    @Test
    public void testGetMarsExplorer_shouldNotReturnError() {
        assertNotNull(this.service.getMarsExplorer());
    }

    @Test
    public void testMove_shouldNotReturnError() {
        this.service.move();
    }

    @Test
    public void testResetMarsExplorer_shouldNotReturnError() {
        //clean up before execute any test
        this.service.resetMarsExplorer();

        this.service.move();
        final MarsExplorer marsExplorer = this.service.getMarsExplorer();
        assertEquals(marsExplorer.getAxisY(), 1);
        this.service.resetMarsExplorer();
        assertEquals(marsExplorer.getAxisX(), 0);
        assertEquals(marsExplorer.getAxisY(), 0);
        assertEquals(marsExplorer.getDirection(), Direction.NORTH);
    }
}
