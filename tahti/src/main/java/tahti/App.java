/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;

import tahti.io.Console;
import tahti.io.IO;

/**
 *
 * @author Michael Aminoff
 */
public class App {

    private IO io;
    private StatCollector sc;

    public App(IO io) {
        this.io = io;
        this.sc = new StatCollector();
    }

    public void run() {
        io.print("Hello and welcome to fancy_ui.");
        io.print("You can run this project by entering a number 0-10 or the command \'custom\'");
        while (true) {
            io.print("");
            io.print("0: Run all current routines (1-10)");
            io.print("1: Runs Dijkstra and A* 100 times on a 512x492 semi-open map, the correct path is 144 steps");
            io.print("2: Runs Dijkstra and A* 50 times on a 512x492 semi-open map, the correct path is 496 steps");
            io.print("3: Runs all 75 times on a 512x492 semi-open map, correct path is 35 steps");
            io.print("4: Runs all 25 times on a 512x492 semi-open map, correct path is 36 steps");
            io.print("5: Runs all 5 times on a 512x492 semi-open map, correct path is 37 steps");
            io.print("6: Runs all 100 on a 512x512 mazelike map. Correct path is 8");
            io.print("7: Runs all 50 times on a 512x512 mazelike map. Correct path is 34");
            io.print("8: All algos 5 times on a 512x512 mazelike map. Correct path is 952");
            io.print("9: Runs Dijkstra and AStar 5 times on a 512x512 mazelike map. Correct path length is 5164");
            io.print("10: Runs all 5 times on a 512x512 mazelike map. Correct path length is 5164");
            io.print("");
            String user_input = io.readLine("");
            switch (user_input) {
                case "0":
                    run_default();
                    break;
                case "1":
                    sc.routine_1();
                    break;
                case "2":
                    sc.routine_2();
                    break;
                case "3":
                    sc.routine_3();
                    break;
                case "4":
                    sc.routine_4();
                    break;
                case "5":
                    sc.routine_5();
                    break;
                case "6":
                    sc.routine_6();
                    break;
                case "7":
                    sc.routine_7();
                    break;
                case "8":
                    sc.routine_8();
                    break;
                case "9":
                    sc.routine_9();
                    break;
                case "10":
                    sc.routine_10();
                    break;
                case "custom":
                    custom();
            }
            user_input = io.readLine("Go again? y/n");
            if (user_input.equals("y") || user_input.equals("Y")) {
                io.print("yay");
            } else {
                return;
            }
        }
    }

    public static void run_default() {
        StatCollector s = new StatCollector();
        s.routine_1();
        System.out.println("---------------------------------------------------------------");
        s.routine_2();
        System.out.println("---------------------------------------------------------------");
        s.routine_3();
        System.out.println("---------------------------------------------------------------");
        s.routine_4();
        System.out.println("---------------------------------------------------------------");
        s.routine_5();
        System.out.println("---------------------------------------------------------------");
        s.routine_6();
        System.out.println("---------------------------------------------------------------");
        s.routine_7();
        System.out.println("---------------------------------------------------------------");
        s.routine_8();
        System.out.println("---------------------------------------------------------------");
        s.routine_9();
        System.out.println("---------------------------------------------------------------");
        s.routine_10();
    }

    public static void main(String[] args) {
        IO io = new Console();
        new App(io).run();
    }

    private void custom() {
        int dij = io.readInt("Run Dijkstra? (0 or 1): ");
        int ast = io.readInt("Run A*? (0 or 1): ");
        int ida = io.readInt("Run IDA*? (0 or 1): ");
        int reps = io.readInt("How many times should the performance test be run?");
        String path = io.readLine("Path to movingai mapfile: ");
        
        int s_x = io.readInt("What's the source's x-location?");
        int s_y = io.readInt("What's the source's y-location?");
        int t_x = io.readInt("What's the target's x-location?");
        int t_y = io.readInt("What's the target's y-location?");
        
        sc.custom(dij, ast, ida, path, s_x, s_y, t_x, t_y, reps);
    }
}
