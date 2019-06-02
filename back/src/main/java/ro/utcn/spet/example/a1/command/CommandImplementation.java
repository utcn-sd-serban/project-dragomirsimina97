package ro.utcn.spet.example.a1.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.utcn.spet.example.a1.repository.OfferRepository;

@Component
@RequiredArgsConstructor
public class CommandImplementation implements CommandFactory{

    private final OfferRepository offerRepository;


    @Override
    public Command askCommand() {
        return new AskCommand(offerRepository);
    }
}
