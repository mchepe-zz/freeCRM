package Functions;

public class Deals {
	String workingDir = System.getProperty("user.dir");
	String testDataFolder = "\\src\\main\\java\\TestData\\";
	Utils utilities = new Utils();
	public String title = utilities.readExcel(workingDir+testDataFolder+"Deals.xlsx", "Deals", 1, 0);
	public String amount = utilities.readExcel(workingDir+testDataFolder+"Deals.xlsx", "Deals", 1, 1);
	public String quantity = utilities.readExcel(workingDir+testDataFolder+"Deals.xlsx", "Deals", 1, 2);
	public String type = utilities.readExcel(workingDir+testDataFolder+"Deals.xlsx", "Deals", 1, 3);
	public String status = utilities.readExcel(workingDir+testDataFolder+"Deals.xlsx", "Deals", 1, 4);
	public String new_title = utilities.readExcel(workingDir+testDataFolder+"Deals.xlsx", "Deals", 1, 5);

}
