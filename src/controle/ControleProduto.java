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
import modelo.Produto;

public class ControleProduto {
    
    private static HashMap<String,Produto>
            bancoProdutos = new HashMap<String, Produto>();
    
    
    public static void carregarDadosProduto() throws IOException, ClassNotFoundException{
        
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("c:\\temp\\produtos.bin"));
        bancoProdutos = (HashMap<String, Produto>)
                ois.readObject();
        ois.close();
    }
    
    public static void armazenarDadosProduto() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("c:\\temp\\produtos.bin"));
        oos.writeObject(bancoProdutos);
        oos.flush();
        oos.close();
    }
    
    public void persistirProduto(Produto produto){
        bancoProdutos.put(produto.getCOD(), produto);
    }
    
    public void removerProduto(String cod){
        bancoProdutos.remove(cod);
    }
    
    public Produto obterProduto(String cod){
        if(bancoProdutos.containsKey(cod))
            return bancoProdutos.get(cod);
        else 
            return null;
    }
    
    public ArrayList<Produto> obterTodosProduto(){
        ArrayList<Produto> lista = new ArrayList<Produto>();
        lista.addAll(bancoProdutos.values());
        Collections.sort(lista,new Comparator<Produto>() {
            public int compare(Produto t1, Produto t2) {
                return (t1.getNome()==null)?
                       (t2.getNome()==null)?0:-1:
                        t1.getNome().compareTo(t2.getNome());
            }
        });
        return lista;        
    }
    
}
