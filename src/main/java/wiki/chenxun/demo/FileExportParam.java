package wiki.chenxun.demo;

import lombok.Data;

@Data
public class FileExportParam {

    /**
     * 单个sheet最多行数
     */
    private int maxRowsOnSheet =65535;

    /**
     * 单个excel最多多少个sheet
     */
    private int maxSheetsOnExcel=10;
}
