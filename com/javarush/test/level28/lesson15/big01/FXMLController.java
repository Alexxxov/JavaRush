package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.FXView;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

/**
 * Created by Admin on 07.02.2017.
 */
public class FXMLController implements Initializable
{

    @FXML
    public ToggleButton btnSearch;
    public AnchorPane mainPane;

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

    private List<Provider> providers;
    private List<Vacancy> tableContent;
    private String searchText;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //prevent column resizing
        tableView.setColumnResizePolicy((param) -> true );

        Callback<TableColumn<Vacancy, String>, TableCell<Vacancy, String>> titleCellFactory = callback ->
        {
            TableCell<Vacancy, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);

            //when click on title column go to website
            cell.addEventFilter(MouseEvent.MOUSE_CLICKED, firstClick ->
            {
                    Vacancy item = titleColumn.getTableView().getSelectionModel().getSelectedItem();
                    if (item != null)
                    {
                        try {
                            Desktop.getDesktop().browse(new URI(item.getUrl()));
                        } catch (URISyntaxException e) {
                        } catch (IOException e) {
                        }
                    }
            });


//            //when hover cell
//            cell.hoverProperty().addListener( listener ->
//            {
//                text.setFill(Color.BLUE);
//                text.setUnderline(true);
//
//            });

            text.wrappingWidthProperty().bind(titleColumn.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        };

        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        titleColumn.setCellFactory(titleCellFactory);

        cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        cityColumn.setCellFactory(cellMutiLineFactory(cityColumn));


        companyColumn.setCellValueFactory(cellData -> cellData.getValue().companyNameProperty());
        companyColumn.setCellFactory(cellMutiLineFactory(companyColumn));

        salaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty());
        salaryColumn.setCellFactory(cellMutiLineFactory(salaryColumn));
    }

    //enable multiline cells
    public <S> Callback<TableColumn<S, String>, TableCell<S, String>> cellMutiLineFactory(TableColumn<S,String> column)
    {
        Callback<TableColumn<S, String>, TableCell<S, String>> cellMultilineFactory = callback ->
        {
            TableCell<S, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(column.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        };
        return cellMultilineFactory;
    }


    public void btnAct(ActionEvent actionEvent) throws InterruptedException, ExecutionException
    {

            //get input query
            searchText = textField.getText();
            if (searchText.equals(""))
            {
                alertMsg("Please write vacancy to search");
                return;
            }

            checkWebsites();
            if (providers.size()==0)
            {
                alertMsg("Please choose websites to parse");
                return;
            }
        WorkIndicatorDialog wd = new WorkIndicatorDialog(mainPane.getScene().getWindow(), "Loading vacancies...");

        wd.addTaskEndNotification(result -> {
            alertMsg("Найдено " + tableContent.size() + " вакансии");
            tableView.setItems(FXCollections.observableList(tableContent));
        });


        wd.exec("1", inputParam -> {
            tableContent = startParsing(searchText);
            return 1;
        });

    }

    private <T> List<T> startParsing(String vacancyText)
    {

        FXView fxView = new FXView();
        Model model = new Model(fxView, providers);
        Controller controller = new Controller(model);
        fxView.setController(controller);

        List<T> vacancies = fxView.userInputQuery(vacancyText);

        return vacancies;
    }

    private void checkWebsites()
    {
        //when pushing search button - just make new arraylist of providers
        providers = new ArrayList<>();
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

    public void btnSave(ActionEvent actionEvent) {
    }
}
