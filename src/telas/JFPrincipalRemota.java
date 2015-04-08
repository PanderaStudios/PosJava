package telas;

import comum.controle.ControleComunicacao;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Produto;

public class JFPrincipalRemota extends JFPrincipal {

    private  static String  ipServidor;
    private final int NUMPORTAS = 3;

    public JFPrincipalRemota() {
      }

    ControleComunicacao c1c[];// = new ControleComunicacao[NUMPORTAS];
//    ControleComunicacao c2p;

    private void carregaTabelas() {
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.addAll(obterTodos());
        System.out.println("CLIENTE - Vetor Clientes vazio> " + lista.isEmpty());

        ArrayList<Produto> lista2 = new ArrayList<>();
        lista2.addAll(obterTodosProdutos());
        System.out.println("CLIENTE - Vetor Produtos vazio> " + lista2.isEmpty());
    }

    protected void remover(String cpf) {
        try {
            c1c[0].enviarTexto("R");
            System.out.println(c1c[0].receberTexto());
            System.out.println("Cliente - remover clientes");
            c1c[0].enviarTexto(cpf);
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void removerProduto(String cpf) {
        try {
            c1c[1].enviarTexto("R");
            System.out.println(c1c[0].receberTexto());
            System.out.println("Cliente - remover produtos");
            c1c[1].enviarTexto(cpf);
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void persistir(Cliente c, String cpf) {
        JDDadosCliente dadosC = new JDDadosCliente(this, true);
        dadosC.setDados(c, cpf);
        dadosC.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if (dadosC.sucesso) {
            try {
                c1c[0].enviarTexto("P");
                System.out.println(c1c[0].receberTexto());
                System.out.println("Cliente - persistir clientes");
                c1c[0].enviarObjeto(dadosC.getDados());
            } catch (NullPointerException | IOException | ClassNotFoundException ex) {
                Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    protected void persistirProduto(Produto p, String cpf) {
        JDDadosProduto dadosP = new JDDadosProduto(this, true);
        dadosP.setDados(p, cpf);
        dadosP.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if (dadosP.sucesso) {
            try {
                c1c[1].enviarTexto("P");
                System.out.println(c1c[1].receberTexto());
                System.out.println("Cliente - persistir produtos");
                c1c[1].enviarObjeto(dadosP.getDados());
            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    protected Cliente obter(String cpf) {
        try {
            c1c[0].enviarTexto("O");
            System.out.println(c1c[0].receberTexto());
            System.out.println("Cliente - obter cliente");
            c1c[0].enviarTexto(cpf);
            return (Cliente) c1c[0].receberObjeto();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    protected Produto obterProduto(String cpf) {
        try {
            c1c[1].enviarTexto("O");
            System.out.println(c1c[1].receberTexto());
            System.out.println("Cliente - obter produto");
            c1c[1].enviarTexto(cpf);
            return (Produto) c1c[1].receberObjeto();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    protected ArrayList<Cliente> obterTodos() {
        try {
            c1c[0].enviarTexto("T");
            System.out.println(c1c[0].receberTexto());
            System.out.println("Cliente - obter todos clientes");
            return (ArrayList<Cliente>) c1c[0].receberObjeto();
        } catch (NullPointerException | IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }
    }

    protected ArrayList<Produto> obterTodosProdutos() {
        try {
            c1c[1].enviarTexto("T");
            System.out.println(c1c[1].receberTexto());
            System.out.println("Cliente - obter todos produtos");
            return (ArrayList<Produto>) c1c[1].receberObjeto();
        } catch (NullPointerException | IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }

    }

    protected void armazenar() {
        try {
            c1c[0].enviarTexto("G");
            c1c[1].enviarTexto("G");
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void carregar() {
        try {
            c1c[0].enviarTexto("C");
            c1c[1].enviarTexto("C");
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void preActions() {
        try {
            System.out.println("Metodo local (Cliente) preActions");
            Socket s1c = new Socket(ipServidor, 5050);
            System.out.println("Conectado Porta 5050> " + s1c.isConnected());

            Socket s2p = new Socket(ipServidor, 6060);
            System.out.println("Conectado Porta 6060> " + s2p.isConnected());

            for(int i=0;i<NUMPORTAS;i++){
            c1c[i] = new ControleComunicacao(s1c);
            }
//            c2p = new ControleComunicacao(s2p);
        } catch (Exception ex) {
        }
    }

    public static void main(String args[]) {

        if (args.length == 0) 
            ipServidor = "localhost";
        else
            ipServidor = Arrays.toString(args);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFPrincipalRemota().setVisible(true);
        });
    }

}
