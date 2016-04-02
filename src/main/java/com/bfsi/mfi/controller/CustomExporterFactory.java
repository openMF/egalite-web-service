package com.bfsi.mfi.controller;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.component.export.ExcelExporter;
import org.primefaces.component.export.Exporter.*;
import org.primefaces.component.export.CSVExporter;
import org.primefaces.component.export.Exporter;
import org.primefaces.component.export.ExporterType;
import org.primefaces.component.export.PDFExporter;
import org.primefaces.component.export.ExporterFactory;
import org.primefaces.component.export.XMLExporter;

       
public class CustomExporterFactory  {

	public static Exporter getExporterForType(String type) {
        Exporter exporter = null;
        
        try {
            ExporterType exporterType = ExporterType.valueOf(type.toUpperCase());

            switch(exporterType) {
                case XLS:
                    exporter = new ExcelExporter();
                break;
                
                case PDF:
                    exporter = new PDFExporter();
                break; 
                
                case CSV:
                    exporter = new CSVExporter();
                break; 
                
                case XML:
                    exporter = new XMLExporter();
                break;
            }
        }
        catch(IllegalArgumentException e) {
            throw new FacesException(e);
        } 
        
        return exporter;
	}
}
