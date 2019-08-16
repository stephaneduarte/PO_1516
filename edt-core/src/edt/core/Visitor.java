package edt.core;

public interface Visitor{
      public String visitSection(Section section);
      public String visitParagraph(Paragraph paragraph);
      public String visitDocument(Document document);
}