package estudio.factorias;
import estudio.*;
import estudio.menus.*;
import constructor.*;

public class menuFactory
{
    private Admin admin;
    public Menu crearMenu(Object cls){
        
      Menu tipoMenu = null;
      
      if(cls instanceof Admin){
            
         return new adminMenu();
            
        
      }else 
      
      if(cls instanceof Aparejador){
          
          return new aparejadorMenu();
          
      }else
      if(cls instanceof Arquitecto){
          
          return new arquitectoMenu();
          
      }else
      if(cls instanceof Cliente){
          
          return new clienteMenu();
          
      }else return null;
   }
}
