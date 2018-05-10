package pedidoagora.pedidoagora.Entidades;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

import pedidoagora.pedidoagora.DAO.ConfiguracaoFirebase;



public class Produtos {


    private String nome;
    private Double valor;
    //private Data image;


    public Produtos() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
