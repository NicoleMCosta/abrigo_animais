package com.mycompany.abrigo_animais.dados;

public class Animal {
    private String nome;
    private String especie;
    private float peso;
    private int idade;
    private String porte;
    
    public Animal(String nome, String especie, float peso, int idade, String porte) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (especie == null || especie.trim().isEmpty()) {
            throw new IllegalArgumentException("Espécie inválida");
        }
        if (peso < 0) {
            throw new IllegalArgumentException("Peso inválido");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida");
        }
        if (porte == null || porte.trim().isEmpty()) {
            throw new IllegalArgumentException("Porte inválido");
        }
        this.nome = nome;
        this.especie = especie;
        this.peso = peso;
        this.idade = idade;
        this.porte = porte;
    }

    // Getters e Setters com validação
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        if (especie == null || especie.trim().isEmpty()) {
            throw new IllegalArgumentException("Espécie inválida");
        }
        this.especie = especie;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("Peso inválido");
        }
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida");
        }
        this.idade = idade;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        if (porte == null || porte.trim().isEmpty()) {
            throw new IllegalArgumentException("Porte inválido");
        }
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
