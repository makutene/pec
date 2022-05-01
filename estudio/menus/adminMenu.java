package estudio.menus;
import java.util.*;
import constructor.*;
import java.time.*;
import estudio.*;
import estudio.factorias.*;



public class adminMenu extends Menu
{
    private boolean salir;
    private int seleccion;
    private int menu;
    private Admin admin;
    private Persona persona;
    private int selector;
    private menuLogin menuLogin;
    private bd base_datos;
    
    public adminMenu(){
        
        this.admin = new Admin();
        this.base_datos = bd.getBd();
        this.verifyStart();
        this.menuLogin = new menuLogin();
    }
    
    public int getMenu(){
        
        salir=false;
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("          Menú ADMIN         ");
        System.out.println("-----------------------------");
        System.out.println("1: Añadir persona al sistema.");
        System.out.println("2: Listar personas en el sistema.");
        System.out.println("3: Borrar persona del sistema.");
        System.out.println("4: Ver lista de proyectos.");
        System.out.println("5: Asignar equipo a un determinado proyecto");
        System.out.println("6: Ver calendario de obras:");
        System.out.println("7: Salir del menu.");
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
                    salir = true;
                    menu = 3;
                    break;
                case 4:
                    salir = true;
                    menu = 4;
                    break;
                case 5:
                    salir = true;
                    menu = 5;
                    break;
                case 6:
                    salir = true;
                    menu = 6;
                    break;
                case 7:
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
                this.agregarPersona();
                break;
            case 2:
                this.listarPersonas();
                break;
            case 3:
                this.borrarPersona();
                break;
            case 4:
                this.listarProyectos();
                break;
            case 5:
                this.designarPersonas();
                break;
            case 6:
                this.listarObras();
                break;
        }
    }
    
    public void listarPersonas(){
        ArrayList<Persona> personas = this.base_datos.getPersonas();
        admin.verListaPersonas(personas);
        selector();
    }
    
    public void listarProyectos(){
    
        ArrayList<Proyecto> proyectos = this.base_datos.getProyectos();
        boolean isEmpty = proyectos.isEmpty();
        if (isEmpty == true)
            System.out.println("Lista de proyectos vacia.");
        else
            admin.verListaProyectos(proyectos);
            selector();
    }
    
    
    public void agregarPersona(){
       
        persona = admin.addPersona();
        this.base_datos.addPersona(persona);
        selector();
        
    }
    
    public void borrarPersona(){
        
        ArrayList<Persona> personas = this.base_datos.getPersonas();
        admin.delPersona(personas);
        selector();
    }
    
    public void designarPersonas(){
        
        ArrayList<Obra> obras = this.base_datos.getObras();
        admin.asignarEquipo(obras);
        selector();
    }
    
    public void listarObras(){
    
        ArrayList<Obra> obras = this.base_datos.getObras();
        admin.verEquipos(obras);
        selector();
    }
    
    public void verifyStart(){
        ArrayList<Persona> personas = this.base_datos.getPersonas();
        
        if(personas.isEmpty()){
            admin = new Admin();
            admin.setName("su");
            admin.setPw("su");
        
            this.base_datos.addPersona(admin);
        }

    }
}