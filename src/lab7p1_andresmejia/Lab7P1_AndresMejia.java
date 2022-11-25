//Andres Mejia
package lab7p1_andresmejia;
import java.util.Scanner;
import java.security.SecureRandom;
import javax.swing.JOptionPane;


public class Lab7P1_AndresMejia {

    static Scanner read=new Scanner(System.in);
    static SecureRandom random=new SecureRandom();
    
    public static void main(String[] args) {
        int opcion;
        do{
            opcion=menu();
            switch(opcion){
                case 1:{
                    System.out.println("Ingrese cantidad de filas: ");
                    int filas=read.nextInt();
                    System.out.println("Ingrese cantidad de columnas: ");
                    int columnas=read.nextInt();
                    while(filas==columnas){
                        System.out.println("No se puede ingresar matrices cuadradas");
                        System.out.println("Ingrese filas otra vez: ");
                        filas=read.nextInt();
                        System.out.println("Ingrese columnas otra vez: ");
                        columnas=read.nextInt();
                        
                    }
                    int [][]numeros=lectura(filas,columnas);
                    
                    
                   
                    
                    
                    
                    break;
                }
                case 2:{
                    System.out.println("Ingrese cantidad de filas: ");
                    int filas=read.nextInt();
                    System.out.println("Ingrese cantidad de columnas: ");
                    int columnas=read.nextInt();
                    while(filas==columnas){
                        System.out.println("No se puede ingresar matrices cuadradas");
                        System.out.println("Ingrese filas otra vez: ");
                        filas=read.nextInt();
                        System.out.println("Ingrese columnas otra vez: ");
                        columnas=read.nextInt();
                        
                    }
                    int [][]numeros=lectura(filas,columnas);
                    int op3=sumaext(numeros)+multint(numeros);
                    JOptionPane.showMessageDialog(null, "La matriz original es: \n"+print(numeros)+"\n La suma de exterior es: "+sumaext(numeros)+"\n"
                            + "La multiplicacion de interior es: "+multint(numeros)+"\n"
                                    + "El numero generado es: "+op3);
                    
                    break;
                }
                
                case 3:{
                    String cadena1, cadena2;
                    System.out.println("Ingrese una palabra: ");
                    cadena1=read.next();
                    System.out.println("Ingrese una segunda palabra: ");
                    cadena2=read.next();
                    cadena1="-"+cadena1;
                    cadena2="-"+cadena2;
                    lcs(cadena1,cadena2);
                    
                    
                    break;
                }
                
                
            }
            
        }while(opcion!=4);
        
        
    }
    
    public static int menu(){
        int opcion;
        System.out.println("Opcion 1: Portrait ");
        System.out.println("Opcion 2: Numero magico ");
        System.out.println("Opcion 3: Subsecuencia ");
        opcion=read.nextInt();
        
        return opcion;
    } //Fin menu
    
    public static int [][] lectura(int filas, int columnas){
        int [][]temporal=new int[filas][columnas];
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                temporal[i][j]=random.nextInt(10);
            }
        }
        return temporal;
    } //Fin de lectura
    
    public static int [][] transpuesta(int [][]array){
        int contador;
        
        int [][]temporal=new int[array[0].length][array.length];
        contador=0;
        for(int i=array.length-1; i>=0;i--){
            
            for(int j=0; j<array[0].length; j++){
                temporal[j][contador]=array[i][j];
            }
            contador++;
        }
        
        return temporal;
    } //Fin transpuesta
    
    public static String print(int [][]array){
        String acum="";
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
               acum=acum+"["+array[i][j]+"]"; 
            }
            acum=acum+"\n";
        }
        return acum;
    } //Fin del print 
    
    public static int sumaext(int[][]array){
        int suma=0;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                if(i==0 || i==array.length-1 || j==0 || j==array[0].length-1){
                    suma=suma+array[i][j];
                }
            }
        }
        return suma;
    } //Fin suma exterior
    
    public static int multint(int[][]array){
        int suma=1;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                if(i!=0 && i!=array.length-1 && j!=0 &&j!=array[0].length-1){
                    suma=suma*array[i][j];
                }
            }
        }
        return suma;
    } //Fin multiplicacion internos
    
    public static int lcs(String cadena1, String cadena2){
        int temporal [][]=new int[cadena1.length()][cadena2.length()];
        int subseq;
        for(int i=0;i<cadena1.length(); i++){
            for(int j=0; j<cadena2.length();j++){
                    if(cadena1.charAt(i)=='-'||cadena2.charAt(j)=='-' ){
                        temporal[i][j]=0;
                    }
                    else if(cadena1.charAt(i)==cadena2.charAt(j)){
                        temporal[i][j]=temporal[i-1][j-1]+1;
                    }
                    else {
                        temporal[i][j]=Math.max(temporal[i-1][j], temporal[i][j-1]);
                    }
            }
        }
        
        subseq=temporal[cadena1.length()-1][cadena2.length()-1];
        JOptionPane.showMessageDialog(null, print(temporal)+"\n El tamaño de la subsecuencia mayor es: "+subseq);
        return subseq;
    } 
    
}
