package estudio;
import java.util.*;
import estudio.menus.*;
import estudio.factorias.*;

public class Arquitecto extends Empleado
{
    private bd base_datos;
    
    public Arquitecto(){
        super();
        this.base_datos = bd.getBd();
    }
    
    public void verMisObras(ArrayList<Obra> obras, ArrayList<Certificado> certificados, LinkedList<Persona> logins){
        
        System.out.println("------------PROYECTOS ASIGNADOS--------------");
        for (Obra obra : obras){
            
            if( obra.getArquitectoName().equals(logins.getLast().getName())){
                
                System.out.println("Tipo de proyecto: "+obra.getTypeOfProyect().getClass()+" | Cliente: "+obra.getProyectOwner());
            }
        }
        System.out.println("------------CERTIFICADOS ASIGNADOS--------------");
        for (Certificado certificado: certificados){
            
            if( certificado.getObra().getArquitectoName().equals(logins.getLast().getName()) ){
                
                System.out.println("Tipo de certificado: "+certificado.getClass()+ " |  Proyecto asociado: "+certificado.getObra().getTypeOfProyect().getClass()+"  | Cliente: "+certificado.getObra().getProyectOwner());
            }
            
        }
    }
    
    public void registroProyecto(ArrayList<Proyecto> listaProyectos, ArrayList<Persona> listaPersonas){
    
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del cliente: ");
        String name = entrada.nextLine();
        
        for (Persona persona : listaPersonas){
            
            if (persona.getName().equals(name)){
                proyectoFactory nuevoProyecto = new proyectoFactory();
                System.out.println("Selecciona el tipo de proyecto: (1.Residencial / 2.No residencial / 3.Rehabilitacion)");
                int set_proyecto = entrada.nextInt();
                
                Scanner input = new Scanner(System.in);
                System.out.println("Escribe la direccion de tu solicitud:");
                String direccion = input.nextLine();
                
                Proyecto proyecto = nuevoProyecto.crearProyecto(set_proyecto);
            
                proyecto.setDireccion(direccion);
                proyecto.setCliente(persona);
                proyecto.setFechaSolicitud();
                
                listaProyectos.add(proyecto);
                break;
                
            
            }else {
                System.out.println("El cliente "+name+" no existe.");
                 break;
                }
        }
    
    }
    
    public void registroCertificado(ArrayList<Certificado> certificados){
        
        Scanner getName = new Scanner(System.in);
        System.out.println("Introduce el nombre del cliente: ");
        String name = getName.nextLine();
            
        Obra obra = base_datos.getObraByName(name);
        
        Scanner getCert = new Scanner(System.in);
        System.out.println("Selecciona el tipo de certificado: (1.Habilitacion / 2.Inspeccion / 3.Energetico / 4.Pericial)");
        int set_certificado = getCert.nextInt();
        
        certificadoFactory nuevoCertificado = new certificadoFactory();
                
        Certificado certificado = nuevoCertificado.crearCertificado(set_certificado);
        System.out.println(certificado.getClass());
        
        certificado.setObra(obra);        
        certificados.add(certificado);        
            
    }
        
}
