package design.patterns.adapter.framework.service;

import design.patterns.adapter.framework.lib.DomPdf;
import design.patterns.adapter.framework.lib.TCPDF;

import java.io.FileWriter;
import java.io.IOException;

public class TcPdfAdapter implements PdfAdapter {

    @Override
    public void generate(String filename, String content) {

        TCPDF tcPdf = new TCPDF();
        tcPdf.AddPage();
        tcPdf.setFont("helvetica",10);
        tcPdf.write(content);

        System.out.println("Relatório gerado: " + filename);
    }
}
