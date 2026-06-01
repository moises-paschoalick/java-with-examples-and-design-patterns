package design.patterns.adapter.framework;

import design.patterns.adapter.framework.service.SalesReportGenerator;

import java.io.IOException;

public class TestAdapter {
    public static void main(String[] args) throws IOException {
        new SalesReportGenerator().generate();
    }

}
