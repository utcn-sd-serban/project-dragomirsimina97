package ro.utcn.spet.example.a1.command;

import ro.utcn.spet.example.a1.dto.OfferDTO;

public interface Command {

    OfferDTO execute (OfferDTO dto);
}
