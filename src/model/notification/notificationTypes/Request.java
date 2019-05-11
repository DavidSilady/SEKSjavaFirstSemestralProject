package model.notification.notificationTypes;

import model.notification.Notification;
import model.user.User;
import model.user.userTypes.CompanyUser;
import model.user.userTypes.InspectionUser;

public class Request extends Notification {
	private CompanyUser sender;
	
	public Request (CompanyUser sender) {
		this.sender = sender;
		super.setGeneratorName(sender.getName());
		super.setGeneratorType("CompanyUser");
		super.setText(sender.getName() + " has requested your assignment to the company.");
	}
	
	public void acceptAssignment(InspectionUser inspectionUser) {
		inspectionUser.addCompanyUser(this.sender);
		sender.assignInspector(inspectionUser);
	}
	
	/**
	 * Removes the notification permanently
	 */
	@Override
	public void dismiss (User user) {
		user.getNotifications().remove(this);
	}
	
	
}
