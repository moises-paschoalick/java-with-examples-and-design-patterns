package design.patterns.adapter.framework.service;

import design.patterns.adapter.framework.lib.DomPdf;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class SalesReportGenerator {

    public void generate() throws IOException {

        // Simula uma lib externa DomPdf
        // Está altamente acoplado com DomPdf
        // Fere o S do SOLID -> Single Responsability Principal
        // Programar para abstrações (interfaces) e não para implementação concretas

        DomPdf domPdf = new DomPdf();
        domPdf.loadHtml("conteúdo do relatório");
        domPdf.setPaper("A4", "landscape");
        domPdf.render();

        String filename = Instant.now().getEpochSecond() + ".pdf";
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(domPdf.output());
        }

        System.out.println("Relatório gerado: " + filename);

    }


}
