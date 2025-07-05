package com.mycompany.abrigo_animais.dados;

import java.util.Date;

public class Veterinario {
    
    private String nome;
    private String endereco;
    private int idade;
    private String especialidade;
    private Date dataContratacao;
    
    public Veterinario(String nome, String endereco, int idade, String especialidade, Date dataContratacao) {
        setNome(nome);
        setEndereco(endereco);
        setIdade(idade);
        setEspecialidade(especialidade);
        setDataContratacao(dataContratacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio");
        }
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade deve ser maior que zero");
        }
        this.idade = idade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        if (dataContratacao == null) {
            throw new IllegalArgumentException("Data de contratação não pode ser nula");
        }
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
