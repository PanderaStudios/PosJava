/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import com.sun.webkit.ThemeClient;
import controle.ControleBancoDados;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author pande_000
 */
public class ServidorPlay extends Thread {

    /**
     * @param args the command line arguments
     */
    private ServerSocket s0;
//    private DefaultListModel<String> listaA;

    private int [] numClientes;
    private int contador;
    private String [] ipCliente;

    public ServidorPlay() {
//        this.s0 = s0;

    }

    public void pararServ() {
        try {
            s0.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorPlay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void preActions() {
        setNumClientes(new int[10]);
        setIpCliente(new String[10]);
        contador = 0;
//        listaA = new DefaultListModel<>();
        try {
            s0 = new ServerSocket(5050);
        } catch (IOException ex) {
            Logger.getLogger(JFPrinicipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        // TODO code application logic here

//        if (listaA == null) {
            preActions();
//        }

        try {
            System.out.println("Cheguei Aqui 2.1");

            try {
                // TENTA LER O ARQUIVO BANCO_DADOS.BIN !!! AQUI PRECISA DE ROTINA DE TRATAMENTO DE ARQUIVO
                ControleBancoDados.carregarDados();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível Ler o Arquivo .bin !!!",
                        "Servidor", JOptionPane.INFORMATION_MESSAGE);
                Logger.getLogger(JFPrinicipalServidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Servidor Correndo",
                    "Servidor", JOptionPane.INFORMATION_MESSAGE);

            while (true) {

//                ServerSocket s2 = s0;

                new ThCliente(s0.accept()).start();

                numClientes[contador] = contador;
                ipCliente[contador] = ""+s0.getInetAddress();
                
 //               listaA.insertElementAt("" + getIpCliente()[contador], 0);
 //               listaA.insertElementAt("" + s0.getLocalPort(), 1);

//                JOptionPane.showMessageDialog(null,
//                        "Cliente:" + s0.getInetAddress() + "Esta Conectado a Porta: " + s0.getLocalPort(),
//                        "Cliente Conectado", JOptionPane.INFORMATION_MESSAGE);

// fazer esse repaint sem precisar da optioPane acima
//                JOptionPane.getDesktopPaneForComponent(this).repaint();
                System.out.println("ip>" + s0.getInetAddress());

                contador++;

            }
        } catch (IOException ex) {
            Logger.getLogger(JFPrinicipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the numClientes
     */
    public int[] getNumClientes() {
        return numClientes;
    }

    /**
     * @param numClientes the numClientes to set
     */
    public void setNumClientes(int[] numClientes) {
        this.numClientes = numClientes;
    }

    /**
     * @return the ipCliente
     */
    public String[] getIpCliente() {
        return ipCliente;
    }

    /**
     * @param ipCliente the ipCliente to set
     */
    public void setIpCliente(String[] ipCliente) {
        this.ipCliente = ipCliente;
    }

}
