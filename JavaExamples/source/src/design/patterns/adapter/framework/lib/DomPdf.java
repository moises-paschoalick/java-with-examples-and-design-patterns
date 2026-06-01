package design.patterns.adapter.framework.lib;

/**
 * Simula a biblioteca externa DomPdf.
 * Representa o "Adaptee" no padrão Adapter — a classe que tem
 * a interface incompatível com o nosso sistema.
 */
public class DomPdf {

    private String htmlContent;
    private String paperSize;
    private String paperOrientation;
    private String renderedOutput;

    public void loadHtml(String html) {
        this.htmlContent = html;
        System.out.println("[DomPdf] HTML carregado: " + html);
    }

    public void setPaper(String size, String orientation) {
        this.paperSize = size;
        this.paperOrientation = orientation;
        System.out.println("[DomPdf] Papel configurado: " + size + " / " + orientation);
    }

    public void render() {
        this.renderedOutput = "<<PDF_BYTES[" + paperSize + "-" + paperOrientation + "]: " + htmlContent + ">>";
        System.out.println("[DomPdf] Renderização concluída.");
    }

    public String output() {
        if (renderedOutput == null) {
            throw new IllegalStateException("Chame render() antes de output().");
        }
        return renderedOutput;
    }
}