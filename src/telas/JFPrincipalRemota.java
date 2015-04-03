package telas;

import comum.controle.ControleComunicacao;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import modelo.BancoDados;

public class JFPrincipalRemota extends JFPrincipal {

    ControleComunicacao c2;

    @Override
    protected void remover(String cpf) {
        try {
            c2.enviarTexto("R");
            c2.enviarTexto(cpf);
        } catch (IOException ex) {
        }
    }

    @Override
    protected void persistir(BancoDados c, String cpf, String tipo) {
        JDDados dados = new JDDados(this, true);
        dados.setDados(c, cpf, tipo);
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

  
    @Override
    protected BancoDados obter(String cpf) {
        try {
            c2.enviarTexto("O");
            c2.enviarTexto(cpf);
            return (BancoDados) c2.receberObjeto();
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }


    @Override
    protected ArrayList<BancoDados> obterTodos() {
        try {
            c2.enviarTexto("T");
            return (ArrayList<BancoDados>) c2.receberObjeto();
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    protected void preActions() {
        try {
            Socket s2 = new Socket("localhost", 5050);
            c2 = new ControleComunicacao(s2);
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
