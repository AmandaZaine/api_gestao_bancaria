package com.amandazaine.api_gestao_bancaria.controller;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.entity.ContaEntity;
import com.amandazaine.api_gestao_bancaria.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaDTO> criarConta(@RequestBody ContaDTO contaDTO) {
        try {
            contaService.saveConta(contaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(contaDTO);
        } catch (RuntimeException runtimeException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<ContaDTO> buscarConta(@RequestParam(name = "numero_conta") Integer numeroConta) {
        try {
            ContaDTO conta = contaService.findConta(numeroConta);
            return ResponseEntity.status(HttpStatus.OK).body(conta);
        } catch (RuntimeException runtimeException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
