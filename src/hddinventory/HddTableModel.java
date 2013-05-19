/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hddinventory;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author linkxs
 */
public class HddTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{"Manufacturer", "Model", "Size", "Form", "Parts"
    };
    private Vector<Hdd> hddData;
//    private Object[][] data = {
//        {"Kathy", "Smith",
//            "Snowboarding", new Integer(5), new Boolean(false)},
//        {"John", "Doe",
//            "Rowing", new Integer(3), new Boolean(true)},
//        {"Sue", "Black",
//            "Knitting", new Integer(2), new Boolean(false)},
//        {"Jane", "White",
//            "Speed reading", new Integer(20), new Boolean(true)},
//        {"Joe", "Brown",
//            "Pool", new Integer(10), new Boolean(false)}
//    };

    public Vector<Hdd> getHddData() {
	return hddData;
    }

    public void setHddData(Vector<Hdd> hddData) {
	this.hddData = hddData;
    }

    public HddTableModel(Vector<Hdd> hddData) {
	this.hddData = hddData;
    }

    @Override
    public int getRowCount() {
	//return data.length;
	return hddData.size();
    }

    @Override
    public int getColumnCount() {
	return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
	//return data[row][col];
	if (columnNames[col].equals("Manufacturer")) {
	    return hddData.get(row).getManufacturer();
	} else if (columnNames[col].equals("Model")) {
	    return hddData.get(row).getModelNum();
	} else if (columnNames[col].equals("Size")) {
	    return hddData.get(row).getSizeGb();
	} else if (columnNames[col].equals(
		"Form")) {
	    return hddData.get(row).getForm();
	} else if (columnNames[col].equals(
		"Parts")) {
	    String total = "";
	    for (String s : hddData.get(row).getPartsPresent()) {
		total = total + ", " + s;
	    }
	    return total.substring(2);
	    //return hddData.get(row).getPartsPresent();
	} else {
	    return null;
	}
    }

    @Override
    public String getColumnName(int col) {
	return columnNames[col];
    }

    @Override
    public Class getColumnClass(int c) {
	return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
	if (col < 2) {
	    return false;
	} else {
	    return true;
	}
    }

    public void setValueAt(Object value, int row, int col) {
	//data[row][col] = value;
	try {
	    if (columnNames[col].equals("Manufacturer")) {
		hddData.get(row).setManufacturer((String) value);
	    } else if (columnNames[col].equals("Model")) {
		hddData.get(row).setModelNum((String) value);
	    } else if (columnNames[col].equals("Size")) {
		hddData.get(row).setSizeGb(Double.parseDouble((String) value));
	    } else if (columnNames[col].equals(
		    "Form")) {
		hddData.get(row).setForm((String) value);
	    } else if (columnNames[col].equals(
		    "Parts")) {
		hddData.get(row).setPartsPresent((String[]) value);
	    } else {
		System.err.println("Else statement reached in HddTableModel.java. Deal with it.");
	    }
	} catch (Exception e) {
	    System.err.println(e.getMessage() + " issue setting table element at HddTableModel.java");
	}

	fireTableCellUpdated(row, col);
    }
}
