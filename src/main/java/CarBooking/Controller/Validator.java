package CarBooking.Controller;

import jakarta.servlet.http.HttpSession;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements Serializable{
    private final int  MIN_AGE = 16;
    private final int  MAX_AGE = 100;
    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z0-9]).{4,}$";
    private String phonePattern = "^\\(?(0[1-9]{1}\\)?[ ]?|[+]61\\ ?|\\(?(\\+61|0)[1-9]{1}\\)?[ ]?)?(?:\\d{4}[ ]?\\d{4}|\\d{3}[ ]?\\d{3}|\\d{2}[ ]?\\d{2}[ ]?\\d{2}|\\d{4}[ ]?\\d{3}|\\d{2}[ ]?\\d{4}[ ]?\\d{4}|\\d{4}[ ]?\\d{4}[ ]?\\d{4}|\\d{3}[ ]?\\d{4}[ ]?\\d{4}|\\d{2}[ ]?\\d{2}[ ]?\\d{4}[ ]?\\d{4})$";

    private String cardNumberPattern = "^(\\d{16})$";
    private String cardExpiryPattern = "(?:0[1-9]|1[0-2])/[0-9]{2}";
    private String cardCvvThreeDigitPattern = "^\\d{3}$";
    private String cardCvvFourDigitPattern = "^\\d{4}$";
    public Validator(){}
    public boolean validate(String pattern, String input){
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }
    public boolean checkEmpty(String email, String password){
        return  email.isEmpty() || password.isEmpty();
    }
    public boolean validateDob(LocalDate dob) {
        return dob.isBefore(LocalDate.now().minusYears(MIN_AGE).plusDays(1)) && dob.isAfter(LocalDate.now().minusYears(MAX_AGE));
    }
    public boolean validateEmail(String email){
        return validate(emailPattern,email);
    }
    public boolean validateName(String name){
        return validate(namePattern,name);
    }
    public boolean validatePassword(String password){
        return validate(passwordPattern,password);
    }
    public boolean validatePhone(String phone) { return validate(phonePattern, phone); }
    public boolean validateCardNumber(String cardNumber) { return validate(cardNumberPattern, cardNumber); }
    public boolean validateCardExpiry(String cardExpiry) {
        return validate(cardExpiryPattern, cardExpiry) && validateCardExpirationDate(cardExpiry);
    }
    public boolean validateCardExpiryFormat(String cardExpiry) {
        return validate(cardExpiryPattern, cardExpiry);
    }
    public boolean validateCardExpirationDate(String cardExpiry) {
        cardExpiry = "01/".concat(cardExpiry);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate cardExpiryDate = LocalDate.parse(cardExpiry, formatter);
        LocalDate currentDate = LocalDate.now();
        return cardExpiryDate.isAfter(currentDate);
    }
    public boolean validateCardCvv(String cardCvv) { return (validate(cardCvvThreeDigitPattern, cardCvv) || validate(cardCvvFourDigitPattern, cardCvv));}
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter your email");
//        session.setAttribute("emailErrRegister", "Enter your email");
//        session.setAttribute("emailErrSupport", "Enter your email");
        session.setAttribute("passErr", "Enter your password");
        session.setAttribute("existErr", "");
        session.setAttribute("userExists", "");
        session.setAttribute("phoneErr", "Enter your phone number");
        session.setAttribute("dateErr", "");
        session.setAttribute("cardNumErr", "Enter your card number");
        session.setAttribute("cardExpiryErr", "MM/YY");
        session.setAttribute("cardCvvErr", "CVV");
        session.setAttribute("cardExists", "");
    }
}