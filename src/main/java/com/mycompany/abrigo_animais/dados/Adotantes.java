package com.mycompany.abrigo_animais.dados;

public class Adotantes {
    private String nome;
    private String endereco;
    private int idade;

    public Adotantes( String nome, String endereco, int idade) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
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

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nEndereço: " + endereco +
                "\nIdade: " + idade;
    }

}
