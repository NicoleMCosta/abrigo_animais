package com.mycompany.abrigo_animais.dados;

public class Adotantes {
    private String nome;
    private String endereco;
    private int idade;

    public Adotantes(String nome, String endereco, int idade) {
        setNome(nome);         // valida no setter
        setEndereco(endereco); // valida no setter
        setIdade(idade);       // valida no setter
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        }
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa");
        }
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nEndereço: " + endereco +
                "\nIdade: " + idade;
    }
}
