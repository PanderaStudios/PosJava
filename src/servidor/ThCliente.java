package servidor;

import comum.controle.ControleComunicacao;
import controle.ControleCliente;
import java.io.IOException;
import java.net.Socket;
import modelo.Cliente;

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
                    System.out.println("Servidor ThCliente - persistir");
                    c1.enviarTexto("Servidor ThCliente - persistir");
                    cCliente.persistir((Cliente) c1.receberObjeto());
                    ControleCliente.armazenar();
                }

                if ("R".equals(comando)) {
                    System.out.println("Servidor ThCliente - remover");
                    c1.enviarTexto("Servidor ThCliente - remover");
                    cCliente.remover(c1.receberTexto());
                    ControleCliente.armazenar();
                }

                if ("O".equals(comando)) {
                    System.out.println("Servidor ThCliente - obter");
                    c1.enviarTexto("Servidor ThCliente - obter");
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cCliente.obter(cpf));
                }

                if ("T".equals(comando)) {
                    System.out.println("Servidor ThCliente - obter todos");
                    c1.enviarTexto("Servidor ThCliente - obter todos");
                    c1.enviarObjeto(cCliente.obterTodos());
                }

                if ("G".equals(comando)) {
                    ControleCliente.armazenar();
                }

                if ("C".equals(comando)) {
                    ControleCliente.carregar();
                }

//                c1.enviarObjeto(cCliente.obterTodos());

            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
