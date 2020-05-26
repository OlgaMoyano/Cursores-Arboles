/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolcursor;

import java.text.Collator;
import java.util.Arrays;

/**
 *
 * @author olgal
 */
public class Cursor {
    int posicion[];
    int izq[];
    int der[];
    String mensaje;
    String raiz[];
    Collator col;

    public Cursor(int numDatos) {
        this.posicion = new int[numDatos];
        this.izq = new int[numDatos];
        this.der = new int[numDatos];
        this.raiz = new String[numDatos];
        this.col =  Collator.getInstance(); 
        mensaje="";
        
        inicializar();
    }
    
    public void inicializar(){
       
    for(int i=0;i<posicion.length;i++){
        this.raiz[i]="";
        this.posicion[i]=i;
        if(i+1<posicion.length){
          this.der[i]=i+1;// siguiente disponible 
        }
    
    }
     this.der[posicion.length-1]=0;
     
        }
    
    public void insertar(String nombre){
    if (nombre!=null){
    int disponible=der[0];
        //System.out.println("diponible->"+disponible);
    raiz[disponible]=nombre;
    //System.out.println("raiz->"+raiz[disponible]);
    izq[disponible]=-1;
    der[disponible]=-1;
    comparar(1,nombre,disponible);
    if(buscar("",raiz)!=-1){
    der[0]=buscar("",raiz);
    }else{
    der[0]=0;
    }
    this.raiz[0]="1";
    }
    
    }
    
    public  void comparar(int disponible,String nombre,int hijo){
       //System.out.println("letra->"+nombre+"-diponible->"+raiz[disponible]+"-hijo->"+hijo); 
       if (nombre!=null){
        if(col.compare(nombre, raiz[disponible])<0){
             if (izq[disponible]==-1){
               
                izq[disponible]=hijo;
                
            }
            else{
                comparar(izq[disponible],nombre,hijo);
            }
        
        }
         if(col.compare(nombre, raiz[disponible])>0){
            // System.out.println("entra Der");
            if (der[disponible]==-1){
                der[disponible]=hijo;
            }
            else{
                comparar(der[disponible],nombre,hijo);
            }
          

        } 
       }
    }
    
    
    public void inorden(int pos){
        if(pos!=-1){
            inorden(this.izq[pos]);
            mensaje=mensaje+","+raiz[pos];
            inorden(this.der[pos]);
        }
     
    }
    
    public void retirar(String nombre){
       mensaje="";
       inorden(1);
       String[] inorden = mensaje.split(",");
       int posEliminar=buscar(nombre,raiz);
        System.out.println(posEliminar);
       //el siguiente en inorden
       int temRemplazo=buscar(nombre,inorden)+1;
       System.out.println(temRemplazo);
        System.out.println(inorden[temRemplazo]);
       int posReemplazo=buscar(inorden[temRemplazo],raiz);
       //verificar si es padre
      System.out.println(posReemplazo);
      
        if(der[posEliminar]!=-1 || izq[posEliminar]!=-1){
            System.out.println("Entra");
           raiz[posEliminar]=raiz[posReemplazo];
           raiz[posReemplazo]="";
            System.out.println(raiz[posEliminar]);
            System.out.println(raiz[posReemplazo]);
           der[0]=posReemplazo;
           limpiarRastro(posReemplazo);
           }
          //No tiene Hijos
        else{
            raiz[posEliminar]="";
            der[0]=posEliminar;
            limpiarRastro(posReemplazo);
        }
    }
    
    
    public int buscar(String nombre,String[] lugar){
    for (int i=1;i<lugar.length;i++){
        if(col.compare(nombre, lugar[i])==0){
            return i;
        }
    }
    return -1;
    }
    
    public int buscarInt(int pos,int[] lugar){
    for (int i=1;i<lugar.length;i++){
        if(pos==lugar[i]){
            System.out.println("pos="+pos+" lugar="+lugar[i]);
            return i;
        }
    }
    return -1;
    }
    
    public void limpiarRastro(int posReemplazo){
        if (buscarInt(posReemplazo,der)!=-1){
            System.out.println("Entra"+buscarInt(posReemplazo,der));
               der[buscarInt(posReemplazo,der)]=-1;
           }
           if (buscarInt(posReemplazo,izq)!=-1){
               izq[buscarInt(posReemplazo,izq)]=-1;
           }
        
    }
      
            
    }
