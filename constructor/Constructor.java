package constructor;
import estudio.*;
import java.util.*;
import estudio.menus.adminMenu;
import estudio.factorias.*;

public class Constructor
{
    private Menu menu;
    private menuFactory tipoMenu;
    private adminMenu admenu;
    private menuLogin menuLogin;
    
    public Constructor(){
        admenu = new adminMenu();
        tipoMenu = new menuFactory();
        menuLogin = new menuLogin();
        login();
    }
    
    public void login(){
        
        menuLogin.menu();
    }
}
