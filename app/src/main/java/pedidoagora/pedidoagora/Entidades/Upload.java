package pedidoagora.pedidoagora.Entidades;

import com.google.firebase.database.Exclude;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mKey;
    private int mValor = 0;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String imageUrl, int valor) {
        if (name.trim().equals("")) {
            name = "No Name";
        }
        mValor = valor;
        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getValor() {
        return mValor;
    }

    public void setValor(int valor) {
        mValor = valor;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}
