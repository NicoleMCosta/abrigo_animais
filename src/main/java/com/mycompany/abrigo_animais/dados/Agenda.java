package com.mycompany.abrigo_animais.dados;

import java.util.Date;

public class Agenda {
    private String vetNome;
    private String animalNome;
    private String tratamento;
    private Date dataConsulta = new Date();
    private String horaConsulta;

    public Agenda(String vetNome, String animalNome, String tratamento, Date dataConsulta, String horaConsulta) {
        this.vetNome = vetNome;
        this.animalNome = animalNome;
        this.tratamento = tratamento;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
    }


    public String getVetNome() {
        return vetNome;
    }

    public void setVetNome(String vetNome) {
        this.vetNome = vetNome;
    }

    public String getAnimalNome() {
        return animalNome;
    }

    public void setAnimalNome(String animalNome) {
        this.animalNome = animalNome;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    @Override
    public String toString() {
        return "\nVeterinario: " + vetNome + '\n' +
                "Animal: " + animalNome + '\n' +
                "Tratamento:" + tratamento + '\n' +
                "Data Consulta:" + dataConsulta + '\n' +
                "Hora Consulta:" + horaConsulta + '\n';
    }
}
