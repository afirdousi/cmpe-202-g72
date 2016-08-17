package com.project.lts.report;

import java.util.ArrayList;
import java.util.Scanner;

public class Report {
	
	public enum REPORTTYPE {
		MEMBER,
		RIDE,
		MY_RIDE,
		PAYMENT_HISTORY,
		LOCATION
	}
	
	private ReportExport exporter;
	Scanner scan = new Scanner(System.in);
	int exportChoice;
	
	public Report(){
		
	}
	
	public void generateReport(REPORTTYPE type, int reportFormat, Object[] reportData){
		
		String format = reportFormat==1?"Excel Format":"PDF Format";
		
		switch(type){
			case RIDE:generateRideReport(format,reportData);break;
			case PAYMENT_HISTORY:generatePaymentHistoryReport(format,reportData);break;
			case MEMBER:generateMemberReport(format,reportData);break;
			case MY_RIDE:generateMyRideReport(format,reportData);break;
			case LOCATION:generateLocationReport(format,reportData);break;
		default:
			break;
		
		}
	}
	
	public void generateMemberReport(String reportFormat,Object[] reportData){
		System.out.println("Generating Member Report : " + reportFormat);
		System.out.println("*************************");
		
		if(reportFormat.contains("Excel")){
			exportToExcel(reportData);
		}else{
			exportToPDF(reportData);
		}
	}

	public void generateRideReport(String reportFormat,Object[] reportData){
		System.out.println("Generating Ride Report : " + reportFormat);
		System.out.println("*************************");
		
		if(reportFormat.contains("Excel")){
			exportToExcel(reportData);
		}else{
			exportToPDF(reportData);
		}
		
	}
	
	public void generateMyRideReport(String reportFormat,Object[] reportData){
		System.out.println("Generating My Ride Report : " + reportFormat);
		System.out.println("*************************");
		
		if(reportFormat.contains("Excel")){
			exportToExcel(reportData);
		}else{
			exportToPDF(reportData);
		}
		
	}
	
	public void generatePaymentHistoryReport(String reportFormat,Object[] reportData){
		System.out.println("Generating Payment History Report : " + reportFormat);
		System.out.println("*************************");
		
		if(reportFormat.contains("Excel")){
			exportToExcel(reportData);
		}else{
			exportToPDF(reportData);
		}
	}
	
	public void generateLocationReport(String reportFormat,Object[] reportData){
		System.out.println("Generating Location Report : " + reportFormat);
		System.out.println("*************************");
		
		if(reportFormat.contains("Excel")){
			exportToExcel(reportData);
		}else{
			exportToPDF(reportData);
		}
	}
	
	public void exportToExcel(Object[] reportData){
		this.exporter = new ExcelExport();
		this.exporter.exportFormatedData(reportData);
	}
	
	public void exportToPDF(Object[] reportData){
		this.exporter = new PDFExport();
		this.exporter.exportFormatedData(reportData);
	}
	
	
}
