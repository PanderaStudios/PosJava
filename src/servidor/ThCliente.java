package servidor;

import comum.controle.ControleComunicacao;
import controle.ControleCliente;
import controle.ControleProduto;
import java.io.IOException;
import java.net.Socket;
import modelo.Cliente;
import modelo.Produto;

public class ThCliente extends Thread {

    private Socket s;
    private Socket p;

    public ThCliente(Socket s) {
        this.s = s;
        this.p = s;
    }

    @Override
    public void run() {
        try {
            ControleComunicacao c1 = new ControleComunicacao(s);
//            ControleComunicacao p1 = new ControleComunicacao(p);

            ControleCliente cCliente = new ControleCliente();
            ControleProduto pProduto = new ControleProduto();

            while (true) {
                String comando = c1.receberTexto();
//                String comandoP = p1.receberTexto();

                if ("P".equals(comando)) {
                    System.out.println("Cheguei Aqui ThCliente 1.0");
                    cCliente.persistir((Cliente) c1.receberObjeto());
                    ControleCliente.armazenarDados();
                }

                if ("PP".equals(comando)) {
                    System.out.println("Cheguei Aqui ThCliente 2.0");
                    pProduto.persistirProduto((Produto) c1.receberObjeto());
                    ControleProduto.armazenarDadosProduto();
                }

                if ("R".equals(comando)) {
                    cCliente.remover(c1.receberTexto());
                    ControleCliente.armazenarDados();
                }

                if ("RR".equals(comando)) {
                    pProduto.removerProduto(c1.receberTexto());
                    ControleProduto.armazenarDadosProduto();
                }

                if ("O".equals(comando)) {
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cCliente.obter(cpf));
                }

                if ("OO".equals(comando)) {
                    String cpf = c1.receberTexto();
//                    String cod = cpf;
                    c1.enviarObjeto(pProduto.obterProduto(cpf));
                }

                if ("T".equals(comando)) {
                    c1.enviarObjeto(cCliente.obterTodos());
                }

                if ("TT".equals(comando)) {
                    c1.enviarObjeto(pProduto.obterTodosProduto());
                }

            }
        } catch (Exception ex) {
        }
    }

}
