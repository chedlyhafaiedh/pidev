import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableItem;

import tn.edu.esprit.pIDev.claimManagementModuleClientProject.delegate.ClaimServicesDelegate;
import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.domain.Claim;


public class ClaimsListMenu {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ClaimsListMenu window = new ClaimsListMenu();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		List<Claim> claims=ClaimServicesDelegate.doFindAllClaims();
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setToolTipText("");
		table.setBounds(10, 42, 391, 169);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		
		for(Claim c:claims)
		{
			TableItem tableItem1 = new TableItem(table, SWT.NONE);
			TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(Integer.toOctalString(c.getIdClaim()));
		
		tableItem1.setText(c.getDescription());
		}
	}
}
