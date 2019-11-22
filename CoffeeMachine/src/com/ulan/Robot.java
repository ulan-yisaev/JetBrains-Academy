package com.ulan;
/*
https://hyperskill.org/learn/step/2180
Enum -> Robot control
Code Challenge — Write a program
258 users successfully solved this problem.  It was last completed 2 days ago.
There is a robot on the game field. The position of the robot on this field is described by two integer coordinates: X and Y. The X axis is oriented from left to right, the Y axis — from bottom to top.

At the initial moment, the robot is in some coordinate on the field. It's also known where the robot looks: up, down, to the right or to the left. The initial position of the robot and its direction can have any values. You need to bring the robot to the destination point of the game field.

A robot is described by the Robot class. You can use the following methods of this class (with unknown implementation):
 */

public class Robot {

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Direction direction;
    private int x, y;

    public Direction getDirection() {
        // current direction
        return direction;
    }

    public int getX() {
        // current X coordinate
        return x;
    }

    public int getY() {
        // current Y o
        return y;
    }

    public void turnLeft() {
        // rotate the robot 90 degrees counterclockwise
        Direction thisDirection = getDirection();
        switch (thisDirection) {
            case UP:
                this.direction = Direction.LEFT;
                break;
            case DOWN:
                this.direction = Direction.RIGHT;
                break;
            case LEFT:
                this.direction = Direction.DOWN;
                break;
            case RIGHT:
                this.direction = Direction.UP;
                break;
        }
    }

    public void turnRight() {
        // rotate the robot 90 degrees clockwise
        Direction thisDirection = getDirection();
        switch (thisDirection) {
            case UP:
                this.direction = Direction.RIGHT;
                break;
            case DOWN:
                this.direction = Direction.LEFT;
                break;
            case LEFT:
                this.direction = Direction.UP;
                break;
            case RIGHT:
                this.direction = Direction.DOWN;
                break;
        }
    }

    public void stepForward() {
        // take one step in the current direction
        // x or y coordinate will be changed by 1

    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int fromX = robot.getX();
        int fromY = robot.getY();
        int xSteps = Math.abs(toX - fromX);
        int ySteps = Math.abs(toY - fromY);
        Direction thisDirection = robot.getDirection();

        switch (thisDirection) {
            case UP:
//                System.out.println(robot.getDirection());
                if (toX > fromX) { robot.turnRight(); for (int i = 0; i < xSteps; i++) { robot.stepForward();} robot.turnLeft();
                } else if (toX < fromX) { robot.turnLeft(); for (int i = 0; i < xSteps; i++) { robot.stepForward();} robot.turnRight();
                }
                if (toY > fromY) { for (int i = 0; i < ySteps; i++) { robot.stepForward();}
                } else if (toY < fromY) { robot.turnRight(); robot.turnRight();  for (int i = 0; i < ySteps; i++) { robot.stepForward();}
                }
                break;
            case DOWN:
//                System.out.println(robot.getDirection());
                if (toX > fromX) { robot.turnLeft(); for (int i = 0; i < xSteps; i++) { robot.stepForward();} robot.turnRight();
                } else if (toX < fromX) { robot.turnRight(); for (int i = 0; i < xSteps; i++) { robot.stepForward();} robot.turnLeft();
                }
                if (toY > fromY) { robot.turnRight(); robot.turnRight(); for (int i = 0; i < ySteps; i++) { robot.stepForward();}
                } else if (toY < fromY) { for (int i = 0; i < ySteps; i++) { robot.stepForward();}
                }
                break;
            case LEFT:
                if (toX > fromX) { robot.turnRight(); robot.turnRight(); for (int i = 0; i < xSteps; i++) { robot.stepForward();} robot.turnLeft(); robot.turnLeft();
                } else if (toX < fromX) { for (int i = 0; i < xSteps; i++) { robot.stepForward();}
                }
                if (toY > fromY) { robot.turnRight(); for (int i = 0; i < ySteps; i++) { robot.stepForward();}
                } else if (toY < fromY) { robot.turnLeft(); for (int i = 0; i < ySteps; i++) { robot.stepForward();}
                }
                break;
            case RIGHT:
                if (toX > fromX) { for (int i = 0; i < xSteps; i++) { robot.stepForward();}
                } else if (toX < fromX) { robot.turnRight(); robot.turnRight(); for (int i = 0; i < xSteps; i++) { robot.stepForward();} robot.turnLeft(); robot.turnLeft();
                }
                if (toY > fromY) { robot.turnLeft(); for (int i = 0; i < ySteps; i++) { robot.stepForward();}
                } else if (toY < fromY) { robot.turnRight(); for (int i = 0; i < ySteps; i++) { robot.stepForward();}
                }
                break;
        }
    }

    public static void main(String[] args) {
        Robot rb = new Robot();
        rb.x = 0;
        rb.y = 0;
        rb.direction = Direction.UP;
        rb.turnRight();
        rb.moveRobot(rb, 3, 2);
        System.out.println("rb.getDirection() = " + rb.getDirection() + " | rb.getX() =  " + rb.getX() + " | rb.getY() = " + rb.getY());

    }
}