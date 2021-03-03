package sample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {

    private List<Country> countries=null;
    private Country cntry=null;
    private StringBuilder data=null;

    public List<Country> getCountries(){
        return countries;
    }
    boolean bdateRep = false;
    boolean bday = false;
    boolean bmonth = false;
    boolean byear = false;
    boolean bcases = false;
    boolean bdeaths = false;
    boolean bcountriesAndTerritories = false;
    boolean bgeoId = false;
    boolean bcountryterritoryCode = false;
    boolean bpopData2018 = false;
    boolean bcontinentExp = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes)throws SAXException{
        if (qName.equalsIgnoreCase("record")){
            cntry=new Country();
            if (countries==null)
                countries=new ArrayList<>();
        }else if (qName.equalsIgnoreCase("dateRep")){
            bdateRep=true;
        }else if (qName.equalsIgnoreCase("day")){
            bday=true;
        }else if (qName.equalsIgnoreCase("month")){
            bmonth=true;
        }else if (qName.equalsIgnoreCase("year")){
            byear=true;
        }else if (qName.equalsIgnoreCase("cases")){
            bcases=true;
        }else if (qName.equalsIgnoreCase("deaths")){
            bdeaths=true;
        }else if (qName.equalsIgnoreCase("countriesAndTerritories")){
            bcountriesAndTerritories=true;
        }else if (qName.equalsIgnoreCase("geoId")){
            bgeoId=true;
        }else if (qName.equalsIgnoreCase("countryterritoryCode")){
            bcountryterritoryCode=true;
        }else if (qName.equalsIgnoreCase("popData2018")){
            bpopData2018=true;
        }else if (qName.equalsIgnoreCase("continentExp")){
            bcontinentExp=true;
        }
        data=new StringBuilder();
    }
    @Override
    public void characters(char ch[], int start, int length)throws SAXException{
        data.append(new String(ch,start,length));
    }

    public void endElement(String uri, String localName, String qName)throws SAXException{
        if (bdateRep){
            cntry.setDateRep(data.toString());
            bdateRep=false;
        }else if (bday){
            cntry.setDay(data.toString());
            bday=false;
        }else if (bmonth){
            cntry.setMonth(data.toString());
            bmonth=false;
        }else if (byear){
            cntry.setYear(data.toString());
            byear=false;
        }else if (bcases){
            cntry.setCases(data.toString());
            bcases=false;
        }else if (bdeaths){
            cntry.setDeaths(data.toString());
            bdeaths=false;
        }else if (bcountriesAndTerritories){
            cntry.setCountriesAndTerritories(data.toString());
            bcountriesAndTerritories=false;
        }else if (bgeoId){
            cntry.setGeoId(data.toString());
            bgeoId=false;
        }else if (bcountryterritoryCode){
            cntry.setCountryterritoryCode(data.toString());
            bcountryterritoryCode=false;
        }else if (bpopData2018){
            cntry.setPopData2018(data.toString());
            bpopData2018=false;
        }else if (bcontinentExp){
            cntry.setContinentExp(data.toString());
            bcontinentExp=false;
        }
        if (qName.equalsIgnoreCase("record")){
            countries.add(cntry);
        }
    }


}

