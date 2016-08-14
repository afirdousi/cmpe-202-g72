package com.project.lts.report;

import java.util.ArrayList;
import java.util.Scanner;

public class Report {
	
	private enum REPORTTYPE {
		RIDE,
		PAYMENT_HISTORY,
		MEMBER
	}
	
	private ReportExport exporter;
	Scanner scan = new Scanner(System.in);
	int exportChoice;
	
	public Report(){
		
	}
	
	public void generateReport(REPORTTYPE type,ArrayList<Object> reportData){
		
		switch(type){
			case RIDE:generateRideReport(reportData);break;
			case PAYMENT_HISTORY:generatePaymentHistoryReport(reportData);break;
			case MEMBER:generateMemberReport(reportData);break;
		default:
			break;
		
		}
	}
	
	public void generateRideReport(ArrayList<Object> reportData){
		//TODO: Print report here
		
		//TODO: Export (Prompt user)
		exportChoice = Integer.parseInt(scan.nextLine());
		
	}
	
	public void generatePaymentHistoryReport(ArrayList<Object> reportData){
		//TODO: Print report here
		
		//TODO: Export (Prompt user)
		exportChoice = Integer.parseInt(scan.nextLine());
	}
	
	public void generateMemberReport(ArrayList<Object> reportData){
		//TODO: Print report here
		
		//TODO: Export (Prompt user)
		exportChoice = Integer.parseInt(scan.nextLine());
	}
	
	public void exportToExcel(ArrayList<Object> reportData){
		this.exporter = new ExcelExport();
		this.exporter.exportFormatedData(reportData);
	}
	
	public void exportToPDF(ArrayList<Object> reportData){
		this.exporter = new PDFExport();
		this.exporter.exportFormatedData(reportData);
	}
	
	
}
