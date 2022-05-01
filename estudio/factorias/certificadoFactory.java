package estudio.factorias;
import estudio.*;
import java.util.*;
import estudio.menus.*;

public class certificadoFactory
{
    public Certificado crearCertificado(int nuevoCertificado){
        
        Certificado tipoCertificado = null;
        
        if(nuevoCertificado == 1){
            
            return new Habitabilidad();
            
        }else
        if(nuevoCertificado == 2){
            
            return new Inspeccion();
        }else
        if(nuevoCertificado == 3){
            
            return new Energetico();
        }else
        if(nuevoCertificado == 4){
            
            return new Pericial();
        }else return null;
    }
}
