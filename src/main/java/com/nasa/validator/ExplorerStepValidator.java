package com.nasa.validator;

/**
 * Helper class to perform some validation.
 *
 * @author marcos.barbero
 */
public interface ExplorerStepValidator {

    /**
     * Verify is the command is a ${@link com.nasa.model.enums.Rotation}.
     *
     * @param command The command to be validated
     * @return A flag
     */
    boolean isRotation(final char command);

    /**
     * Verify is the command is a move ("M") command.
     *
     * @param command The command to be validated
     * @return A flag
     */
    boolean isMove(final char command);

    /**
     * Verify if the given position is allowed in the range.
     *
     * @param position The position
     */
    void validatePosition(final Integer position);

    /**
     * Validate if the current command has any invalid step.
     *
     * @param command The given command
     * @return Char array with the steps from given command
     */
    char[] validateSteps(final String command);
}
