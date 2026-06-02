package design.patterns.adapter.framework.service;

public interface PdfAdapter {

    default void generate(String filename, String content) {

    }

}
