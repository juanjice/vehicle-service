package com.consumevehicle.consumevehicle.vehicle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author Juan Manuel Jimenez Celis
 */
@RestController
@CrossOrigin("*")
public class VehicleController {

    @Autowired
    private RestTemplate restTemplate;
    private final String TOKEN_USER="E630C3F619EC42164D17FBA99731D8624D332936D43420845CC214E501D122B3";
    private static String url="https://test.teclogi.com/Teclogi/services/vehicle";

    //
    @PostMapping(
            value="/createvehicle",
            consumes="application/json",
            produces="application/json"
    )
    public ResponseEntity<String> createVehicle(@RequestBody String vehicle) throws JsonProcessingException {
        //create necesary headers including tokenUser
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("tokenUser", TOKEN_USER);
        //using rest template for post in a public api
        ResponseEntity<String> response=getResponseVehicle(vehicle,headers);
        //if body doesnt match with the object then generate a random vehicle
        if(response.getStatusCode()!=HttpStatus.OK){
                System.out.println("BAD BODY!,generating an random vehicle");
                ObjectMapper objectMapper = new ObjectMapper();
                //create an a completly random vehicle and convert into Json String
                String vehicleString=objectMapper.writeValueAsString(Vehicle.getRandomVehicle());
                //get the new response
                response = getResponseVehicle(vehicleString,headers);
        }
        return response;
    }
    //abstract method that creates the response
    public ResponseEntity<String> getResponseVehicle(String vehicle,HttpHeaders headers){
        //create entitty from Json string and headers
        HttpEntity<String> respEntity= new HttpEntity<String>(vehicle, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url,respEntity,String.class);
        return response;
    }

}
