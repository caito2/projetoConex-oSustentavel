package com.projeto.crud_endereco.service;

import com.projeto.crud_endereco.Address;
import com.projeto.crud_endereco.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return repository.findById(id);
    }

    public Address createAddress(Address address) {
        return repository.save(address);
    }

    public Address updateAddress(Long id, Address updatedAddress) {
        return repository.findById(id)
                .map(address -> {
                    address.setStreet(updatedAddress.getStreet());
                    address.setCity(updatedAddress.getCity());
                    address.setState(updatedAddress.getState());
                    address.setZipCode(updatedAddress.getZipCode());
                    return repository.save(address);
                })
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public void deleteAddress(Long id) {
        repository.deleteById(id);
    }
}
