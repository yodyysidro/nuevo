/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerc1;
//ARREGLOS BIDIMENSIONALES:
public class Ejerc1 {
    public static void main(String[] args) {
         final int ENCUESTADOS=10;
         //Creamos la tabla de la Encuesta, no importa si es de 3x20 o 20x3
        int lista[][]=new int [3][ENCUESTADOS];
         //Rellenamos la tabla
        rellenoSexo(lista);
        rellenoTrabajo(lista);
        rellenoSueldo(lista);
         //Mostramos la tabla, es opcional mostrarla
        imprimirArray(lista);
         //Mostramos los datos
        System.out.println("Hay un "+porcHombresMujeres(lista, 1)+" % de hombres");
        System.out.println("Hay un "+porcHombresMujeres(lista, 2)+" % de mujeres");
 
        System.out.println("Hay un "+porcHombresMujeresTrabajo(lista, 1, 1)+" % de hombres que trabajan");
        System.out.println("Hay un "+porcHombresMujeresTrabajo(lista, 2, 1)+" % de mujeres que trabajan");
 
        System.out.println("Hay un "+porcHombresMujeresTrabajo(lista, 1, 2)+" % de hombres que no tiene trabajo");
        System.out.println("Hay un "+porcHombresMujeresTrabajo(lista, 2, 2)+" % de mujeres que no tiene trabajo");
 
        System.out.println("El sueldo medio es de "+promedioSueldo(lista, 1, 1));
        System.out.println("El sueldo medio es de "+promedioSueldo(lista, 2, 1));
 
    }
    //Creamos un metodo static para rellenar el valor del sexo en aletorio 
    //esto nos dara entre mujer o homre para eso usaremos el Math.ramdom.
    public static void rellenoSexo (int lista[][]){
        for (int i=0;i<lista[0].length;i++){
            int numero=(int)Math.floor(Math.random()*2+1);
            lista[0][i]=numero;
        }
    }
    //Creamos un metodo static para rellenar los valores de trabajo de cada persona en modo aletorio
    //donde obtendremos si trabaja o no trabaja en lo cual tambien llamaremos el Math.ramdom
    public static void rellenoTrabajo (int lista[][]){
        for (int i=0;i<lista[1].length;i++){
            int numero=(int)Math.floor(Math.random()*2+1);
            lista[1][i]=numero;
        }
    }
    //Creamos un metodo static para rellenar valores de los sueldos desde usando el Math.ramdon
    //dandole valores de *1000+500.
    public static void rellenoSueldo (int lista[][]){
        for (int i=0;i<lista[1].length;i++){
             for (int j=0;j<lista[2].length;j++){
                if (lista[1][j]==2){
                    lista[2][j]=0;
                }else{
                    int numero=(int)Math.floor(Math.random()*1000+500);
                    lista[2][j]=numero;
                }
            }
 
        }
    }
    //creamos un metodo static para que nos imprima una lista de la escuesta
    // con los valores datos
    public static void imprimirArray (int lista[][]){
        //Esto solo es cuestion de estetica
        String datoEncuesta[]={"Sexo", "Trabajo", "Sueldo"};
        for (int i=0;i<lista.length;i++){
            System.out.println(datoEncuesta[i]);
            for (int j=0;j<lista[i].length;j++){
                System.out.println("En la fila " +i+" y columna " +j+ " tiene " +lista[i][j]);
            }
 
        }
    }
    public static double porcHombresMujeres (int lista[][], int sexo){
        int contador=0;
        for(int i=0;i<lista[0].length;i++){
            if (lista[0][i]==sexo){
                contador+=1;
            }
        }
        double porcentaje=(contador*100)/lista[0].length;
        return porcentaje;
    }
    public static double porcHombresMujeresTrabajo (int lista[][], int sexo, int trabajo){
        int contador=0;
        double porcentaje_sexo=0;
        double porcentaje=0;
         for(int i=0;i<lista[0].length;i++){
                if (lista[0][i]==sexo && lista[1][i]==trabajo){
                    contador+=1;
                }
        }
        if(sexo==1){
            porcentaje_sexo=porcHombresMujeres(lista, 1);
            porcentaje=(contador*100)/(porcentaje_sexo/10);
        }else{
            porcentaje_sexo=porcHombresMujeres(lista, 2);
            porcentaje=(contador*100)/(porcentaje_sexo/10);
        }
 
        return porcentaje;
    }
    public static double promedioSueldo(int lista[][], int sexo, int trabajo){
        int contador=0;
        double suma=0;
        double promedio=0;
        for(int i=0;i<lista[0].length;i++){
                 if (lista[0][i]==sexo && lista[1][i]==trabajo && lista[2][i]!=0){
                    suma+=lista[2][i];
                    contador+=1;
                }
        }
        promedio=suma/contador;
        return promedio;
    }
 
}
