/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti;


/**
 *
 * @author Michael Aminoff
 */
public class Main {

    /**
     * Will in the future output metrics for various algorithms For now it only
     * serves the purpose of quick hack testing
     *
     * @param args
     */
    public static void main(String[] args) {
        StatCollector s = new StatCollector();
        s.routine_1();
        s.routine_2();
        s.routine_3();        
    }
}
