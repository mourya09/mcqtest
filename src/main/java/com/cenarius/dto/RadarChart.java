/**
 * 
 */
package com.cenarius.dto;

import com.google.gson.Gson;

/**
 * @author nex6uyu
 * 
 */
public class RadarChart {
	private String[] labels;
	private PreciseDataSet[] datasets;

	/**
	 * @return the labels
	 */
	public String[] getLabels() {
		return labels;
	}

	/**
	 * @param labels
	 *            the labels to set
	 */
	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	/**
	 * @return the datasets
	 */
	public PreciseDataSet[] getDatasets() {
		return datasets;
	}

	/**
	 * @param datasets
	 *            the datasets to set
	 */
	public void setDatasets(PreciseDataSet[] datasets) {
		this.datasets = datasets;
	}

	public String toString() {

		Gson gson = new Gson();
		return gson.toJson(this, RadarChart.class);
	}
}
