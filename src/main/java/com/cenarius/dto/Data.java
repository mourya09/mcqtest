/**
 * 
 */
package com.cenarius.dto;

import java.io.Serializable;

/**
 * @author nex6uyu
 * 
 */
public class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8122217077154118515L;

	private Integer value;
	private String color;
	private String highlight;
	private String label;

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the highlight
	 */
	public String getHighlight() {
		return highlight;
	}

	/**
	 * @param highlight
	 *            the highlight to set
	 */
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}
