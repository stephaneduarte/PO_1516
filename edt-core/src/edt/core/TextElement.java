package edt.core;

import java.io.Serializable;

public abstract class TextElement implements Serializable{

//ATRIBUTOS
    private String _id = "";
    
//CONSTRUTORES
    public TextElement() {}
    
    public TextElement(String id){
	_id = id;
    }

//GETTERS E SETTERS
    public String getID(){
	return _id;
    }
    
    public void setID(String id){
	_id = id;
    }
    
//MÉTODOS

    public abstract String accept(Visitor v);
    
}
