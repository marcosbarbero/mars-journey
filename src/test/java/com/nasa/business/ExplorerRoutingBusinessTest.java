package com.nasa.business;

import com.nasa.business.impl.ExplorerRoutingBusinessImpl;
import com.nasa.exception.BadRequestException;
import com.nasa.model.beans.MarsExplorer;
import com.nasa.model.enums.Direction;
import com.nasa.model.repository.impl.ExplorerRoutingRepositoryImpl;
import com.nasa.service.ExplorerRoutingService;
import com.nasa.service.impl.ExplorerRoutingServiceImpl;
import com.nasa.validator.impl.ExplorerStepValidatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for ${@link ExplorerRoutingBusiness}.
 *
 * @author marcos.barbero
 */
public class ExplorerRoutingBusinessTest {

    private ExplorerRoutingService service = new ExplorerRoutingServiceImpl(new ExplorerStepValidatorImpl(), new ExplorerRoutingRepositoryImpl());
    private ExplorerRoutingBusiness business = new ExplorerRoutingBusinessImpl(this.service, new ExplorerStepValidatorImpl());

    @Test
    public void testGetMarsExplorer_shouldNotReturnError() {
        assertNotNull(this.business.getMarsExplorer());
    }

    @Test
    public void testResetMarsExplorer_shouldNotReturnError() {
        final MarsExplorer mars = this.business.resetMarsExplorer();
        assertEquals(mars.getDirection(), Direction.NORTH);
        assertEquals(mars.getAxisX(), 0);
        assertEquals(mars.getAxisY(), 0);
    }

    @Test
    public void testMove_regularMove_shouldNotReturnError() {
        this.business.resetMarsExplorer();
        final MarsExplorer mars = this.business.move("MML");
        assertEquals(mars.getDirection(), Direction.WEST);
        assertEquals(mars.getAxisX(), 0);
        assertEquals(mars.getAxisY(), 2);
    }

    @Test(expected = BadRequestException.class)
    public void testMove_InvalidrMove_shouldReturnError() {
        this.business.resetMarsExplorer();
        final MarsExplorer mars = this.business.move(null);
        assertEquals(mars.getDirection(), Direction.WEST);
        assertEquals(mars.getAxisX(), 0);
        assertEquals(mars.getAxisY(), 2);
    }

    @Test
    public void testMove_RotateLeft_shouldNotReturnError() {
        this.business.resetMarsExplorer();
        final MarsExplorer mars = this.business.move("L");
        assertEquals(mars.getDirection(), Direction.WEST);
        assertEquals(mars.getAxisX(), 0);
        assertEquals(mars.getAxisY(), 0);
    }

    @Test
    public void testMove_RotateRight_shouldNotReturnError() {
        this.business.resetMarsExplorer();
        final MarsExplorer mars = this.business.move("R");
        assertEquals(mars.getDirection(), Direction.EAST);
        assertEquals(mars.getAxisX(), 0);
        assertEquals(mars.getAxisY(), 0);
    }

    @Test
    public void testMove_RotateSouth_shouldNotReturnError() {
        this.business.resetMarsExplorer();
        final MarsExplorer mars = this.business.move("RR");
        assertEquals(mars.getDirection(), Direction.SOUTH);
        assertEquals(mars.getAxisX(), 0);
        assertEquals(mars.getAxisY(), 0);
    }

    @Test
    public void testMove_move_shouldNotReturnError() {
        this.business.resetMarsExplorer();
        final MarsExplorer mars = this.business.move("MMRMMRMM");
        assertEquals(mars.getDirection(), Direction.SOUTH);
        assertEquals(mars.getAxisX(), 2);
        assertEquals(mars.getAxisY(), 0);
    }

    @Test(expected = BadRequestException.class)
    public void testMove_move_shouldReturnError() {
        this.business.resetMarsExplorer();
        this.business.move("AAA");
    }

    @Test(expected = BadRequestException.class)
    public void testMove_moveOutOfTheBound_shouldReturnError() {
        this.business.resetMarsExplorer();
        this.business.move("MMMMMMMMMMMMMMMMMMMMMMMM");
    }
}
