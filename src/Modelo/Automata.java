package Modelo;

public class Automata {
    // -1 = no hay transición (rechazo)
    private static final int[][] matriz = {
            //0,1,  2, 3
            {1, 5, 10, 14},   // q0 (inicio)
            {2, 4, 9, -1},    // q1 (I)
            {3, -1, -1, -1},  // q2 (II)
            {-1, -1, -1, -1}, // q3 (III)
            {-1, -1, -1, -1}, // q4 (IV)
            {6, -1, -1, -1},  // q5 (V)
            {7, -1, -1, -1},  // q6 (VI)
            {8, -1, -1, -1},  // q7 (VII)
            {-1, -1, -1, -1}, // q8 (VIII)
            {-1, -1, -1, -1}, // q9 (IX)
            {1, 5, 11, 13},   // q10 (X)
            {1, 5, 12, -1},   // q11 (XX)
            {1, 5, -1, -1},   // q12 (XXX)
            {1, 5, -1, -1},   // q13 (XL)
            {-1, -1, -1, -1}  // q14 (L)
    };

    public static boolean evaluarRomano(String numero) {
        if(numero.isBlank()){
            return false;
        }
        int estado = 0; // estado inicial

        for (char c : numero.toCharArray()) {
            int columna;

            switch (c) {
                case 'I'-> columna = 0;
                case 'V'-> columna = 1;
                case 'X' -> columna = 2;
                case 'L' -> columna = 3;
                default -> {
                    return false; // caracter inválido
                }
            }

            // Avanzar de estado según la matriz
            estado = matriz[estado][columna];

            // Si no existe transición (=-1), la cadena es inválida
            if (estado == -1) return false;
        }
        // Si llegamos aquí, significa que la cadena fue válida
        return true;
    }
}
