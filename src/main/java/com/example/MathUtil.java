package com.example;

public class MathUtil {
    /*
     * Essa classe não terá atributos, então seus métodos podem
     * ser static e assim qdo eles forem chamados em outras classes
     * não será preciso instaciar a classe, basta chamar a apartir
     * classe diretamente.
     */
                            //11  e  2
    public static int mdc(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if(b > 0 && a % b == 0) {
            return b;
        }
        if(b == 0) {
            return Math.abs(a);
        }
        if(a % b > 0 && b % a == 0) {
            return a;
        }
        return -1; //usar -1 p ver retornou erro pq se usar 0 pode ser um valor válido para algum cenário
        //throws 
    }

    

}
