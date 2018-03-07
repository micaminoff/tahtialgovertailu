/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahti.io;

/**
 *
 * @author Michael Aminoff
 */
public interface IO {
    void print(String toPrint);
    int readInt(String prompt);
    String readLine(String prompt);
}
