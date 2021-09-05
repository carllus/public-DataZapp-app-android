package csilva.analisedeti.quediaehoje;

public class ItemListView {
    private String data;
    private String descricao;
    private String imagem;
    private String nome;
    private String url;

    public ItemListView() {
    }

    public ItemListView(String nome2, String data2, String descricao2, String imagem2, String url2) {
        setNome(nome2);
        setData(data2);
        setDescricao(descricao2);
        setImagem(imagem2);
        setUrl(url2);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome2) {
        this.nome = nome2;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data2) {
        this.data = data2;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao2) {
        this.descricao = descricao2;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem2) {
        this.imagem = imagem2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }
}
