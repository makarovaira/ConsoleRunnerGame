package src.ex00;

import java.util.Scanner;

public class Moving {
    Field field;
    int size;
    public Moving(Field field) {
        this.field = field;
        this.size = field.getGrid().length;
    }
    public void menu(String direction) {
        switch (direction) {
            case "W":
            case "w":
                moveUp();
                break;
            case "A":
            case "a":
                moveLeft();
                break;
            case "D":
            case "d":
                moveRight();
                break;
            case "S":
            case "s":
                moveDown();
                break;
        }
    }

    private void moveUp() {
        int cordX = field.getPlayerCoord().getcordX();
        int cordY = field.getPlayerCoord().getcordY();
        int[][] grid = field.getGrid();
        if (cordX > 0 && field.getGrid()[cordX-1][cordY] == 0) {
            grid[cordX-1][cordY] = 111;
            grid[cordX][cordY] = 0;
            field.setPlayerCoord(new Coordinate(cordX-1, cordY));
        }
    }
    private void moveLeft() {
        int cordX = field.getPlayerCoord().getcordX();
        int cordY = field.getPlayerCoord().getcordY();
        int[][] grid = field.getGrid();
        if (cordY > 0 && field.getGrid()[cordX][cordY-1] == 0) {
            grid[cordX][cordY-1] = 111;
            grid[cordX][cordY] = 0;
            field.setPlayerCoord(new Coordinate(cordX, cordY-1));
        }
    }
    private void moveRight() {
        int cordX = field.getPlayerCoord().getcordX();
        int cordY = field.getPlayerCoord().getcordY();
        int[][] grid = field.getGrid();
        if (cordY < size-1 && field.getGrid()[cordX][cordY+1] == 0) {
            grid[cordX][cordY+1] = 111;
            grid[cordX][cordY] = 0;
            field.setPlayerCoord(new Coordinate(cordX, cordY+1));
        }
    }
    private void moveDown() {
        int cordX = field.getPlayerCoord().getcordX();
        int cordY = field.getPlayerCoord().getcordY();
        int[][] grid = field.getGrid();
        if (cordX < size-1 && field.getGrid()[cordX+1][cordY] == 0) {
            grid[cordX+1][cordY] = 111;
            grid[cordX][cordY] = 0;
            field.setPlayerCoord(new Coordinate(cordX+1, cordY));
        }
    }
    public void setMap(Field map) {
        this.field = map;
    }

}


