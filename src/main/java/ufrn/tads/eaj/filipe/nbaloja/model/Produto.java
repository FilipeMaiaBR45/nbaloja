package ufrn.tads.eaj.filipe.nbaloja.model;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String timeJogador;
    private float preco;
    private String tamanho;
    private String indicadoPara;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTimeJogador() {
        return timeJogador;
    }

    public void setTimeJogador(String timeJogador) {
        this.timeJogador = timeJogador;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getIndicadoPara() {
        return indicadoPara;
    }

    public void setIndicadoPara(String indicadoPara) {
        this.indicadoPara = indicadoPara;
    }
}
