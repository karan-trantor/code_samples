package adbeat.api.automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class ReadPdf {

	public static void main(String[] args) {

		String pdWithData = "C:\\Users\\harpreet2.singh\\Desktop\\With Data.pdf";
		String pdWithNoData = "C:\\Users\\harpreet2.singh\\Desktop\\blank.pdf";
		String pdWithMultiplaePageData = "C:\\Users\\harpreet2.singh\\Desktop\\multiplePage.pdf";
		verifyPdfdata(pdWithNoData);
		verifyPdfdata(pdWithData);
		verifyPdfdata(pdWithMultiplaePageData);

	}

	public static void verifyPdfdata(String path) {
		try {
			PDDocument document = null;
			document = PDDocument.load(new File(path));
			document.getClass();
			System.out.println("\n\n**Veryfying data in PDF with location:" + path + "**");
			if (!document.isEncrypted()) {
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper Tstripper = new PDFTextStripper();
				int count = document.getNumberOfPages();
				String st = Tstripper.getText(document);
				System.out.println("Total number of pages= " + count);

				if (count == 1) {
					if (!(st.trim().length() == 0)) {
						System.out.println("\nPDF Content \n" + st);
					} else {
						System.out.println("\nPDF is Blank");

					}
				} else if (count > 1) {
					for (int i = 1; i <=count; i++) {
						Tstripper.setStartPage(i);
						Tstripper.setEndPage(i);
						System.out.println("PAGE NO.: "+i+" \n: "+Tstripper.getText(document).trim()); 

					}
				}else{
					System.out.println("TROUBLE READING PDF!!!");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
