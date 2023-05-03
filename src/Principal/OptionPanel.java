package Principal;

import javax.swing.JOptionPane;

public class OptionPanel {

	
	public String  InputDialog(String argumento, Object opcion) {
		
		boolean valorValido = false;
		String cantidadPorConvertir = "0";
		
		if( opcion == null) {
			valorValido = true;
		}
		
		while(valorValido == false && cantidadPorConvertir != null) {
			cantidadPorConvertir = JOptionPane.showInputDialog(null, 
					argumento);
			
			valorValido = isNumeric(cantidadPorConvertir);
			
			if(valorValido == false && cantidadPorConvertir != null) {
				
				JOptionPane.showMessageDialog(null, "Valor no valido");
			}
		}
		
		return cantidadPorConvertir;
	}
	

	private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
	
	
	public boolean VentanaYesNoCancel() {
		
		int ventanaYesNotCancel = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", 
				"Select an Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(ventanaYesNotCancel == 0) { 
		  return true;
		}else{
			JOptionPane.showMessageDialog(null, "Programa Terminado");
			return false;
		}
	}
	
}
