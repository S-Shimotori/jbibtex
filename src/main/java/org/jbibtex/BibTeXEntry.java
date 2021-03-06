/*
 * Copyright (c) 2012 University of Tartu
 */
package org.jbibtex;

import java.util.Collections;
import java.util.Map;

public class BibTeXEntry extends BibTeXObject {

	private Key type = null;

	private Key key = null;

	private KeyMap<Value> fields = new KeyMap<Value>();


	public BibTeXEntry(Key type, Key key){
		setType(type);
		setKey(key);
	}

	public BibTeXEntry getCrossReference(){
		Value value = this.fields.get(KEY_CROSSREF);

		CrossReferenceValue crossRefValue = (CrossReferenceValue)value;
		if(crossRefValue != null){
			return crossRefValue.getEntry();
		}

		return null;
	}

	public Value getField(Key key){
		Value value = this.fields.get(key);

		if(value == null){
			BibTeXEntry entry = getCrossReference();

			if(entry != null){
				return entry.getField(key);
			}
		}

		return value;
	}

	public void addField(Key key, Value value){
		this.fields.put(key, value);
	}

	public void addAllFields(Map<Key, Value> fields){
		this.fields.putAll(fields);
	}

	public void removeField(Key key){
		this.fields.remove(key);
	}

	public Key getType(){
		return this.type;
	}

	private void setType(Key type){
		this.type = type;
	}

	public Key getKey(){
		return this.key;
	}

	private void setKey(Key key){
		this.key = key;
	}

	public Map<Key, Value> getFields(){
		return Collections.unmodifiableMap(this.fields);
	}

	public static final Key TYPE_ARTICLE = new Key("article");
	public static final Key TYPE_BOOK = new Key("book");
	public static final Key TYPE_BOOKLET = new Key("booklet");
	public static final Key TYPE_CONFERENCE = new Key("conference");
	public static final Key TYPE_INBOOK = new Key("inbook");
	public static final Key TYPE_INCOLLECTION = new Key("incollection");
	public static final Key TYPE_INPROCEEDINGS = new Key("inproceedings");
	public static final Key TYPE_MANUAL = new Key("manual");
	public static final Key TYPE_MASTERSTHESIS = new Key("mastersthesis");
	public static final Key TYPE_MISC = new Key("misc");
	public static final Key TYPE_PHDTHESIS = new Key("phdthesis");
	public static final Key TYPE_PROCEEDINGS = new Key("proceedings");
	public static final Key TYPE_TECHREPORT = new Key("techreport");
	public static final Key TYPE_UNPUBLISHED = new Key("unpublished");

	public static final Key KEY_ABSTRACT = new Key("abstract");
	public static final Key KEY_ABSTRACT_E = new Key("abstract_e");
	public static final Key KEY_ABSTRACT_100 = new Key("abstract_100");
	public static final Key KEY_ABSTRACT_300 = new Key("abstract_300");
	public static final Key KEY_ABSTRACT_1000 = new Key("abstract_1000");
	public static final Key KEY_ACCEPTANCE = new Key("acceptance");
	public static final Key KEY_ADDRESS = new Key("address");
	public static final Key KEY_ADDRESS_E = new Key("address_e");
	public static final Key KEY_ANNOTE = new Key("annote");
	public static final Key KEY_AUTHOR = new Key("author");
	public static final Key KEY_AUTHOR_E = new Key("author_e");
	public static final Key KEY_AWARD = new Key("award");
	public static final Key KEY_AWARD_E = new Key("award_e");
	public static final Key KEY_BOOKTITLE = new Key("booktitle");
	public static final Key KEY_BOOKTITLE_E = new Key("booktitle_e");
	public static final Key KEY_CHAPTER = new Key("chapter");
	public static final Key KEY_CONFERENCE = new Key("conference");
	public static final Key KEY_CONFERENCE_URL = new Key("conference_url");
	public static final Key KEY_CROSSREF = new Key("crossref");
	public static final Key KEY_DOI = new Key("doi");
	public static final Key KEY_EDITION = new Key("edition");
	public static final Key KEY_EDITOR = new Key("editor");
	public static final Key KEY_EPRINT = new Key("eprint");
	public static final Key KEY_EVENT = new Key("event");
	public static final Key KEY_HOWPUBLISHED = new Key("howpublished");
	public static final Key KEY_INSTITUTION = new Key("institution");
	public static final Key KEY_ISBN = new Key("isbn");
	public static final Key KEY_ISSN = new Key("issn");
	public static final Key KEY_JOURNAL = new Key("journal");
	public static final Key KEY_JOURNAL_E = new Key("journal_e");
	public static final Key KEY_KEY = new Key("key");
	public static final Key KEY_KEYWORDS = new Key("keywords");
	public static final Key KEY_KEYWORDS_E = new Key("keywords_e");
	public static final Key KEY_MONTH = new Key("month");
	public static final Key KEY_NENDO = new Key("nendo");
	public static final Key KEY_NOTE = new Key("note");
	public static final Key KEY_NOTE_E = new Key("note_e");
	public static final Key KEY_NUMBER = new Key("number");
	public static final Key KEY_ORGANIZATION = new Key("organization");
	public static final Key KEY_PAGES = new Key("pages");
	public static final Key KEY_PDF = new Key("pdf");
	public static final Key KEY_PUBLISHER = new Key("publisher");
	public static final Key KEY_SCHOOL = new Key("school");
	public static final Key KEY_SCHOOL_E = new Key("school_e");
	public static final Key KEY_SEEOTHER = new Key("seeother");
	public static final Key KEY_SERIES = new Key("series");
	public static final Key KEY_SLIDESHARE = new Key("slideshare");
	public static final Key KEY_STUDENTID = new Key("studentid");
	public static final Key KEY_TAGS = new Key("tags");
	public static final Key KEY_TITLE = new Key("title");
	public static final Key KEY_TITLE_E = new Key("title_e");
	public static final Key KEY_TRACK = new Key("track");
	public static final Key KEY_TYPE = new Key("type");
	public static final Key KEY_URL = new Key("url");
	public static final Key KEY_URL_E = new Key("url_e");
	public static final Key KEY_VOLUME = new Key("volume");
	public static final Key KEY_YEAR = new Key("year");

}
