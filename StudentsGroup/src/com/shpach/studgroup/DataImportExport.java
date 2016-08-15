package com.shpach.studgroup;

import java.io.IOException;

public  interface DataImportExport {
	
	ClassGroup importGroup() throws IOException, Exception;
	void exportGroup(ClassGroup group) throws IOException;
	
}
