package com.example.leitorclima.Utils;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import java.io.File;
import java.util.ArrayList;

public class GeraPdfUtil {
    public static void geraPdf(String cidadePdf,String dataInicial,String dataFinal,Float medTemp,Float medTempIns,Float medUmi,Float medUmiIns,Float medPtoOrvalho,Float medPtoOrvalhoIns,Float medPressao,Float medPressaoIns,Float medVelVento,Float medDirVento,Float medRajVento,Float medRadiacao,Float medChuva,Float medNebulos,Float medInsolacao){
        String filePath = "relatorio_climatico.pdf";
        String cidade = cidadePdf; // cidade
        String periodo = dataInicial + " - " + dataFinal; // data

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
            String[] dadosClimaticos = {"Temp. (C): "+medTemp,"Temp. Ins. (C): "+medTempIns, "Umi. (%): "+medUmi,
                    "Umi. Ins. (%): "+medUmiIns, "Pto Orvalho (C): "+medPtoOrvalho,"Pto Orvalho Ins. (C): "+medPtoOrvalhoIns,
                    "Pressao (hPa): "+medPressao,"Pressao Ins. (hPa): "+medPressaoIns, "Vel. Vento (m/s): "+medVelVento,
                    "Dir. Vento (m/s): "+medDirVento, "Raj. Vento (m/s): "+medRajVento,
                    "Radiacao (KJ/m²): "+medRadiacao, "Chuva (mm): "+medChuva,
                    "Nebulosidade (Decimos): "+medNebulos, "Insolacao (h): "+medInsolacao};




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