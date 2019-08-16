package edt.textui;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;
import edt.textui.main.Message;

import java.io.IOException;

import edt.core.*;

public class ContentVisitor implements Visitor{
      
      public String visitSection(Section section){
	  String _content = "";
	  String _id = section.getID();
	  String _title = section.getTitle();
	  _content += Message.sectionIndexEntry(_id,_title) + "\n";
	  _content += getParagraphsContent(section) + getSectionContent(section);
	  return _content;
      }
      
      public String visitParagraph(Paragraph paragraph){
	  return paragraph.getContent() + "\n";
      }
      
      public String visitDocument(Document document){
	  String _content = "";
	  _content += "{" + document.getTitle() + "}\n" + getParagraphsContent(document) + getSectionContent(document);
	  return _content;
      }
      
      public String getSectionContent(Section section){
	String _content = "";
	try{
	    for (int i = 0; i < section.getSubsections().size() ; i++){
		Section sec = section.selectSection(i);
		_content += sec.accept(this);
	    }
	   }
	catch(NoSuchSectionException e){} //This exceptions will never occur but have to be treated.
	finally{
	    return _content;
	}
	}
	
	public String getParagraphsContent(Section section){
	    String _content = "";
	    try{
	    for (int i = 0; i < section.getParagraphs().size(); i++){
		Paragraph par = section.selectParagraph(i);
		_content += par.accept(this);
	    }
	    }
	    catch(NoSuchParagraphException e){}
	    finally{
		return _content;
	    }
	}

}