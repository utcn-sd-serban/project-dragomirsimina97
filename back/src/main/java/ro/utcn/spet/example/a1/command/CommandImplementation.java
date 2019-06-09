package ro.utcn.spet.example.a1.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.utcn.spet.example.a1.repository.OfferRepository;
import ro.utcn.spet.example.a1.repository.RepositoryFactory;

@Component
@RequiredArgsConstructor
public class CommandImplementation implements CommandFactory{

    private final RepositoryFactory repositoryFactory;


    @Override
    public Command askCommand() {
        return new AskCommand(repositoryFactory);
    }
}
