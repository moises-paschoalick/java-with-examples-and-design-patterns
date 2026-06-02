package design.patterns.adapter.framework.lib;

/**
 * Simula a biblioteca externa TCPDF.
 * Representa o "Adaptee" no padrão Adapter — a classe que tem
 * a interface incompatível com o nosso sistema.
 */
public class TCPDF {

    private String fontName;
    private Integer fontSize;
    private String content;

    public void AddPage() {
    }

    public void setFont(String fontName, Integer fontSize) {
        this.fontName = fontName;
        this.fontSize = fontSize;
        System.out.println("[TCPDF] configurado: " + fontName + " / " + fontSize);
    }

    public void write(String content) {
        System.out.println("[TCPDF] Conteúdo:\n" +
                "-----------------------------\n" +
                content + "\n" +
                "-----------------------------\n" +
                "Renderização concluída.");
    }

}