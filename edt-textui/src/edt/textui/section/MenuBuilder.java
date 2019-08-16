/** @version $Id: MenuBuilder.java,v 1.5 2015/11/28 20:01:27 ist181186 Exp $ */
package edt.textui.section;

import ist.po.ui.Command;
import ist.po.ui.Menu;

import edt.core.*;

/**
 * Menu builder for search operations.
 */
public class MenuBuilder {
  public static void menuFor(Section sec, Document doc) { //NAO SEI SE É SECÇÃO
    Menu menu = new Menu(MenuEntry.TITLE,
        new Command<?>[] { //
            new ChangeTitle(sec, doc), //NEM AQUI
            new ListSections(sec, doc), //
            new ShowContent(sec, doc), //
            new SelectSection(sec, doc), //
            new InsertSection(sec, doc), //
            new NameSection(sec, doc), //
            new RemoveSection(sec, doc), //
            new InsertParagraph(sec, doc), //
            new NameParagraph(sec, doc), //
            new EditParagraph(sec, doc), //
            new RemoveParagraph(sec, doc), //
    });
    menu.open();
  }
}
