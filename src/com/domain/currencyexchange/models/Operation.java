package com.domain.currencyexchange.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {

    private Pair pair;
    private Date date;

    public Operation (Pair pair, Date date) {
        this.pair = pair;
        this.date = date;
    }

    public Pair getPair() {
        return pair;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formattedDate = dateFormat.format(date);

        return ("Pair: { " + pair.base_code() + "/" + pair.target_code() + " = $" + pair.conversion_rate() +
                ", Amount: $" + pair.conversion_result() / pair.conversion_rate() + ", Result of conversion: $" +
                pair.conversion_result() + ", \nDate and time: " +  formattedDate + " }");
    }
}
