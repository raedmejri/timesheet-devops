package tn.esprit.spring.services;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService us;
	@Test
	@Order(1)
	public void testentrepriseRetrouve()
	{
		List<Entreprise> listentre = us.retrieveAllEntreprise();
		Assertions.assertEquals(2, listentre.size());
	}
	@Test
	@Order(2)
	public void testentrepriseAdd()
	{
		Entreprise u = new Entreprise("Google", "S.A");
		Entreprise ent = us.addEntreprise(u);
		Assertions.assertEquals(u.getName(), ent.getName());
	}
	@Test
	@Order(3)
	public void testentreprisedelet()
	{
		List<Entreprise> e1 = us.retrieveAllEntreprise();
		int s = e1.size();
		Entreprise e11 =e1.get(s-3);
		 Long id = e11.getId();
		 String idd = String.valueOf(id);
		
		us.deleteEntreprise(idd);
	}
	
	@Test
	@Order(4)
	public void testupdateEntreprise()
	{
		List<Entreprise> e1 = us.retrieveAllEntreprise();
		int s = e1.size();
		Entreprise e11 = e1.get(s-1);
		
		
		Entreprise u = new Entreprise(e11.getId(),"Facebook", "S.A.R.L");
		Entreprise userUpdated = us.addEntreprise(u);
		Assertions.assertEquals(u.getName(), userUpdated.getName());
		
		
	}

}
