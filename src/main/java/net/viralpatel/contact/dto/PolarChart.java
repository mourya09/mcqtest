/**
 * 
 */
package net.viralpatel.contact.dto;

/**
 * @author nex6uyu
 * 
 */
public class PolarChart extends MasterChart {

	@Override
	public String getJson() {
		if (super.getData() == null || super.getData().length == 0) {
			return "{}";
		}
		return super.toString();
	}

}
