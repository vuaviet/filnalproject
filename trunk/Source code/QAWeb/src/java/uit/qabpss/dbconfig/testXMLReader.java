package uit.qabpss.dbconfig;


public class testXMLReader {
	public static void main(String args[]){
		XMLReader rd = new XMLReader();
		System.out.println(rd.relationWordMapping("be publish"));
                System.out.println(rd.getValueElement("publication",XMLReader.TABLENAME));
                System.out.println(rd.getValueElement("publication",XMLReader.PRIMARYKEY));
	}
}