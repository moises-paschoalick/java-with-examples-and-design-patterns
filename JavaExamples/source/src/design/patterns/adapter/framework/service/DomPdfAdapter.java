package design.patterns.adapter.framework.service;

import design.patterns.adapter.framework.lib.DomPdf;

import java.io.FileWriter;
import java.io.IOException;

// Classe sempre dempender de abstrações
public class DomPdfAdapter implements PdfAdapter {

    @Override
    public void generate(String filename, String content) {

        DomPdf domPdf = new DomPdf();
        domPdf.loadHtml(content);
        domPdf.setPaper("A4", "landscape");
        domPdf.render();

        //String filename = Instant.now().getEpochSecond() + ".pdf";
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(domPdf.output());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Relatório gerado: " + filename);
    }
}
