/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;

import java.util.Scanner;

/**
 *
 * @author Michael Aminoff
 */
public class Main {

    /**
     * Will in the future output metrics for various algorithms For now it only serves the purpose
     * of quick hack testing
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        StatCollector s = new StatCollector();
        Scanner fancy_ui = new Scanner(System.in);
        System.out.println("Hello and welcome to fancy_ui.");
        System.out.println("You can run this project by entering a number 0-5 (don't press 6 or 7).");
        while (true) {
            System.out.println("");
            System.out.println("0: Run all current routines (1-5)");
            System.out.println("1: Routine 1: A* 100 times on a 512x492 semi-open map, the correct path is 144 steps");
            System.out.println("2: Routine 2: Dijkstra 100 times on a 512x492 semi-open map, the correct path is 144 steps");
            System.out.println("3: Routine 3: Dijkstra and AStar 50 times on a 512x492 semi-open map, the correct path is 496 steps");
            System.out.println("4: Routine 4: Dijkstra and AStar 5 times on a 512x512 mazelike map. Correct path length is 5164");
            System.out.println("5: Routine 5: IDA* and A* on a 512x512 mazelike map. Correct path is 8");
            System.out.println("6: Routine 5: IDA* and A* on a 512x512 mazelike map. Correct path is 34");
            String user_input = fancy_ui.nextLine();
            System.out.println(user_input);
            switch (user_input) {
                case "0":
                    run_default();
                    break;
                case "1":
                    s.routine_1();
                    break;
                case "2":
                    s.routine_2();
                    break;
                case "3":
                    s.routine_3();
                    break;
                case "4":
                    s.routine_4();
                    break;
                case "5":
                    s.routine_5();
                    break;
                case "6":
                    s.routine_6();
                    break;
                case "7":
                    s.routine_7();
                    
            }
            System.out.println("Go again? y/n");
            user_input = fancy_ui.nextLine();
            if (user_input.equals("y") || user_input.equals("Y")) {
                System.out.println("yay");
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
    }
}
