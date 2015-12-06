package com.nasa.validator;

import com.nasa.exception.BadRequestException;
import com.nasa.model.enums.Rotation;
import com.nasa.validator.impl.ExplorerStepValidatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for ${@link ExplorerStepValidator}.
 *
 * @author marcos.barbero
 */
public class ExplorerStepValidatorTest {
    private static final char INVALID_COMMAND = 'X';
    private static final char MOVE_COMMAND = 'M';
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 4;

    private ExplorerStepValidator validator = new ExplorerStepValidatorImpl();

    @Test
    public void testIsRotation_shouldReturnTrue() {
        assertTrue(this.validator.isRotation(Rotation.LEFT.getRotation()));
    }

    @Test
    public void testIsRotation_shouldReturnFalse() {
        assertFalse(this.validator.isRotation(INVALID_COMMAND));
    }

    @Test
    public void testIsMove_shouldReturnTrue() {
        assertTrue(this.validator.isMove(MOVE_COMMAND));
    }

    @Test
    public void testIsMove_shouldReturnFalse() {
        assertFalse(this.validator.isMove(INVALID_COMMAND));
    }

    @Test
    public void testValidatePosition_regularValue_shouldNotReturnError() {
        this.validator.validatePosition(MIN_BOUND);
    }

    @Test(expected = BadRequestException.class)
    public void testValidatePosition_lessThanZeroValue_shoulReturnError() {
        this.validator.validatePosition(MIN_BOUND - 1);
    }

    @Test(expected = BadRequestException.class)
    public void testValidatePosition_biggerThanAllowedValue_shoulReturnError() {
        this.validator.validatePosition(MAX_BOUND + 1);
    }

    @Test
    public void testValidateSteps_regularValue_shouldNotReturnError() {
        assertNotNull(this.validator.validateSteps("MMR"));
    }

    @Test(expected = BadRequestException.class)
    public void testValidateSteps_invalidValue_shouldReturnError() {
        this.validator.validateSteps("X");
    }
}
