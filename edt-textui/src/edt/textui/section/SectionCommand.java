/** @version $Id: SectionCommand.java,v 1.3 2015/11/28 20:01:27 ist181186 Exp $ */
package edt.textui.section;

import ist.po.ui.Command;

/* FIXME: import core classes here */

import edt.core.*;

/**
 * Superclass of all section-context commands.
 */
public abstract class SectionCommand extends Command<Section> {
  
    protected Document _receiver2;
    
	public SectionCommand(String title, Section receiver, Document receiver2) {
		super(title, receiver);
		_receiver2 = receiver2;
	}

}
