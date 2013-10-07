package tn.edu.esprit.pIDev.claimManagementModuleEjbProject.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.domain.Claim;
import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.services.interfaces.ClaimServicesLocal;
import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.services.interfaces.ClaimServicesRemote;

@Stateless
public class ClaimServices implements ClaimServicesRemote, ClaimServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	public ClaimServices() {

	}

	@Override
	public void addClaim(Claim claim) {
		entityManager.persist(claim);

	}

	@Override
	public void updateClaim(Claim claim) {
		entityManager.merge(claim);

	}

	@Override
	public void updateStatu(Claim claim, String statu) {
		claim.setStatu(statu);
		entityManager.merge(claim);
	}

	@Override
	public List<Claim> findAllClaims() {
		
		return entityManager.createQuery("select c from Claim c")
				.getResultList();
	}

	@Override
	public List<Claim> findAllIntreatedClaims() {
		return entityManager.createQuery("select c from Claim c where c.statu= ?1").setParameter(1, "intreated")
				.getResultList();
	}

	@Override
	public List<Claim> findAllInProgressClaims() {
		return entityManager.createQuery("select c from Claim c where c.statu= ?1").setParameter(1, "inProgress")
				.getResultList();
	}

	@Override
	public List<Claim> findAllTreatedClaims() {
		return entityManager.createQuery("select c from Claim c where c.statu= ?1").setParameter(1, "treated")
				.getResultList();
	}

	@Override
	public List<Claim> findAllRefusedClaims() {
		return entityManager.createQuery("select c from Claim c where c.statu= ?1").setParameter(1, "refused")
				.getResultList();
	}

	@Override
	public void refuseClaim(Claim claim) {
		claim.setStatu("refused");
		claim.setSheduledDate(new Date());
		entityManager.merge(claim);

	}

	@Override
	public Claim findClaimByID(int idClaim) {
		return entityManager.find(Claim.class, idClaim);
	}

}
