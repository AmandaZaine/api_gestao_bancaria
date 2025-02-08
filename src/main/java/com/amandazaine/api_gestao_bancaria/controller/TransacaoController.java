package com.amandazaine.api_gestao_bancaria.controller;

import com.amandazaine.api_gestao_bancaria.service.TransacaoContext;
import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.dto.TransacaoDTO;
import com.amandazaine.api_gestao_bancaria.service.TransacaoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    private TransacaoContext transacaoContext;

    @PostConstruct
    public void init() {
        transacaoContext = new TransacaoContext(transacaoService);
    }

    @PostMapping
    public ResponseEntity<ContaDTO> realizarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        try {
            ContaDTO contaDTO = transacaoContext.executarTransacao(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(contaDTO);
        } catch (IllegalArgumentException | NullPointerException illegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (UnsupportedOperationException unsupportedOperationException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
