import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class CreatePdf {

		public static void main(String[] args) {

		Document document = new Document();
		try{
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/prahallad/Test Pdfs/FirstPdfFile.pdf"));
			document.open();
//			document.add(new Paragraph("Hello ! This is the first pdf document"));
			
			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(105);
			table.setSpacingBefore(5f);
			table.setSpacingAfter(5f);
			float[] colWidth0 = {5f};
			table.setWidths(colWidth0);
			Paragraph p = new Paragraph("S. I. W. S. College of Commerce and Economics and \n\n Smt. Thirumalai College of " +
					                    "Science - Wadala.\n");
			p.getFont().setSize(15);
			
			PdfPCell c0 = new PdfPCell(p);
			c0.setHorizontalAlignment(Element.ALIGN_CENTER);
			c0.setBorder(Rectangle.NO_BORDER);
			table.addCell(c0);
			document.add(table);
			
			PdfPTable table1 = new PdfPTable(3);
			table1.setWidthPercentage(105);
			table1.setSpacingBefore(5f);
			table1.setSpacingAfter(11f);
			
			float[] colWidth = {2f, 2f, 2f};
			table1.setWidths(colWidth);
			PdfPCell c1 = new PdfPCell(new Paragraph("Column 1"));
			
			PdfPCell c2 = new PdfPCell(new Paragraph("Column 2"));
			c2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell c3 = new PdfPCell(new Paragraph("Column 3"));
			c3.setHorizontalAlignment(Element.ALIGN_RIGHT);
			
			table1.addCell(c1);
			table1.addCell(c2);
			table1.addCell(c3);
			document.add(table1);
			
			
			document.close();
			writer.close();
		}
		catch (DocumentException e){
			e.printStackTrace();
		}
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}