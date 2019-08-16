/** @version $Id: RemoveSection.java,v 1.5 2015/11/30 14:49:27 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * §2.2.7.
 */
public class RemoveSection extends SectionCommand {
  public RemoveSection(Section sec, Document doc/* FIXME: decls of argument(s) for receiver(s) */) {
    super(MenuEntry.REMOVE_SECTION, sec, doc);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    int id = IO.readInteger(Message.requestSectionId());
    try{
      _receiver2.removeTextElements(_receiver.removeSection(id));
    }
    catch(NoSuchSectionException e){
      IO.println(Message.noSuchSection(id));
  }
 }
}