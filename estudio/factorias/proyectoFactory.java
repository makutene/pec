package estudio.factorias;
import estudio.*;
import java.util.*;
import estudio.menus.*;

public class proyectoFactory
{
    public Proyecto crearProyecto(int nuevoProyecto){
        
        Proyecto tipoProyecto = null;
        
        if(nuevoProyecto == 1){
            Scanner entrada = new Scanner(System.in);
            
            System.out.println("Introduce metros del terreno:");
            int m_terreno = entrada.nextInt();
            
            System.out.println("Introduce metros del edificio:");
            int m_edificio =  entrada.nextInt();
            
            System.out.println("Numero de plantas:");
            int num_plantas = entrada.nextInt();
            
            System.out.println("Numero de habitaciones:");
            int num_hab = entrada.nextInt();
            
            System.out.println("Numero de baños");
            int num_bagno = entrada.nextInt();
            
            return new Residencial(m_terreno, m_edificio, num_plantas, num_hab, num_bagno);
            
        }else
        if(nuevoProyecto == 2){
            Scanner entrada = new Scanner(System.in);
            
            System.out.println("Introduce metros del terreno:");
            int m_terreno = entrada.nextInt();
            
            System.out.println("Introduce metros del edificio:");
            int m_edificio = entrada.nextInt();
            
            Scanner entrada2 = new Scanner(System.in);
            System.out.println("Describe la finalidad:");
            String tipo_finalidad = entrada2.nextLine();
            
            return new No_Residencial(m_terreno, m_edificio, tipo_finalidad);

        }else
        if(nuevoProyecto == 3){
            Scanner entrada = new Scanner(System.in);
            
            System.out.println("Introduce los metros a reformar:");
            int m_reformar = entrada.nextInt();
            return new Rehabilitacion(m_reformar);
        }else return null;
    }
}
