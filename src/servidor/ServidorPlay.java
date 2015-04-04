/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controle.ControleBancoDados;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author pande_000
 */
public class ServidorPlay extends Thread {

    /**
     * @param args the command line arguments
     */
    private ServerSocket s0;
//    private ArrayList<String> listaA;

    private DefaultListModel<String> clienteON;
    private DefaultListModel<String> clienteOFF;

    //   private JList listaA;
    private JTextField status;

    private JTextField txtNumClientes;

    private int numCliente;
    private String ipCliente;

    public ServidorPlay(DefaultListModel clienteON, DefaultListModel clienteOFF, JTextField status, JTextField txtNumClientes) {
        this.status = status;
        this.clienteON = clienteON;
        this.clienteOFF = clienteOFF;
        this.txtNumClientes = txtNumClientes;
        preActions();
    }

    public void pararServ() {
        //      this.thcliente.interrupt();
            clienteOFF.insertElementAt(numCliente + " - IP: " + s0.getInetAddress(), 0);
        try {
            s0.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorPlay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preActions() {

        numCliente = 0;
        ipCliente = "127.0.0.1";

        try {
            s0 = new ServerSocket(5050);
        } catch (IOException ex) {
            Logger.getLogger(JFPrinicipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        // TODO code application logic here
        System.out.println("Cheguei Aqui 2.1");

        try {
            ControleBancoDados.carregarDados();
            status.setText("ONLINE");
            txtNumClientes.setText("" + numCliente);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Ler o Arquivo .bin !!!",
                    "Servidor", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ServidorPlay.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {

            try {
                new ThCliente(s0.accept(), ipCliente).start();
            } catch (IOException ex) {
                Logger.getLogger(ServidorPlay.class.getName()).log(Level.SEVERE, null, ex);
            }

            numCliente++;

            txtNumClientes.setText("" + numCliente);

            clienteON.insertElementAt(numCliente + " - IP: " + s0.getInetAddress(), 0);

            System.out.println("ip>" + s0.getInetAddress());
        }
    }
}
