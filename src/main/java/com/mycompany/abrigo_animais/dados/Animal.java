package com.mycompany.abrigo_animais.dados;

public class Animal {
    private String nome;
    private String especie;
    private float peso;
    private int idade;
    private String porte;
    
    public Animal(String nome, String especie, float peso, int idade, String porte) {
        if (peso < 0) {
            throw new IllegalArgumentException("Peso invalido");
        }
        this.nome = nome;
        this.especie = especie;
        this.peso = peso;
        this.idade = idade;
        this.porte = porte;
    }

    //get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String especie) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nEspécie: " + especie +
                "\nPeso: " + peso +
                "\nIdade: " + idade +
                "\nPorte: " + porte;
    }

}
