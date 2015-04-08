package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.Pedido;

public class ControlePedido {

    private static HashMap<String, Pedido> bancoPedidos = new HashMap<>();

    public ControlePedido() { //throws IOException, ClassNotFoundException{
        // ControleCliente.carregar();

    }
    /**
     * @Author Heraldo variavel dir criada apenas uma vez para ser reutilizada
     * em toda a classe
     *
     */
    private final static String PEDIDOS = "Pedidos";
    private final static String pasta = ":\\TrabalhoJava\\";
    private final static String arquivo = ".bin";
    private static String drive = "d";

    public static void carregar() throws IOException, ClassNotFoundException {
        //heraldo feito a validacao do arquivo
        File file = verificaArquivo(PEDIDOS);

        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String linha = buffer.readLine();

        if (linha != null) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(drive + pasta + PEDIDOS + arquivo))) {
                bancoPedidos = (HashMap<String, Pedido>) ois.readObject();
            }

        }
    }

    /**
     * @return 
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @
     * @param nomeArq
     * @Author Heraldo
     * @metodo criado para verificar se o arquivo existe caso nao exista ele
     * cria o arquivo
     *
     */
    public static File verificaArquivo(String nomeArq) throws IOException, ClassNotFoundException {

//        boolean retorno = false;
        File file = new File(drive + pasta + PEDIDOS + arquivo);
        if (!file.exists()) {
            drive = "";
            while (drive.isEmpty() || (!drive.equalsIgnoreCase("c") && !drive.equalsIgnoreCase("d"))) {
                 if ((drive = JOptionPane.showInputDialog(null, "Informe o Disco do arquivo Cliente (Ex. C ou D).",
                        "MSG Servidor", JOptionPane.INFORMATION_MESSAGE)) == null) {
                    drive = "d";
                }
           }

            file.renameTo(new File(drive + pasta + PEDIDOS + arquivo));

            if (!file.exists()) {
                file = new File(drive + pasta);
                file.mkdir();
                file = new File(drive + pasta + PEDIDOS + arquivo);
                file.createNewFile();
                JOptionPane.showMessageDialog(null, "Arquivo Cliente criado com sucesso em "
                        + drive + pasta + PEDIDOS + arquivo, "MSG do Servidor",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return file;
    }

    public static void armazenar() throws IOException, ClassNotFoundException {
        //heraldo feito a validacao do arquivo
        File file = verificaArquivo(PEDIDOS);

        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String linha = buffer.readLine();

        if (linha != null || !bancoPedidos.isEmpty()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(drive + pasta + PEDIDOS + arquivo))) {
                oos.writeObject(bancoPedidos);
                oos.flush();
            }
        }
    }

    public void persistir(Pedido pedido) {
        bancoPedidos.put(pedido.getCodPed(), pedido);
    }

    public void remover(String cod) {
        bancoPedidos.remove(cod);
    }

    public Pedido obter(String cod) {
        if (bancoPedidos.containsKey(cod)) {
            return bancoPedidos.get(cod);
        } else {
            return null;
        }
    }

    public ArrayList<Pedido> obterTodos() {
        ArrayList<Pedido> lista = new ArrayList<>();
        lista.addAll(bancoPedidos.values());
        Collections.sort(lista, (Pedido t1, Pedido t2)
                -> (t1.getCodCli()== null)
                        ? (t2.getCodCli() == null) ? 0 : -1
                        : t1.getCodCli().compareTo(t2.getCodCli()));
        return lista;
    }

}
