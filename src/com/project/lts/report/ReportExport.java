package com.project.lts.report;

import java.util.ArrayList;

public abstract class ReportExport
{
    public void readReportData()
    {
        System.out.println("Reading data....");
    }

    public void formatReportData()
    {
    	System.out.println("Formating the data as per requriements.");
    }

    public abstract void exportData(ArrayList<Object> reportData);        

    //Report Template
    public void exportFormatedData(ArrayList<Object> reportData)
    {
        this.readReportData();
        this.formatReportData();
        this.exportData(reportData);
    }
}
