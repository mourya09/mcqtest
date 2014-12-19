/**
 * 
 */
package com.cenarius.dto;

import java.io.Serializable;

/**
 * @author nex6uyu
 * 
 */
public class DataSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8095515692074997927L;

	private String fillColor;

	private String strokeColor;

	private String highlightFill;

	private String highlightStroke;

	private int[] data;

	/**
	 * @return the fillColor
	 */
	public String getFillColor() {
		return fillColor;
	}

	/**
	 * @param fillColor
	 *            the fillColor to set
	 */
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	/**
	 * @return the strokeColor
	 */
	public String getStrokeColor() {
		return strokeColor;
	}

	/**
	 * @param strokeColor
	 *            the strokeColor to set
	 */
	public void setStrokeColor(String strokeColor) {
		this.strokeColor = strokeColor;
	}

	/**
	 * @return the highlightFill
	 */
	public String getHighlightFill() {
		return highlightFill;
	}

	/**
	 * @param highlightFill
	 *            the highlightFill to set
	 */
	public void setHighlightFill(String highlightFill) {
		this.highlightFill = highlightFill;
	}

	/**
	 * @return the highlightStroke
	 */
	public String getHighlightStroke() {
		return highlightStroke;
	}

	/**
	 * @param highlightStroke
	 *            the highlightStroke to set
	 */
	public void setHighlightStroke(String highlightStroke) {
		this.highlightStroke = highlightStroke;
	}

	/**
	 * @return the data
	 */
	public int[] getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(int[] data) {
		this.data = data;
	}
}
