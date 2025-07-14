package com.example.docgen.controllers.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.docgen.dto.UserRequestDTO;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cpf-test")
public class CpfValidationTestController {

	@PostMapping("/cpf-test")  
    public ResponseEntity<String> validateCpf(@RequestBody @Valid UserRequestDTO dto) {
        CPFValidator cpfValidator = new CPFValidator();

        try {
            cpfValidator.assertValid(dto.getCpf());
            return ResponseEntity.ok("CPF válido: " + dto.getCpf());
        } catch (InvalidStateException e) {
            return ResponseEntity.badRequest().body("❌ CPF inválido: " + dto.getCpf());
        }
    }
}
