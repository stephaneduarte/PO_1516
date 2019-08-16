package edt.core;

import java.io.*;

public class Editor{
    
//ATRIBUTOS

    private Document _document = new Document("");
    private String _datafile = "";
    
//CONSTRUTORES
    public Editor(){}
    
//GETTERS E SETTERS
    public void setDataFile(String datafile){
	_datafile = datafile;
    }
    
    public String getDataFile(){
	return _datafile;
    }
    
    public Document getDocument(){
	return _document;
    }
    
    public boolean addAuthor(String name, String email){
	return _document.addAuthor(name, email);
    }
    
    public void NewDocument(){
	_document = new Document();
    }
    
 //METODOS
    public boolean hasAssociatedFile(){
	return (_datafile != "");
    }
    
    public boolean open(String filename){
      try{
	ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
	_document = (Document) ois.readObject();
	ois.close();
	_datafile = filename;
	return true;
      }
      catch(IOException e) {return false;}
      catch(ClassNotFoundException e) {return false;}
    }
    
    public void save(String filename){
      try{
	setDataFile(filename);
	ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
	oos.writeObject(_document);
	oos.close();
      }
      catch(IOException e) {e.printStackTrace();}
    } 
    
    public void importar(String datafile){
	  Section _curSection = new Section();
	  BufferedReader reader = null;
	  try{
	      reader = new BufferedReader(new FileReader(datafile));
	      _document = new Document();
	      _curSection = _document;
	      String line = reader.readLine();
	      if(line != null){
		_document.changeTitle(line);
	      }
	      line = reader.readLine();
	      if (line != null){
	      for (String author : line.split("\\|")){
		    String[] str = author.split("/");
		    _document.addAuthor(str[0], str[1]);
	      }
	      }
	      while ((line = reader.readLine()) != null){
		  String[] content = line.split("\\|");
		  switch(content[0]){
		      case "SECTION": //create new section
			  if (content[1].length() > 0){
			      _curSection = new Section(content[2], content[1]);
			      _document.addSection(_curSection);
			      _document.addTextElement(content[1],_curSection);
			 }
			  else{
			      _curSection = new Section(content[2]);
			      _document.addSection(_curSection);
			 }
			  break;
		     case "PARAGRAPH": //create new paragraph
			  _curSection.addParagraph(content[1]);
			  break;
		     default:
			  System.err.println("Invalid content" + line);
		}
	      }
	  }
	catch(IOException e) {e.printStackTrace();}
	finally{
	    if (reader != null)
	      try{ reader.close();}
	      catch(IOException e) {e.printStackTrace();}
    }
}
}