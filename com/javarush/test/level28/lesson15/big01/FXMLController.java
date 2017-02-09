package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.FXView;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Admin on 07.02.2017.
 */
public class FXMLController implements Initializable
{

    @FXML
    private Button btnSearch;
    @FXML
    private TextField textField;
    @FXML
    private CheckBox hhCheckBox;
    @FXML
    private CheckBox moikrugCheckBox;
    @FXML
    public TableView<Vacancy> tableView;
    @FXML
    public TableColumn<Vacancy, String> titleColumn;
    @FXML
    public TableColumn<Vacancy, String> cityColumn;
    @FXML
    public TableColumn<Vacancy, String> companyColumn;
    @FXML
    public TableColumn<Vacancy, String> salaryColumn;

    private List<Provider> providers = new ArrayList<>();
    private ObservableList<Vacancy> tableContent;

    private static String searchText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        companyColumn.setCellValueFactory(cellData -> cellData.getValue().companyNameProperty());
        salaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty());
    }

    public void btnAct(ActionEvent actionEvent) {
            //получаем введенный текст
            searchText = textField.getText();
            if (searchText.equals(""))
            {
                alertMsg("Please write vacancy to search");
                return;
            }
            List<Vacancy> tableContent = startParsing(searchText);

            //TODO ObserverList implementation use another because every time saves the query
            tableView.getItems().clear();
            tableView.setItems((ObservableList<Vacancy>) tableContent);
        }

        private<T> ObservableList<T> startParsing(String vacancyText)
        {
            checkWebsites();
            if (providers.size()==0)
            {
                alertMsg("Please choose websites to parse");
                return FXCollections.emptyObservableList();
            }

            FXView fxView = new FXView();
            Model model = new Model(fxView, providers);
            Controller controller = new Controller(model);
            fxView.setController(controller);
            ObservableList<T> vacancies = fxView.userInputQuery(vacancyText);

            return vacancies;
        }

    private void checkWebsites()
    {
        if (hhCheckBox.isSelected())
            providers.add(new Provider(new HHStrategy()));
        if (moikrugCheckBox.isSelected())
            providers.add(new Provider(new MoikrugStrategy()));
    }

    private void alertMsg(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
