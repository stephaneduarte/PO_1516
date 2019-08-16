/** @version $Id: ShowTextElement.java,v 1.5 2015/11/30 01:40:06 ist181186 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;
import edt.textui.*;

/**
 * §2.1.5.
 */
public class ShowTextElement extends Command<Editor> {
  public ShowTextElement(Editor editor) {
    super(MenuEntry.SHOW_TEXT_ELEMENT, editor);
  }

  @Override
  public final void execute() throws DialogException, IOException {
	 String id = IO.readString(Message.requestElementId());
	 Visitor v = new ContentVisitor();
	 try{
	    String _content = ((_receiver.getDocument()).getTextElement(id)).accept(v);
	    IO.println(_content.substring(0, _content.length() - 1));
	 }
	 catch(NoSuchTextElementException e){
	    IO.println(Message.noSuchTextElement(id));
	 }
	 catch(StringIndexOutOfBoundsException e){}
  }
}
