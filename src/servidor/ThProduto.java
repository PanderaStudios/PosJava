package servidor;

import comum.controle.ControleComunicacao;
import controle.ControleProduto;
import java.io.IOException;
import java.net.Socket;
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
                    System.out.println("ServidorProduto ThProduto - persistir");
                    c1.enviarTexto("ServidorProduto ThProduto - persistir");
                    cProduto.persistir((Produto) c1.receberObjeto());
                    ControleProduto.armazenar();
                }

                if ("R".equals(comando)) {
                    System.out.println("ServidorProduto ThProduto - remover");
                    c1.enviarTexto("ServidorProduto ThProduto - remover");
                    cProduto.remover(c1.receberTexto());
                    ControleProduto.armazenar();
                }

                if ("O".equals(comando)) {
                    System.out.println("ServidorProduto ThProduto - obter");
                    c1.enviarTexto("ServidorProduto ThProduto - obter");
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cProduto.obter(cpf));
                }

                if ("G".equals(comando)) {
                    ControleProduto.armazenar();
                }

                if ("C".equals(comando)) {
                    ControleProduto.carregar();
                }

                if ("T".equals(comando)) {
                    System.out.println("ServidorProduto ThProduto - obter todos");
                    c1.enviarTexto("ServidorProduto ThProduto - obter todos");
                    c1.enviarObjeto(cProduto.obterTodos());
                }

//                c1.enviarObjeto(cProduto.obterTodos());

            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
