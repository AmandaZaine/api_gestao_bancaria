package com.amandazaine.api_gestao_bancaria.service.impl;

import com.amandazaine.api_gestao_bancaria.dto.ContaDTO;
import com.amandazaine.api_gestao_bancaria.entity.ContaEntity;
import com.amandazaine.api_gestao_bancaria.repository.ContaRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ContaServiceImplTest {

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private ContaServiceImpl contaService;

    private ContaDTO contaDTO;
    ContaEntity contaEntityTest;

    @BeforeEach
    void setUp() {
        contaDTO  = new ContaDTO(1111, 100f);
        contaEntityTest = new ContaEntity(contaDTO);
    }

    @Nested
    class saveConta {
        @Test
        @DisplayName("Deve criar um conta com sucesso")
        public void deveCriarUmaConta() {
            Optional<ContaEntity> contaEntityOptional = Optional.empty();

            Mockito.doReturn(contaEntityOptional).when(contaRepository).findById(contaDTO.getNumeroConta());

            contaService.saveConta(contaDTO);

            Mockito.verify(contaRepository, times(1)).save(contaEntityTest);
        }

        @Test
        @DisplayName("Não deve criar uma conta e deve ser lançada uma exceção")
        public void naoDeveCriarUmaConta() {
            Optional<ContaEntity> contaEntityOptional = Optional.of(contaEntityTest);

            Mockito.doReturn(contaEntityOptional).when(contaRepository).findById(contaDTO.getNumeroConta());

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> contaService.saveConta(contaDTO)
            );

            Mockito.verify(contaRepository, never()).save(any(ContaEntity.class));
        }
    }

    @Nested
    class findConta {
        @Test
        @DisplayName("Deve retornar uma ContaDTO ao buscar uma conta que já exista")
        public void deveEncontrarUmConta() {
            Optional<ContaEntity> contaEntityOptional = Optional.ofNullable(contaEntityTest);

            Mockito.doReturn(contaEntityOptional).when(contaRepository).findById(contaDTO.getNumeroConta());

            ContaDTO contaDtoRetorno = contaService.findConta(contaDTO.getNumeroConta());

            Assertions.assertEquals(contaDTO, contaDtoRetorno);

        }

        @Test
        @DisplayName("Deve lançar uma exceção ao buscar uma conta inexistente")
        public void deveLancarExcecaoAoBuscarUmaContaInexistente() {
            Optional<ContaEntity> contaEntityOptional = Optional.empty();

            Mockito.doReturn(contaEntityOptional).when(contaRepository).findById(contaDTO.getNumeroConta());

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> contaService.findConta(contaDTO.getNumeroConta())
            );
        }
    }

}
