/**
 * 
 */
package com.cenarius.dto;

import com.google.gson.Gson;

/**
 * @author nex6uyu
 *
 */
public class BarChart {
	private String[] labels;
	private DataSet[] datasets;
	/**
	 * @return the labels
	 */
	public String[] getLabels() {
		return labels;
	}
	/**
	 * @param labels the labels to set
	 */
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	/**
	 * @return the datasets
	 */
	public DataSet[] getDatasets() {
		return datasets;
	}
	/**
	 * @param datasets the datasets to set
	 */
	public void setDatasets(DataSet[] datasets) {
		this.datasets = datasets;
	}
	
	public String toString()
	{
		
		Gson gson = new Gson();
		return gson.toJson(this, BarChart.class);
	}
	
}
