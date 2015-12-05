package com.nasa.model.validator.impl;

import com.nasa.exception.BadRequestException;
import com.nasa.model.enums.Rotation;
import com.nasa.model.validator.ExplorerStepValidator;

import javax.inject.Named;

/**
 * @author marcos.barbero
 */
@Named
public class ExplorerStepValidatorImpl implements ExplorerStepValidator {
    public static final char MOVE_COMMAND = 'M';
    public static final int MIN_BOUND = 0;
    public static final int MAX_BOUND = 4;

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
        char[] steps = command.toUpperCase().toCharArray();
        for (char step : steps) {
            if (step != MOVE_COMMAND && step != Rotation.LEFT.getRotation() && step != Rotation.RIGHT.getRotation()) {
                throw new BadRequestException(String.format("Unknown command received: '%s", step));
            }
        }
        return steps;
    }
}
