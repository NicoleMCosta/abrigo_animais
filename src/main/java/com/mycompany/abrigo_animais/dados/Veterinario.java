package com.mycompany.abrigo_animais.dados;

import java.util.Date;

public class Veterinario {
    
    private String nome;
    private String endereco;
    private int idade;
    private String especialidade;
    private Date dataContratacao = new Date();
    
    public Veterinario(String nome, String endereco, int idade, String especialidade, Date dataContratacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.especialidade = especialidade;
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
    public void setIdade(int idade) { this.idade = idade; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

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
                "\nEspecialidade: " + especialidade +
                "\nData de Contratação: " + new java.text.SimpleDateFormat("dd/MM/yyyy").format(dataContratacao);
    }

}
