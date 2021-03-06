package com.kayak.exercises.one;

public class MarsRobot {

    private Point location;
    private Direction direction;

    public MarsRobot() {
        location = new Point(0, 0);
        direction = Direction.NORTH;
    }

    public MarsRobot(final Point location, final Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(final Point location) {
        this.location = location;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        Direction result = null;
        switch (direction) {
        case EAST:
            result = Direction.NORTH;
            break;
        case NORTH:
            result = Direction.WEST;
            break;
        case WEST:
            result = Direction.SOUTH;
            break;
        case SOUTH:
            result = Direction.EAST;
            break;
        default:
            break;
        }
        direction = result;
    }

    public void turnRight() {
        Direction result = null;
        switch (direction) {
        case EAST:
            result = Direction.SOUTH;
            break;
        case NORTH:
            result = Direction.EAST;
            break;
        case WEST:
            result = Direction.NORTH;
            break;
        case SOUTH:
            result = Direction.WEST;
            break;
        default:
            break;
        }
        direction = result;
    }

    public void goForward() {
        switch (direction) {
        case EAST:
            location.setX(location.getX() + 1);
            break;
        case NORTH:
            location.setY(location.getY() + 1);
            break;
        case WEST:
            location.setX(location.getX() - 1);
            break;
        case SOUTH:
            location.setY(location.getY() - 1);
            break;
        default:
            break;
        }
    }

    /**
     * The method runs commands looking like LFFFRFFFRRFFF,
     * where "L" is a "turn 90 degrees left", "R" is a "turn 90 degrees right",
     * and "F" is "go forward one space.
     *
     * @param command
     */
    public void runCommand(final String command) {
        if (command == null) {
            throw new IllegalArgumentException("Command must not be null.");
        }
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
            case 'F':
                goForward();
                break;
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            default:
                throw new UnsupportedOperationException();
            }
        }
    }
}
