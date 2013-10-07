package tn.edu.esprit.pIDev.claimManagementModuleClientProject.test;

import java.util.Date;

import tn.edu.esprit.pIDev.claimManagementModuleClientProject.delegate.ClaimServicesDelegate;
import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.domain.Claim;

public class TestAddClaim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Claim claim1 = new Claim("noise claim",
				"Sfax principal bouzayenne km4.5", "north", true, true,
				"intreated", 1, new Date(), null, null);
		Claim claim2 = new Claim("street claim",
				"Sfax principal bouzayenne km4.5", "west", true, false,
				"intreated", 1, new Date(), null, null);
		Claim claim3 = new Claim("public claim",
				"Sfax principal bouzayenne km4.5", "north", false, true,
				"intreated", 1, new Date(), null, null);
		Claim claim4 = new Claim("noise claim",
				"Sfax principal bouzayenne km4.5", "north", false, false,
				"treated", 1, new Date(), null, null);
		ClaimServicesDelegate.doAddClaim(claim1);
		ClaimServicesDelegate.doAddClaim(claim2);
		ClaimServicesDelegate.doAddClaim(claim3);
		ClaimServicesDelegate.doAddClaim(claim3);
		claim1.setIdClaim(1);
		claim2.setIdClaim(2);
		claim3.setIdClaim(3);
		claim4.setIdClaim(4);
		System.out.println("list of claims");
		for (Claim c : ClaimServicesDelegate.doFindAllClaims()) {
			System.out.println("***" + c.toString());
		}
		ClaimServicesDelegate.doRefuseClaim(claim1);
		ClaimServicesDelegate.doUpdateStatu(claim3, "inprogress");
		claim4.setDescription("envirement claim");
		ClaimServicesDelegate.doUpdateClaim(claim4);
		claim4.setClosedDate(new Date());
		ClaimServicesDelegate.doUpdateStatu(claim4, "treated");
		Claim claimfound = ClaimServicesDelegate.doFindClaimByID(claim4
				.getIdClaim());
		System.out.println("claim4 after changes:" + claimfound.toString());
		System.out.println("list of claims after changes");
		for (Claim c : ClaimServicesDelegate.doFindAllClaims()) {
			System.out.println("***" + c.toString());
		}
		System.out.println("list of intreated claims ");
		for (Claim c : ClaimServicesDelegate.doFindAllIntreatedClaims()) {
			System.out.println("***" + c.toString());
		}
		System.out.println("list of inProgress claims ");
		for (Claim c : ClaimServicesDelegate.doFindAllInProgressClaims()) {
			System.out.println("***" + c.toString());
		}
		System.out.println("list of treated claims ");
		for (Claim c : ClaimServicesDelegate.doFindAllTreatedClaims()) {
			System.out.println("***" + c.toString());
		}
		System.out.println("list of refused claims ");
		for (Claim c : ClaimServicesDelegate.doFindAllRefusedClaims()) {
			System.out.println("***" + c.toString());
		}

	}

}
