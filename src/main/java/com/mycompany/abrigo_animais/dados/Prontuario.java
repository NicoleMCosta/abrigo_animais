package com.mycompany.abrigo_animais.dados;


public class Prontuario {
    private int codigo;
    private String nomeMedico;
    private String tratamento;
    private String status; 

    public Prontuario(int codigo, String nomeMedico, String tratamento, String status) {
        this.codigo = codigo;
        this.nomeMedico = nomeMedico;
        this.tratamento = tratamento;
        this.status = status;
    }
    

    //get e set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                "\nNome do Médico: " + nomeMedico +
                "\nTratamento: " + tratamento +
                "\nStatus: " + status;
    }



}
