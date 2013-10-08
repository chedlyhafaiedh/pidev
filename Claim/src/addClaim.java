import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import tn.edu.esprit.pIDev.claimManagementModuleClientProject.delegate.ClaimServicesDelegate;
import tn.edu.esprit.pIDev.claimManagementModuleEjbProject.domain.Claim;

public class addClaim {

	protected Shell shlAddClaim;
	private Text Description;
	private Text Location;
	private String direc;
	private boolean pi;
	private boolean v;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			addClaim window = new addClaim();
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
		shlAddClaim.open();
		shlAddClaim.layout();
		while (!shlAddClaim.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAddClaim = new Shell();
		shlAddClaim.setSize(502, 383);
		shlAddClaim.setText("Add Claim");

		Button btnAddClaim = new Button(shlAddClaim, SWT.NONE);
		btnAddClaim.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Claim claim1 = new Claim(Description.getText(), Location
						.getText(), direc, pi, v, "intreated", 1, new Date(),
						null, null);
				ClaimServicesDelegate.doAddClaim(claim1);
			}
		});
		btnAddClaim.setBounds(203, 291, 104, 25);
		btnAddClaim.setText("Add Claim");

		Label lblNewLabel = new Label(shlAddClaim, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 69, 15);
		lblNewLabel.setText("Description");

		Description = new Text(shlAddClaim, SWT.BORDER);
		Description.setBounds(82, 10, 250, 67);

		Location = new Text(shlAddClaim, SWT.BORDER);
		Location.setBounds(82, 94, 250, 21);

		Label lblLocation = new Label(shlAddClaim, SWT.NONE);
		lblLocation.setBounds(10, 97, 55, 15);
		lblLocation.setText("Location");

		final Combo Direction = new Combo(shlAddClaim, SWT.NONE);
		Direction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				direc = Direction.getText();

			}
		});
		Direction.addTouchListener(new TouchListener() {
			public void touch(TouchEvent arg0) {

			}
		});
		Direction.setItems(new String[] { "North", "East", "West", "South" });
		Direction.setBounds(82, 140, 127, 23);
		Direction.select(0);

		Label lblDirection = new Label(shlAddClaim, SWT.NONE);
		lblDirection.setBounds(10, 143, 55, 15);
		lblDirection.setText("Direction");

		final Button PersonalInjury = new Button(shlAddClaim, SWT.CHECK);
		PersonalInjury.addTouchListener(new TouchListener() {
			public void touch(TouchEvent arg0) {

			}
		});
		PersonalInjury.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pi = PersonalInjury.getSelection();

			}
		});
		PersonalInjury.setBounds(10, 181, 109, 16);
		PersonalInjury.setText("Personal Injury");

		final Button btnVisibility = new Button(shlAddClaim, SWT.CHECK);
		btnVisibility.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				v = btnVisibility.getSelection();
			}
		});
		btnVisibility.setText("Visibility");
		btnVisibility.setBounds(10, 216, 109, 16);

	}
}
