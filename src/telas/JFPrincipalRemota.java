package telas;

import comum.controle.ControleComunicacao;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Produto;

public class JFPrincipalRemota extends JFPrincipal {

    ControleComunicacao c2;

    protected void remover(String cpf) {
        try {
            c2.enviarTexto("R");
            c2.enviarTexto(cpf);
        } catch (IOException ex) {
        }
    }

    protected void removerProduto(String cpf) {
        try {
            c2.enviarTexto("RR");
            c2.enviarTexto(cpf);
        } catch (IOException ex) {
        }
    }

    @Override
    protected void persistir(Cliente c, String cpf) {
        JDDadosCliente dados = new JDDadosCliente(this, true);
        dados.setDados(c,cpf);
        dados.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if (dados.sucesso) {
            try {
                c2.enviarTexto("P");
                c2.enviarObjeto(dados.getDados());
            } catch (IOException ex) {
            }
        }
    }

    protected void persistirProduto(Produto p, String cpf) {
        JDDadosProduto dados = new JDDadosProduto(this, true);
        dados.setDados(p, cpf);
        dados.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if (dados.sucesso) {
            try {
                c2.enviarTexto("PP");
                c2.enviarObjeto(dados.getDados());
            } catch (IOException ex) {
            }
        }
    }

    protected Cliente obter(String cpf) {
        try {
            c2.enviarTexto("O");
            c2.enviarTexto(cpf);
            return (Cliente) c2.receberObjeto();
        } catch (Exception ex) {
            return null;
        }
    }

    protected Produto obterProduto(String cpf) {
        try {
            c2.enviarTexto("OO");
            c2.enviarTexto(cpf);
            return (Produto) c2.receberObjeto();
        } catch (Exception ex) {
            return null;
        }
    }

    protected ArrayList<Cliente> obterTodos() {
        try {
            c2.enviarTexto("T");
            return (ArrayList<Cliente>) c2.receberObjeto();
        } catch (Exception ex) {
            return new ArrayList<Cliente>();
        }
    }

    /**
     *
     * @return
     */
    protected ArrayList<Produto> obterTodosProduto() {
        try {
            c2.enviarTexto("TT");
            return (ArrayList<Produto>) c2.receberObjeto();
        } catch (Exception ex) {
            return new ArrayList<Produto>();
        }
    }

    protected void preActions() {
        try {
            Socket s2 = new Socket("127.0.0.1", 5050);
            c2 = new ControleComunicacao(s2);
        } catch (Exception ex) {
        }
    }

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipalRemota().setVisible(true);
            }
        });
    }

}
