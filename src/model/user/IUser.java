package model.user;

public interface IUser {
	String getMail ();
	String getPassword ();
	/**
	 * @return the authenticated user or null if not authenticated
	 */
	User loginUser(String loginMail, String loginPassword);
	/**
	 * @param organizationID - usually ICO
	 * @return the signed up user
	 */
	User signUpUser(String name,
	                       String organizationID,
	                       String email,
	                       String phone,
	                       String password);
}
