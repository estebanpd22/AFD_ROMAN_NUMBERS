package Modelo;

public class PruebasAutomata {
    // Ejemplos de romanos válidos
    private static final String[] romanosValidos = {
            "I", "II", "III", "IV", "V",
            "VI", "VII", "VIII", "IX", "X",
            "XV", "XX", "XL", "L",
    };

    // Ejemplos de romanos inválidos
    private static final String[] romanosInvalidos = {
            "IIII", "VV", "IC", "IL", "VX", "LC", "XXXX"
    };

    public static void probarRomano(Automata afd) {
        System.out.println("=== PRUEBAS CON ROMANOS VÁLIDOS ===");
        for (String num : romanosValidos) {
            System.out.println(num + " → " + Automata.evaluarRomano(num));
        }

        System.out.println("\n=== PRUEBAS CON ROMANOS INVÁLIDOS ===");
        for (String num : romanosInvalidos) {
            System.out.println(num + " → " + Automata.evaluarRomano(num));
        }
    }
}
