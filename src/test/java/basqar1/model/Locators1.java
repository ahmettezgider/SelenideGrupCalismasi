package basqar1.model;

import org.openqa.selenium.By;

public interface Locators1 {

    String URL = "https://test.basqar.techno.study/";
    String KULLANICI = "daulet2030@gmail.com";
    String SIFRE = "TechnoStudy123@";
    By USERNAME = By.cssSelector("input[formcontrolname='username']");
    By PASSWORD = By.cssSelector("input[formcontrolname='password']");
    By GOTIT = By.partialLinkText("Got it");
    By USERBELL = By.cssSelector("user-message-bell");
    By SETUP1 = By.xpath("(//span[contains(text(),'Setup')])[1]");
    By PARAMETERS1 = By.xpath("(//span[contains(text(),'Parameters')])[1]");
    By COUNTRIES = By.xpath("//span[contains(text(),'Countries')]");
    By ADDBUTTON = By.tagName("ms-add-button");
    By DIALOGCONTAINER = By.cssSelector("mat-dialog-container");
    By FORM_NAME = By.cssSelector("ms-text-field[formcontrolname='name']>input");
    By FORM_CODE = By.cssSelector("ms-text-field[formcontrolname='code']>input");
    By FORM_SAVE_BUTTON = By.cssSelector("mat-dialog-actions ms-save-button");
    By LEFTMENUBAR = By.cssSelector("fuse-sidebar");
    By ToggleSideBarFolded = By.cssSelector("button.toggle-sidebar-folded");
    By NavbarToggleButton = By.cssSelector("button.navbar-toggle-button");
    By NOTIFICATION_CONTAINER = By.cssSelector("div#toast-container");
    By DIALOG_CLOSE_BUTTON = By.cssSelector("ms-dialog mat-toolbar button[aria-label='Close dialog']");
    By DIALOG_CONFIRM_YES = By.xpath("//button[@type='submit']");





}
