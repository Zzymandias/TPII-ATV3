package br.edu.fatecpg.spring.ConsomeApi.service;

import br.edu.fatecpg.spring.ConsomeApi.model.Serie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ConsomeApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsomeApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		ConverteDado conversor = new ConverteDado();

		while (true) {
			System.out.println("1-Pesquisar 2-Sair");
			String tipo = scan.nextLine();
			switch (tipo.toLowerCase()) {
				case "1":
					System.out.println("Digite a serie ou filme que você está procurando: ");
					String tituloserie = scan.nextLine();
					try {
						String json = ConsumeApi.obterDado(tituloserie);
						Serie serie = conversor.obterDado(json, Serie.class);
						System.out.println(serie);
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
						System.out.println("Erro ao buscar dados da API.");
					}
					break;
				case "2":
					return;
			}
		}
	}
}
