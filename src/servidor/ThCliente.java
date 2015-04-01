package servidor;

import comum.controle.ControleComunicacao;
import controle.ControleBancoDados;
import java.net.Socket;
import modelo.BancoDados;

public class ThCliente extends Thread {

    private Socket s;

    public ThCliente(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            ControleComunicacao c1 = new ControleComunicacao(s);

            ControleBancoDados cCliente = new ControleBancoDados();

            while (true) {
                String comando = c1.receberTexto();

                if ("P".equals(comando)) {
                    cCliente.persistir((BancoDados) c1.receberObjeto());
                    ControleBancoDados.armazenarDados();
                }

                if ("R".equals(comando)) {
                    cCliente.remover(c1.receberTexto());
                    ControleBancoDados.armazenarDados();
                }

                if ("O".equals(comando)) {
                    String cpf = c1.receberTexto();
                    c1.enviarObjeto(cCliente.obter(cpf));
                }

                if ("T".equals(comando)) {
                    c1.enviarObjeto(cCliente.obterTodos());
                }
            }
        } catch (Exception ex) {
        }
    }

}
