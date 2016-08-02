package compropagosdk.Factory.V11;

import compropagosdk.Factory.Abs.InstructionDetails;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class InstructionDetails11 extends InstructionDetails {

    public String amount;
    public String store;
    public String bank_account_number;
    public String bank_name;

    @Override
    public String getAmount() {
        return amount;
    }

    @Override
    public String getStore() {
        return store;
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
