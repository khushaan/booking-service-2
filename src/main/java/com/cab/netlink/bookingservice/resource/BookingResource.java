package com.cab.netlink.bookingservice.resource;


import com.cab.netlink.bookingservice.model.BookingModel;
import com.cab.netlink.bookingservice.model.DriverModel;
import com.cab.netlink.bookingservice.model.User;
import com.cab.netlink.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Booking")
public class BookingResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BookingRepository bookingRepository;


    @PostMapping("createBooking")
    public String createBooking(@RequestBody BookingModel bookingModel){

        ResponseEntity<User> user = restTemplate.exchange("http://user-service/user-service/getUserId/" + bookingModel.getCustomer().getId(), HttpMethod.GET,
                null, new ParameterizedTypeReference<User>() {
                });

        User u = user.getBody();


        ResponseEntity<DriverModel> responseEntity = restTemplate.exchange("http://driver-service/driver-service/driver/" + bookingModel.getDriver().getId(), HttpMethod.GET,
                null, new ParameterizedTypeReference<DriverModel>() {
                });

        DriverModel driver= responseEntity.getBody();
        driver.setCurrent_customer(u.getId());



        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

        headers.add("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<DriverModel> request = new HttpEntity<DriverModel>(driver, headers);

        restTemplate.postForObject("http://localhost:8082/driver-service/updateStatus", request, String.class);
        //restTemplate.postForObject("http://driver-service/driver-service/driver/updateStatus",request,String.class);
        BookingModel model = new BookingModel();
        model.setCustomer(u);
        model.setDriver(driver);
        bookingRepository.save(model);

        return  "Booking Created Successfully";


    }


}
