import java.util.Scanner;

public class EstructuraCondicionalSimple {

    public void estructuraSimple(){

        Scanner objTeclado = new Scanner(System.in);
        float salario;
        System.out.println("Ingrese el salario");
        salario = objTeclado.nextFloat();

        if(salario >= 80000){
            System.out.println("Debe pagar impuesto");

        }else{
            System.out.println("No paga impuestos");
        }
    }

    public void calcularImpuesto(){
        Scanner objTeclado = new Scanner(System.in);
        float impuesto;
        String nombre;
        String familia;
        int hijos = 0;
        String esposo = "";
        Float salario;

        System.out.println("Ingrese nombre");
        nombre = objTeclado.nextLine();
        System.out.println("tiene familia? (si/no)");
        familia = objTeclado.next();
        if(familia.equalsIgnoreCase("si")){
            System.out.println("tiene esposo/a (si/no)");
            esposo = objTeclado.next();
            System.out.println("cuantos hijos tiene?");
            hijos = objTeclado.nextInt();
        }
        System.out.println("Ingrese el salario");
        salario = objTeclado.nextFloat();

        System.out.println("nombre: " + nombre);
        System.out.println("familia: " + familia);
        if(esposo.equalsIgnoreCase("si")){
            System.out.println("tiene esposo/a y  " + hijos + " hijos" );

        }else{
            System.out.println("no tiene esposo/a");
            if(hijos != 0){
                System.out.println("hijos: " + hijos);
            }
        }

        if(salario >= 80000){

            impuesto = (float) (salario * 0.16);

            System.out.println("pagar: " + impuesto);

        }else{
            System.out.println("No paga impuestos");
        }
    }
}
