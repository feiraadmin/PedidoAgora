package pedidoagora.pedidoagora.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import pedidoagora.pedidoagora.Activity.PrincipalActivity;
import pedidoagora.pedidoagora.DAO.ConfiguracaoFirebase;
import pedidoagora.pedidoagora.Entidades.Produtos;
import pedidoagora.pedidoagora.Entidades.Usuarios;
import pedidoagora.pedidoagora.Helper.Base64Custom;
import pedidoagora.pedidoagora.Helper.PreferenciasAndroid;
import pedidoagora.pedidoagora.R;

public class CadastroProdutos extends AppCompatActivity {

    private Button btnGravar, btnVoltarTelaInicial;
    private EditText edtNome, edtValor;
    private Produtos produtos;
    private DatabaseReference firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produtos);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtValor = (EditText) findViewById(R.id.edtValor);
        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnVoltarTelaInicial = (Button) findViewById(R.id.btnVoltarTelaInicial);


        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                produtos = new Produtos();
                produtos.setNome(edtNome.getText().toString());
                produtos.setValor(Double.valueOf(edtValor.getText().toString()));


                salvarProduto(produtos);


            }
        });

        btnVoltarTelaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarTelaInicial();
            }
        });
    }


    private boolean salvarProduto(Produtos produtos) {
        try {
            firebase = ConfiguracaoFirebase.getFirebase().child("addprodutos");
            firebase.child(produtos.getNome()).setValue(produtos);
            Toast.makeText(CadastroProdutos.this, "Produto inserido com sucesso", Toast.LENGTH_LONG).show();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private void voltarTelaInicial() {
        Intent intent = new Intent(CadastroProdutos.this, PrincipalActivity.class);
        startActivity(intent);
        finish();
    }
}
