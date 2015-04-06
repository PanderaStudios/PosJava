package servidor;

import comum.controle.ControleComunicacao;
import controle.ControleCliente;
import controle.ControleProduto;
import java.io.IOException;
import java.net.Socket;
import modelo.Cliente;
import modelo.Produto;

public class ThProduto extends Thread {

    private Socket p;

    public ThProduto(Socket p) {
        this.p = p;
    }

    @Override
    public void run() {
        try {
            ControleComunicacao c1 = new ControleComunicacao(p);

            ControleProduto cProduto = new ControleProduto();

            while (true) {
                String comando = c1.receberTexto();

                if ("P".equals(comando)) {
                    System.out.println("ServidorProduto ThCliente - persistir");
                    c1.enviarTexto("ServidorProduto ThCliente - persistir");
                    cProduto.persistir((Produto) c1.receberObjeto());
                    ControleProduto.armazenar();
                }

                if ("R".equals(comando)) {
                    System.out.println("ServidorProduto ThCliente - remover");
                    c1.enviarTexto("ServidorProduto ThCliente - remover");
                    cProduto.remover(c1.receberTexto());
                    ControleProduto.armazenar();
                }

                if ("O".equals(comando)) {
                    System.out.println("ServidorProduto ThCliente - obter");
                    c1.enviarTexto("ServidorProduto ThCliente - obter");
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cProduto.obter(cpf));
                }

                if ("T".equals(comando)) {
                    System.out.println("ServidorProduto ThCliente - obter todos");
                    c1.enviarTexto("ServidorProduto ThCliente - obter todos");
                    c1.enviarObjeto(cProduto.obterTodos());
                }

                if ("G".equals(comando)) {
                    ControleProduto.armazenar();
                }

                if ("C".equals(comando)) {
                    ControleProduto.carregar();
                }
                c1.enviarObjeto(cProduto.obterTodos());

            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
