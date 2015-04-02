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
import modelo.BancoDados;

public class ControleBancoDados {
    
    private static HashMap<String,BancoDados>
            bancoClientes = new HashMap<String, BancoDados>();
    
    
    public static void carregarDados() throws IOException, ClassNotFoundException{
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("\\temp\\Banco_Dados.bin"))) {
            bancoClientes = (HashMap<String, BancoDados>)
                    ois.readObject();
        }
    }
    
    public static void armazenarDados() throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("\\temp\\Banco_Dados.bin"))) {
            oos.writeObject(bancoClientes);
            oos.flush();
        }
    }
    
    public void persistir(BancoDados cliente){
        bancoClientes.put(cliente.getCpf(), cliente);
    }
    
    public void remover(String cpf){
        bancoClientes.remove(cpf);
    }
    
    public BancoDados obter(String cpf){
        if(bancoClientes.containsKey(cpf))
            return bancoClientes.get(cpf);
        else 
            return null;
    }
    
    public ArrayList<BancoDados> obterTodos(){
        ArrayList<BancoDados> lista = new ArrayList<>();
        lista.addAll(bancoClientes.values());
        Collections.sort(lista,new Comparator<BancoDados>() {
            @Override
            public int compare(BancoDados t1, BancoDados t2) {
                return (t1.getNome()==null)?
                       (t2.getNome()==null)?0:-1:
                        t1.getNome().compareTo(t2.getNome());
            }
        });
        return lista;        
    }
// rotina em teste, pode ser retirada?
    public ArrayList<BancoDados> obterTodosP(){
        int contador = 0;
        ArrayList<BancoDados> lista = new ArrayList<>();
        for (int i = 0; i<bancoClientes.size();i++)
        {
            if ("P".equals(bancoClientes.get(i).getTipo())){
                lista.add(contador, (BancoDados) bancoClientes.values());
                contador++;
            }
        }
//        lista.addAll(bancoClientes.values());
        Collections.sort(lista,new Comparator<BancoDados>() {
            @Override
            public int compare(BancoDados t1, BancoDados t2) {
                return (t1.getNome()==null)?
                       (t2.getNome()==null)?0:-1:
                        t1.getNome().compareTo(t2.getNome());
            }
        });
        return lista;        
    }
    
}
