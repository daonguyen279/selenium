package Common;

public class Constant {
	public static String baseUrl = "http://www.railwayseleium.somee.com";

	public static String validEmail = "son.nguyen@logigear.com";
	public static String validPassword = "12345678";
	public static String invalidPassword = "123456789";

	public static String loginErrMessageWithBlankValues = "There was a problem with your login and/or errors exist in your form.";
	public static String loginErrMessageWithInvalidValues = "Invalid username or password. Please try again.";

	public static String registerErrMessageWithInvalidValues = "There're errors in the form. Please correct the errors and try again.";
	public static String registerErrMessageWithRegisteredEmail = "This email address is already in use.";
	public static String registerErrMessageInvalidPassword = "Invalid password length";
	public static String registerErrMessageInvalidPid = "Invalid ID length";
	public static String registerSuccessMessage = "Thank you for registering your account";

	public static String changePasswordErrMessage = "Password change failed. Please correct the errors and try again.";

	public static String resetPasswordErrMessage = "Could not reset password. Please correct the errors and try again.";
	public static String resetPasswordErrMessageWithInvalidToken = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
	public static String resetPasswordTokenErrMessage = "The password reset token is invalid";
	public static String resetPasswordConfirmPasswordErrMessage = "The password confirmation did not match the new password.";

	public static String bookTicketSuccessMessage = "Ticket booked successfully!";
}
