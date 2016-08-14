package com.project.lts.report;

import java.util.ArrayList;

public class ExcelExport extends ReportExport {

	@Override
	public void exportData(ArrayList<Object> reportData) {
		System.out.println("Downloading excel file...");
		System.out.println("Excel file downloaded...");
	}
}
