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
      
     
    }

}
