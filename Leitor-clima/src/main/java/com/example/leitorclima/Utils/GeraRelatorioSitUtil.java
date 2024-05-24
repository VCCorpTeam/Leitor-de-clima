package com.example.leitorclima.Utils;

import java.util.ArrayList;

public class GeraRelatorioSitUtil {


        // Dados de exemplo - Crie uma estrutura de dados para armazenar seus dados reais
        Map<String, List<Medida>> dados = new HashMap<>();
        dados.put("Sjc", new ArrayList<>());
        dados.get("Sjc").add(new Medida("24/05/2024", "20:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("19/05/2024", "22:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("20/05/2024", "23:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("24/05/2024", "20:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("20/05/2024", "23:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("20/05/2024", "23:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("22/05/2024", "22:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("24/05/2024", "22:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("19/05/2024", "22:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("24/05/2024", "20:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));
        dados.get("Sjc").add(new Medida("11/05/2024", "19:00", 20.6, 19.8, 88, 18, 17.7, 1200, 1.2, 5.5, 0.6, 10));

        String cidade = "Sjc"; // Cidade para consultar

        // Encontre a medida mais recente para a cidade
        Medida ultimaMedida = encontrarUltimaMedida(dados.get(cidade));

        // Exiba o relatório na tela
        exibirRelatorio(cidade, ultimaMedida);
    }

    // Encontra a medida mais recente de uma lista de medidas
    private static Medida encontrarUltimaMedida(List<Medida> medidas) {
        if (medidas.isEmpty()) {
            return null;
        }

        Collections.sort(medidas, Comparator.comparing(Medida::getDataHora).reversed());
        return medidas.get(0);
    }

    // Exibe o relatório na tela
    private static void exibirRelatorio(String cidade, Medida ultimaMedida) {
        if (ultimaMedida == null) {
            System.out.println("Não há dados para a cidade " + cidade);
            return;
        }

        System.out.println("Relatório Situacional - Dados Mais Recentes");
        System.out.println("----------------------------------------");
        System.out.println("Cidade: " + cidade);
        System.out.println("Data: " + ultimaMedida.getData());
        System.out.println("Hora: " + ultimaMedida.getHora());
        System.out.println("Umidade: " + ultimaMedida.getUmidade());
        System.out.println("Pressão: " + ultimaMedida.getPressao());
        System.out.println("Chuva: " + ultimaMedida.getChuva());
        System.out.println("Temperatura: " + ultimaMedida.getTemperatura());
        System.out.println("Ponto de Orvalho: " + ultimaMedida.getPontoOrvalho());
        System.out.println("Radiação: " + ultimaMedida.getRadiacao());
        System.out.println("Velocidade do Vento: " + ultimaMedida.getVelocidadeVento());
        System.out.println("Rajada de Vento: " + ultimaMedida.getRajadaVento());
        System.out.println("Insolação: " + ultimaMedida.getInsolacao());
        System.out.println("Nebulosidade: " + ultimaMedida.getNebulosidade());
    }

    // Classe para representar uma medida
    private static class Medida {
        private String data;
        private String hora;
        private double umidade;
        private double pressao;
        private int chuva;
        private int temperatura;
        private double pontoOrvalho;
        private int radiacao;
        private double velocidadeVento;
        private double rajadaVento;
        private double insolacacao;
        private int nebulosidade;

        public Medida(String data, String hora, double umidade, double pressao, int chuva, int temperatura,
                      double pontoOrvalho, int radiacao, double velocidadeVento, double rajadaVento, double insolacacao,
                      int nebulosidade) {
            this.data = data;
            this.hora = hora;
            this.umidade = umidade;
            this.pressao = pressao;
            this.chuva = chuva;
            this.temperatura = temperatura;
            this.pontoOrvalho = pontoOrvalho;
            this.radiacao = radiacao;
            this.velocidadeVento = velocidadeVento;
            this.rajadaVento = rajadaVento;
            this.insolacacao = insolacacao;
            this.nebulosidade = nebulosidade;
        }

        public String getData() {
            return data;
        }

        public String getHora() {
            return hora;
        }

        public String getDataHora() {
            return data + " " + hora;
        }

        public double getUmidade() {
            return umidade;
        }

        public double getPressao() {
            return pressao;
        }

        public int getChuva() {
            return chuva;
        }

        public int getTemperatura() {
            return temperatura;
        }

        public double getPontoOrvalho() {
            return pontoOrvalho;
        }

        public int getRadiacao() {
            return radiacao;
        }

        public double getVelocidadeVento() {
            return velocidadeVento;
        }

        public double getRajadaVento() {
            return rajadaVento;
        }

        public double getInsolacao() {
            return insolacacao;
        }

        public int getNebulosidade() {
            return nebulosidade;
        }
    }








