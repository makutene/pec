package estudio.menus;

import java.util.*;
import constructor.*;
import estudio.*;
import estudio.factorias.*;
import estudio.menus.*;


public class arquitectoMenu extends Menu
{
    private boolean salir;
    private int seleccion;
    private int menu;
    private int selector;
    private menuLogin menuLogin;
    private bd base_datos;
    private Arquitecto arquitecto;
    
    public arquitectoMenu(){
        this.arquitecto = new Arquitecto();
        this.base_datos = bd.getBd();
        this.menuLogin = new menuLogin();
    }
    
    public int getMenu(){
        
        salir=false;
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("          Menú ARQUITECTO    ");
        System.out.println("-----------------------------");
        System.out.println("1. Ver clientes asignados (proyectos/certificados/obras)");
        System.out.println("2. Registro de proyectos");
        System.out.println("3. Registro de certificado");
        System.out.println("4. Actualizar proyecto");
        System.out.println("5. Actualizar certificado");
        System.out.println("6: Salir del menu.");
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
                    salir=true;
                    menu=3;
                    break;
                case 4:
                    salir=true;
                    menu=4;
                    break;
                case 5:
                    salir=true;
                    menu=5;
                    break;
                case 6:
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
                this.misAsignaciones();
                break;
            case 2:
                this.nuevoProyecto();
                break;
            case 3:
                this.nuevoCertificado();
                break;
        }
    }
    
    public void nuevoProyecto(){
    
        ArrayList<Persona> personas = this.base_datos.getPersonas();
        ArrayList<Proyecto> proyectos = this.base_datos.getProyectos();
        
        arquitecto.registroProyecto(proyectos, personas);
        selector();
    }
    
    public void nuevoCertificado(){
        
        ArrayList<Certificado> certificados = this.base_datos.getCertificados();
        
        arquitecto.registroCertificado(certificados);
        selector();
    }
    
    public void misAsignaciones(){
        
        ArrayList<Certificado> certificados = this.base_datos.getCertificados();
        ArrayList<Obra> obras = this.base_datos.getObras();
        LinkedList<Persona> logins = this.base_datos.getLastLogin();
        
        arquitecto.verMisObras(obras, certificados, logins);
        selector();
    }
}