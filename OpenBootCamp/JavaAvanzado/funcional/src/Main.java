/*
PRINCIPIOS BASICOS DE LA PROGRAMACION FUNCIONAL

1. FUNCION PURA
2. FUNCION DE ALTO ORDEN

 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    //Funtion<tipo_entrada, tipo_salida> nombreFuncion = nombreVariableEntrada -> loQueDevuelve;
    private Function<String, String> toMayus = x -> x.toUpperCase();
    private Function<Integer, Integer> sumador = x -> x.sum(x,x);

    public static void main(String[] args) {
        //Funcionales f = new Funcionales();
        //f.pruebas();

        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Paco");
        nombres.add("Pepe");
        nombres.add("Juan");

        // x->System.out.println(x) es lo mismo que System.out::println

        //esto....
   //     nombres.stream().forEach(System.out::println);

        //...hace lo mismo que esto
    //    for (String nombre: nombres ) {
     //       System.out.println(nombre);
     //   }

        //map: por cada resultado generado por mi stream le aplico otra funcion
        Stream<String> valores = nombres.stream().map( (x) ->"Hola, " + x.toUpperCase());

        valores.forEach(x -> System.out.println(x));

        //generalmente las funciones que se invocan detras de un Stream devuelven stream
        //ventaja del stream es que hacen el for automatico,
        // desventaja es que se consumen(una vez que recorri el stream no puedo volver a utilizarlo) -> solo se puede recorrer una vez


        //filter aplica una funcion de descarte
        //lo que no cumpla la condicion no va a devolverse

        Stream<String> valoresDos = nombres.stream()
                .map(x ->"Hola, " + x.toUpperCase())
                .filter(x->x.startsWith("P"));
        valoresDos.forEach(System.out::println);

        int[] numeros = {1,2,3,4,5,6,7,8,9,10};

        //convierto un array a stream pero lo consumo
        var stNumeros = Arrays.stream(numeros);
        //stNumeros.forEach(x-> System.out.println(x));

        //muestra los numeros pares de array
        //var resultado = stNumeros.filter(x->x%2==0);
        //resultado.forEach(System.out::println);

        //muestra la suma de los numeros pares del array, cero es el valor inicial
        //var resultado = stNumeros.filter(x->x%2==0).reduce(0,(x,y) -> x+y);

        var resultado = stNumeros
                .filter(x->x%2==0)
                .reduce(0,(x,y) -> {
                    System.out.println("X es: " + x + " Y es: " + y);
                    return x+y;
                });
        System.out.println("Mi suma de pares es: " + resultado);

        var stNumeros2 = Arrays.stream(numeros);
        var resultado2 = stNumeros2
                .map(x->x*2)
                .filter(x->x%2==0)
                .reduce(0,(x,y) -> {
            System.out.println("X es: " + x + " Y es: " + y);
            return x+y;
        });
        System.out.println("Mi suma de pares es: " + resultado2);


        /*
        FORMA FUNCIONAL: (DECLARATIVA)
        var resultado = stNumeros
                .map(x->x*2)
                .filter(x->x%2==0)
                .reduce(0,(x,y) ->x+y);
        System.out.println("Mi suma de pares es: " + resultado);

        FORMA IMPERATIVA:
        int sumaTotal = 0;
        for(int numero : numeros){
            numero = numero * 2;
            if(numero % 2 != 0){
                continue;
            }
            sumaTotal += numero;
        }
        System.out.println("Mi suma de pares es: " + sumaTotal);
        */
    }
/*
FUNCION PURA
-aquella que dados unos parametros de entrada siempre produzca el mismo resultado de salida
(ante un mismo valor de entrada siemore devuelve en mismo retorno)
-no puede haber efecto colateral (ej modifical una variable global o local dentro de la funcion)
(no puede modificar datos ajenos a la funcion)
- si invoca a una funcion que no es pura, ya no es pura
-para que siga siento pura puedo modificar solo las variables que son creadas dentro de la misma funcion(las locales a la funcion)
 -tiene qe hacer exactamente lo que dice (si se llama suma solo tiene que sumar, nada mas)
 */

    //funcion pura basica: siempre devuelve el mismo valor cuando sus paramentros de entrada no varien
    public static int suma(int a, int b){
        return a + b;
    }

    /*
    FUNCION DE ALTO ORDEN
    -una funcion puede llamar a otra funcion y debe devolver una funcion
    -debe recibir un parametro que sea obligatoriamente otra funcinon o que devuelve otra funcion
     -ej funciones lamda
     */
    public static boolean devuelve(String cadena){
        return cadena.startsWith("a");
    }

    //metodo de ejemplo de que hace la funcion de alto nivel toMayus (funcion lambda)
    public static String toMayuscula(String nombre){
        return nombre.toUpperCase();
    }

    public void pruebas(){
        toMayus.apply("Hola");
        sumador.apply(5);
    }
}