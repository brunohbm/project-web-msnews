package br.com.bruno.modelos;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Noticia {
    private int id;
    private String legenda;
    private String resumo;
    private String descricao;
    private String imagem;
    private Date data;
    private Assunto assunto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String[] getDescricaoFormat () {
        String[] text;
        text = descricao.split("\\r?\\n");
        return text;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public String getData() {
        SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");  
        return sdf.format(data);
    }

    public void setData(Date data) {        
        this.data = data;
    }

}
