package compropagosdk.Factory.V10;

import compropagosdk.Factory.Abs.InstructionDetails;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class InstructionDetails10 extends InstructionDetails {

    public String payment_amount;
    public String payment_store;
    public String bank_account_number;
    public String bank_name;

    @Override
    public String getAmount() {
        return payment_amount;
    }

    @Override
    public String getStore() {
        return payment_store;
    }

    @Override
    public String getBankAccountNumber() {
        return bank_account_number;
    }

    @Override
    public String getBankName() {
        return bank_name;
    }
}
