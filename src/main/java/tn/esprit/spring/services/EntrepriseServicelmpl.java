package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.repository.EntrepriseRepository;


@Service
public class EntrepriseServicelmpl implements IEntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRepository;
	

	private static final Logger L = LogManager.getLogger(EntrepriseServicelmpl.class);
	
	@Override
	public List<Entreprise> retrieveAllEntreprise() {
		List<Entreprise> entreprises = null; 
		try {
			
			L.info("In method retieveAllentreprise :");
	
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();  
			
			L.info("Out of Method retrieveAllEntreprise with succes");
		}catch (Exception e) {
			L.error("Out of Methode retrieveAllentreprise with errors : " + e);
		}

		return entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise e) {
		L.info("In method addentreprise :");
		Entreprise u_saved = entrepriseRepository.save(e); 
		L.info("Out method addentreprise :");
		return u_saved; 
	}

	@Override
	public void deleteEntreprise(String id) {
		L.info("In method deletenterprise :");
		entrepriseRepository.deleteById(Long.parseLong(id));; 
		L.info("Out method deleteUser :");

		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		L.info("In methodupdateEntreprise :");
		boolean u_saved = entrepriseRepository.existsById(e.getId()); 
		if (u_saved)
		{
			String Name = e.getName();
			String rs = e.getRaisonSocial();
			Long idd = e.getId();
		e.setName(Name);
		e.setRaisonSocial(rs);
		e.setId(idd);
		}
		Entreprise u = entrepriseRepository.save(e);
		L.info("Out method updateEntreprise :");
		return u; 
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		L.info("In method retrouveEntreprise :");
		
		
		Optional<Entreprise> entrepriseOpt = entrepriseRepository.findById(Long.parseLong(id));
		
		if (entrepriseOpt.isPresent()) {
			Entreprise u =  entrepriseOpt.get(); 
			L.info("Out method retrieveentreprise :");
			return u;
		}
		
		return null;
		
		
		 
	}

}
