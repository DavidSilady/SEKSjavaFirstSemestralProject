package model.notification.notificationTypes;

import model.notification.Notification;
import model.user.User;
import model.user.userTypes.CompanyUser;
import model.user.userTypes.InspectionUser;

public class Request extends Notification {
	private CompanyUser sender;
	public Request (CompanyUser sender) {
		this.sender = sender;
	}
	
	public void acceptAssignment(InspectionUser inspectionUser) {
		inspectionUser.getCompanyUsers().add(this.sender);
		sender.assignInspector(inspectionUser);
	}
	
	@Override
	public void dismiss (User user) {
		user.getNotifications().remove(this);
	}
	
	
}
