package com.brujula.infraestructure.api;


import com.brujula.application.service.CustomerService;
import com.brujula.infraestructure.api.dto.CustomerDto;
import com.brujula.infraestructure.api.mappers.CustomerDtoMapperImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;
    private final CustomerDtoMapperImpl customerDtoMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerDtoMapperImpl customerDtoMapper) {
        this.customerService = customerService;
        this.customerDtoMapper = customerDtoMapper;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Customer", notes = "Use this operation to get a customer by Id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Operation OK"),
        @ApiResponse(code = 500, message = "Error Internal server"),
        @ApiResponse(code = 409, message = "Not Found Data"),
        @ApiResponse(code = 400, message = "not match data")
    })
    public ResponseEntity<CustomerDto> get(@ApiParam(value = "Customer Id", required = true) @PathVariable int id){
        return ResponseEntity.ok(CustomerDto.createCustomerDto(customerService.get(id)));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Post Customer", notes = "Use this operation to post a customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation OK"),
            @ApiResponse(code = 500, message = "Error Internal server"),
            @ApiResponse(code = 409, message = "Not Found Data"),
            @ApiResponse(code = 400, message = "not match data")
    })
    public ResponseEntity<CustomerDto> post(@Valid @RequestBody CustomerDto request){
        return ResponseEntity.ok(CustomerDto.createCustomerDto(
                customerService.save(
                        customerDtoMapper.customerDtoToCustomer(request)
                )
        ));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Customer", notes = "Use this operation to get a customer by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operation OK"),
            @ApiResponse(code = 500, message = "Error Internal server"),
            @ApiResponse(code = 409, message = "Not Found Data"),
            @ApiResponse(code = 400, message = "not match data")
    })
    public ResponseEntity<CustomerDto> put(@ApiParam(value = "Customer Id", required = true) @PathVariable int id,
                                           @Valid @RequestBody CustomerDto request){
        return ResponseEntity.ok(CustomerDto.createCustomerDto(
                customerService.update(
                        id,
                        customerDtoMapper.customerDtoToCustomer(request))
        ));
    }
}
