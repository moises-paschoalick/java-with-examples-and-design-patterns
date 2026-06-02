package design.patterns.adapter.framework;

import design.patterns.adapter.framework.service.DomPdfAdapter;
import design.patterns.adapter.framework.service.PdfAdapter;
import design.patterns.adapter.framework.service.SalesReportGenerator;
import design.patterns.adapter.framework.service.TcPdfAdapter;

import java.io.IOException;

public class TestAdapter {
    public static void main(String[] args) throws IOException {

        //PdfAdapter pdf = new DomPdfAdapter();
        PdfAdapter pdf = new TcPdfAdapter(); // Modifica somente aqui

        SalesReportGenerator salesReportGenerator = new SalesReportGenerator(pdf);
        salesReportGenerator.generate();

        // Classes de baixo nível e classes externas precisam adaptar
        // ao nosso código

        // Um código extremamente testável
        // Usa os princípios SOLID
        // Boas práticas

    }

}
