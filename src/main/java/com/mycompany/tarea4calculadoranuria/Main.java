/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tarea4calculadoranuria;

import javax.swing.JFrame;

/**
 *
 * @author nuria
 */
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setBounds(250, 250, 0, 0);
        frame.add(new PanelPrincipal());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
