package com.mycompany.abrigo_animais.dados;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Atendente {
    private String nome;
    private String endereco;
    private int idade;
    private Date dataContratacao = new Date();

    public Atendente(String nome, String endereco, int idade, Date dataContratacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.dataContratacao = dataContratacao;

    }

    //get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nEndereço: " + endereco +
                "\nIdade: " + idade +
                "\nData de Contratação: " + new SimpleDateFormat("dd/MM/yyyy").format(dataContratacao);
    }
}