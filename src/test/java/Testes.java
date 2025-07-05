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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class Testes {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out; //para simulação de user input
    private final InputStream originalIn = System.in;

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
//        System.out.println("Testes Finalizados");
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // TODO add test methods here.
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
    public void CadAnimalPesoNeg() {
        new Animal("Rex", "Cachorro", -10.0f, 2, "Médio");
        //assertFalse(Animal);
    }

    @Test
    public void CadConfirmaAdotante() {
        var adotante = new Adotantes("Maria", "Rua A", 30);
        assertEquals("Maria", adotante.getNome());
        assertEquals("Rua A", adotante.getEndereco());
        assertEquals(30, adotante.getIdade());
    }

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
    public void CadConfirmaAtendente() {
        var data = new Date();
        var atendente = new Atendente("Paula", "Centro", 29, data);
        assertEquals("Paula", atendente.getNome());
        assertEquals("Centro", atendente.getEndereco());
        assertEquals(29, atendente.getIdade());
        assertEquals(data, atendente.getDataContratacao());
    }

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
    public void CadConfirmaProntuario() {
        var pront = new Prontuario(123, "Dra. Ana", "Cirurgia", "Em andamento");
        assertEquals(123, pront.getCodigo());
        assertEquals("Dra. Ana", pront.getNomeMedico());
        assertEquals("Cirurgia", pront.getTratamento());
        assertEquals("Em andamento", pront.getStatus());
    }

    @Test
    public void testFluxoGeralCadastroAnimal() {

        System.setOut(new PrintStream(outContent));
        // Simula a seguinte sequência:
        // 5 -> acessar "Animal"
        // 1 -> opção "Cadastrar"
        // Dados do animal
        // 6 linhas de dados (nome, espécie, peso, idade, porte)
        // 2 -> opção "Alterar"
        // 0 -> sair

        String simulatedUserInput = String.join(System.lineSeparator(),
                "5",          // Menu -> Animal
                "1",          // Cadastrar
                "Bidu",       // nome
                "Cachorro",   // espécie
                "12.5",       // peso
                "5",          // idade
                "Pequeno",    // porte
                "1",          // continuar com animal
                "2",          // Alterar
                "0",          // índice do animal
                "Shitzu",           // nova espécie
                "13.2",       // novo peso
                "6",          // nova idade
                "Médio",      // novo porte
                "2",          // Não continuar com animais
                "0"           // Sair do sistema
        );

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        // Executa a main
        Abrigo_animais.main(new String[]{});

        // Verificações simples de saída esperada
        String output = outContent.toString();
        Assertions.assertFalse(output.isEmpty());
        Assertions.assertTrue(output.contains("Cadastro alterado com sucesso!"));
        Assertions.assertTrue(output.contains("Saindo..."));
    }


    @Test
    public void testFluxoAnimalPesoNeg() {

        System.setOut(new PrintStream(outContent));
        // Simula a seguinte sequência:
        // 5 -> acessar "Animal"
        // 1 -> opção "Cadastrar"
        // Dados do animal
        // 6 linhas de dados (nome, espécie, peso, idade, porte)
        // 2 -> opção "Alterar"
        // 0 -> sair

        String simulatedUserInput = String.join(System.lineSeparator(),
                "5",          // Menu -> Animal
                "1",          // Cadastrar
                "Bidu",       // nome
                "Cachorro",   // espécie
                "-5",       // peso
                "5",          // idade
                "Pequeno",    // porte
                "1",          // continuar com animal
                "2",          // Alterar
                "0",          // índice do animal
                "Shitzu",           // nova espécie
                "13.2",       // novo peso
                "6",          // nova idade
                "Médio",      // novo porte
                "2",          // Não continuar com animais
                "0"           // Sair do sistema
        );

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);

        // Executa a main
        Abrigo_animais.main(new String[]{});

        // Verificações simples de saída esperada
        String output = outContent.toString();
        Assertions.assertFalse(output.contains("Peso invalido. Tente novamente."));
        Assertions.assertTrue(output.contains("Cadastro alterado com sucesso!"));
        Assertions.assertTrue(output.contains("Saindo..."));
    }
}

