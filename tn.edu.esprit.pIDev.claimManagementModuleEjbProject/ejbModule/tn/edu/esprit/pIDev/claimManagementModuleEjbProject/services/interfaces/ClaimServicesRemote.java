package tn.edu.esprit.pIDev.claimManagementModuleEjbProject.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.domain.Claim;

@Remote
public interface ClaimServicesRemote {

	public void addClaim(Claim claim);

	public void updateClaim(Claim claim);

	public void updateStatu(Claim claim,String statu);
	
	public void refuseClaim(Claim claim);

	public List<Claim> findAllClaims();
	
	public List<Claim> findAllIntreatedClaims();
	
	public List<Claim> findAllInProgressClaims();
	
	public List<Claim> findAllTreatedClaims();
	
	public List<Claim> findAllRefusedClaims();
	
	public Claim findClaimByID(int idClaim);

}
