package com.project.lts.report;

import java.util.ArrayList;

public class ExcelExport extends ReportExport {

	@Override
	public void exportData(Object[] reportData) {
		System.out.println("Downloading excel file...");
		System.out.println("report1.xls file downloaded...");
		System.out.println(reportData);
		
	}
}
