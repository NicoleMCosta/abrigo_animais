package com.mycompany.abrigo_animais.apresentacao;

import com.mycompany.abrigo_animais.dados.*;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import java.util.ArrayList;

public class ComandoMenu {
    private Scanner input;

    private ArrayList<Animal> animais;
    private ArrayList<Veterinario> vets;
    private ArrayList<Atendente> atendentes;
    private ArrayList<Prontuario> prontuarios;
    private ArrayList<Adotantes> adotantes;
    private ArrayList<Agenda> agenda;

    public ComandoMenu(Scanner input,
                       ArrayList<Animal> animais,
                       ArrayList<Veterinario> vets,
                       ArrayList<Atendente> atendentes,
                       ArrayList<Prontuario> prontuarios,
                       ArrayList<Adotantes> adotantes,
                       ArrayList<Agenda> agenda) {
        this.input = input;
        this.animais = animais;
        this.vets = vets;
        this.atendentes = atendentes;
        this.prontuarios = prontuarios;
        this.adotantes = adotantes;
        this.agenda = agenda;
    }

    public void executar() {
        int choice = -1;

        do {
            out.println("\nMENU");
            out.println("0 - Sair do Sistema");
            out.println("1 - Dados Atendentes");
            out.println("2 - Dados Veterinario");
            out.println("3 - Dados Adotantes");
            out.println("4 - Prontuarios");
            out.println("5 - Animal");
            out.println("6 - Agenda");
            out.print("\nEscolha uma opcao do menu: ");

            if(input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // limpar buffer
            } else {
                out.println("Entrada invalida! Digite um numero.");
                input.nextLine(); // limpar buffer inválido
                continue;
            }

            switch (choice) {
                case 0:
                    out.println("\nSaindo...");
                    break;
                case 1:
                    executarMenuAtendentes();
                    break;
                case 2:
                    executarMenuVeterinarios();
                    break;
                case 3:
                    executarMenuAdotantes();
                    break;
                case 4:
                    executarMenuProntuarios();
                    break;
                case 5:
                    executarMenuAnimais();
                    break;
                case 6:
                    executarMenuAgenda();
                    break;
                default:
                    out.println("Opcao invalida.");
            }

        } while (choice != 0);
    }

    private int menu_dados() {
        out.println("Opcoes:");
        out.println("1- Cadastrar");
        out.println("2- Alterar");
        out.println("3- Listar");
        out.print("\nEscolha uma opcao: ");
        while(!input.hasNextInt()) {
            out.println("Entrada invalida! Digite um numero.");
            input.nextLine();
        }
        int choice = input.nextInt();
        input.nextLine();
        return choice;
    }

    private void executarMenuAtendentes() {
        int opcaoContinuar = 1;
        while (opcaoContinuar == 1) {
            int choice_atd = menu_dados();
            if (choice_atd == 1)
                atendentes.add(Abrigo_animais.CriarCadastroAtendente(input));
            else if (choice_atd == 2)
                Abrigo_animais.AlterarCadastroAtendente(atendentes, input);
            else if (choice_atd == 3)
                Abrigo_animais.listarAtendentes(atendentes);
            else
                out.println("Opcao invalida.");

            out.print("\nDeseja continuar com Atendentes? 1-Sim | 2-Nao: ");
            opcaoContinuar = lerOpcaoContinuar();
        }
    }

    private void executarMenuVeterinarios() {
        int opcaoContinuar = 1;
        while (opcaoContinuar == 1) {
            int choice_med = menu_dados();
            if (choice_med == 1)
                vets.add(Abrigo_animais.CriarMedico(input));
            else if (choice_med == 2)
                Abrigo_animais.AlterarCadastroMedico(vets, input);
            else if (choice_med == 3)
                Abrigo_animais.listaMedicos(vets);
            else
                out.println("Opcao invalida.");

            out.print("\nDeseja continuar com Veterinarios? 1-Sim | 2-Nao: ");
            opcaoContinuar = lerOpcaoContinuar();
        }
    }

    private void executarMenuAdotantes() {
        int opcaoContinuar = 1;
        while (opcaoContinuar == 1) {
            int choice_adt = menu_dados();
            if (choice_adt == 1)
                adotantes.add(Abrigo_animais.CriarCadastroPessoa(input));
            else if (choice_adt == 2)
                Abrigo_animais.AlterarCadastroPessoa(adotantes, input);
            else if (choice_adt == 3)
                Abrigo_animais.listarAdotantes(adotantes);
            else
                out.println("Opcao invalida.");

            out.print("\nDeseja continuar com Adotantes? 1-Sim | 2-Nao: ");
            opcaoContinuar = lerOpcaoContinuar();
        }
    }

    private void executarMenuProntuarios() {
        int opcaoContinuar = 1;
        while (opcaoContinuar == 1) {
            int choice_ptr = menu_dados();
            if (choice_ptr == 1)
                prontuarios.add(Abrigo_animais.CriarProntuario(input));
            else if (choice_ptr == 2)
                Abrigo_animais.AlterarProntuario(prontuarios,  input);
            else if (choice_ptr == 3)
                Abrigo_animais.listaProntuarios(prontuarios);
            else
                out.println("Opcao invalida.");

            out.print("\nDeseja continuar com Prontuarios? 1-Sim | 2-Nao: ");
            opcaoContinuar = lerOpcaoContinuar();
        }
    }

    private void executarMenuAnimais() {
        int opcaoContinuar = 1;
        while (opcaoContinuar == 1) {
            int choice_animal = menu_dados();
            if (choice_animal == 1)
                animais.add(Abrigo_animais.CriarAnimal(input));
            else if (choice_animal == 2)
                Abrigo_animais.AlterarCadastroAnimal(animais, input);
            else if (choice_animal == 3)
                Abrigo_animais.listarAnimais(animais);
            else
                out.println("Opcao invalida.");

            out.print("\nDeseja continuar com Animais? 1-Sim | 2-Nao: ");
            opcaoContinuar = lerOpcaoContinuar();
        }
    }

    private void executarMenuAgenda() {
        int opcaoContinuar = 1;
        while (opcaoContinuar == 1) {
            int choice_agenda = menu_dados();
            if (choice_agenda == 1)
                agenda.add(Abrigo_animais.CriarAgenda(input));
            else if (choice_agenda == 2)
                Abrigo_animais.AlterarCadastroAgenda(agenda,input);
            else if (choice_agenda == 3)
                Abrigo_animais.listarAgendas(agenda);
            else
                out.println("Opcao invalida.");

            out.print("\nDeseja continuar com Agenda? 1-Sim | 2-Nao: ");
            opcaoContinuar = lerOpcaoContinuar();
        }
    }

    private int lerOpcaoContinuar() {
        while (!input.hasNextInt()) {
            out.println("Entrada invalida! Digite 1 para Sim ou 2 para Nao.");
            input.nextLine();
        }
        int opcao = input.nextInt();
        input.nextLine();
        if (opcao != 1 && opcao != 2) {
            out.println("Opcao invalida! Considerando como 'Nao'.");
            return 2;
        }
        return opcao;
    }
}
