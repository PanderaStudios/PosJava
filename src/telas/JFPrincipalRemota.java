package telas;

import comum.controle.ControleComunicacao;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Produto;

public class JFPrincipalRemota extends JFPrincipal {

    ControleComunicacao c1c;
    ControleComunicacao c2p;

    @Override
    protected void remover(String cpf) {
        try {
            c1c.enviarTexto("R");
            System.out.println(c1c.receberTexto());
            System.out.println("Metodo local (Cliente) - remover clientes");
            c1c.enviarTexto(cpf);
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void removerProduto(String cpf) {
        try {
            c2p.enviarTexto("R");
            c2p.enviarTexto(cpf);
            System.out.println(c1c.receberTexto());
            System.out.println("Metodo local (Cliente) - remover produtos");
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void persistir(Cliente c, String cpf) {
        JDDadosCliente dadosC = new JDDadosCliente(this, true);
        dadosC.setDados(c, cpf);
        dadosC.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if (dadosC.sucesso) {
            try {
                c1c.enviarTexto("P");
                System.out.println(c1c.receberTexto());
                System.out.println("Metodo local (Cliente) - persistir clientes");
                c1c.enviarObjeto(dadosC.getDados());
            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
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
                c2p.enviarTexto("P");
                System.out.println(c2p.receberTexto());
                System.out.println("Metodo local (Cliente) - persistir produtos");
                c2p.enviarObjeto(dadosP.getDados());
            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected Cliente obter(String cpf) {
        try {
            c1c.enviarTexto("O");
            System.out.println(c1c.receberTexto());
            System.out.println("Metodo local (Cliente) - obter cliente");
            c1c.enviarTexto(cpf);
            return (Cliente) c1c.receberObjeto();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    @Override
    protected Produto obterProduto(String cpf) {
        try {
            c2p.enviarTexto("O");
            System.out.println(c2p.receberTexto());
            System.out.println("Metodo local (Cliente) - obter produto");
            c2p.enviarTexto(cpf);
            return (Produto) c2p.receberObjeto();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    @Override
    protected ArrayList<Cliente> obterTodos() {
        try {
            c1c.enviarTexto("T");
            System.out.println(c1c.receberTexto());
            System.out.println("Metodo local (Cliente) - obter todos clientes");
            return (ArrayList<Cliente>) c1c.receberObjeto();
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }
    }

    /**
     *
     * @return
     */
    protected ArrayList<Produto> obterTodosProduto() {
        try {
            c2p.enviarTexto("T");
            System.out.println(c2p.receberTexto());
            System.out.println("Metodo local (Cliente) obter todos produtos");
            return (ArrayList<Produto>) c2p.receberObjeto();
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }

    }

    protected void armazenar() {
        try {
            c1c.enviarTexto("G");
            c2p.enviarTexto("G");
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void carregar() {
        try {
            c1c.enviarTexto("C");
            c2p.enviarTexto("C");
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipalRemota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void preActions() {
        try {
            Socket s1c = new Socket("localhost", 5050);
            Socket s2p = new Socket("localhost", 6060);
            c1c = new ControleComunicacao(s1c);
            c2p = new ControleComunicacao(s2p);
        } catch (Exception ex) {
        }
    }

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFPrincipalRemota().setVisible(true);
        });
    }

}
