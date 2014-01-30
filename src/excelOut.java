//�G�N�Z���ɏo��

package excelTest;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class excelOut {
	 public static void main(String[] args){
		 
		HSSFWorkbook workbook = new HSSFWorkbook();		//Excel�I�u�W�F�N�g�쐬
		logOutput("���[�N�u�b�N�쐬");
		
		String[] colName = {"�Ј�ID", "�Ј���", "�����ԍ�", "������", "����"};
		logOutput("�o�͗񖼁@�쐬");
		
		String[] colTest = {"1101", "Alen", "101", "�J��", "150000"};
		
		Sheet sheet = workbook.createSheet("test");		//�V�[�g�쐬 ("�V�[�g��")
		logOutput("�V�[�g�쐬");
		
		Row row1 = sheet.createRow(1);					//�s�쐬
		logOutput("�o�͍s�@�쐬");
		
		
		//�f�t�H���g��o��
		int i=0;	//��ԍ�
		for(String celTop: colName){
			Cell cell1_i = row1.createCell(i);			//�Z���쐬
			cell1_i.setCellValue(celTop);				//�l���Z�b�g
			logOutput(celTop+" ��쐬");
			logOutput((i+1)+"�񊮗�");
			i++;
		}
		
		/* �ȉ������f�[�^�̏o��
		 * ��{�I�Ɂ��ƕς��Ȃ�*/
		i=0;
		Row rowOutput = sheet.createRow(2);
		for(String celLineOut: colTest){
			Cell cell = rowOutput.createCell(i);
			cell.setCellValue(celLineOut);
			i++;
		}
		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("sample.xls");	//�t�@�C���쐬("�t�@�C����")
			logOutput("�t�@�C���쐬�@sample.xls");
			
			workbook.write(out);						//�t�@�C���ۑ�
			logOutput("�t�@�C���ۑ�");
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				out.close();							//�N���[�Y
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
	
//���O�o�̓��\�b�h (String �o�͕���)
	static void logOutput(String other){
		System.out.println(other);
	}
}
