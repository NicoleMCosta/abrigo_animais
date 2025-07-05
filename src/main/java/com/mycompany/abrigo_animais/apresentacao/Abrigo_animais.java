package com.mycompany.abrigo_animais.apresentacao;

import com.mycompany.abrigo_animais.dados.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;


public class Abrigo_animais {
    private static ArrayList<Animal> animais = new ArrayList<>();
    private static ArrayList<Veterinario> vets = new ArrayList<>();
    private static ArrayList<Atendente> atendentes = new ArrayList<>();
    private static ArrayList<Prontuario> prontuarios = new ArrayList<>();
    private static ArrayList<Adotantes> adotantes = new ArrayList<>();
    private static ArrayList<Agenda> agenda = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static int menu_dados() {
        out.println("Opcoes:");
        out.println("1- Cadastrar");
        out.println("2- Alterar");
        out.println("3- Listar");
        out.println("\nEscolha uma opcao:");
        int choice_dados = input.nextInt();
        input.nextLine();

        return choice_dados;
    }

    public static Animal CriarAnimal() {
    System.out.println("Informe o nome do animal: ");
    String nome = input.nextLine();

    System.out.print("Informe a especie: ");
    String especie = input.nextLine();

    float peso = -1;
    while (peso <= 0) {
        System.out.print("Informe o peso: ");
        if (input.hasNextFloat()) {
            peso = input.nextFloat();
            if (peso <= 0) {
                System.out.println("Peso invalido. Tente novamente.");
            }
        } else {
            System.out.println("Entrada invalida. Digite um numero.");
            input.nextLine(); // limpar entrada
        }
    }
    input.nextLine();

    int idade = -1;
    while (idade < 0 || idade > 100) {
        System.out.print("Informe a idade: ");
        if (input.hasNextInt()) {
            idade = input.nextInt();
            if (idade < 0 || idade > 100) {
                System.out.println("Idade invalida. Tente novamente.");
            }
        } else {
            System.out.println("Entrada invalida. Digite um numero inteiro.");
            input.next(); // limpar entrada
        }
    }

    input.nextLine(); // limpar quebra de linha

    System.out.print("Informe o porte: ");
    String porte = input.nextLine();

    return new Animal(nome, especie, peso, idade, porte);
}

    public static void listarAnimais(ArrayList<Animal> animais) {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }

