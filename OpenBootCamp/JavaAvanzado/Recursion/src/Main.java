import java.util.Arrays;
import java.util.stream.IntStream;

//RECURSION: la funcion se llama a si misma para ejecutar la tarea
/*
dos tipos de recursion:
RECURSIVIDAD DE COLA
lo ultimo que se ejecuta es la llamada de la funcion a si misma
ej: sumaRecursiva
RECURSIVIDAD DE CABEZA
cuando lo primero que se hace es invocar a la propia funcion

VENTAJAS RECURSIVIDAD
-reduce la complejidad de tiempo, es decir reduce el tiempo que tarda en ejecutarse algo (O, n, n2...)
-genera cierta claridad en el codigo para debug
DESVENTAJAS
-consumo de memoria ->crea multiples copias de variables para "acordarse de cada paso"
 */
public class Main {
    public static void main(String[] args) {
        //tailRecursion(5);
        //headRecursion(5);
        System.out.println("suma itetativa: " + suma(5));
        System.out.println("suma recursiva: " + sumaRecursiva(5));
        System.out.println("suma funcional: " + sumaFuncional(5));

        System.out.println("factorial itetativa: " + factorial(5));
        System.out.println("factorial recursiva: " + factorialRecursivo(5));
        System.out.println("factorial funcional: " + factorialFuncional(5));
    }

    public static int factorial(int numero){
        int resultado = 1;

        for (int i = 1; i <= numero ; i++) {
            resultado *= i;
        }

        return resultado;

    }
    public static int factorialRecursivo(int numero){

        if(numero == 0){
            return 1;
        }
        return numero * factorialRecursivo(numero - 1);
    }
    public static int factorialFuncional(int numero){

        return IntStream.rangeClosed(1,numero)
                .reduce(1,(a,b)->a*b);
    }

    public static int sumaRecursiva(int numero){
        if(numero == 1){
            return 1;
        }
        return numero + sumaRecursiva(numero - 1);
    }

    public static int sumaFuncional(int numero){
        return IntStream.rangeClosed(1,numero)
                .reduce(0,(a,b)->a+b);
    }
    public static void tailRecursion(int valor){
        if(valor == 0){
            return;
        }
        System.out.println(valor);
        tailRecursion(valor - 1);
    }

    public static void headRecursion(int valor){
        if(valor == 0){
            return;
        }
        headRecursion(valor - 1);
        System.out.println(valor);

    }

    public static int suma(int max){
        int resultado = 0;

        for (int i = 0; i <= max ; i++) {
            resultado += i;
        }
        return resultado;
    }
}