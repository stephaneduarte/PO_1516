package edt.core;

import java.io.Serializable;

public class Paragraph extends TextElement implements Serializable{
    
//ATRIBUTOS
    private String _content;
    
//CONSTRUTORES
    public Paragraph(String content){
	_content = content;
    }
    
//GETTERS E SETTERS
    public void nameParagraph(String id){
	super.setID(id);
    }
    
    public String getContent(){
	return _content;
    }
    
    public void editParagraph(String content){
	_content = content;
    }
    
//MÉTODOS
    public String accept(Visitor v){
	  return v.visitParagraph(this);
    }
    
}