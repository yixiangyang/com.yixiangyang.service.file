package com.yixiangyang.file.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ConfigController {
//	@Value("${foo}")
	private String foo ="aaa";
	
	@RequestMapping(value = "/hi",method=RequestMethod.GET)
	public String hi(HttpServletResponse response){
		List<String> headersList = new ArrayList<String>();
		headersList.add("第一");
		headersList.add("第二");
		List<List<String>> contentList = new ArrayList<>();
		List<String> content = new ArrayList<>();
		content.add("5555");
		content.add("666");
		contentList.add(content);
		ConfigController excelUtil = new ConfigController();
		excelUtil.exportExcel("aa", "ddd", "aa", headersList, contentList,response);
		return "gggggggg";
	}
	

    public static String getCellValue(Cell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
	public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

		// 设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体大小
		font.setFontHeightInPoints((short) 11);
		// 字体加粗
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体名字
		font.setFontName("Courier New");
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 在样式用应用设置的字体;
		style.setFont(font);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}

	public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
		// 设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体大小
		// font.setFontHeightInPoints((short)10);
		// 字体加粗
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体名字
		font.setFontName("Courier New");
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 在样式用应用设置的字体;
		style.setFont(font);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
    /**
	 * 创建Excel
	 * @param title
	 * @param excelName
	 * @param headerList
	 * @param contentList
	 */
	public void exportExcel(String sheetName, String title, String excelName, List<String> headerList,
			List<List<String>> contentList,HttpServletResponse response) {
		if (excelName == null) {
			System.out.println("名称不能为空");
		}
		HSSFWorkbook book = new HSSFWorkbook();
		try {
			HSSFSheet sheet = book.createSheet(sheetName);
			HSSFCellStyle columnTopStyle = this.getColumnTopStyle(book); // 获取列头样式对象
			HSSFCellStyle style = this.getStyle(book);
			// 创建title
			if (title != null) {
				HSSFRow rowm = sheet.createRow(0);
				HSSFCell cellTiltle = rowm.createCell(0);
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (headerList.size() - 1)));
				cellTiltle.setCellStyle(columnTopStyle);
				cellTiltle.setCellValue(title);
			}
			int rown = 0;
			if (title != null && title.trim().length() > 0) {
				rown = 1;
			}
			HSSFRow rowRowName = sheet.createRow(rown);
			// 创建表头
			for (int n=0; n<headerList.size();n++) {
				HSSFCell cellRowName = rowRowName.createCell(n); // 创建列头对应个数的单元格
				HSSFRichTextString text = new HSSFRichTextString(headerList.get(n));
				cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING); // 设置列头单元格的数据类型
				cellRowName.setCellValue(text); // 设置列头单元格的值
				cellRowName.setCellStyle(columnTopStyle);
			}
			// 创建excel数据
			for (int i = 0; i < contentList.size(); i++) {
				int row = 1;
				if (title != null && title.trim().length() >= 0 && !headerList.isEmpty()) {
					row = 2;
				}
				HSSFRow hssfRow = sheet.createRow(i + row);
				List<String> contents = contentList.get(i);
				for (int j = 0; j < contents.size(); j++) {
					HSSFCell cell = hssfRow.createCell(j, HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(contents.get(j));
					cell.setCellStyle(style);
				}
			}
			if (book != null) {
				try {
					FileOutputStream fout = new FileOutputStream("F:\\a.xls"); 
				    book.write(fout);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (book != null) {
				try {
					book.close();
				} catch (Exception e2) {
//					throw new CodeException("EXCEL_CREATE_FAILED", "报表生成失败");
				}
			}
		}
	}
}
