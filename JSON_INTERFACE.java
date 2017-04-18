package addressbook.demo;

import java.util.List;

public interface JSON_INTERFACE {
	public void makeData(PERSON_LIST tree);
	public void getData(PERSON_LIST tree);
	public List<RECENTS> getData();
}
