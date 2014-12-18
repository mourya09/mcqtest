/**
 * 
 */
package com.test;

import net.viralpatel.contact.dto.BarChart;
import net.viralpatel.contact.dto.Data;
import net.viralpatel.contact.dto.DataSet;
import net.viralpatel.contact.dto.PolarChart;
import net.viralpatel.contact.dto.RadarChart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

/**
 * @author nex6uyu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-servlet.xml" })
public class TestCharts {

	
	@Test
	public void testChart()
	{
		Gson gson = new Gson();
		PolarChart pc = new PolarChart();
		Data[] data = new Data[2];
		data[0] = new Data();
		data[0].setColor("#F7464A");
		data[0].setHighlight("#FF5A5E");
		data[0].setLabel("Red");
		data[0].setValue(300);
		
		data[1] = new Data();
		data[1].setColor("#46BFBD");
		data[1].setHighlight("#5AD3D1");
		data[1].setLabel("Green");
		data[1].setValue(50);
		pc.setData(data);
		String da = gson.toJson(data, Data[].class);
		System.out.println(da);
		
	}
	
	@Test
	public void testTheme()
	{
		Gson gson = new Gson();
		
		DataSet[] ds = new DataSet[2];
		ds[0] = new DataSet();
		ds[1] = new DataSet();
		ds[0].setData(new int[]{1,2,3,4});
		ds[0].setFillColor("#fffff");
		ds[0].setHighlightFill("#ffeee");
		ds[0].setHighlightStroke("#fdss");
		ds[0].setStrokeColor("222");
		ds[1].setData(new int[]{1,2,3,4});
		ds[1].setFillColor("#fffff");
		ds[1].setHighlightFill("#ffeee");
		ds[1].setHighlightStroke("#fdss");
		ds[1].setStrokeColor("222");
		BarChart rc = new BarChart();
		rc.setLabels(new String[]{"Jan","Feb","Mar","Apr"});
		rc.setDatasets(ds);
		System.out.println(gson.toJson(rc,RadarChart.class));
	}
}
