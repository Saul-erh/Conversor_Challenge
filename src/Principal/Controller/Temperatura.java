package Principal.Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;

import Principal.OptionPanel;

public class Temperatura {

	public boolean OpcionesDeTemperatura(String cantidadPorConvertir) {
		
		String [] temperaturas = {"Grados Celcius a Grados Fahrenheit", "Grados Celcius a Grados kelvin", 
				"Grados Fahrenheit a Grados Celcius", "kelvin a Grados Celcius", "kelvin a Grados Fahrenheit"};
		
		Object opcionDeTemperatura = JOptionPane.showInputDialog(null,"Elije una opcion para converitr",
				"Temperaturas",JOptionPane.QUESTION_MESSAGE,null,temperaturas, temperaturas[0]);
			
		if(opcionDeTemperatura != null) {
			
			int i;
			for( i = 0; i< temperaturas.length; i++) {
				if(opcionDeTemperatura == temperaturas[i]) {
					break;
				}
			}
			
			BigDecimal valorDeTemperatura = DameValorTemperatura(i,temperaturas, cantidadPorConvertir);
			return MuestraTemperatura(cantidadPorConvertir, valorDeTemperatura, i);
		}
		
		return true;
	}
	
public boolean MuestraTemperatura(String cantidadPorConvertir, BigDecimal valorDeTemperatura, int i) {
			
		ObtenerTemperatura(cantidadPorConvertir, valorDeTemperatura, i);

		OptionPanel optionPanel = new OptionPanel();
		boolean ventanaYesNotCancel = optionPanel.VentanaYesNoCancel();
		
		return ventanaYesNotCancel;
		
	}
	
	public BigDecimal DameValorTemperatura(int i, String [] temperaturas, String cantidadPorConvertir) {
		
		BigDecimal temperaturaPorCovertir  = new BigDecimal(cantidadPorConvertir); 
		BigDecimal valorDeTemperatura = new BigDecimal(0);
		BigDecimal nueveQuintos = new BigDecimal(1.8).setScale(2,RoundingMode.HALF_UP);
		BigDecimal cincoNovenos = new BigDecimal(0.555).setScale(3, RoundingMode.HALF_UP);
		
		switch (temperaturas[i]) {
		case "Grados Celcius a Grados Fahrenheit":
			valorDeTemperatura = temperaturaPorCovertir.multiply(nueveQuintos).add(new BigDecimal(32));
		break;
		case "Grados Celcius a Grados kelvin": 
			valorDeTemperatura = temperaturaPorCovertir.add(new BigDecimal(273));
		break;
		case "Grados Fahrenheit a Grados Celcius": 
			valorDeTemperatura = temperaturaPorCovertir.subtract(new BigDecimal(32)).multiply(cincoNovenos);
		break;
		case "kelvin a Grados Celcius": 
			valorDeTemperatura = temperaturaPorCovertir.subtract(new BigDecimal(273));
		break;
		case "kelvin a Grados Fahrenheit": 
			valorDeTemperatura = (temperaturaPorCovertir.subtract(new BigDecimal(273))).multiply(nueveQuintos).add(new BigDecimal(32));
		break;
		default: valorDeTemperatura = new BigDecimal(0);
		
		}
		
		return valorDeTemperatura;
	}
	
	
	public void ObtenerTemperatura(String cantidadPorConvertir, BigDecimal valorDeTemperatura, int i) {	
		
		switch (i) {
		case 0: 
			JOptionPane.showMessageDialog(null, cantidadPorConvertir + " Grados Celcius son "+ 
					valorDeTemperatura + " Grados Fahrenheit");
		break;
		case 1:
			JOptionPane.showMessageDialog(null, cantidadPorConvertir + " Grados Celcius son "+ 
					valorDeTemperatura + " Grados Kelvin");
		break;
		case 2: JOptionPane.showMessageDialog(null, cantidadPorConvertir + " Grados Fahrenheit son "+ 
				valorDeTemperatura + " Grados Celcius");
		break;
		case 3:
			JOptionPane.showMessageDialog(null, cantidadPorConvertir + " Grados Kelvin son "+ 
					valorDeTemperatura +" Grados Celcius");
		break;
		case 4:
			JOptionPane.showMessageDialog(null, cantidadPorConvertir + " Grados Kelvin son "+ 
					valorDeTemperatura + " Grados Fahrenheit");
		break;
		
		default: JOptionPane.showMessageDialog(null, " Valor invalido");
		
		}
		
	
	}
	
	
}
