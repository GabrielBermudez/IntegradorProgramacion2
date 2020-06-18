package Controlador;

import Modelo.ModeloMenuPrincipal;
import Vista.MenuPrincipal;

public class Main {

	public static void main(String[] args) {
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		ModeloMenuPrincipal modeloMenuPrincipal = new ModeloMenuPrincipal();
		
		ControladorMenuPrincipal controladorMenuPrincipal = new ControladorMenuPrincipal(menuPrincipal, modeloMenuPrincipal);
	}

}