        System.out.println("\n--- ANIMAIS ---");
        int i = 0;
        for (Animal a : animais) {
            System.out.println("Animal " + i++);
            System.out.println(a);
        }
    }

    public static void AlterarCadastroAnimal(ArrayList<Animal> animais) {
    if (animais.isEmpty()) {
        System.out.println("Nenhum animal para alterar.");
        return;
    }

    listarAnimais(animais);

    System.out.print("Digite o indice do animal que deseja alterar: ");
    int index = input.nextInt();
    input.nextLine();

    if (index < 0 || index >= animais.size()) {
        System.out.println("Indice invalido.");
        return;
    }

    Animal a = animais.get(index);

    // Mostrar dados atuais
    System.out.println("\nDados atuais:");
    System.out.println(a);


    System.out.print("Novo nome: ");
    String nome = input.nextLine();
    if (!nome.isBlank()) {
        a.setNome(nome);
    }

    System.out.print("Nova especie: ");
    String especie = input.nextLine();
    if (!especie.isBlank()) {
        a.setEspecie(especie);
    }

    float peso = -1;
    while (peso <= 0) {
        System.out.print("Novo peso: ");
        if (input.hasNextFloat()) {
            peso = input.nextFloat();
            if (peso <= 0) {
                System.out.println("Peso invalido. Tente novamente.");
            } else {
                a.setPeso(peso);
            }
        } else {
            System.out.println("Entrada invalida. Digite um numero.");
            input.next(); // limpar entrada
        }
    }

    int idade = -1;
    while (idade < 0 || idade > 100) {
        System.out.print("Nova idade: ");
        if (input.hasNextInt()) {
            idade = input.nextInt();
            if (idade < 0 || idade > 100) {
                System.out.println("Idade invalida. Tente novamente.");
            } else {
                a.setIdade(idade);
            }
        } else {
            System.out.println("Entrada invalida. Digite um numero inteiro.");
            input.next(); // limpar entrada
        }
    }
    input.nextLine(); // limpar quebra de linha

    System.out.print("Novo porte: ");
    String porte = input.nextLine();
    if (!porte.isBlank()) {
        a.setPorte(porte);
    }

    System.out.println("Cadastro alterado com sucesso!");
}


    ///metodo atendente
    public static Atendente CriarCadastroAtendente() {
    Scanner input = new Scanner(System.in);

    System.out.print("Nome: ");
    String nome = input.nextLine();

    System.out.print("Endereço: ");
    String endereco = input.nextLine();

    int idade = -1;
    while (idade < 0 || idade > 120) {
        System.out.print("Idade: ");
        if (input.hasNextInt()) {
            idade = input.nextInt();
            if (idade < 0 || idade > 120) {
                System.out.println("Idade invalida. Tente novamente.");
            }
        } else {
            System.out.println("Entrada invalida. Digite um numero valido.");
            input.next(); // Limpa entrada inválida
        }
    }
    input.nextLine(); // Limpa o buffer do teclado

    Date dataContratacao = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false); // impede datas inválidas como 32/13/2023

    while (dataContratacao == null) {
        System.out.print("Data de contratacao (formato dd/MM/yyyy): ");
        String dataTexto = input.nextLine();
        try {
            Date dataTemp = sdf.parse(dataTexto);
            Date hoje = new Date();
            if (dataTemp.after(hoje)) {
                System.out.println("Data nao pode ser no futuro. Tente novamente.");
            } else {
                dataContratacao = dataTemp;
            }
        } catch (ParseException e) {
            System.out.println("Formato de data invalido. Tente novamente.");
        }
    }

    return new Atendente(nome, endereco, idade, dataContratacao);
}

    public static void listarAtendentes(ArrayList<Atendente> atendentes) {
        if (atendentes.isEmpty()) {
            System.out.println("Nenhum atendente cadastrado.");
            return;
        }

        System.out.println("--- ATENDENTES ---");
        int i = 0;
        for (Atendente a : atendentes) {
            System.out.println("Atendente " + i++);
            System.out.println(a);
        }
    }

    public static void AlterarCadastroAtendente(ArrayList<Atendente> atendentes) {
    if (atendentes.isEmpty()) {
        System.out.println("Nenhum atendente cadastrado.");
        return;
    }

    listarAtendentes(atendentes);

    System.out.print("Indice do atendente que deseja alterar: ");
    int index = input.nextInt();
    input.nextLine();

    if (index < 0 || index >= atendentes.size()) {
        System.out.println("Indice invalido.");
        return;
    }

    Atendente a = atendentes.get(index);

    // Mostrar dados atuais
    System.out.println("\nDados atuais:");
    System.out.println(a);

    System.out.print("Novo nome: ");
    String nome = input.nextLine();
    if (!nome.isBlank()) {
        a.setNome(nome);
    }

    System.out.print("Novo endereco: ");
    String endereco = input.nextLine();
    if (!endereco.isBlank()) {
        a.setEndereco(endereco);
    }

    System.out.print("Nova idade: ");
    int idade = -1;
    if (input.hasNextInt()) {
        idade = input.nextInt();
        if (idade >= 0 && idade <= 120) {
            a.setIdade(idade);
        } else {
            System.out.println("Idade invalida. A idade nao foi alterada.");
        }
    } else {
        System.out.println("Entrada invalida. A idade nao foi alterada.");
        input.next(); // limpar entrada invalida
    }
    input.nextLine(); // limpar quebra de linha

    System.out.print("Nova data de contratacao (dd/MM/yyyy): ");
    String dataTexto = input.nextLine();
    if (!dataTexto.isBlank()) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date data = sdf.parse(dataTexto);
            if (data.after(new Date())) {
                System.out.println("Data nao pode ser no futuro. A data nao foi alterada.");
            } else {
                a.setDataContratacao(data);
            }
        } catch (ParseException e) {
            System.out.println("Data invalida. A data nao foi alterada.");
        }
    }

    System.out.println("Cadastro alterado com sucesso!");
}



    //métodos PRONTUÁRIO
    public static Prontuario CriarProntuario() {
    int codigo = -1;
    while (codigo <= 0) {
        System.out.print("Codigo: ");
        if (input.hasNextInt()) {
            codigo = input.nextInt();
            if (codigo <= 0) {
                System.out.println("Codigo invalido. Tente novamente.");
            }
        } else {
            System.out.println("Entrada invalida. Digite um numero inteiro.");
            input.next(); // limpar entrada invalida
        }
    }
    input.nextLine(); // limpar quebra de linha

    String nomeMedico = "";
    while (nomeMedico.isBlank()) {
        System.out.print("Nome do medico: ");
        nomeMedico = input.nextLine();
        if (nomeMedico.isBlank()) {
            System.out.println("Nome nao pode estar em branco.");
        }
    }

    String tratamento = "";
    while (tratamento.isBlank()) {
        System.out.print("Tratamento: ");
        tratamento = input.nextLine();
        if (tratamento.isBlank()) {
            System.out.println("Tratamento nao pode estar em branco.");
        }
    }

    String status = "";
    while (status.isBlank()) {
        System.out.print("Status do tratamento: ");
        status = input.nextLine();
        if (status.isBlank()) {
            System.out.println("Status nao pode estar em branco.");
        }
    }

    return new Prontuario(codigo, nomeMedico, tratamento, status);
}

    public static void listaProntuarios(ArrayList<Prontuario> prontuarios) {
        if (prontuarios.isEmpty()) {
            System.out.println("Nao ha prontuários cadastrados.");
            return;
        }

        System.out.println("--- PRONTUARIOS ---");
        int i = 0;
        for (Prontuario p : prontuarios) {
            System.out.println("Prontuario " + i++);
            System.out.println(p);
        }
    }

    public static void AlterarProntuario(ArrayList<Prontuario> prontuarios) {
    if (prontuarios.isEmpty()) {
        System.out.println("Nao ha prontuarios cadastrados.");
        return;
    }

    listaProntuarios(prontuarios);

    System.out.print("Indice do prontuario que deseja alterar: ");
    int index = input.nextInt();
    input.nextLine();

    if (index < 0 || index >= prontuarios.size()) {
        System.out.println("Indice invalido.");
        return;
    }

    Prontuario p = prontuarios.get(index);

    // Mostrar dados atuais
    System.out.println("\nDados atuais:");
    System.out.println(p);

    // Atualizacoes
    System.out.print("Novo codigo (ou -1 para manter " + p.getCodigo() + "): ");
    int codigo = -1;
    if (input.hasNextInt()) {
        codigo = input.nextInt();
        if (codigo > 0) {
            p.setCodigo(codigo);
        } else if (codigo != -1) {
            System.out.println("Codigo invalido. O valor nao foi alterado.");
        }
    } else {
        System.out.println("Entrada invalida. Codigo nao alterado.");
        input.next(); // limpar entrada invalida
    }
    input.nextLine(); // limpar quebra de linha

    System.out.print("Novo nome do medico (ou Enter para manter): ");
    String nomeMedico = input.nextLine();
    if (!nomeMedico.isBlank()) {
        p.setNomeMedico(nomeMedico);
    }

    System.out.print("Novo tratamento (ou Enter para manter): ");
    String tratamento = input.nextLine();
    if (!tratamento.isBlank()) {
        p.setTratamento(tratamento);
    }

    System.out.print("Novo status (ou Enter para manter): ");
    String status = input.nextLine();
    if (!status.isBlank()) {
        p.setStatus(status);
    }

    System.out.println("Prontuario alterado com sucesso!");
}


    //métodos VETERINÁRIO
    public static Veterinario CriarMedico() {
    // Usa o Scanner estático 'input' da classe para evitar múltiplas instâncias
    System.out.print("Nome: ");
    String nome = input.nextLine();

    System.out.print("Endereco: ");
    String endereco = input.nextLine();

    int idade = -1;
    while (idade < 0 || idade > 120) {
        System.out.print("Idade: ");
        if (input.hasNextInt()) {
            idade = input.nextInt();
            if (idade < 0 || idade > 120) {
                System.out.println("Idade invalida. Tente novamente.");
            }
        } else {
            System.out.println("Entrada invalida. Digite um numero inteiro.");
            input.next(); // limpar entrada inválida
        }
    }
    input.nextLine(); // limpar o buffer do Scanner após nextInt()

    System.out.print("Especialidade: ");
    String especialidade = input.nextLine();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);
    Date dataContratacao = null;

    while (dataContratacao == null) {
        System.out.print("Data de contratacao (formato dd/MM/yyyy): ");
        String dataTexto = input.nextLine();
        try {
            Date temp = sdf.parse(dataTexto);
            if (temp.after(new Date())) {
                System.out.println("Data nao pode ser no futuro. Tente novamente.");
            } else {
                dataContratacao = temp;
            }
        } catch (ParseException e) {
            System.out.println("Data invalida. Tente novamente.");
        }
    }

    return new Veterinario(nome, endereco, idade, especialidade, dataContratacao);
}

    public static void listaMedicos(ArrayList<Veterinario> veterinarios){
        if(veterinarios.isEmpty()){
            System.out.println("Nao ha veterinarios cadastrados.");
            return;
        }

        int i = 0;
        System.out.println("--- VETERINARIOS ---");
        for(Veterinario v : veterinarios){
            System.out.println("Veterinario: " + i++ );
            System.out.println(v);
        }

    }

    public static void AlterarCadastroMedico(ArrayList<Veterinario> veterinarios) {
    if (veterinarios.isEmpty()) {
        System.out.println("Nao ha veterinarios cadastrados.");
        return;
    }

    listaMedicos(veterinarios);

    System.out.print("Indice do veterinario que deseja alterar: ");
    int index = input.nextInt();
    input.nextLine();

    if (index < 0 || index >= veterinarios.size()) {
        System.out.println("Indice invalido.");
        return;
    }

    Veterinario v = veterinarios.get(index);

    // Mostrar dados atuais
    System.out.println("\nDados atuais:");
    System.out.println(v);

    System.out.print("Novo nome: ");
    String nome = input.nextLine();
    if (!nome.isBlank()) {
        v.setNome(nome);
    }

    System.out.print("Novo endereco: ");
    String endereco = input.nextLine();
    if (!endereco.isBlank()) {
        v.setEndereco(endereco);
    }

    System.out.print("Nova idade: ");
    int idade = -1;
    if (input.hasNextInt()) {
        idade = input.nextInt();
        if (idade >= 0 && idade <= 120) {
            v.setIdade(idade);
        } else {
            System.out.println("Idade invalida. A idade nao foi alterada.");
        }
    } else {
        System.out.println("Entrada invalida para idade. A idade nao foi alterada.");
        input.next(); // limpar entrada invalida
    }
    input.nextLine(); // limpar quebra de linha

    System.out.print("Nova especialidade: ");
    String especialidade = input.nextLine();
    if (!especialidade.isBlank()) {
        v.setEspecialidade(especialidade);
    }

    System.out.print("Nova data de contratacao (dd/MM/yyyy): ");
    String dataTexto = input.nextLine();
    if (!dataTexto.isBlank()) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date data = sdf.parse(dataTexto);
            if (data.after(new Date())) {
                System.out.println("Data nao pode ser no futuro. A data nao foi alterada.");
            } else {
                v.setDataContratacao(data);
            }
        } catch (ParseException e) {
            System.out.println("Data invalida. A data nao foi alterada.");
        }
    }

    System.out.println("Cadastro alterado com sucesso!");
}

    //métodos ADOTANTES
    public static Adotantes CriarCadastroPessoa() {
    System.out.print("Nome: ");
    String nome = input.nextLine();
    while (nome.isBlank()) {
        System.out.println("Nome nao pode ser vazio.");
        System.out.print("Nome: ");
        nome = input.nextLine();
    }

    System.out.print("Endereco: ");
    String endereco = input.nextLine();
    while (endereco.isBlank()) {
        System.out.println("Endereco nao pode ser vazio.");
        System.out.print("Endereco: ");
        endereco = input.nextLine();
    }

    int idade = -1;
    while (idade < 0 || idade > 120) {
        System.out.print("Idade: ");
        if (input.hasNextInt()) {
            idade = input.nextInt();
            if (idade < 0 || idade > 120) {
                System.out.println("Idade invalida. Tente novamente.");
            }
        } else {
            System.out.println("Entrada invalida. Digite um numero inteiro.");
            input.next(); // limpar entrada invalida
        }
    }
    input.nextLine(); // limpar buffer

    return new Adotantes(nome, endereco, idade);
}

    public static void listarAdotantes(ArrayList<Adotantes> adotantes) {
        if (adotantes.isEmpty()) {
            System.out.println("Nenhum adotante cadastrado.");
            return;
        }

        System.out.println("--- ADOTANTES ---");
        int i = 0;
        for (Adotantes a : adotantes) {
            System.out.println("Adotante" + i++);
            System.out.println(a);
        }
    }

    public static void AlterarCadastroPessoa(ArrayList<Adotantes> adotantes) {
    if (adotantes.isEmpty()) {
        System.out.println("Nenhum adotante cadastrado.");
        return;
    }

    listarAdotantes(adotantes);

    System.out.print("Indice do adotante a alterar: ");
    int index = -1;
    if (input.hasNextInt()) {
        index = input.nextInt();
        input.nextLine();
    } else {
        System.out.println("Entrada invalida. Indice deve ser um numero.");
        input.next(); // limpar entrada invalida
        return;
    }

    if (index < 0 || index >= adotantes.size()) {
        System.out.println("Indice invalido.");
        return;
    }

    Adotantes a = adotantes.get(index);

    System.out.println("\nDados atuais:");
    System.out.println(a);

    System.out.print("Novo nome: ");
    String nome = input.nextLine();
    if (!nome.isBlank()) {
        a.setNome(nome);
    }

    System.out.print("Novo endereco: ");
    String endereco = input.nextLine();
    if (!endereco.isBlank()) {
        a.setEndereco(endereco);
    }

    System.out.print("Nova idade: ");
    int idade = -1;
    if (input.hasNextInt()) {
        idade = input.nextInt();
        input.nextLine();
        if (idade >= 0 && idade <= 120) {
            a.setIdade(idade);
        } else {
            System.out.println("Idade invalida. A idade nao foi alterada.");
        }
    } else {
        System.out.println("Entrada invalida para idade. A idade nao foi alterada.");
        input.next(); // limpar entrada invalida
    }

    System.out.println("Cadastro alterado com sucesso!");
}

    //métodos AGENDA
    public static Agenda CriarAgenda() {
    String vetNome = "";
    while (vetNome.isBlank()) {
        System.out.print("Informe o nome do veterinario: ");
        vetNome = input.nextLine();
        if (vetNome.isBlank()) {
            System.out.println("Nome do veterinario nao pode ficar vazio.");
        }
    }

    String animalNome = "";
    while (animalNome.isBlank()) {
        System.out.print("Informe o nome do animal: ");
        animalNome = input.nextLine();
        if (animalNome.isBlank()) {
            System.out.println("Nome do animal nao pode ficar vazio.");
        }
    }

    String tratamento = "";
    while (tratamento.isBlank()) {
        System.out.print("Informe o tratamento: ");
        tratamento = input.nextLine();
        if (tratamento.isBlank()) {
            System.out.println("Tratamento nao pode ficar vazio.");
        }
    }

    Date dataConsulta = null;
    SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    sdfData.setLenient(false);
    while (dataConsulta == null) {
        System.out.print("Informe a data da consulta (dd/MM/yyyy): ");
        String dataStr = input.nextLine();
        try {
            dataConsulta = sdfData.parse(dataStr);
            Date hoje = new Date();
            if (dataConsulta.before(hoje)) {
                System.out.println("Data da consulta nao pode ser antes de hoje.");
                dataConsulta = null;
            }
        } catch (ParseException e) {
            System.out.println("Data em formato invalido. Tente novamente.");
        }
    }

    String horaConsulta = "";
    SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
    sdfHora.setLenient(false);
    boolean horaValida = false;
    while (!horaValida) {
        System.out.print("Informe a hora da consulta (HH:mm): ");
        horaConsulta = input.nextLine();
        try {
            sdfHora.parse(horaConsulta);
            horaValida = true;
        } catch (ParseException e) {
            System.out.println("Hora em formato invalido. Tente novamente.");
        }
    }

    return new Agenda(vetNome, animalNome, tratamento, dataConsulta, horaConsulta);
}

    public static void listarAgendas(ArrayList<Agenda> agendas) {
        if (agendas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }

        System.out.println("\n--- CONSULTAS AGENDADAS ---");
        int i = 0;
        for (Agenda ag : agendas) {
            System.out.println("Consulta " + i++);
            System.out.println(ag);
        }
    }

    public static void AlterarCadastroAgenda(ArrayList<Agenda> agendas) {
    if (agendas.isEmpty()) {
        System.out.println("Nenhuma agenda para alterar.");
        return;
    }

    listarAgendas(agendas);

    System.out.print("Digite o indice da agenda que deseja alterar: ");
    int index = -1;
    if (input.hasNextInt()) {
        index = input.nextInt();
        input.nextLine();
    } else {
        System.out.println("Entrada invalida. Indice deve ser um numero.");
        input.next(); // limpar entrada invalida
        input.nextLine();
        return;
    }

    if (index < 0 || index >= agendas.size()) {
        System.out.println("Indice invalido.");
        return;
    }

    Agenda ag = agendas.get(index);

    System.out.println("\nDados atuais:");
    System.out.println(ag);

    System.out.print("Novo nome do veterinario: ");
    String vetNome = input.nextLine();
    if (!vetNome.isBlank()) {
        ag.setVetNome(vetNome);
    }

    System.out.print("Novo nome do animal: ");
    String animalNome = input.nextLine();
    if (!animalNome.isBlank()) {
        ag.setAnimalNome(animalNome);
    }

    System.out.print("Novo tratamento: ");
    String tratamento = input.nextLine();
    if (!tratamento.isBlank()) {
        ag.setTratamento(tratamento);
    }

    System.out.print("Nova data da consulta (dd/MM/yyyy): ");
    String dataStr = input.nextLine();
    if (!dataStr.isBlank()) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date novaData = sdf.parse(dataStr);

            Date hoje = new Date();
            if (novaData.before(hoje)) {
                System.out.println("Data nao pode ser anterior a hoje. Mantendo a data atual.");
            } else {
                ag.setDataConsulta(novaData);
            }
        } catch (ParseException e) {
            System.out.println("Data invalida. Mantendo a data atual.");
        }
    }

    System.out.print("Nova hora da consulta (HH:mm): ");
    String novaHora = input.nextLine();
    if (!novaHora.isBlank()) {
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        sdfHora.setLenient(false);
        try {
            sdfHora.parse(novaHora);
            ag.setHoraConsulta(novaHora);
        } catch (ParseException e) {
            System.out.println("Hora invalida. Mantendo a hora atual.");
        }
    }

    System.out.println("Consulta alterada com sucesso!");
}


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Animal> animais = new ArrayList<>();
        ArrayList<Veterinario> vets = new ArrayList<>();
        ArrayList<Atendente> atendentes = new ArrayList<>();
        ArrayList<Prontuario> prontuarios = new ArrayList<>();
        ArrayList<Adotantes> adotantes = new ArrayList<>();
        ArrayList<Agenda> agenda = new ArrayList<>();

        ComandoMenu menu = new ComandoMenu(input, animais, vets, atendentes, prontuarios, adotantes, agenda);
        menu.executar();

        input.close();
    }

}

