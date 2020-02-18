package casoTestes;


import org.junit.Test;

import apoio.ApoioProjetoMantis;

public class TesteWebMantis extends ApoioProjetoMantis {
	
	
	@Test
	public void Testando () throws Throwable {	
		
		acessarMantis();		
		alteraProjeto();
		criaReportIssue();		
		adicionaFiltros();
		incluiNotes();
				
	}

}
