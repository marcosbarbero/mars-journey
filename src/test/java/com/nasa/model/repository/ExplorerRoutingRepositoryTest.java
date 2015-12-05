package com.nasa.model.repository;

import com.nasa.model.repository.impl.ExplorerRoutingRepositoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for ${@link ExplorerRoutingRepository}.
 *
 * @author marcos.barbero
 */
public class ExplorerRoutingRepositoryTest {

    private ExplorerRoutingRepository repository = new ExplorerRoutingRepositoryImpl();

    @Test
    public void testFindOne_shouldNotReturnError() {
        assertNotNull(this.repository.findOne());
    }
}
