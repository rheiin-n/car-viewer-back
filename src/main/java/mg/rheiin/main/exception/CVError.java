package mg.rheiin.main.exception;

import java.util.ArrayList;
import java.util.List;

import mg.rheiin.main.decorator.Responsable;

public class CVError implements Responsable {
	
	private List<String> contents = new ArrayList<String>();
	
	public CVError() {}
	
	public CVError(List<String> contents) {
		this.contents = contents;
	}

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}
}
