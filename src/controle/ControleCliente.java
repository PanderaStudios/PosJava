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
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class ControleCliente {
    
    private static HashMap<String,Cliente>
            bancoClientes = new HashMap<String, Cliente>();

    public ControleCliente() { //throws IOException, ClassNotFoundException{
       // ControleCliente.carregar();
    
    }
    /** 
    * @Author Heraldo
    * variavel dir criada apenas uma vez para ser reutilizada em toda a classe
    **/
    private final static String CLIENTES = "Clientes";
    private final static String pasta = ":\\TrabalhoJava\\";
    private final static String arquivo = ".bin";    
    private static String dir ="";
           
    
    public static void carregar() throws IOException, ClassNotFoundException{
       //heraldo feito a validacao do arquivo
        File  file = verificaArquivo(CLIENTES);
           
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        
        String linha = buffer.readLine();
        
        if(linha != null){
          ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dir +pasta + CLIENTES  + arquivo));
          bancoClientes = (HashMap<String, Cliente>) ois.readObject();
          ois.close();
          
         }
    }

    /**
    * @Author Heraldo
    * @metodo criado para verificar se o arquivo existe caso nao exista ele cria o arquivo
    **/
    public static File verificaArquivo( String nomeArq) throws IOException, ClassNotFoundException{
      
        boolean retorno = false;
       
        while (dir.isEmpty()){
            dir = JOptionPane.showInputDialog(null, "Informe o Disco do Arquivo Cliente (Ex. C ou D).",
                    "MSG do Servidor", JOptionPane.INFORMATION_MESSAGE);
        }
        
        File file = new File(dir + pasta + CLIENTES + arquivo);
        
        if (!file.exists()){
          file = new File(dir + pasta);  
          file.mkdir();
          file = new File(dir + pasta +CLIENTES + arquivo);
          file.createNewFile();
          JOptionPane.showConfirmDialog(null,"Arquivo Cliente criado com sucesso em " + 
                  dir + pasta + CLIENTES + arquivo,"MSG do Servidor",
                  JOptionPane.INFORMATION_MESSAGE);        
        }
       
        return file;
    }

    public static void armazenar() throws IOException, ClassNotFoundException{
     //heraldo feito a validacao do arquivo
        File  file = verificaArquivo(CLIENTES);
        
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        
        String linha = buffer.readLine();
        
        if(linha != null || !bancoClientes.isEmpty()){
                ObjectOutputStream oos = new ObjectOutputStream(
                                new FileOutputStream(dir + pasta +CLIENTES+ arquivo));
                oos.writeObject(bancoClientes);
                oos.flush();
                oos.close();
        }
    }
    
    
    public void persistir(Cliente cliente){
        bancoClientes.put(cliente.getCpf(), cliente);
    }
    
    public void remover(String cpf){
        bancoClientes.remove(cpf);
    }
    
    public Cliente obter(String cpf){
        if(bancoClientes.containsKey(cpf))
            return bancoClientes.get(cpf);
        else 
            return null;
    }
    
    public ArrayList<Cliente> obterTodos(){
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.addAll(bancoClientes.values());
        Collections.sort(lista, (Cliente t1, Cliente t2) -> 
                (t1.getNome()==null)?
                (t2.getNome()==null)?0:-1:
                t1.getNome().compareTo(t2.getNome()));
        return lista;        
    }
    
}