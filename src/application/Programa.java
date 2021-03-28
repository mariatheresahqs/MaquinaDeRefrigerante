package application;

import java.util.Locale;

import util.*;

public class Programa {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        /*
            CLASSE MENU FOI CRIADA PARA PERMITIR TESTAR A APLICAÇÃO5
        */
        Menu menu = new Menu();
        menu.mostrarMenu();    
    }
}