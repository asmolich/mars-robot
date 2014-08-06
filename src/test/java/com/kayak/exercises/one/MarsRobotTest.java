package com.kayak.exercises.one;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MarsRobotTest {

    private String command;
    private Point endPoint;
    private Direction endDirection;

    public MarsRobotTest(final String command, final Point endPoint, final Direction endDirection) {
        this.command = command;
        this.endPoint = endPoint;
        this.endDirection = endDirection;
    }

    @Test
    public void testRobotsLocationShouldMatch() {
        // Given
        final MarsRobot robot = new MarsRobot();

        // When
        robot.runCommand(command);

        // Then
        assertLocation(endPoint, robot);
        assertDirection(endDirection, robot);
    }

    private void assertLocation(final Point point, final MarsRobot robot) {
        assertEquals(point.getX(), robot.getLocation().getX());
        assertEquals(point.getY(), robot.getLocation().getY());
    }

    private void assertDirection(final Direction direction, final MarsRobot robot) {
        assertEquals(direction, robot.getDirection());
    }

    @Parameters(name="{index}: expected {1} {2} for command {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "LLLLLLLLLLLL", new Point(0,0), Direction.NORTH },
                { "RRRRRRRRRRRR", new Point(0,0), Direction.NORTH },
                { "LR", new Point(0,0), Direction.NORTH },
                { "LLRR", new Point(0,0), Direction.NORTH },
                { "FF", new Point(0,2), Direction.NORTH },
                { "FFRFFRFFRFF", new Point(0,0), Direction.WEST },
                { "FFFLLFFF", new Point(0,0), Direction.SOUTH },
                { "FFRFFLFL", new Point(2,3), Direction.WEST },
                { "LFFLF", new Point(-2,-1), Direction.SOUTH },
                { "LFFFRFFFRRFFF", new Point(-3, 0), Direction.SOUTH },
                { "LFFFL", new Point(-3, 0), Direction.SOUTH }
        });
    }
}
