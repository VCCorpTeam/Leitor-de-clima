package com.example.leitorclima.Utils;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import javafx.stage.FileChooser;

import java.io.File;

public class GeraPdfUtil {
    public static File geraPdf(String cidadePdf, String dataInicial, String dataFinal, Float medTemp, Float medTempIns, Float medUmi, Float medUmiIns, Float medPtoOrvalho, Float medPtoOrvalhoIns, Float medPressao, Float medPressaoIns, Float medVelVento, Float medDirVento, Float medRajVento, Float medRadiacao, Float medChuva, Float medNebulos, Float medInsolacao) {
        String cidade = cidadePdf;
        String periodo = dataInicial + " - " + dataFinal;

        try {
            //Abre um seletor de arquivo para o usuário escolher o local
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName("relatorio_" + cidade + ".pdf");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            File file = fileChooser.showSaveDialog(null);

            //Se o usuário cancelar, retornar null
            if (file == null) {
                return null;
            }

            //Cria um novo documento PDF
            PdfWriter writer = new PdfWriter(file);
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

            System.out.println("PDF gerado com sucesso em: " + file.getAbsolutePath());
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
