package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import modelo.dao.FabricaDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Principal {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		VendedorDao vendDao = FabricaDao.criaVendedorDao();

		System.out.println("===== TESTE 1 Busca por id =====");
		Vendedor vend = vendDao.buscaId(5);
		System.out.println(vend);
	
		System.out.println("\n===== TESTE 2 Busca por Departamento =====");
		Departamento dep = new Departamento(2, null);
		List<Vendedor> listaVendedor = vendDao.buscaIdDepartamento(dep);
		for (Vendedor obj : listaVendedor) {
			System.out.println(obj);
		}
		
		System.out.println("\n===== TESTE 3 Busca todos =====");
		listaVendedor = vendDao.buscaTodos();
		for (Vendedor obj : listaVendedor) {
			System.out.println(obj);
		}

	/*	System.out.println("\n===== TESTE 4 Insere Vendedor =====");
		Vendedor vendedorNovo = new Vendedor(null, "Marco Junior", "silva241277@gmail.com", data, 4000.0, dep);
		vendDao.insere(vendedorNovo);
		System.out.println("Vendedor = " + vendedorNovo); */
		
		System.out.println("\n===== TESTE 5 Atualiza Vendedor =====");
		vend = vendDao.buscaId(1);
		vend.setNome("Patricia Maciel");
		vend.setEmail("patricia@gmail.com");
		vend.setDataNasc(sdf.parse("23/02/1988"));
		vend.setSalario(3500.0);
		vend.setDepartamento(new Departamento(3, null));
        vendDao.atualiza(vend);
        System.out.println("Vendedor = " + vend);
        
        System.out.println("\n===== TESTE 6 Deleta Vendedor =====");
        vendDao.deletaId(8);
        vendDao.deletaId(9);
        System.out.println("Ids deletados");
	}

}
