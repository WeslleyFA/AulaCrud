package weslley.br;

import weslley.br.resolucoes.ResolucaoKlaudio;

public class Main {
	public static void main(String[] args) {

	
		Integer numero = 19;
		
		numero = numero > 10 && numero < 20 ? 30 : 40;
		
		System.out.println(numero);
		

		ResolucaoKlaudio resolucao = new ResolucaoKlaudio();
		resolucao.menu();
	}
}
