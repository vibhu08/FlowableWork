package holidayrequest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;



public class CallExternalSystemDelegate implements JavaDelegate {
	public void execute(DelegateExecution execution) {
        System.out.println("Calling the external system for employee "
            + execution.getVariable("employee"));
      
        File file = new File("D:/PDFWork/MY_PDF_DIRECTORY"); 
    	String s[]=file.list();
    	
    	for(String s1 :s )
    	{
    		
    		 File f=new File("D:/PDFWork/MY_PDF_DIRECTORY/"+s1);
    		 PDDocument document = null;
			try {
				document = PDDocument.load(f);
			} catch (InvalidPasswordException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
		
				e.printStackTrace();
			} 
    		 PDFTextStripper pdfStripper = null;
			try {
				pdfStripper = new PDFTextStripper();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
    		 pdfStripper.setParagraphStart("/t");
    		    
    		ArrayList<String> l= new ArrayList<String>();
    		int n=0;

    		    try {
					for (String line: pdfStripper.getText(document).split(pdfStripper.getParagraphStart()))
					        {
					            int c=0;
					            line=line.trim();
						        for(int i=0;i<line.length();i++)
					            {
					               
					                if( ((i>0)&&(line.charAt(i)!=' ')&&(line.charAt(i-1)==' ')) || ((line.charAt(i)!=' ')&&(i==0)) )
					                {
					                c++;
					                }
					                
					            }
						        if(c<=5 && c>0)
					            {
						        	l.add(line);
						        	n++;
					            	System.out.println(line);
					            System.out.println("********************************************************************");
					            }  
					        }
				} catch (IOException e) {
					e.printStackTrace();
				}
    		    
    		    BufferedWriter br = null;
				try {
					br = new BufferedWriter(new FileWriter("D:///PDFWork//PdfBox_Examples//"+s1+"_Heading"+".txt"));
				} catch (IOException e) {
					e.printStackTrace();
				}
    		    for(int i=0;i<n;i++)
    		    {
    		    	try {
						br.write(l.get(i));
					} catch (IOException e) {
						e.printStackTrace();
					}
    		    	try {
						br.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
    		    }
    		    try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		
    	}
    }

}
