package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{

    //xmlData butonAction ile adresine kaydediyor ancak parse islemini console ekranında çalıstırmak icin ayriyeten manuel bir sekilde
    //adres linkini ekledim. XMLParserSAX classı calistirildiginda parse icin adresi buradan almaktadir.
    public static String xmlData="https://opendata.ecdc.europa.eu/covid19/casedistribution/xml/";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblData;

    @FXML
    private TextField txtData;

    @FXML
    private Button btnData;

    @FXML
    private CategoryAxis xData;

    @FXML
    private NumberAxis yCases;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private StackedBarChart<String, Number> barChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private TableView<Country> tableView;

    @FXML
    private TableColumn<Country, String> tblCountry;

    @FXML
    private TableColumn<Country, Integer> tblTotCases;

    @FXML
    private TableColumn<Country, Integer> tblNewCases;

    @FXML
    private TableColumn<Country, Integer> tblTotDeaths;

    @FXML
    private TableColumn<Country, Integer> tblNewDeaths;

    @FXML
    private TableColumn<Country, Integer> tblPopulation;

    @FXML
    private TableColumn<Country, Double> tblMortality;

    @FXML
    private TableColumn<Country, Double> tblAttack;

    @FXML
    private ListView<String> listView;

    @FXML
    public void ClickedData(){

         xmlData=txtData.getText();

        tblCountry.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblTotCases.setCellValueFactory(new PropertyValueFactory<>("totalCases"));
        tblNewCases.setCellValueFactory(new PropertyValueFactory<>("newCases"));
        tblTotDeaths.setCellValueFactory(new PropertyValueFactory<>("totDeaths"));
        tblNewDeaths.setCellValueFactory(new PropertyValueFactory<>("newDeaths"));
        tblPopulation.setCellValueFactory(new PropertyValueFactory<>("population"));
        tblMortality.setCellValueFactory(new PropertyValueFactory<>("mortality"));
        tblAttack.setCellValueFactory(new PropertyValueFactory<>("attackRate"));
        //tableView.setItems(countries);
        //listView.setItems(countries);

    }






     @Override
     public void initialize(URL location, ResourceBundle resources){
        XYChart.Series turkey=new XYChart.Series();
        turkey.getData().add(new XYChart.Data("1",5));
        turkey.getData().add(new XYChart.Data("2",15));
        turkey.getData().add(new XYChart.Data("3",20));
        turkey.getData().add(new XYChart.Data("4",12));
        turkey.getData().add(new XYChart.Data("5",42));
        turkey.getData().add(new XYChart.Data("6",45));
        turkey.getData().add(new XYChart.Data("7",10));
        turkey.getData().add(new XYChart.Data("8",35));
        turkey.getData().add(new XYChart.Data("9",20));
        turkey.setName("TURKEY");

        XYChart.Series italy=new XYChart.Series();
        italy.getData().add(new XYChart.Data("1",2));
        italy.getData().add(new XYChart.Data("2",6));
        italy.getData().add(new XYChart.Data("3",10));
        italy.getData().add(new XYChart.Data("4",12));
        italy.getData().add(new XYChart.Data("5",65));
        italy.getData().add(new XYChart.Data("6",32));
        italy.getData().add(new XYChart.Data("7",45));
        italy.getData().add(new XYChart.Data("8",20));
        italy.getData().add(new XYChart.Data("9",25));
        italy.setName("ITALY");

        XYChart.Series germany=new XYChart.Series();
        germany.getData().add(new XYChart.Data("1",10));
        germany.getData().add(new XYChart.Data("2",40));
        germany.getData().add(new XYChart.Data("2",70));
        germany.getData().add(new XYChart.Data("3",30));
        germany.getData().add(new XYChart.Data("4",50));
        germany.getData().add(new XYChart.Data("6",80));
        germany.getData().add(new XYChart.Data("7",100));
        germany.getData().add(new XYChart.Data("8",120));
        germany.getData().add(new XYChart.Data("9",230));
        germany.setName("GERMANY");
         lineChart.getData().addAll(turkey,italy,germany);
         barChart.getData().addAll(turkey,italy,germany);


    }

}

