package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;

public class ListSectionVisitor implements Visitor{
      
      public String visitSection(Section section){
	    String _content = "";
	    try{
	    for (int i = 0; i < section.getSubsections().size() ; i++){
		Section sec = section.selectSection(i);
		String _id = sec.getID();
		String _title = sec.getTitle();
		_content += "[" + _id + "] {" + _title + "}\n" + sec.accept(this);
	    }
	    }
	    
	    catch(NoSuchSectionException e){} //This exception will never occur but has to be treated.
	    
	    finally{
		return _content;
	    }
      }
      
      public String visitParagraph(Paragraph paragraph){
	    String _content = "";
	    return _content;
      }
      
      public String visitDocument(Document document){
	    String _content = "";
	    try{
	    for (int i = 0; i < document.getSubsections().size() ; i++){
		Section sec = document.selectSection(i);
		String _id = sec.getID();
		String _title = sec.getTitle();
		_content += "[" + _id + "] {" + _title + "}\n" + sec.accept(this);
	    }
	    }
	    
	    catch(NoSuchSectionException e){} //This exception will never occur but has to be treated.
	    
	    finally{
		return _content;
	    }
      }

}