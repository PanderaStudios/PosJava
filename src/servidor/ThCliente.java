package servidor;

import comum.controle.ControleComunicacao;
import controle.ControleBancoDados;
import java.io.IOException;
import java.net.Socket;
import modelo.BancoDados;

public class ThCliente extends Thread {

    private Socket s;
    String ipCliente;

    public ThCliente(Socket s, String ipCliente) {
        this.s = s;
        this.ipCliente = ipCliente;
    }

    @Override
    public void run() {
        try {
            ControleComunicacao c1 = new ControleComunicacao(s);

            ControleBancoDados dDados = new ControleBancoDados();

            while (true) {
                String comando = c1.receberTexto();

                if ("P".equals(comando)) {
                    dDados.persistir((BancoDados) c1.receberObjeto());
                    ControleBancoDados.armazenarDados();
                }

                if ("R".equals(comando)) {
                    dDados.remover(c1.receberTexto());
                    ControleBancoDados.armazenarDados();
                }

                if ("O".equals(comando)) {
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(dDados.obter(cpf));
                }

                if ("T".equals(comando)) {
                    c1.enviarObjeto(dDados.obterTodos());
                }

                if ("S".equals(comando)) {
                    ipCliente = c1.receberTexto();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
