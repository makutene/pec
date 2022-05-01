package estudio.menus;
import java.util.*;
import estudio.*;
import estudio.menus.*;
import estudio.factorias.*;


public class aparejadorMenu extends Menu
{
    private boolean salir;
    private int seleccion;
    private int menu;
    private int selector;
    private bd base_datos;
    private menuLogin menuLogin;
    
    
    public aparejadorMenu(){
        
        this.base_datos = bd.getBd();
        this.menuLogin = new menuLogin();
    }
    
    public int getMenu(){
        
        salir=false;
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("          Menú APAREJADOR   ");
        System.out.println("-----------------------------");
        System.out.println("1: Ver proyectos asignados.");
        System.out.println("2: Listar personas en el sistema.");
        System.out.println("3: Salir.");
        System.out.println();
        
        do {
            System.out.print("Seleccionar acción: ");
            seleccion=entrada.nextInt();
            
            switch(seleccion){
                case 1:
                    salir=true;
                    menu=1;
                    break;
                case 2:
                    salir=true;
                    menu=2;
                    break;  
                case 3:
                    entrada.close();
                    System.out.println();    
                    System.out.println("********************************");
                    System.out.println("*                              *");
                    System.out.println("*      Aplicación cerrada.     *");
                    System.out.println("*         Hasta pronto.        *");
                    System.out.println("*                              *");
                    System.out.println("********************************");
                    System.out.println("");
                    System.out.println("");
                    System.exit(1);
                default: 
                    salir=false;
                    System.out.println("");
                    System.out.println("Opción no válida");    
            }
            
        } while(!salir);
        
        System.out.println("-----------------------------");
        System.out.println();
        
        return menu;
    }
    
    public void selector(){
        
        selector = getMenu();
    }
}


