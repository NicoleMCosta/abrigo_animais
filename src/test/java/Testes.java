/*
        BEFORE ALL ESTÁ COMENTADO APENAS PARA
        NÃO DAR ENQUANTO AINDA
        NÃO IMPLEMENTADO
*/

import com.mycompany.abrigo_animais.apresentacao.Abrigo_animais;
import com.mycompany.abrigo_animais.dados.Animal;
import com.mycompany.abrigo_animais.dados.Adotantes;
import com.mycompany.abrigo_animais.dados.Agenda;
import com.mycompany.abrigo_animais.dados.Veterinario;
import com.mycompany.abrigo_animais.dados.Atendente;
import com.mycompany.abrigo_animais.dados.Prontuario;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class Testes {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out; //para simulação de user input
    private final InputStream originalIn = System.in;   //idem

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {

    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

//    @BeforeAll
//    public static void setUpClass() {
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//    }
//
//    @BeforeEach
//    public void setUp() {
//    }
//


    // TODO add test methods here.
    //Testes Animal
    @Test
    public void CadConfirmaAnimal() {
        var animal = new Animal("teste 1", "especie", 1.1F, 1, "1");
        assertEquals("teste 1", animal.getNome());
        assertEquals("especie", animal.getEspecie());
        assertEquals(1.1F, animal.getPeso(), 0.0001);
        assertEquals(1, animal.getIdade());
        assertEquals("1", animal.getPorte());
    }

    @Test
    public void DadosInvalidosAnimal(){
        String inputSimulado = "5\n1\n\nBolt\nCachorro\n0\n2.4\n-2\n2\nPequeno\n2\n0\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try{
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saidaTexto = saidaCapturada.toString();

            assertTrue(saidaTexto.contains("Nome não pode ser vazio"));
            assertTrue(saidaTexto.contains("Peso invalido. Tente novamente."));
            assertTrue(saidaTexto.contains("Idade invalida. Tente novamente."));
            assertTrue(saidaTexto.contains("Cadastro realizado com sucesso!"));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void AlterarCadastroAnimal() {
        ArrayList<Animal> animais = new ArrayList<>();
        Animal animalOriginal = new Animal("Bolt", "Cachorro", 15.0f, 5, "Médio");
        animais.add(animalOriginal);

        // Simulação de user input
        // - índice do animal que deseja alterar: 0
        // - novo nome: Mittens
        // - nova espécie: Gato
        // - novo peso: 4.2
        // - nova idade: 3
        // - novo porte: Pequeno

        String inputStr = "0\nMittens\nGato\n4.2\n3\nPequeno\n";
        Scanner input = new Scanner(new ByteArrayInputStream(inputStr.getBytes()));

        Abrigo_animais.AlterarCadastroAnimal(animais, input);

        Animal alterado = animais.get(0);

        assertEquals("Mittens", alterado.getNome());
        assertEquals("Gato", alterado.getEspecie());
        assertEquals(4.2f, alterado.getPeso());
        assertEquals(3, alterado.getIdade());
        assertEquals("Pequeno", alterado.getPorte());
    }

    //Testes Adotantes
    @Test
    public void CadConfirmaAdotante() {
        var adotante = new Adotantes("Maria", "Rua A", 30);
        assertEquals("Maria", adotante.getNome());
        assertEquals("Rua A", adotante.getEndereco());
        assertEquals(30, adotante.getIdade());
    }

    @Test
    public void DadosInvalidosAdotante(){
        String inputSimulado = "3\n1\n\nAna\n\nRua\n-2\n20\n2\n0\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try{
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saidaTexto = saidaCapturada.toString();

            assertTrue(saidaTexto.contains("Nome não pode ser vazio"));
            assertTrue(saidaTexto.contains("Endereço não pode ser vazio"));
            assertTrue(saidaTexto.contains("Cadastro realizado com sucesso!"));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void AlterarAdotante() {
        ArrayList<Adotantes> adotantes = new ArrayList<>();
        Adotantes adotanteOriginal = new Adotantes("Maria", "Rua A", 30);
        adotantes.add(adotanteOriginal);

        //Simulação user input
        //index: 0
        //novo nome: Maria Eduarda
        //novo endereço: Enter mantém
        //nova idade: 31

        String inputStr = "0\nMaria Eduarda\n\n31\n";
        Scanner input = new Scanner(new ByteArrayInputStream(inputStr.getBytes()));

        Abrigo_animais.AlterarCadastroPessoa(adotantes, input);
        Adotantes alterado = adotantes.get(0);

        assertEquals("Maria Eduarda", alterado.getNome());
        assertEquals("Rua A", alterado.getEndereco());
        assertEquals(31, alterado.getIdade());
    }
    //Testes Agenda
    @Test
    public void CadConfirmaAgenda() {
        var data = new Date();
        var agenda = new Agenda("Dra. Ana", "Bolt", "Consulta", data, "10:00");
        assertEquals("Dra. Ana", agenda.getVetNome());
        assertEquals("Bolt", agenda.getAnimalNome());
        assertEquals("Consulta", agenda.getTratamento());
        assertEquals(data, agenda.getDataConsulta());
        assertEquals("10:00", agenda.getHoraConsulta());
    }

    @Test
    public void DadosInvalidosAgenda(){
        String inputSimulado = "6\n1\n\nDr. Ana\n\nBidu\n\nCheckup\n12/12/2003\n12/12/2025\n14:00\n2\n0\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try{
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saidaTexto = saidaCapturada.toString();

            assertTrue(saidaTexto.contains("Nome do veterinario nao pode ficar vazio"));
            assertTrue(saidaTexto.contains("Nome do animal nao pode ficar vazio"));
            assertTrue(saidaTexto.contains("Tratamento nao pode ficar vazio"));
            assertTrue(saidaTexto.contains("Data da consulta nao pode ser antes de hoje"));
            assertTrue(saidaTexto.contains("Consulta agendada com sucesso!"));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void AlterarAgenda() throws ParseException {
        ArrayList<Agenda> agendas = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  sdf.parse("07/07/2025");

        Agenda agendaOriginal = new Agenda("Danton", "Mittens","Checkup",data,"16:20");
        agendas.add(agendaOriginal);

        //User input
        //index alteração: 0
        //vet: Danton J. Silva
        //animal: Enter mantém
        //tratamento: Enter mantém
        //data: 09/07/2025
        //hora: 17:00
        String inputStr = "0\nDanton J. Silva\n" +
                "\n" +
                "\n" +
                "09/07/2025\n" +
                "17:00\n";

        Scanner input = new Scanner(new ByteArrayInputStream(inputStr.getBytes()));
        Abrigo_animais.AlterarCadastroAgenda(agendas, input);
        Agenda alterado = agendas.get(0);

        assertEquals("Danton J. Silva", alterado.getVetNome());
        assertEquals("Mittens", alterado.getAnimalNome());
        assertEquals("Checkup", alterado.getTratamento());
        assertEquals(sdf.parse("09/07/2025"), alterado.getDataConsulta());
        assertEquals("17:00", alterado.getHoraConsulta());
    }

    //Testes Atendente
    @Test
    public void CadConfirmaAtendente() {
        var data = new Date();
        var atendente = new Atendente("Paula", "Centro", 29, data);
        assertEquals("Paula", atendente.getNome());
        assertEquals("Centro", atendente.getEndereco());
        assertEquals(29, atendente.getIdade());
        assertEquals(data, atendente.getDataContratacao());
    }

    @Test
    public void DadosInvalidosAtendente() {
        String inputSimulado = "1\n1\n\nAnahi\n\nRua B\n0\n20\n12/10/2020\n2\n0\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try{
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saidaTexto = saidaCapturada.toString();

            assertTrue(saidaTexto.contains("Nome não pode ser vazio"));
            assertTrue(saidaTexto.contains("Endereço não pode ser vazio"));
            assertTrue(saidaTexto.contains("Idade deve estar entre 18 e 100."));
            assertTrue(saidaTexto.contains("Cadastro realizado com sucesso!"));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void AlterarAtendente() throws ParseException {
        ArrayList<Atendente> atendentes = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  sdf.parse("14/02/2023");

        Atendente atendenteOg = new Atendente("Marissa", "Rua B", 23, data);
        atendentes.add(atendenteOg);

        //User input
        //nome: Marissa Castro
        //endereço: Rua B, apto 1
        //idade: 24
        //data: 20/02/2023
        String inputStr = "0\nMarissa Castro\nRua B, apto 1\n24\n20/02/2023\n";
        Scanner input = new Scanner(new ByteArrayInputStream(inputStr.getBytes()));

        Abrigo_animais.AlterarCadastroAtendente(atendentes, input);
        Atendente alterado = atendentes.get(0);

        assertEquals("Marissa Castro", alterado.getNome());
        assertEquals("Rua B, apto 1", alterado.getEndereco());
        assertEquals(24, alterado.getIdade());
        assertEquals(sdf.parse("20/02/2023"), alterado.getDataContratacao());

    }

    //Testes Veterinario
    @Test
    public void CadConfirmaVeterinario() {
        var data = new Date();
        var vet = new Veterinario("Dra. Clara", "Rua Vet", 40, "Clínica", data);
        assertEquals("Dra. Clara", vet.getNome());
        assertEquals("Rua Vet", vet.getEndereco());
        assertEquals(40, vet.getIdade());
        assertEquals("Clínica", vet.getEspecialidade());
        assertEquals(data, vet.getDataContratacao());
    }

    @Test
    public void DadosInvalidosVet() {
        String inputSimulado = "2\n1\n\nBob\n\nRua A\n1\n12\n19\nGatos\n12/12/2025\n12/12/2024\n2\n0\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try{
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saidaTexto = saidaCapturada.toString();

            assertTrue(saidaTexto.contains("Nome não pode ser vazio"));
            assertTrue(saidaTexto.contains("Endereço não pode ser vazio"));
            assertTrue(saidaTexto.contains("Idade invalida. Tente novamente."));
            assertTrue(saidaTexto.contains("Data nao pode ser no futuro. Tente novamente."));
            assertTrue(saidaTexto.contains("Cadastro realizado com sucesso!"));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void AlterarVeterinario() throws ParseException {
        ArrayList<Veterinario> veterinarios = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  sdf.parse("10/01/2024");

        Veterinario vetOg = new Veterinario("Vinicius Correa", "Rua C", 24, "Eutanásia", data);
        veterinarios.add(vetOg);

        //User input
        //indice alterado: 0
        //nome: Vinicius C.K.
        //endereço: Rua B
        //idade: 25
        //esp: Clinico Geral
        //data: 10/02/2024

        String inputStr = "0\nViniciu C.K.\nRua B\n25\nClinico Geral\n10/02/2024\n";
        Scanner input = new Scanner(new ByteArrayInputStream(inputStr.getBytes()));

        Abrigo_animais.AlterarCadastroMedico(veterinarios, input);
        Veterinario alterado = veterinarios.get(0);

        assertEquals("Viniciu C.K.", alterado.getNome());
        assertEquals("Rua B", alterado.getEndereco());
        assertEquals(25, alterado.getIdade());
        assertEquals("Clinico Geral", alterado.getEspecialidade());
        assertEquals(sdf.parse("10/02/2024"), alterado.getDataContratacao());
    }

    //Testes Prontuario
    @Test
    public void CadConfirmaProntuario() {
        var pront = new Prontuario(123, "Dra. Ana", "Cirurgia", "Em andamento");
        assertEquals(123, pront.getCodigo());
        assertEquals("Dra. Ana", pront.getNomeMedico());
        assertEquals("Cirurgia", pront.getTratamento());
        assertEquals("Em andamento", pront.getStatus());
    }

    @Test
    public void DadosInvalidosProntuario() {
        String inputSimulado = "4\n1\na\n1\n\nDra. Claudia\n\nAsma\n\nEm andamento\n2\n0\n";
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try{
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saidaTexto = saidaCapturada.toString();

            assertTrue(saidaTexto.contains("Entrada invalida. Digite um numero inteiro."));
            assertTrue(saidaTexto.contains("Nome nao pode estar em branco."));
            assertTrue(saidaTexto.contains("Tratamento nao pode estar em branco."));
            assertTrue(saidaTexto.contains("Status nao pode estar em branco."));
            assertTrue(saidaTexto.contains("Cadastro realizado com sucesso!"));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void AlterarProntuario() throws ParseException {
        ArrayList<Prontuario> prontuarios = new ArrayList<>();

        Prontuario prtOg = new Prontuario(123, "Dra. Ana", "Cirurgia", "Em Andamento");
        prontuarios.add(prtOg);

        String inputStr  = "0\n100\nDra. Anahi\nCirurgia na perna esquerda\nConcluido\n";
        Scanner input = new Scanner(new ByteArrayInputStream(inputStr.getBytes()));
        Abrigo_animais.AlterarProntuario(prontuarios, input);

        Prontuario alterado = prontuarios.get(0);

        assertEquals(100, alterado.getCodigo());
        assertEquals("Dra. Anahi", alterado.getNomeMedico());
        assertEquals("Cirurgia na perna esquerda", alterado.getTratamento());
        assertEquals("Concluido", alterado.getStatus());
    }

    //Testes Fluxo
    @Test
    public void EntradaInvalidaMenu(){
        String inputSimulado = "abc\n0\n";

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try{
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saidaTexto = saidaCapturada.toString();

            assertTrue(saidaTexto.contains("Entrada invalida! Digite um numero."));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void TesteFluxoListar() {
    String inputSimulado =
                "1\n" +
                "3\n" +
                "2\n" + //sair menu atendente
                "2\n" +
                "3\n" +
                "2\n" +//sair menu veterinario
                "3\n" +
                "3\n" +
                "2\n" +//sair menu adotante
                "4\n" +
                "3\n" +
                "2\n" +//sair menu prontuario
                "5\n" +
                "3\n" +
                "2\n" +//sair menu animal
                "6\n" +
                "3\n" +
                "2\n" +//sair menu agenda
                "0\n";
        try {
            InputStream originalIn = System.in;
            PrintStream originalOut = System.out;
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));

            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saidaTexto = saidaCapturada.toString();

            assertTrue(saidaTexto.contains("Nenhum atendente cadastrado."));
            assertTrue(saidaTexto.contains("Nao ha veterinarios cadastrados."));
            assertTrue(saidaTexto.contains("Nenhum adotante cadastrado."));
            assertTrue(saidaTexto.contains("Nao ha prontuários cadastrados."));
            assertTrue(saidaTexto.contains("Nenhum animal cadastrado."));
            assertTrue(saidaTexto.contains("Nenhuma consulta agendada."));
            assertTrue(saidaTexto.contains("Saindo..."));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void TesteFluxoCompleto() {
        String inputSimulado =
                // Menu: 5 = Animal
                "5\n" +
                "1\n" +           // Cadastrar
                "Bolt\n" +        // nome
                "Cachorro\n" +    // especie
                "10.0\n" +        // peso
                "4\n" +           // idade
                "Médio\n" +       // porte
                        //saida: Cadastro realizado com sucesso!
                "1\n" +           // Voltar menu Animal
                "3\n" +           // Listar
                        //saida: --- ANIMAIS ---
                "2\n" +           // Voltar menu main

                // Menu: 1 = Veterinário
                "2\n" +
                "1\n" +           // Cadastrar
                "Dr. House\n" +   // nome
                "Rua A\n" +       // endereço
                "45\n" +          // idade
                "Clinico\n" +     // especialidade
                "01/01/2020\n" +  // data contratacao
                "1\n" +           // Voltar menu Veterinário
                "3\n" +           // Listar
                "2\n" +           // Voltar menu main

                // Menu: 4 = Prontuário
                "4\n" +
                "1\n" +           // Criar prontuário
                "1\n" +           // código
                "Dr. House\n" +   // nome médico
                "Vacinação\n" +   // tratamento
                "Em andamento\n" +// status
                "1\n" +           // Voltar menu Prontuário
                "3\n" +           // Listar prontuários
                "2\n" +           // Voltar menu main

                // Alterar animal (menu 5)
                "5\n" +
                "2\n" +           // Alterar
                "0\n" +           // índice do animal
                "Bolt Jr.\n" +    // novo nome
                "\n" +            // manter espécie
                "12.0\n" +        // novo peso
                "5\n" +           // nova idade
                "Grande\n" +      // novo porte
                "1\n" +           // Voltar menu Animal
                "3\n" +           // Listar
                "2\n" +           // Voltar menu main
                "0\n";            // Sair geral

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(new ByteArrayInputStream(inputSimulado.getBytes()));
            ByteArrayOutputStream saidaCapturada = new ByteArrayOutputStream();
            System.setOut(new PrintStream(saidaCapturada));

            Abrigo_animais.main(new String[]{});
            String saida = saidaCapturada.toString();

            // Verificações
            assertTrue(saida.contains("Nome: Bolt"));                // animal original
            assertTrue(saida.contains("Nome do Médico: Dr. House"));
            assertTrue(saida.contains("Tratamento: Vacinação"));     // prontuário
            assertTrue(saida.contains("Nome: Bolt Jr."));            // alteração persistida
            assertTrue(saida.contains("Cadastro alterado com sucesso!"));

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }


}



