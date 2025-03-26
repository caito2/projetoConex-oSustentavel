package com.projeto.crud_endereco.controller;

import com.projeto.crud_endereco.Address;
import com.projeto.crud_endereco.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public List<Address> getAllAddresses() {
        return service.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return service.getAddressById(id);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return service.createAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address updatedAddress) {
        return service.updateAddress(id, updatedAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        service.deleteAddress(id);
    }
}
