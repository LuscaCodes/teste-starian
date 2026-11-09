package br.com.softplan.report.application;

import java.util.Iterator;
import java.util.List;

public class GeradorObservacao<T> { 

	public String geraObservacao(List<T> notas) {
		if (notas.isEmpty()) {
			return "";
		}
		
		return geraPrefixo(notas.size()) + retornaCodigos(notas) + ".";		
	}

	private String retornaCodigos(List<T> notas) {
		StringBuilder retorno = new StringBuilder();
		
		for (Iterator<T> iterator = notas.iterator(); iterator.hasNext(); ) {
			T nota = iterator.next();
					
			retorno.append(geraSeparador(retorno, iterator));
			retorno.append(nota);
		}
		
		return retorno.toString();
	}

	private String geraSeparador(StringBuilder retorno, Iterator<T> iterator) {
		String separador;
		
		if(retorno.toString().length() == 0 ) {
			separador =  "";
		} else if(iterator.hasNext()) {
			separador =  ", ";
		} else {
			separador =  " e ";
		}
		
		return separador;
	}
	
	private String geraPrefixo(int tamanho) {
		if (tamanho > 1) {
			return "Fatura das notas fiscais de simples remessa: ";
		} else {
			return "Fatura da nota fiscal de simples remessa: ";
		}
	}
	
}