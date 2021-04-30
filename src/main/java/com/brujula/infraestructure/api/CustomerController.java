package com.brujula.infraestructure.api;

import com.brujula.application.service.CustomerService;
import com.brujula.infraestructure.api.dto.CustomerDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Customer", notes = "Use this operation to get a customer by Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation OK")
    })
    public ResponseEntity<CustomerDto> get(@ApiParam(value = "Customer Id", required = true) @PathVariable int id) {
        return ResponseEntity.ok(CustomerDto.createCustomerDto(customerService.get(id)));
    }
}
