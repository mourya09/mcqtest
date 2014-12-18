/**
 * 
 */
package net.viralpatel.contact.dto;

/**
 * @author nex6uyu
 * 
 */
public class PreciseDataSet {
	private String label;
	private String fillColor;
	private String strokeColor;
	private String pointColor;
	private String pointStrokeColor = "#fff";
	private String pointHighlightFill = "#fff";
	private String pointHighlightStroke;

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
	 * @return the pointColor
	 */
	public String getPointColor() {
		return pointColor;
	}

	/**
	 * @param pointColor
	 *            the pointColor to set
	 */
	public void setPointColor(String pointColor) {
		this.pointColor = pointColor;
	}

	/**
	 * @return the pointStrokeColor
	 */
	public String getPointStrokeColor() {
		return pointStrokeColor;
	}

	/**
	 * @param pointStrokeColor
	 *            the pointStrokeColor to set
	 */
	public void setPointStrokeColor(String pointStrokeColor) {
		this.pointStrokeColor = pointStrokeColor;
	}

	/**
	 * @return the pointHighlightFill
	 */
	public String getPointHighlightFill() {
		return pointHighlightFill;
	}

	/**
	 * @param pointHighlightFill
	 *            the pointHighlightFill to set
	 */
	public void setPointHighlightFill(String pointHighlightFill) {
		this.pointHighlightFill = pointHighlightFill;
	}

	/**
	 * @return the pointHighlightStroke
	 */
	public String getPointHighlightStroke() {
		return pointHighlightStroke;
	}

	/**
	 * @param pointHighlightStroke
	 *            the pointHighlightStroke to set
	 */
	public void setPointHighlightStroke(String pointHighlightStroke) {
		this.pointHighlightStroke = pointHighlightStroke;
	}

}
