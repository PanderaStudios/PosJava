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

    public ThCliente(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            ControleComunicacao c1 = new ControleComunicacao(s);

            ControleCliente cCliente = new ControleCliente();

            while (true) {
                String comando = c1.receberTexto();

                if ("P".equals(comando)) {
                    System.out.println("Cheguei Aqui ThCliente 1.0");
                    cCliente.persistir((Cliente) c1.receberObjeto());
                    ControleCliente.armazenar();
                }

                if ("R".equals(comando)) {
                    cCliente.remover(c1.receberTexto());
                    ControleCliente.armazenar();
                }

                if ("O".equals(comando)) {
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cCliente.obter(cpf));
                }

                if ("T".equals(comando)) {
                    c1.enviarObjeto(cCliente.obterTodos());
                }
                
                if ("G".equals(comando)) {
                    ControleCliente.armazenar();
                }
                
                if ("C".equals(comando)) {
                    ControleCliente.carregar();
                }

            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
