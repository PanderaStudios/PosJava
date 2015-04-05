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
                    System.out.println("Cheguei Aqui ThProduto 1.0");
                    cProduto.persistir((Produto) c1.receberObjeto());
                    ControleProduto.armazenar();
                }

                if ("R".equals(comando)) {
                    cProduto.remover(c1.receberTexto());
                    ControleProduto.armazenar();
                }

                if ("O".equals(comando)) {
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cProduto.obter(cpf));
                }

                if ("T".equals(comando)) {
                    c1.enviarObjeto(cProduto.obterTodos());
                }

                if ("G".equals(comando)) {
                    ControleProduto.armazenar();
                }
                
                if ("C".equals(comando)) {
                    ControleProduto.carregar();
                }

            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
