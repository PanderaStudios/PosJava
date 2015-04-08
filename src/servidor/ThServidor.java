/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controle.ControleCliente;
import controle.ControleProduto;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author pande_000
 */
public class ThServidor extends Thread {

    /**
     * @param args the command line arguments
     */
    private ServerSocket s0;
    private ServerSocket s1;
    private Socket s2;
    private Socket s3;

    private DefaultListModel<String> clienteON;
    private DefaultListModel<String> clienteOFF;

    // Controle de textos na janela
    private JTextField status;
    private JTextField txtNumClientes;

    private int numCliente;
    private String ipCliente;

    public ThServidor(DefaultListModel clienteON, DefaultListModel clienteOFF, JTextField status, JTextField txtNumClientes) {
        this.status = status;
        this.clienteON = clienteON;
        this.clienteOFF = clienteOFF;
        this.txtNumClientes = txtNumClientes;
        preActions();
    }

    public void pararServ() {
        //      this.thcliente.interrupt();
        try {
            clienteOFF.insertElementAt(numCliente + " - IP: " + s2.getInetAddress(), 0);

        } catch (Exception ex) {

        }
        try {
            s0.close();
            s1.close();
        } catch (IOException ex) {
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preActions() {

        numCliente = 0;
        ipCliente = "255.255.255.1";

        try {
            s0 = new ServerSocket(5050);
            s1 = new ServerSocket(6060);
        } catch (IOException ex) {
            Logger.getLogger(JFPrinicipalServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        // TODO code application logic here
        System.out.println("Classe Servidor Play - run()");
        status.setText("ONLINE");
        txtNumClientes.setText("" + numCliente);

        try {
            ControleCliente.carregar();
            status.setText("ONLINE");
            txtNumClientes.setText("" + numCliente);

        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Ler o Arquivo Cliente !!!",
                    "Servidor", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ControleProduto.carregar();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível Ler o Arquivo Produto !!!",
                    "Servidor", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {

            try {
                s2 = s0.accept();
                s3 = s1.accept();
                new ThCliente(s2).start();
                new ThProduto(s3).start();

                System.out.println("Cliente Conectado Porta 5050> " + s2.isConnected());
                System.out.println("Cliente Conectado Porta 6060> " + s3.isConnected());

            } catch (IOException ex) {
                Logger.getLogger(ThServidor.class.getName()).log(Level.SEVERE, null, ex);
            }

            numCliente++;
            txtNumClientes.setText("" + numCliente);
            clienteON.insertElementAt(numCliente + " - IP: " + s2.getInetAddress(), 0);

            System.out.println("ip>" + s2.getInetAddress());
        }
    }
}
