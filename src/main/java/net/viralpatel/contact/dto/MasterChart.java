/**
 * 
 */
package net.viralpatel.contact.dto;

import com.google.gson.Gson;

/**
 * @author nex6uyu
 * 
 */
public abstract class MasterChart {
	private Data[] data;

	/**
	 * @return the data
	 */
	public Data[] getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Data[] data) {
		this.data = data;
	}

	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(data, Data[].class);
	}

	public abstract String getJson();
}
