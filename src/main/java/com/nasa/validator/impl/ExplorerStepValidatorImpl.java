package com.nasa.validator.impl;

import com.nasa.exception.BadRequestException;
import com.nasa.model.enums.Rotation;
import com.nasa.validator.ExplorerStepValidator;

import javax.inject.Named;
import java.util.logging.Logger;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerStepValidatorImpl implements ExplorerStepValidator {
    private static final Logger logger = Logger.getLogger(ExplorerStepValidatorImpl.class.getCanonicalName());

    private static final char MOVE_COMMAND = 'M';
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 4;

    /**
     * Return a pattern with allowed movements.
     *
     * @return The pattern
     */
    private String pattern() {
        return String.format("%s|%s|%s", MOVE_COMMAND, Rotation.LEFT.getRotation(), Rotation.RIGHT.getRotation());
    }

    /**
     * This method only logs a message and throws a ${@link BadRequestException}.
     *
     * @param step The unrecognized step.
     */
    private void stop(final char step) {
        String message = String.format("Unknown command received: '%s'", step);
        logger.warning(message);
        throw new BadRequestException(message);
    }

    @Override
    public boolean isRotation(final char command) {
        return Rotation.getRotation(command) != null;
    }

    @Override
    public boolean isMove(final char command) {
        return command == MOVE_COMMAND;
    }

    @Override
    public void validatePosition(final Integer position) {
        if (position == null || position < MIN_BOUND || position > MAX_BOUND) {
            throw new BadRequestException(String.format("The position '%s' is out of allowed bound. Min. value: '%s', Max. value: '%s'", position, MIN_BOUND, MAX_BOUND));
        }
    }

    @Override
    public char[] validateSteps(final String command) {
        if (command == null) {
            throw new BadRequestException("The sent command cannot be null.");
        }
        char[] steps = command.toUpperCase().toCharArray();
        for (char step : steps) {
            if (!Character.toString(step).matches(this.pattern())) {
                this.stop(step);
            }
        }
        return steps;
    }
}
