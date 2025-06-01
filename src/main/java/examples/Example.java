package examples;

import app.Database;
import model.Evento;
import model.Usuario;
import subtypes.Endereco;

import java.time.LocalDate;

public class Example {

    public Example(){
        // Endereços
        Endereco endereco1 = new Endereco(123, "Rua das Flores", "São Paulo", "Centro", "SP", "01000-000");
        Endereco endereco2 = new Endereco(456, "Av. Brasil", "Rio de Janeiro", "Copacabana", "RJ", "22000-000");
        Endereco endereco3 = new Endereco(789, "Rua da Paz", "Belo Horizonte", "Savassi", "MG", "30100-000");

        // Usuários
        Usuario joao = new Usuario("João da Silva", "joao@email.com", "Universidade XYZ");
        Usuario maria = new Usuario("Maria Oliveira", "maria@email.com", "Instituto ABC");
        Usuario carlos = new Usuario("Carlos Souza", "carlos@email.com", "Universidade Federal");

        // Eventos
        Evento evento1 = new Evento(
                "Congresso de Computação",
                "Evento sobre temas atuais em computação",
                LocalDate.of(2025, 10, 1),
                LocalDate.of(2025, 10, 5),
                endereco1,
                100,
                LocalDate.of(2025, 8, 1),
                joao,
                3
        );

        Evento evento2 = new Evento(
                "Simpósio de Inteligência Artificial",
                "Discussão de IA e Aprendizado de Máquina",
                LocalDate.of(2025, 11, 10),
                LocalDate.of(2025, 11, 12),
                endereco2,
                200,
                LocalDate.of(2025, 9, 15),
                maria,
                2
        );

        Evento evento3 = new Evento(
                "Workshop de Segurança Cibernética",
                "Palestras sobre segurança e criptografia",
                LocalDate.of(2025, 9, 20),
                LocalDate.of(2025, 9, 21),
                endereco3,
                80,
                LocalDate.of(2025, 7, 1),
                carlos,
                5
        );

        Database.getInstance().getUsuarioRepository().create(joao);
        Database.getInstance().getUsuarioRepository().create(maria);
        Database.getInstance().getUsuarioRepository().create(carlos);
        Database.getInstance().getEventoRepository().create(evento1);
        Database.getInstance().getEventoRepository().create(evento2);
        Database.getInstance().getEventoRepository().create(evento3);

    }

}
