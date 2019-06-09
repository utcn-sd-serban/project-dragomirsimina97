package ro.utcn.spet.example.a1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.utcn.spet.example.a1.dto.AuthorDTO;
import ro.utcn.spet.example.a1.entity.Author;
import ro.utcn.spet.example.a1.entity.Offer;
import ro.utcn.spet.example.a1.repository.RepositoryFactory;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorManagementService {
    private final RepositoryFactory repositoryFactory;

    @Transactional
    public List<AuthorDTO> author() {
        List<AuthorDTO> myOffers = repositoryFactory.createAuthorRepository().findAll().stream().map(AuthorDTO::ofEntity).collect(Collectors.toList());
        Collections.reverse(myOffers);

        return myOffers;

    }
}
