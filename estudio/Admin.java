package estudio;
import java.util.*;
import java.time.*;
import estudio.factorias.*;
import estudio.menus.*;

public class Admin extends Empleado{
        
    private bd base_datos;
    
    public Admin(){
        
        super();
        this.base_datos = bd.getBd();
    }
    
    public Persona addPersona(){
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce nombre: ");
        String name = entrada.nextLine();
        
        System.out.println("Selecciona el rol de "+name+ " (Cliente / Arquitecto / Aparejador / Contable)");
        String rol = entrada.nextLine();
        
        System.out.println("Introduce un password: ");
        String pw = entrada.nextLine();
        
        personaFactory tipoPersona = new personaFactory();
        Persona persona = tipoPersona.crearPersona(rol);
        
        persona.setName(name);
        persona.setPw(pw);
        
        return persona;
    }
    
    public void delPersona(ArrayList<Persona> listaPersonas){
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del usuario a eliminar: ");
        String name = entrada.nextLine();
        
        for (Persona persona : listaPersonas){
            if (persona.getName().equals(name)){
                
                listaPersonas.remove(persona);
                System.out.println("El usuario "+persona.getName()+" ha sido eliminado del sistema");
                break;
            }
        }
        
        
    }

    public void asignarEquipo(ArrayList<Obra> obras){
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduce el nombre del arquitecto asignado:");
        String arq_name = entrada.nextLine();
        Persona arquitecto = base_datos.getPersonaByName(arq_name);
        
        System.out.println("Introduce el nombre del aparejador asignado:");
        String apa_name = entrada.nextLine();
        Persona aparejador = base_datos.getPersonaByName(apa_name);
        
        System.out.println("Introduce el nombre del contable asignado:");
        String cont_name = entrada.nextLine();
        Persona contable = base_datos.getPersonaByName(cont_name);
        
        System.out.println("Selecciona el nombre de la persona al que va asignado el equipo:");
        String name = entrada.nextLine();
        Proyecto proyecto = base_datos.getProyectoByName(name);
        
        Obra obra = new Obra();
        obra.setProyecto(proyecto);
        obra.setArquitecto(arquitecto);
        obra.setAparejador(aparejador);
        obra.setContable(contable);
        
        
        System.out.println("Introduce la fecha de inicio de la obra (YYYY-mm-dd):");
        String start_date = entrada.nextLine();
        System.out.println("Introduce la fecha de fin de la obra (YYYY-mm-dd):");
        String end_date = entrada.nextLine();
        
        obra.setStartDate(start_date);
        obra.setEndDate(end_date);
        
        obra.setEsperando();
        obras.add(obra);        
        
    }
    
    public void verEquipos(ArrayList<Obra> obras){
        
        for (Obra obra : obras){
            
            System.out.println("Nombre del cliente: "+obra.getProyectOwner()+" | Tipo de proyecto: "+obra.getTypeOfProyect().getClass()+" | Arquitecto asignado: "+obra.getArquitectoName()+"  | Aparejador asignado: "+obra.getAparejadorName()+ "  | Contable asignado: "+obra.getContableName()+"  | Fecha inicio de la obra: "+obra.getStartDate()+"  | Fecha fin de la obra: "+obra.getEndDate()+" | Estado de la obra: "+obra.getEsperando());
        }
    }
    
    public void verListaProyectos(ArrayList<Proyecto> listaProyectos){
        
        for (Proyecto proyecto : listaProyectos) {
          System.out.println("Nombre: " + proyecto.getClienteName() +" | Tipo: " + proyecto.getClass()+ " | Direccion: "+proyecto.getDireccion()+" | Fecha de solicitud: "+proyecto.getFechaSolicitud());
        }
    }
    
    public void verListaPersonas(ArrayList<Persona> listaPersonas){
    
        for (Persona persona : listaPersonas){
            if(persona != null){
                System.out.println("Nombre: "+persona.getName()+" |  Rol: "+persona.getClass());
            }
        }
    }
    
    
}