package Principal;

import javax.swing.JOptionPane;

import Principal.Controller.Moneda;
import Principal.Controller.Temperatura;

public class Conversor {

	public static void main(String[] args) {
		
		OptionPanel optionPanel = new OptionPanel();
		boolean ProgramaTerminado = true;
		Object opcionDeConversor;
		String cantidadPorConvertir;
		String [] menu = {"Conversor de moneda","Conversor de Temperatura"};
		
		do {
			opcionDeConversor = JOptionPane.showInputDialog(null,"Seleccione una opcion de conversion",
					"Menu",JOptionPane.QUESTION_MESSAGE,null,menu, menu[0]);
			
			cantidadPorConvertir = optionPanel.InputDialog("Ingrese la cantidad que deseas convertir", opcionDeConversor);
			
			if(opcionDeConversor == "Conversor de moneda" && cantidadPorConvertir != null) {
				Moneda moneda = new Moneda();
				ProgramaTerminado = moneda.OpcionesDeMonedas(cantidadPorConvertir); 
				
			}else if(opcionDeConversor == "Conversor de Temperatura" && cantidadPorConvertir != null) {
				
				Temperatura temperatura = new Temperatura();
				ProgramaTerminado = temperatura.OpcionesDeTemperatura(cantidadPorConvertir);
				
			}else if(cantidadPorConvertir != null){
				
				JOptionPane.showMessageDialog(null, "Programa Terminado");
				ProgramaTerminado = false;
			}
			
		
		}while(ProgramaTerminado != false);
			
		
	}

	
}
