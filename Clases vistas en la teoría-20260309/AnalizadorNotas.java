package com.germangascon.ed;

import java.util.Arrays;

/**
 * <p><strong>AnalizadorNotas</strong></p>
 * <p>Descripción</p>
 * License: 🅮 Public Domain<br />
 * Created on: 2026-01-18<br />
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.0.1
 * @since 0.0.1
 **/
public class AnalizadorNotas {

    /**
     * Devuelve la media de un array de notas.
     * Requisitos:
     * - Si el array está vacío, devolver 0.0
     * - La media debe ser con decimales
     */
    public static double media(int[] notas) {
        if (notas.length == 0) return 0.0;

        int suma = 0;
        for (int n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }

    /**
     * Devuelve la nota máxima.
     * Requisitos:
     * - Si el array está vacío, lanzar IllegalArgumentException
     * - Funciona también si hay notas negativas (p. ej. penalizaciones)
     */
    public static int maximo(int[] notas) {
        if (notas.length == 0) {
            throw new IllegalArgumentException("No hay notas");
        }

        int max = 0;
        for (int n : notas) {
            if (n > max) max = n;
        }
        return max;
    }

    /**
     * Cuenta cuántas notas son aprobadas.
     * Requisitos:
     * - Se considera aprobado si nota >= 5
     */
    public static int contarAprobados(int[] notas) {
        int c = 0;
        for (int n : notas) {
            if (n > 5) {
                c++;
            }
        }
        return c;
    }

    /**
     * Normaliza un nombre de alumno.
     * Requisitos:
     * - Quitar espacios al principio y al final
     * - Poner la primera letra en mayúscula y el resto en minúscula
     * - Si el nombre es null o vacío (tras trim), devolver "Desconocido"
     *
     * Ejemplos:
     * "  aNa  " -> "Ana"
     * "" -> "Desconocido"
     * null -> "Desconocido"
     */
    public static String normalizarNombre(String nombre) {
        if (nombre == null) return "Desconocido";

        nombre.trim(); // quitar espacios
        if (nombre == "") return "Desconocido";

        String primera = nombre.substring(0, 1).toUpperCase();
        String resto = nombre.substring(1).toLowerCase();
        return primera + resto;
    }

    /**
     * Aplica un “bonus” a una nota.
     * Requisitos:
     * - bonus puede ser negativo (penalización)
     * - El resultado final debe estar en el rango [0, 10]
     */
    public static int aplicarBonus(int nota, int bonus) {
        int resultado = nota + bonus;
        if (resultado > 10) return 10;
        if (resultado < 0) return 0;
        return resultado;
    }

    // Programa de prueba manual (puedes añadir tus propios casos)
    public static void main(String[] args) {
        int[] notas1 = {5, 6, 7};
        int[] notas2 = {10, 10, 9, 8};
        int[] notas3 = {4, 5, 5};
        int[] notas4 = {-2, -5, -1};   // caso raro: negativas
        int[] vacio  = {};

        System.out.println("notas1: " + Arrays.toString(notas1));
        System.out.println("media(notas1) = " + media(notas1));
        System.out.println("maximo(notas1) = " + maximo(notas1));
        System.out.println("aprobados(notas1) = " + contarAprobados(notas1));
        System.out.println();

        System.out.println("notas3: " + Arrays.toString(notas3));
        System.out.println("media(notas3) = " + media(notas3));
        System.out.println("aprobados(notas3) = " + contarAprobados(notas3));
        System.out.println();

        System.out.println("notas4: " + Arrays.toString(notas4));
        System.out.println("maximo(notas4) = " + maximo(notas4));
        System.out.println();

        System.out.println("normalizarNombre(\"  aNa  \") = " + normalizarNombre("  aNa  "));
        System.out.println("normalizarNombre(\"\") = " + normalizarNombre(""));
        System.out.println("normalizarNombre(null) = " + normalizarNombre(null));
        System.out.println();

        System.out.println("aplicarBonus(9, 5) = " + aplicarBonus(9, 5));
        System.out.println("aplicarBonus(2, -5) = " + aplicarBonus(2, -5));

        System.out.println();
        System.out.println("media(vacio) = " + media(vacio));

        // Ojo: maximo(vacio) debería lanzar excepción según la especificación.
        // System.out.println("maximo(vacio) = " + maximo(vacio));
    }
}
