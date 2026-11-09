package br.com.softplan.report.application;

import org.junit.Before;
import org.junit.Test;

import br.com.softplan.report.model.NotaFiscal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class GeradorObservacaoTest {

    private GeradorObservacao<Integer> geradorObservacao;
    private GeradorObservacao<NotaFiscal> geradorObservacaoNotaFiscal;

    @Before
    public void setUp() {
        geradorObservacao = new GeradorObservacao<Integer>();
        geradorObservacaoNotaFiscal = new GeradorObservacao<NotaFiscal>();
    }

    @Test
    public void deve_gerar_observacao_sem_nota() {
        List<Integer> numerosNotaFiscal = new ArrayList<>();

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("", observacao);
    }

    @Test
    public void deve_gerar_observacao_com_uma_nota() {
        List<Integer> numerosNotaFiscal = singletonList(1);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura da nota fiscal de simples remessa: 1.", observacao);
    }

    @Test
    public void deve_gerar_observacao_com_duas_notas() {
        List<Integer> numerosNotaFiscal = asList(1, 3);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura das notas fiscais de simples remessa: 1 e 3.", observacao);
    }

    @Test
    public void deve_gerar_observacao_com_diversas_notas() {
        List<Integer> numerosNotaFiscal = asList(1, 2, 3, 4, 5);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.", observacao);
    }
    
    @Test
    public void deve_gerar_observacao_com_notas_com_valores() {
    	List<NotaFiscal> notasFiscais = asList(
    			new NotaFiscal(1L, BigDecimal.valueOf(10)),
    			new NotaFiscal(2L, BigDecimal.valueOf(20)),
    			new NotaFiscal(3L, BigDecimal.valueOf(30)));
    	
        String observacao = geradorObservacaoNotaFiscal.geraObservacao(notasFiscais);
        
        assertEquals("Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10, 2 cujo valor é R$ 20 e 3 cujo valor é R$ 30.", observacao);
    }

}
