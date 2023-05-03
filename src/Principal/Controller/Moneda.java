package Principal.Controller;

import javax.swing.JOptionPane;

import Principal.OptionPanel;

import java.math.BigDecimal;

public class Moneda {

	public boolean OpcionesDeMonedas(String cantidadPorConvertir) {
			
		String [] monedas = {"De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras",
				"De Pesos a Yen", "De Pesos a Won Coreano", "De Dólar a Pesos", "De Euro a Pesos",
				"De Libras a Pesos", "De Yen a Pesos", "De Won Coreano a Pesos"};
		
		Object opcionDeMoneda = JOptionPane.showInputDialog(null,"Elije la moneda a la que deseas convertir tu dinero",
				"Monedas",JOptionPane.QUESTION_MESSAGE,null,monedas, monedas[0]);
			
		if(opcionDeMoneda != null) {
			
			int i;
			for( i = 0; i< monedas.length; i++) {
				if(opcionDeMoneda == monedas[i]) {
					break;
				}
			}
			
			String valorDeMoneda = DameValorMoneda(i,monedas);
			return ConvierteMoneda(cantidadPorConvertir, valorDeMoneda, i);
		}
		
		return true;
		
	}
	
	
	public boolean ConvierteMoneda(String cantidadPorConvertir, String valorDeMoneda, int i) {
		
		BigDecimal bdCantidad = new BigDecimal(cantidadPorConvertir);
		BigDecimal bdValorMoneda = new BigDecimal(valorDeMoneda);
		
		BigDecimal valor = bdValorMoneda.multiply(bdCantidad); 
		
		String nombreMoneda = ObtenerNombreMoneda(i);
		JOptionPane.showMessageDialog(null, "Tienes $ " + valor + nombreMoneda);	

		OptionPanel optionPanel = new OptionPanel();
		boolean ventanaYesNotCancel = optionPanel.VentanaYesNoCancel();
		
		return ventanaYesNotCancel;
		
	}
	
	public String DameValorMoneda(int i, String [] monedas) {
		
		String valorDeMoneda;
		
		
		switch (monedas[i]) {
		case "De Pesos a Dólar": valorDeMoneda = "0.056";
		break;
		case "De Pesos a Euro": valorDeMoneda = "0.051";
		break;
		case "De Pesos a Libras": valorDeMoneda = "0.045";
		break;
		case "De Pesos a Yen": valorDeMoneda = "7.59";
		break;
		case "De Pesos a Won Coreano": valorDeMoneda = "74.55";
		break;
		case "De Dólar a Pesos": valorDeMoneda = "17.98";
		break;
		case "De Euro a Pesos": valorDeMoneda = "19.79";
		break;
		case "De Libras a Pesos": valorDeMoneda = "22.42";
		break;
		case "De Yen a Pesos": valorDeMoneda = "0.13";
		break;
		case "De Won Coreano a Pesos": valorDeMoneda = "0.013";
		break;
		default: valorDeMoneda = "0";
		
		}
		
		return valorDeMoneda;
	}
	
	public String ObtenerNombreMoneda(int i) {
		
		String nombreDeMoneda;
		
		switch (i) {
		case 0: nombreDeMoneda = " Dolares";
		break;
		case 1: nombreDeMoneda = " Euros";
		break;
		case 2: nombreDeMoneda = " Libras";
		break;
		case 3: nombreDeMoneda = " Yenes";
		break;
		case 4: nombreDeMoneda = " Wones Coreano";
		break;
		
		default: nombreDeMoneda = " Pesos";
		
		}
		
		return nombreDeMoneda;
	}
	
	
}
