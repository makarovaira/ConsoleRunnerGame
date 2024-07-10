package src.ex00;

import javax.xml.bind.ValidationException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Enemy {
    private Coordinate coordEnemy;

    public class Vector{
        public double dist;
        public int index;
    }

    public class VectorComparator implements Comparator<Vector> {
        @Override
        public int compare(Vector a, Vector b) {
            return Double.compare(a.dist, b.dist);
        }
    }

    public Enemy () {}

    public Enemy(Coordinate coordEnemy) {
        this.coordEnemy = coordEnemy;
    }

    public void setCoordEnemy(Coordinate coord) {
        coordEnemy = coord;
    }
    public Coordinate getCoordEnemy() {
        return coordEnemy;
    }

    public void coordEnemyUpdate(Field mapNow, Coordinate player) {
        int x = coordEnemy.getcordX();
        int y = coordEnemy.getcordY();
        Coordinate[] nextMoves = new Coordinate[4];
        Vector[] vectors = new Vector[4];
        Arrays.fill(nextMoves, coordEnemy);
        if (mapNow.checkBordersMap(x + 1, y)) {
            char cell = (char) mapNow.getCellGrid(x + 1, y);
            if (cell != '#' && cell != 'X') {
                nextMoves[0] = new Coordinate(x + 1, y);
            }
        }

        if (mapNow.checkBordersMap(x - 1, y)) {
            char cell = (char) mapNow.getCellGrid(x - 1, y);
            if (cell != '#' && cell != 'X') {
                nextMoves[1] = new Coordinate(x - 1, y);
            }
        }

        if (mapNow.checkBordersMap(x, y + 1)) {
            char cell = (char) mapNow.getCellGrid(x, y + 1);
            if (cell != '#' && cell != 'X') {
                nextMoves[2] = new Coordinate(x, y + 1);
            }
        }

        if (mapNow.checkBordersMap(x, y - 1)) {
            char cell = (char) mapNow.getCellGrid(x, y - 1);
            if (cell != '#' && cell != 'X') {
                nextMoves[3] = new Coordinate(x, y - 1);
            }
        }


        for (int i = 0; i < 4; i++) {
            double dist = Math.sqrt(Math.pow(player.getcordX() - nextMoves[i].getcordX(), 2) + Math.pow(player.getcordY() - nextMoves[i].getcordY(), 2));
            Vector vect = new Vector();
            vect.dist = dist;
            vect.index = i;
            vectors[i] = vect;
        }
        Arrays.sort(vectors, new VectorComparator());

        coordEnemy = nextMoves[vectors[0].index];

    }

}
