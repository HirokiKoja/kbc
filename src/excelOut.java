//エクセルに出力

package excelTest;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class excelOut {
	 public static void main(String[] args){
		 
		HSSFWorkbook workbook = new HSSFWorkbook();		//Excelオブジェクト作成
		logOutput("ワークブック作成");
		
		String[] colName = {"社員ID", "社員名", "部署番号", "部署名", "給料"};
		logOutput("出力列名　作成");
		
		String[] colTest = {"1101", "Alen", "101", "開発", "150000"};
		
		Sheet sheet = workbook.createSheet("test");		//シート作成 ("シート名")
		logOutput("シート作成");
		
		Row row1 = sheet.createRow(1);					//行作成
		logOutput("出力行　作成");
		
		
		//デフォルト列出力
		int i=0;	//列番号
		for(String celTop: colName){
			Cell cell1_i = row1.createCell(i);			//セル作成
			cell1_i.setCellValue(celTop);				//値をセット
			logOutput(celTop+" 列作成");
			logOutput((i+1)+"列完了");
			i++;
		}
		
		/* 以下が実データの出力
		 * 基本的に↑と変わらない*/
		i=0;
		Row rowOutput = sheet.createRow(2);
		for(String celLineOut: colTest){
			Cell cell = rowOutput.createCell(i);
			cell.setCellValue(celLineOut);
			i++;
		}
		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("sample.xls");	//ファイル作成("ファイル名")
			logOutput("ファイル作成　sample.xls");
			
			workbook.write(out);						//ファイル保存
			logOutput("ファイル保存");
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				out.close();							//クローズ
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
	
//ログ出力メソッド (String 出力文字)
	static void logOutput(String other){
		System.out.println(other);
	}
}
