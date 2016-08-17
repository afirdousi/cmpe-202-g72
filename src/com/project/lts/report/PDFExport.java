package com.project.lts.report;

import java.util.ArrayList;

public class PDFExport extends ReportExport {

	@Override
	public void exportData(Object[] reportData) {
		System.out.println("Downloading PDF file...");
		System.out.println("report1.pdf file downloaded...");
		System.out.println(reportData);
	}
}
