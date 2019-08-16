/** @version $Id: TextEditor.java,v 1.5 2015/11/16 11:54:29 ist181186 Exp $ */
package edt.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;

import edt.core.*;

/**
 * Class that starts the application's textual interface.
 */
public class TextEditor {
	public static void main(String[] args) {
		Editor editor = new Editor();
		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			editor.importar(datafile);
		}
		edt.textui.main.MenuBuilder.menuFor(editor);
		IO.closeDown();
	}
}
