package controle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import modelo.Cliente;

public class ControleCliente {
    
    private static HashMap<String,Cliente>
            bancoClientes = new HashMap<String, Cliente>();
    
    
    public static void carregarDados() throws IOException, ClassNotFoundException{
        
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("c:\\temp\\clientes.bin"));
        bancoClientes = (HashMap<String, Cliente>)
                ois.readObject();
        ois.close();
    }
    
    public static void armazenarDados() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("c:\\temp\\clientes.bin"));
        oos.writeObject(bancoClientes);
        oos.flush();
        oos.close();
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
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        lista.addAll(bancoClientes.values());
        Collections.sort(lista,new Comparator<Cliente>() {
            public int compare(Cliente t1, Cliente t2) {
                return (t1.getNome()==null)?
                       (t2.getNome()==null)?0:-1:
                        t1.getNome().compareTo(t2.getNome());
            }
        });
        return lista;        
    }
    
}
