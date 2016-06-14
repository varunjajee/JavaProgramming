package com.muks.DesignPatterns.structural;

/*
 * Created by mukthar.ahmed on 12/28/15.
 */
public class BankCustomer extends BankDetails implements CreditCard {
    public void giveBankDetails() {
        String customername = "Mukthar";
        long accno = 1234567890L;
        String bankname = "HDFC Bank";

        setAccHolderName(customername);
        setAccNumber(accno);
        setBankName(bankname);
    }

    @Override
    public String isElgibleForCreditCard() {
        long accno = getAccNumber();
        String accholdername = getAccHolderName();
        String bname = getBankName();

        return ("The Account number " + accno + " of " + accholdername + " in " + bname + " bank " +
                "is valid and authenticated for issuing the credit card. ");
    }

}
