package tn.edu.esprit.pIDev.claimManagementModuleClientProject.delegate;

import java.util.List;

import tn.edu.esprit.pIDev.claimManagementModuleClientProject.locator.ServiceLocator;
import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.domain.Claim;
import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.services.interfaces.ClaimServicesRemote;

public class ClaimServicesDelegate {

	private static final String jndiName = "tn.edu.esprit.pIDev.claimManagementModuleEjbProject/ClaimServices!tn.edu.esprit.pIDev.claimManagementModuleEjbProject.services.interfaces.ClaimServicesRemote";

	private static ClaimServicesRemote getProxy() {
		return (ClaimServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void doAddClaim(Claim claim) {
		getProxy().addClaim(claim);

	}

	public static void doUpdateClaim(Claim claim) {
		getProxy().updateClaim(claim);

	}

	public static void doUpdateStatu(Claim claim, String statu) {
		getProxy().updateStatu(claim, statu);
	}

	public static List<Claim> doFindAllClaims() {

		return getProxy().findAllClaims();
	}

	public static List<Claim> doFindAllIntreatedClaims() {
		return getProxy().findAllIntreatedClaims();
	}

	public static List<Claim> doFindAllInProgressClaims() {
		return getProxy().findAllInProgressClaims();
	}

	public static List<Claim> doFindAllTreatedClaims() {
		return getProxy().findAllTreatedClaims();
	}

	public static List<Claim> doFindAllRefusedClaims() {
		return getProxy().findAllRefusedClaims();
	}

	public static void doRefuseClaim(Claim claim) {
		getProxy().refuseClaim(claim);

	}

	public static Claim doFindClaimByID(int idClaim) {
		return getProxy().findClaimByID(idClaim);
	}

}