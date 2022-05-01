package estudio.factorias;
import estudio.*;
import estudio.menus.*;

public class personaFactory
{
    public Persona crearPersona(String nuevaPersona){
        
        Persona tipoPersona = null;
        if(nuevaPersona.equalsIgnoreCase("Admin")){
            
            return new Admin();
            
        }else
        if(nuevaPersona.equalsIgnoreCase("Cliente")){
            
            return new Cliente();
            
        }else
        if(nuevaPersona.equalsIgnoreCase("Aparejador")){
            
            return new Aparejador();
        }else
        if(nuevaPersona.equalsIgnoreCase("Arquitecto")){
            
            return new Arquitecto();
        }else
        if(nuevaPersona.equalsIgnoreCase("Contable")){
            
            return new Contable();
        }else return null;
    }
}