package edt.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Document extends Section{
      
//ATRIBUTOS
      private int _dimension;
      private TreeMap<String,Author> _authors = new TreeMap<String,Author>();
      private TreeMap<String,TextElement> _textelements = new TreeMap<String,TextElement>();
      
//CONSTRUTORES
      public Document(String title){
	  super(title);
      }
      
      public Document(){
	  super();
      }
      
//GETTERS E SETTERS
      public boolean addAuthor(String name, String email){
	  if (_authors.get(name) == null){
	    Author author = new Author(name, email);
	    _authors.put(name,author);
	    return false;
	  }
	  return true;
      }
      
      public String countAuthors(){
	  return "" + _authors.size();
      }
      
      public void addTextElement(String id, Section section){
	  _textelements.put(id,section);
      }

      public TextElement getTextElement(String id) throws NoSuchTextElementException{
	  if (_textelements.get(id) != null)
	    return _textelements.get(id);
	  else
	     throw new NoSuchTextElementException();
      }
      
     public ArrayList getAuthorsInfo(){
	  ArrayList<ArrayList> _listAuthors = new ArrayList<ArrayList>();
	  for(Map.Entry<String,Author> entry : _authors.entrySet()){
		      ArrayList<String> _authorinfo = new ArrayList<String>();
		      Author author = entry.getValue();
		      _authorinfo.add(author.getName());
		      _authorinfo.add(author.getEmail());
		      _listAuthors.add(_authorinfo);
	}
	return _listAuthors;
    }
		      

//METODOS

      public boolean changeTextElement(String id_uniq, TextElement textelement){
	    boolean hasName = false;
	    TextElement telement = _textelements.get(id_uniq);
	    if (telement != null){
		  telement.setID("");
	    }
	    String curID = textelement.getID();
	    if (!(curID.equals(""))){
		  hasName = true;
		  _textelements.remove(curID);
	    }
	    textelement.setID(id_uniq);
	    _textelements.put(id_uniq, textelement);
	    return hasName;
      }
      
      public int calcIDs(){
	    return _textelements.size();
      }
      
      public void removeId(String id){
	    _textelements.remove(id);
      }
      
      public void removeAuthors(){
	    for(Map.Entry<String,Author> entry : _authors.entrySet()){
		String key = entry.getKey();
		_authors.remove(key);
	    }
      }
      
      public void removeTextElements(ArrayList<String> textelements){
	for (String id : textelements)
	   _textelements.remove(id);
      }
      
      public String accept(Visitor v){
	  return v.visitDocument(this);
      }
 }
 