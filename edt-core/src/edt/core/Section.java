package edt.core;

 import java.io.Serializable;
 import java.util.List;
 import java.util.ArrayList;
 
 public class Section extends TextElement implements Serializable{
 
    //ATRIBUTOS
    
    /* Title of the section. */
     private String _title = "";
     /* Paragraphs of the section. */
     private List<Paragraph> _paragraphs = new ArrayList<Paragraph>();
     /* Subsections of the section. */
     private List<Section> _subsections = new ArrayList<Section>();
     
     //CONSTRUTOR
      /*Inicialize a Section.
      */
     public Section(){
     }
     
     /*Inicialize a Section with a title.
      * 
      * @param title
      *              title of the section.
      */
     public Section(String title){
	_title = title;
     }
     
    public Section(String title, String id){
	super(id);
	_title = title;
    }
    
     /*Change the section title.
  * 
  * @param title
  * 		title of the section.
  */
     public void changeTitle(String title){
	_title = title;
     }
     
     /*Get the section title.
      *
      *@return a title.
      */
     public String getTitle(){
	 return _title;
     }
     
     /*Get a list of paragraphs.
      * 
      * @return paragraphs of the section.
      */
     public List getParagraphs(){
	  return _paragraphs;
    }
    
    /*Get a list of Subsections.
      * 
      * @return subsections of the section.
      */
    public List getSubsections(){
	  return _subsections;
    }
    
    public ArrayList getSubsectionsInfo(){
	  ArrayList<ArrayList> _listSections = new ArrayList<ArrayList>();
	  for(Section section : _subsections){
		      ArrayList<String> _sectioninfo = new ArrayList<String>();
		      _sectioninfo.add(section.getID());
		      _sectioninfo.add(section.getTitle());
		      _listSections.add(_sectioninfo);
	}
	return _listSections;
    }
    
     /*Set the section ID.
      *
      *@param id
      *		a section id.
      */
     public void setID(String id){
	 super.setID(id);
     }
     
     /*Calculate the dimension of a section.
      *
      *@return dim
      *		the dimension of the section.
      */
     
     public int calcDimension(){
	int dim = 0;
	dim += _title.length();
	if (!_subsections.isEmpty()){
	    for (Section s : _subsections)
		dim += s.calcDimension();
	}
	if (!_paragraphs.isEmpty()){
	    for (Paragraph p : _paragraphs)
		dim += (p.getContent()).length();
	}
	return dim;
      }
     
      /*Name a section.
      *
      *@param id
      *		an id of a section.
      */
     public void nameSection(String id){
	  super.setID(id);
     }
     
      /*Remove section through an ID.
      *
      *@param id
      *		an id of a section.
      */
     public void removeSection(String id){
	for (Section i : _subsections){
	    if (i.getID() == id){
		_subsections.remove(i);
	    }
	}
     }
     
        /*Add a subsection.
      *
      *@param title
      *		the title of the subsection.
      *@param id
      *		the id of the subsection.
      */
     public void addSection(String title, String id){
	  Section section = new Section(title);
	  section.setID(id);
	  _subsections.add(section);
    }
     
      
     /*Add a subsection.
      *
      *@param section
      *		subsection that will be add.
      */
     public void addSection(Section section){
	 _subsections.add(section);
     }
     
      /*Add a subsection.
      *
      *@param section
      *		subsection that will be add.
      *@param id
      *		the id of the subsection.
      */
     public void addSection(Section section, String id){
	 section.setID(id);
	 _subsections.add(section);
     }
     
      public void insertSection(String title, int i){
	 Section section = new Section(title);
	 if( i > -1 && i < _subsections.size() ) 
	      _subsections.add(i, section);
	 else
	      _subsections.add(section);
     }
     
      /*Count the number of sections.
      *
      *@return cont
      *		the number of sections.
      */
     public int getNumSections(){
	int cont = 0;
	for (Section section : _subsections){
	    cont++;
	}
	return cont;
    }
     
       /*Select a section.
      *
      *@param id
      *		the id of the subsection.
      *@return i
      *		the section.
      */
     public Section selectSection(int i) throws NoSuchSectionException{
	if (i > -1 && i < _subsections.size())
	    return (_subsections.get(i));
	else
	    throw new NoSuchSectionException();
    }
    
    public Paragraph selectParagraph(int i) throws NoSuchParagraphException{
	if (i > -1 && i < _paragraphs.size())
	    return (_paragraphs.get(i));
	else	
	    throw new NoSuchParagraphException();
    }
    
    /*Add a paragraph.
      *
      *@param content
      *		the content of the paragraph.
      */
    public void addParagraph(String content){
	Paragraph paragraph = new Paragraph(content);
	_paragraphs.add(paragraph);
    }
    
    public void insertParagraph(String content, int i){
	 Paragraph paragraph = new Paragraph(content);
	 if( i > -1 && i < _paragraphs.size() ) 
	      _paragraphs.add(i, paragraph);
	 else
	      _paragraphs.add(paragraph);
     }
    
    
   public String removeParagraph(int i) throws NoSuchParagraphException{
	if (i > -1 && i < _paragraphs.size()){
	    Paragraph paragraph = _paragraphs.remove(i);
	    return paragraph.getID();
	}
	else{
	    throw new NoSuchParagraphException();
	}
    }
    
    public void changeParagraphContent(int i, String content) throws NoSuchParagraphException{
	 Paragraph paragraph = selectParagraph(i);
	 paragraph.editParagraph(content);
    }
    
    public Section changeSection(int id_local, String id_uniq){
	  Section _subsection = _subsections.remove(id_local);
	  _subsection.setID(id_uniq);
	  _subsections.add(id_local, _subsection);
	  return _subsection;
    }
    
    public ArrayList cleanThis(){
	   _title = "";
	   ArrayList<String> _ids = new ArrayList<String>();
	   while(!_subsections.isEmpty()){
		Section s = _subsections.get(0);
		_ids.addAll(s.getAffectedIds());
		_subsections.remove(0);
	  }
	   if(!_paragraphs.isEmpty()){
		for (int i = 0; i < _paragraphs.size(); i++){
			Paragraph paragraph = _paragraphs.get(i);
			_ids.add(paragraph.getID());
			_paragraphs.remove(i);
		}
	  }
	   return _ids;
    }
    
    public ArrayList removeSection(int id) throws NoSuchSectionException{
		Section _section = selectSection(id);
		ArrayList _ids = _section.getAffectedIds();
		_subsections.remove(id);
		return _section.getAffectedIds();
    }
    
    public ArrayList getAffectedIds(){
	   ArrayList<String> _ids = new ArrayList<String>();
	   if(!_subsections.isEmpty()){
		for (Section s : _subsections)
			_ids.addAll(s.getAffectedIds());
		}
	   if(!_paragraphs.isEmpty()){
		for (Paragraph p : _paragraphs)
			_ids.add(p.getID());
		}
	   _ids.add(this.getID());
	   return _ids;
    }
    
    public String accept(Visitor v){
	  return v.visitSection(this);
    }
}