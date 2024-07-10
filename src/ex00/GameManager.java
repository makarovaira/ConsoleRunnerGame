package src.ex00;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
    private int enemiesCount;
    private int wallsCount;
    private int size;
    private String profile;

    public GameManager(Args arguments) {
        enemiesCount = arguments.getEnemiesCount();
        wallsCount = arguments.getWallsCount();
        size = arguments.getSize();
        profile = arguments.getProfile();
    }
    public void start() throws IOException {
        if (enemiesCount+wallsCount+2 > size*size) {
            throw new IllegalArgumentException("Невозможно разместить указанное количество врагов и препятствий на карте заданного размера!");
        }
        if (!profile.equals("production") && !profile.equals("development")) {
            throw new IllegalArgumentException("В бесплатной версии этой игры нет такого режима, выберите \"production\" или \"development\"!");
        }

        Architecture arch = new Architecture();
        Map<String, String> properties = arch.readPropertiesFile("D:/21schoolProjects/Java_Bootcamp.Team00-2/src/ex00/application-production.properties");
        Player player = new Player();
        //Enemy enemy = new Enemy(new Coordinate(2, 4));
        Enemy[] allEnemies = new Enemy[enemiesCount];
        Field field = new Field(enemiesCount, wallsCount, size, player, allEnemies, properties);
        field.generateStartMap();
        allEnemies = field.getAllEnemies();
        field.paintMap();

        Scanner scanner = new Scanner(System.in);
        String direction = scanner.next();
        Moving move = new Moving(field);


        while (true) {
            if (direction.equals("9")) {
                System.out.println("GAME OVER!");
                System.exit(-1);
            }
            if (profile.equals("production")) field.clearScene(true);
            move.setMap(field);
            move.menu(direction);

            field.freeEnemies();
            for (int i = 0; i < enemiesCount; i++) {
                Enemy newEn = new Enemy(allEnemies[i].getCoordEnemy());
                newEn.coordEnemyUpdate(field, player.getCord());
                allEnemies[i] = newEn;
            }

            field.setEnemiesCoord(allEnemies);
            field.paintMap();
            direction = scanner.next();
        }
    }
}
