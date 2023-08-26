package com.example;

public class MathUtil {
    /*
     * Essa classe não terá atributos, então seus métodos podem
     * ser static e assim qdo eles forem chamados em outras classes
     * não será preciso instaciar a classe, basta chamar a apartir
     * classe diretamente.
     */

    public static int mdc(int a, int b) {
        if(b > 0 && a % b == 0) {
            return b;
        }
        return 0;
    }

}
