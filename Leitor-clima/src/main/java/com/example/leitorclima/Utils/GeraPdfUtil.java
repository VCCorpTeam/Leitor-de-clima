package com.example.leitorclima.Utils;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import java.io.File;
import java.util.ArrayList;

public class GeraPdfUtil {
    public static void geraPdf() {
        String filePath = "output.pdf";

        try {
            // Cria um novo documento PDF
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);

            // Cria um documento iText
            Document document = new Document(pdf);

            // Adiciona título
            Paragraph title = new Paragraph("Exemplo de PDF com iText");
            title.setFontSize(20);
            title.setBold();
            title.setFontColor(new DeviceRgb(0, 0, 255)); // Cor azul
            document.add(title);

            // Adiciona parágrafo
            Paragraph paragraph = new Paragraph("Este é um parágrafo de exemplo para demonstrar a geração de PDF com iText.");
            paragraph.setFontSize(12);
            document.add(paragraph);

            // Cria uma lista numerada usando ArrayList
            ArrayList<ListItem> items = new ArrayList<>();
            items.add(new ListItem("Item 1"));
            items.add(new ListItem("Item 2"));
            items.add(new ListItem("Item 3"));

            // Adiciona os itens à lista do documento
            for (ListItem item : items) {
                document.add(item);
            }

            // Fecha o documento
            document.close();

            System.out.println("PDF gerado com sucesso em: " + new File(filePath).getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}