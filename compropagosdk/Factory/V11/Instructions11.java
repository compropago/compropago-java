package compropagosdk.Factory.V11;

import compropagosdk.Factory.Abs.InstructionDetails;
import compropagosdk.Factory.Abs.Instructions;

/**
 * @author Eduardo Aguilar <eduardo.aguilar@compropago.com>
 */
public class Instructions11 extends Instructions {

    public String description;
    public String step_1;
    public String step_2;
    public String step_3;
    public String note_extra_comition;
    public String note_expiration_date;
    public String note_confirmation;
    public InstructionDetails11 details;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getStep1() {
        return step_1;
    }

    @Override
    public String getStep2() {
        return step_2;
    }

    @Override
    public String getStep3() {
        return step_3;
    }

    @Override
    public String getNoteExtraComition() {
        return note_extra_comition;
    }

    @Override
    public String getNoteExpirationDate() {
        return note_expiration_date;
    }

    @Override
    public String getNoteConfirmation() {
        return note_confirmation;
    }

    @Override
    public InstructionDetails getDetails() {
        return details;
    }
}
