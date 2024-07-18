package aplicacao;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelo.dao.DepartamentoDao;
import modelo.dao.FabricaDao;
import modelo.entidades.Departamento;

public class Principal2 {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		DepartamentoDao depDao = FabricaDao.criaDepartamentoDao();

		System.out.println("===== TESTE 1 Busca por id =====");
		Departamento dep = depDao.buscaId(1);
		System.out.println(dep);
	
		System.out.println("\n===== TESTE 2 Busca todos =====");
		List<Departamento> listaDepartamento = depDao.buscaTodos();
		for (Departamento obj : listaDepartamento) {
			System.out.println(obj);
		}
			
		System.out.println("\n===== TESTE 3 Insere Departamento =====");
      	Departamento novoDep = new Departamento(null, "Discos");
      	depDao.insere(novoDep);
      	System.out.print("Id " + novoDep.getId() + " inserido");
		
		System.out.println("\n===== TESTE 4 Atualiza Departamento =====");
		Departamento dep2 = depDao.buscaId(1);
		dep2.setNome("Alimentos");
		depDao.atualiza(dep2);
        System.out.println(dep2 + " atualizado");
        
        System.out.println("\n===== TESTE 5 Deleta Departamento =====");
        System.out.print("Informe o número do id que você quer excluir: ");
        int id = sc.nextInt();
        depDao.deletaId(id);
        System.out.print("Id " + id + " deletado");
	        
        sc.close();

	}
}
		

	
		
	


