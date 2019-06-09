package ro.utcn.spet.example.a1.repository;


import ro.utcn.spet.example.a1.repository.memory.AuthorRepository;

public interface RepositoryFactory {

	OfferRepository createOfferRepository();
	AuthorRepository createAuthorRepository();




}
