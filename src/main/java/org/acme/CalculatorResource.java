package org.acme;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URL;


@Path("/calculator")
public class CalculatorResource {


    @GET
    @Path("/add/{num1}/{num2}")
    @Produces(MediaType.TEXT_PLAIN)
    public int add(@PathParam(value = "num1") int num1, @PathParam(value = "num2") int num2) throws MalformedURLException {

        URL url = new URL("http://www.dneonline.com/calculator.asmx?wsdl");
        Calculator calculatorService = new Calculator(url);
        CalculatorSoap port = calculatorService.getCalculatorSoap();
        return port.add(num1,num2);
    }
}