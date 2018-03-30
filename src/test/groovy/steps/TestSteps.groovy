package steps

import geb.Browser

import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When



When(~/^I navigate to Stack Overflow question page ([0-9]+)$/) { int page ->
    Browser.drive {
        go "https://stackoverflow.com/questions?page=" + page
    }
}


Then(~/^I verify Stack Overflow question page ([0-9]+) is opened$/) { int page  ->
    Browser.drive {
        assert driver.getTitle().contains("Page " + page)
    }

}