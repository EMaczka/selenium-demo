package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DropdownList {

    @FindBy (linkText = "Dropdown")
    private WebElement pageLink;

    @FindBy (id = "dropdown")
    private WebElement dropdownList;

    public DropdownList() {
    }

    private void goToDropdownListPage() {
        pageLink.click();
    }

    private void selectOptions(String option) {
        goToDropdownListPage();
        dropdownList.click();
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals(option)) {
                options.get(i).click();
            }
        }
    }

    public String checkOption(String option) {
        selectOptions(option);
        String selectedOption = "";
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()) {
                selectedOption = options.get(i).getText();
            }
        }
        return selectedOption;
    }
}
