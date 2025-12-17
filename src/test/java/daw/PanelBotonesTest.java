package com.mycompany.tarea4calculadoranuria;

import javax.swing.JButton;
import java.awt.GridLayout;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PanelBotonesTest {

    @Test
    public void testNumeroDeBotones() {
        PanelBotones panel = new PanelBotones();
        JButton[] botones = panel.getgrupoBotones();

        assertNotNull(botones, "El array de botones no debe ser null");
        assertEquals(16, botones.length, "Debe haber 16 botones");
    }

    @Test
    public void testTextoDeBotonesNumericos() {
        PanelBotones panel = new PanelBotones();
        JButton[] botones = panel.getgrupoBotones();

        for (int i = 0; i < 10; i++) {
            assertEquals(
                Integer.toString(i),
                botones[i].getText(),
                "El botón " + i + " debe tener el texto correcto"
            );
        }
    }

    @Test
    public void testTextoDeBotonesOperaciones() {
        PanelBotones panel = new PanelBotones();
        JButton[] botones = panel.getgrupoBotones();

        assertEquals("+", botones[10].getText());
        assertEquals("-", botones[11].getText());
        assertEquals("*", botones[12].getText());
        assertEquals("/", botones[13].getText());
        assertEquals("=", botones[14].getText());
        assertEquals("C", botones[15].getText());
    }

    @Test
    public void testLayoutDelPanel() {
        PanelBotones panel = new PanelBotones();

        assertTrue(panel.getLayout() instanceof GridLayout, 
                   "El layout debe ser GridLayout");

        GridLayout layout = (GridLayout) panel.getLayout();
        assertEquals(4, layout.getRows(), "Debe tener 4 filas");
        assertEquals(4, layout.getColumns(), "Debe tener 4 columnas");
    }
}
