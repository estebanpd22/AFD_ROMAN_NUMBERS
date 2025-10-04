package Interfaz;

import Modelo.Automata;
import Modelo.PruebasAutomata;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Programa {
    static {

        try {
            UIManager.put("OptionPane.background", Color.decode("#03045E"));
            UIManager.put("Panel.background", Color.decode("#03045E"));
            UIManager.put("OptionPane.messageForeground", Color.decode("#FFFFFF"));
            UIManager.put("Button.background", Color.decode("#00B4D8"));
            UIManager.put("Button.foreground", Color.decode("#FFFFFF"));
            UIManager.put("Button.select", Color.decode("#0096C7"));
        } catch (Exception e) {
            System.err.println("Error al configurar UIManager: " + e.getMessage());
        }
    }

    // 🖼️ Rutas de los GIFs
    private static final String GIF_OK = "/Recursos/muy-bien.gif";
    private static final String GIF_ERROR = "/Recursos/mal.gif";
    private static final String GIF_CLOSE = "/Recursos/close.gif";

    public static void main(String[] args) {

        // Se ejecuta pruebas automaticas en consola:
        PruebasAutomata.probarRomano(new Automata());

        Icon gifCierre = new ImageIcon(Objects.requireNonNull(
                Programa.class.getResource(GIF_CLOSE)));

        while (true) {
            String num = JOptionPane.showInputDialog(null,
                    "Escribe un número romano entre I y L: \nDéjalo vacío o presiona Cancelar si quieres salir",
                    "AFD Números Romanos",
                    JOptionPane.QUESTION_MESSAGE);

            if (num == null || num.isBlank()) break;

            num = num.toUpperCase();
            boolean valido = Automata.evaluarRomano(num);
            procesarRespuesta(num, valido);
        }

        JOptionPane.showMessageDialog(null, "Cerrando... Presiona OK",
                "AFD Números Romanos", JOptionPane.PLAIN_MESSAGE, gifCierre);
    }

    private static void procesarRespuesta(String numero, boolean valido) {
        String respuesta = valido
                ? "Cadena válida: " + numero
                : "Cadena inválida: " + numero;

        String nombreArchivo = valido ? GIF_OK : GIF_ERROR;

        Icon gif = new ImageIcon(Objects.requireNonNull(
                Programa.class.getResource(nombreArchivo)));

        JOptionPane.showMessageDialog(null, respuesta,
                "AFD Números Romanos", JOptionPane.PLAIN_MESSAGE, gif);
    }
}

