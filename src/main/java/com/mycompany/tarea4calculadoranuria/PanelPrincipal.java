/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea4calculadoranuria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author nuria
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;
    private double primerNumero;
    private boolean esperandoSegundoNumero;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
        primerNumero = 0;
        esperandoSegundoNumero = false;
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
// Se obtiene el objeto que desencadena el evento
        Object o = e.getSource();
        // Si es un botón
        if (o instanceof JButton) {
            String textoBoton = ((JButton) o).getText();
            areaTexto.setText(((JButton) o).getText());
        }

        // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
    }

    switch (textoBoton) {
        case "+":
        case "-":
        case "*":
        case "/":
            try {
                primerNumero = Double.parseDouble(areaTexto.getText());
                esperandoSegundoNumero = true;
                switch (textoBoton) {
                    case "+":
                        tipoOperacion = 0;
                    case "-":
                        tipoOperacion = 1;
                    case "*":
                        tipoOperacion = 2;
                    case "/":
                        tipoOperacion = 3;
                }
                areaTexto.setText("");
            } catch (NumberFormatException e) {
                areaTexto.setText("Error");
            }

        case "=":
            try {
                double segundoNumero = Double.parseDouble(areaTexto.getText());
                double resultado = 0;

                switch (tipoOperacion) {
                    case 0:
                        resultado = primerNumero + segundoNumero;
                       
                    case 1:
                        resultado = primerNumero - segundoNumero;
                       
                    case 2:
                        resultado = primerNumero * segundoNumero;
                       
                    case 3:
                        if (segundoNumero == 0) {
                            areaTexto.setText("Error: división entre 0");
                            return;
                        }
                        resultado = primerNumero / segundoNumero;
                       
                    default:
                        areaTexto.setText("Operación no válida");
                        return;
                }

                areaTexto.setText(String.valueOf(resultado));
                esperandoSegundoNumero = false;

            } catch (NumberFormatException ex) {
                areaTexto.setText("Error");
            }
            break;

    }
