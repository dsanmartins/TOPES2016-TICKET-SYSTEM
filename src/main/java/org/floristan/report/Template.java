package org.floristan.report;

/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2013 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsCustomizer;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

import java.awt.Color;
import java.util.Locale;

import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Template 
{
	public static final StyleBuilder rootStyle1;
	public static final StyleBuilder boldStyle1;
	public static final StyleBuilder italicStyle1;
	public static final StyleBuilder boldCenteredStyle1;
	public static final StyleBuilder bold12LeftStyle1;
	public static final StyleBuilder bold12CenterStyle1;
	public static final StyleBuilder bold18CenteredStyle1;
	public static final StyleBuilder bold22CenteredStyle1;
	public static final StyleBuilder boldLeftStyle1;
	public static final StyleBuilder boldCenterStyle1;
	public static final StyleBuilder columnStyle1;
	public static final StyleBuilder columnTitleStyle1;
	public static final StyleBuilder groupStyle1;
	public static final StyleBuilder subtotalStyle1;
	public static final StyleBuilder Left12Style1;
	public static final ReportTemplateBuilder reportTemplate1;
	public static final ComponentBuilder<?, ?> dynamicReportsComponent1;
	public static final ComponentBuilder<?, ?> footerComponent1;

	static {
		rootStyle1           = stl.style().setPadding(2);
		boldStyle1           = stl.style(rootStyle1).bold();
		italicStyle1         = stl.style(rootStyle1).italic();
		boldCenteredStyle1   = stl.style(boldStyle1).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		boldLeftStyle1       = stl.style(boldStyle1).setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.MIDDLE);
		boldCenterStyle1     = stl.style(boldStyle1).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
		bold12LeftStyle1     = stl.style(boldLeftStyle1).setFontSize(12);
		bold12CenterStyle1   = stl.style(boldCenterStyle1).setFontSize(11);
		Left12Style1         = stl.style().setFontSize(12);
		bold18CenteredStyle1 = stl.style(boldCenteredStyle1).setFontSize(18);
		bold22CenteredStyle1 = stl.style(boldCenteredStyle1).setFontSize(22);
		columnStyle1         = stl.style(rootStyle1).setVerticalAlignment(VerticalAlignment.MIDDLE);
		columnTitleStyle1    = stl.style(columnStyle1)
				.setBorder(stl.pen1Point())
				.setHorizontalAlignment(HorizontalAlignment.CENTER)
				.setBackgroundColor(Color.LIGHT_GRAY)
				.bold();
		groupStyle1          = stl.style(boldStyle1)
				.setHorizontalAlignment(HorizontalAlignment.LEFT);
		subtotalStyle1       = stl.style(boldStyle1)
				.setTopBorder(stl.pen1Point());

		StyleBuilder crosstabGroupStyle      = stl.style(columnTitleStyle1);
		StyleBuilder crosstabGroupTotalStyle = stl.style(columnTitleStyle1)
				.setBackgroundColor(new Color(170, 170, 170));
		StyleBuilder crosstabGrandTotalStyle = stl.style(columnTitleStyle1)
				.setBackgroundColor(new Color(140, 140, 140));
		StyleBuilder crosstabCellStyle       = stl.style(columnStyle1)
				.setBorder(stl.pen1Point());

		TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer()
				.setHeadingStyle(0, stl.style(rootStyle1).bold());

		reportTemplate1 = template()
				.setLocale(Locale.getDefault())
				.setColumnStyle(columnStyle1)
				.setColumnTitleStyle(columnTitleStyle1)
				.setGroupStyle(groupStyle1)
				.setGroupTitleStyle(groupStyle1)
				.setSubtotalStyle(subtotalStyle1)
				.highlightDetailEvenRows()
				.crosstabHighlightEvenRows()
				.setCrosstabGroupStyle(crosstabGroupStyle)
				.setCrosstabGroupTotalStyle(crosstabGroupTotalStyle)
				.setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
				.setCrosstabCellStyle(crosstabCellStyle)
				.setTableOfContentsCustomizer(tableOfContentsCustomizer);

		dynamicReportsComponent1 = cmp.horizontalList();
		footerComponent1 = cmp.verticalList(
				cmp.verticalList(
						cmp.text("Floristan Ticket (Proof of Purchase) OR RESERVATION").setStyle(bold12CenterStyle1).setHorizontalAlignment(HorizontalAlignment.RIGHT)),
						cmp.pageXofY().setFormatExpression("{0} de {1}").setStyle(stl.style(boldCenteredStyle1).setTopBorder(stl.pen1Point())));
	}

	public static ComponentBuilder<?, ?> head( String date, String time)
	{

		return cmp.horizontalList()
				.add(
						dynamicReportsComponent1,
						cmp.horizontalList(
								cmp.horizontalGap(20),
								cmp.verticalList(
										cmp.verticalGap(10),
										cmp.text("TICKET PROOF PURCHASE FLORISTAN THEATER OR RESERVATION").setStyle(Left12Style1).setHorizontalAlignment(HorizontalAlignment.LEFT),
										cmp.verticalGap(10),
										cmp.text("DATE: "+ date.replaceAll("/", ".")).setStyle(Left12Style1).setHorizontalAlignment(HorizontalAlignment.LEFT),
										cmp.verticalGap(20),	
										cmp.text("TIME:                     "+time).setStyle(bold12CenterStyle1).setHorizontalAlignment(HorizontalAlignment.LEFT)	
										)
								));
	}
	/**
	 * Creates custom component which is possible to add to any report band component
	 */
	public static ComponentBuilder<?, ?> createTitleComponent(String label) 
	{
		return cmp.horizontalList()
				.add(
						dynamicReportsComponent1,
						cmp.text(label).setStyle(bold12CenterStyle1).setHorizontalAlignment(HorizontalAlignment.CENTER))
						.newRow()
						.add(cmp.line())
						.newRow()
						.add(cmp.verticalGap(10));
	}
}
