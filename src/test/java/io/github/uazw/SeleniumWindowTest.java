package io.github.uazw;

import com.thoughtworks.selenium.DefaultSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SeleniumWindowTest {

    private DefaultSelenium selenium;

    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*iexplore", "http://localhost:8080/window/");
        selenium.start();
    }

    @Test
    public void testOpenWindow() {
        selenium.open("index.html");
        selenium.type("input1", "input1");
        selenium.type("input2", "input2");
        selenium.click("windowTrigger");
        selenium.openWindow("http://localhost:8080/window/", "theNewA");
        selenium.selectWindow("helloAll");
        System.out.println(Arrays.toString(selenium.getAllWindowIds()));
        selenium.type("input3", "input3");
        selenium.type("input4", "input4");
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenGivenEmptyUrl() {
        selenium.open("index.html");
        selenium.type("input1", "input1");
        selenium.type("input2", "input2");
        selenium.click("windowTrigger");
        selenium.openWindow("", "theNewA");
        selenium.selectWindow("theNewWindow");
        assertThat(selenium.getAllWindowIds().length, is(0));
        selenium.type("input3", "input3");
        selenium.type("input4", "input4");
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
