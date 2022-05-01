package estudio.menus;
import java.util.*;
import estudio.*;
import estudio.menus.*;
import estudio.factorias.*;


public class clienteMenu extends Menu
{
    private boolean salir;
    private int seleccion;
    private int menu;
    private int selector;
    private bd base_datos;
    private menuLogin menuLogin;
    private Cliente cliente;
    
    public clienteMenu(){
        this.cliente = new Cliente();
        this.base_datos = bd.getBd();
        this.menuLogin = new menuLogin();
    }
    
    public int getMenu(){
        
        salir=false;
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("          Menú CLIENTE   ");
        System.out.println("-----------------------------");
        System.out.println("1: Ver mis proyectos solicitados.");
        System.out.println("2: Salir.");
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
                    menuLogin.menu();
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
        
        switch(selector){
            case 1:
                this.misProyectos();
                break;
            
        }   
    }
    
    public void misProyectos(){
        
        ArrayList<Proyecto> listaProyectos = this.base_datos.getProyectos();
        LinkedList<Persona> logins = this.base_datos.getLastLogin();
        
        cliente.verMisProyectos(listaProyectos, logins);
        selector();
    }
}