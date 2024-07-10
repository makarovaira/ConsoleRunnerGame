package src.ex00;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.beust.jcommander.JCommander;


public class Main {
    public static void main(String[] args) throws IOException {
        Args arguments = new Args();
        JCommander jcommander = JCommander.newBuilder().addObject(arguments).build();
        jcommander.parse(args);
        GameManager gameManager = new GameManager(arguments);
        gameManager.start();


    }



}




