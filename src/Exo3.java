
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;



public class Exo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//scanner that reads an input from the user
		Scanner scanner=new Scanner(System.in);
		LocalDate date = null;
		
		//formater with pattern
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		 //make sure that the user give the right format and a correct date 
		boolean i=false;

		do {  
			
			System.out.println("Veuillez introduire une date de type --/--/---- : \n");
			
			try {

				String inputDate=scanner.nextLine();
				date = LocalDate.parse(inputDate, formatter);
				i=true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Format ou date invalide \n");
				i=false;

			}
		}while (!i);

		scanner.close();
		

		 
		//get the current date
		  LocalDate localDate = LocalDate.now();
		 
		
	
		
		  System.out.println("\n\n**************************\n\n");
		  
		  System.out.println("Jour de Naissance : \n"+date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)).split(" ", 2)[0]+"\n\n");
		 
		  System.out.println("Votre Age : \n"+Period.between(date,localDate).getYears()+"\n\n");  
		  
		  System.out.println("Votre Date de Naissance : \n"+date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))+"\n\n");

		  System.out.println("Votre Date de Naissance en arabe : ");
		  String dateArab=date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale( "ar", "SA" ) ));
		  
		  try {
			  //write arabic letters
				 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));

				out.write(dateArab);
				 out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		  //get the anniv of this year
		  LocalDate annivThisYearDay=LocalDate.of(localDate.getYear(),date.getMonth(),date.getDayOfMonth());
		
		  System.out.println("\n\n\nLe jour de semaine pour l'anniversaire de cette annee : "+annivThisYearDay.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)).split(" ", 2)[0]+"\n");

		
		System.out.println("\n\n**************************\n\n");
		
		




	}

}
