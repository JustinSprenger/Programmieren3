package Uebung_6_2;

public class EuroConverter 
{
	// Waehrungs-Kennungen
	  static final int 
	    DEM = 0;
	  // Umrechnungsfaktoren
	  private static final double[] faktor = new double[] {
	    1.95583
	  };
	  // Ausgeschriebene Bezeichnungen der Waehrungen
	  private static final String[] bezeichnung = new String[] {
	    "Deutsche Mark"
	  };
	  // liefert die Bezeichnung zur Waehrungs-Kennung 'kennung'
	  static String getBezeichnung(int kennung) {
	    return bezeichnung[kennung];
	  }
	  // konvertiert den Euro-Wert 'euro' in die durch die
	  // Waehrungs-Kennung 'kennung' spezifizierte Waehrung
	  static double convertFromEuro(double euro, int kennung) {
	    return faktor[kennung] * euro;
	  }
	  // konvertiert den Wert 'sonst' der durch die Waehrungs-Kennung 
	  // 'kennung' spezifizierten Waehrung in den entsprechenden Euro-Wert
	  static double convertToEuro(double sonst, int kennung) {
	    return sonst / faktor[kennung];
	  }


}
