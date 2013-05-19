/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hddinventory;

import java.io.Serializable;

/**
 *
 * @author linkxs
 */
public class Hdd implements Serializable {
    private String manufacturer;
    private String modelNum;
    private String serialNum;
    private String partNum;
    private String pcbNum;
    private String dateNum;
    private String series;
    //
    private String form;
    private String iface;
    private String notes;
    private String owner;
    //
    private double sizeGb;
    private String[] partsPresent;
    private boolean works;

    public Hdd(String manufacturer, String modelNum, String serialNum, String partNum, String pcbNum, String dateNum, String series, String form, String iface, String notes, String owner, double sizeGb, String[] partsPresent, boolean works) {
	this.manufacturer = manufacturer;
	this.modelNum = modelNum;
	this.serialNum = serialNum;
	this.partNum = partNum;
	this.pcbNum = pcbNum;
	this.dateNum = dateNum;
	this.series = series;
	this.form = form;
	this.iface = iface;
	this.notes = notes;
	this.owner = owner;
	this.sizeGb = sizeGb;
	this.partsPresent = partsPresent;
	this.works = works;
    }

    public String getOwner() {
	return owner;
    }

    public void setOwner(String owner) {
	this.owner = owner;
    }

    public String getSeries() {
	return series;
    }

    public void setSeries(String series) {
	this.series = series;
    }

    public String getManufacturer() {
	return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public String getModelNum() {
	return modelNum;
    }

    public void setModelNum(String modelNum) {
	this.modelNum = modelNum;
    }

    public String getSerialNum() {
	return serialNum;
    }

    public void setSerialNum(String serialNum) {
	this.serialNum = serialNum;
    }

    public String getPartNum() {
	return partNum;
    }

    public void setPartNum(String partNum) {
	this.partNum = partNum;
    }

    public String getPcbNum() {
	return pcbNum;
    }

    public void setPcbNum(String pcbNum) {
	this.pcbNum = pcbNum;
    }

    public String getDateNum() {
	return dateNum;
    }

    public void setDateNum(String dateNum) {
	this.dateNum = dateNum;
    }

    public String getForm() {
	return form;
    }

    public void setForm(String form) {
	this.form = form;
    }

    public String getIface() {
	return iface;
    }

    public void setIface(String iface) {
	this.iface = iface;
    }

    public String getNotes() {
	return notes;
    }

    public void setNotes(String notes) {
	this.notes = notes;
    }

    public double getSizeGb() {
	return sizeGb;
    }

    public void setSizeGb(double sizeGb) {
	this.sizeGb = sizeGb;
    }

    public String[] getPartsPresent() {
	return partsPresent;
    }

    public void setPartsPresent(String[] partsPresent) {
	this.partsPresent = partsPresent;
    }

    public boolean isWorks() {
	return works;
    }

    public void setWorks(boolean works) {
	this.works = works;
    }
}
