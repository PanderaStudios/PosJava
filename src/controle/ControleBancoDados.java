package controle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import modelo.BancoDados;

public class ControleBancoDados {
    
    private static HashMap<String,BancoDados>
            bancoDados = new HashMap<>();
    
    
    public static void carregarDados() throws IOException, ClassNotFoundException{
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("\\temp\\Banco_Dados.bin"))) {
            bancoDados = (HashMap<String, BancoDados>)
                    ois.readObject();
        }
    }
    
    public static void armazenarDados() throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("\\temp\\Banco_Dados.bin"))) {
            oos.writeObject(bancoDados);
            oos.flush();
        }
    }
    
    public void persistir(BancoDados dados){
        bancoDados.put(dados.getCpf(), dados);
    }
    
    public void remover(String cpf){
        bancoDados.remove(cpf);
    }
    
    public BancoDados obter(String cpf){
        if(bancoDados.containsKey(cpf))
            return bancoDados.get(cpf);
        else 
            return null;
    }
    
    public ArrayList<BancoDados> obterTodos(){
        ArrayList<BancoDados> lista = new ArrayList<>();
        lista.addAll(bancoDados.values());
        Collections.sort(lista, (BancoDados t1, BancoDados t2) -> (t1.getNome()==null)?
                (t2.getNome()==null)?0:-1:
                t1.getNome().compareTo(t2.getNome()));
        return lista;        
    }
    
}
