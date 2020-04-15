package com.time.demo.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Excel导出
 *
 * @author time
 */
public class ExcelUtil {

    /**
     * @param response 响应对象
     * @param sheetName sheet的名字
     * @param list      需要导出的list集合（内容）
     * @param clazz     导出的模型类（此类必须继承了BaseRowModel）
     * @throws Exception 抛出异常
     */
    public static void getExcel(HttpServletResponse response, String sheetName, List<? extends BaseRowModel> list, Class clazz)
            throws Exception {
        OutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet1 = new Sheet(1, 0, clazz);
        writer.write(list, sheet1);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(sheetName + ".xlsx", "UTF-8"));
        response.setHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        writer.finish();
        out.flush();
    }
}
