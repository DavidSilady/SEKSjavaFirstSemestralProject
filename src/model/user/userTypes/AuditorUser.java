package model.user.userTypes;

import model.device.Device;
import model.user.IUser;
import model.user.User;

import java.io.Serializable;

/**
 * Governmental user - makes auditions of devices
 */
public class AuditorUser extends User implements Serializable, IUser {
	
	/**
	 *  Hardcoded to log in with credentials "admin", "admin";
	 * for simulation simplicity
	 * @return new Auditor if the authentication is correct, null, if incorrect
	 */
	@Override
	public User loginUser (String loginMail, String loginPassword) {
		if(loginMail.equals("admin") && loginPassword.equals("admin"))
			return new AuditorUser();
		return null;
	}
	
	/**
	 * Empty due to simulation simplicity,
	 * a whole new system would be required for signing up
	 */
	@Override
	public User signUpUser (String name, String organizationID, String email, String phone, String password) {
		return null;
	}
	
	/**
	 * Updates the devices audition dates (last - today, next - calculates)
	 * @see Device
	 */
	@Override
	public void updateDevice (Device device) {
		device.calculateNextAudition();
	}
	
	/**
	 * Empty - Auditor user uses no notifications as of now
	 */
	@Override
	public void updateNotifications () {
	}
}
