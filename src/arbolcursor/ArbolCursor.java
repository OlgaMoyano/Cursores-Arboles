/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolcursor;

/**
 *
 * @author olgal
 */
public class ArbolCursor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String entrada[]=new String[20];
        entrada[0]="olga";
        entrada[1]="lucia";
        entrada[2]="gabi";
        entrada[3]="ana";
        entrada[4]="ursula";
        entrada[5]="carlos";
        entrada[6]="ivan";
      
        Cursor cursor=new Cursor(entrada.length+1);
        for (int x=0;x<entrada.length;x++){
           //System.out.println("Caracter " + x + ": " + nombre.charAt(x));
          
           cursor.insertar(entrada[x]);
        }
        for (int i=0;i<cursor.posicion.length;i++){
            if(cursor.raiz[i]!=""){
            System.out.println("----------");
            System.out.println("pos"+cursor.posicion[i]);
            System.out.println("r="+cursor.raiz[i]+"-i="+cursor.izq[i]+"-d="+cursor.der[i]);}
        }
        System.out.println("Inorden");
       cursor.inorden(1);
       System.out.println(cursor.mensaje);
       cursor.retirar("carlos");
       cursor.insertar("Sofia");
               for (int i=0;i<cursor.posicion.length;i++){
            if(cursor.raiz[i]!=""){
            System.out.println("----------");
            System.out.println("pos"+cursor.posicion[i]);
            System.out.println("r="+cursor.raiz[i]+"-i="+cursor.izq[i]+"-d="+cursor.der[i]);}
        }
    }
    
   
    
}
