package comum.controle;

import java.io.*;

public class ControleTeclado
   {
	private static final BufferedReader teclado = 
                new BufferedReader (
		new InputStreamReader(System.in));
        
	public static String obterTexto() throws IOException
	  {
	  	return teclado.readLine();
	  }
	public static int obterInteiro()
	     throws IOException
	  {
	  	return Integer.parseInt(teclado.readLine());
	  }     	
	public static double obterFracionario() throws IOException
	  {
	  	return Double.parseDouble(teclado.readLine());
	  }  
   }


