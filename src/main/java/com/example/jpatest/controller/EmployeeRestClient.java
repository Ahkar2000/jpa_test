package com.example.jpatest.controller;

import com.example.jpatest.BaseResponse;
import com.example.jpatest.database.entity.Employee;
import com.example.jpatest.database.repository.AddressRepository;
import com.example.jpatest.database.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRestClient {
    private static final String GET_ALL_EMPLOYEE_API = "http://localhost:8080/api/employee";
    private static final String GET_EMPLOYEE_BY_ID_API = "http://localhost:8080/api/employee/{id}";
    private static final String CREATE_EMPLOYEE_API = "http://localhost:8080/api/employee/create";
    private static final String UPDATE_EMPLOYEE_API = "http://localhost:8080/api/employee/{id}/update";
    private static final String DELETE_EMPLOYEE_API = "http://localhost:8080/api/employee/{id}/delete";

    static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        callGetAllUsersAPI();
        callGetEmployeeByIdAPI();
    }


    private static void callGetAllUsersAPI(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
        ResponseEntity<String> result = restTemplate.exchange(GET_ALL_EMPLOYEE_API, HttpMethod.GET,entity,String.class);
        System.out.println(result);
    }

    private static void callGetEmployeeByIdAPI(){
        Map<String,Long> param = new HashMap<>();
        param.put("id",4L);
        BaseResponse baseResponse = restTemplate.getForObject(GET_EMPLOYEE_BY_ID_API, BaseResponse.class,param);
        System.out.println(baseResponse);
    }

}
