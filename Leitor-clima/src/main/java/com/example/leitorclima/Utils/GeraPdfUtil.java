package com.example.leitorclima.Utils;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import java.io.File;
import java.util.ArrayList;

public class GeraPdfUtil {
    public static void geraPdf(String[] args) {
        String filePath = "relatorio_climatico.pdf";
        String cidade = "Nome da Cidade"; // cidade
        String periodo = "XX/XX/XXXX - XX/XX/XXXX"; // data

        try {
            //Cria um novo documento PDF
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);

            //Cria um documento iText
            Document document = new Document(pdf);

            //título
            Paragraph title = new Paragraph("Relatório Climático - " + cidade);
            title.setFontSize(20);
            title.setBold();
            document.add(title);

            //Adiciona infos sobre o período
            Paragraph period = new Paragraph("Período: " + periodo);
            period.setFontSize(12);
            document.add(period);

            //Adiciona espaço para os dados climáticos
            Paragraph climaticData = new Paragraph("Dados Climáticos:");
            climaticData.setFontSize(16);
            document.add(climaticData);

            //Adiciona parágrafos em branco para os dados climáticos
            String[] dadosClimaticos = {"Data: ________", "Hora (UTC): ________", "Temp. Ins. (C): ________",
                    "Umi. Ins. (%): ________", "Pto Orvalho Ins. (C): ________",
                    "Pressao Ins. (hPa): ________", "Vel. Vento (m/s): ________",
                    "Dir. Vento (m/s): ________", "Raj. Vento (m/s): ________",
                    "Radiacao (KJ/m²): ________", "Chuva (mm): ________",
                    "Nebulosidade (Decimos): ________", "Insolacao (h): ________"};

            for (String dado : dadosClimaticos) {
                Paragraph blankData = new Paragraph(dado);
                blankData.setFontSize(12);
                document.add(blankData);
            }

            document.close();

            System.out.println("PDF gerado com sucesso em: " + new File(filePath).getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}